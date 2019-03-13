package java8.random;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fw
 * @date 2019/03/13
 */
public class MoneyRandom {
    public static void main(String[] args) {
        double total = 20.0;
        int population = 20;
        int iteration = 10000;
        double stderr = 0.5;
        int part = 10000;
        //均值相同，前n-1个人方差相同的算法
        //double[][] arr = alg1(total,population, iteration,stderr);
        //每一个人拿剩下的数做随机的算法
        //double[][] arr = alg2(total,population,iteration);
        //古典概率
        double[][] arr = alg3(total,population,iteration,part);
        printarr(arr);
    }

    /**
     * 均值相同，前n-1个人方差相同的算法
     */
    private static double[][] alg1(double total, int population, int iteration, double stderr){
        double[][] arr = new double[population][iteration];
        //做count次试验
        //生成一个population*count的矩阵
        //population为人数，count为次数
        for (int i = 0; i < iteration ; i++){
            double left = total;
            Random random = new Random();
            for (int j = 0; j < population ; j++) {
                if(j!=population - 1){
                    double v = random.nextGaussian() * stderr;
                    v = v + total/population;
                    arr[j][i] = v;
                    left = left - v;
                }else {
                    arr[j][i] = left;
                }
            }
        }
        return arr;
    }

    /**
     * 每一个人拿剩下的数做随机的算法
     */
    private static double[][] alg2(double total, int population, int iteration){
        double[][] arr = new double[population][iteration];
        //做count次试验
        //生成一个population*count的矩阵
        //population为人数，count为次数
        for (int i = 0; i < iteration ; i++){
            double left = total;
            Random random = new Random();
            for (int j = 0; j < population ; j++) {
                if(j!=population - 1){
                    double v = left*(random.nextDouble());
                    arr[j][i] = v;
                    left = left - v;
                }else {
                    arr[j][i] = left;
                }
            }
        }
        return arr;
    }

    /**
     * 古典概率
     * @param total
     * @param population
     * @param iteration
     * @return
     */
    private static double[][] alg3(double total, int population, int iteration,int part){
        double[][] arr = new double[population][iteration];
        //做count次试验
        //生成一个population*count的矩阵
        //population为人数，count为次数
        Random random = new Random();
        for (int i = 0; i < iteration ; i++){
            for (int p = 0; p < part; p++) {
                int person = random.nextInt(population);
                arr[person][i] += total/part;
            }
        }
        return arr;
    }

    /**
     * 打印结果
     */
    private static void printarr(double[][] arr){
        Arrays.stream(arr).forEach(
            arr1 -> {
                DoubleSummaryStatistics statistics = Arrays.stream(arr1).summaryStatistics();
                OptionalDouble aDouble = Arrays.stream(arr1).map(
                    d -> Math.pow((d - statistics.getAverage()), 2)
                ).reduce((a, b) -> a + b);
                double result =  (aDouble.getAsDouble())/(statistics.getCount() - 1);
                System.out.println("均值：" + statistics.getAverage() +"\t最大：" + statistics.getMax() + "\t最小：" + statistics.getMin() + "\t标准方差：" + result);
                //System.out.printf("均值：%4d 最大：%4d 最小：%4d 方差：%4d",statistics.getAverage(),statistics.getMax(),statistics.getMin(),result);
            }
        );
    }


}
