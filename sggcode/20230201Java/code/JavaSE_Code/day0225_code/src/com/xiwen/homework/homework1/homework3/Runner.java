package com.xiwen.homework.homework1.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-12:17
 * @Version: 1.0
 */
public class Runner extends Thread {

    private static long distance; //全距离
    private long sum; // 跑的米数
    private String name;   //名字
    private long runTime;  //每米需要的时间
    private long restTime; //休息的时间
    private long time; //跑完全程的总时间
    private boolean finished; //是否跑完全程

    public Runner() {
    }

    public Runner(String name, long runTime, long restTime) {
        this.name = name;
        this.runTime = runTime;
        this.restTime = restTime;
    }

    public static long getDistance() {
        return distance;
    }

    public static void setDistance(long distance) {
        Runner.distance = distance;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public String getName2() {
        return name;
    }

    public void setName2(String name) {
        this.name = name;
    }

    public long getRunTime() {
        return runTime;
    }

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    public long getRestTime() {
        return restTime;
    }

    public void setRestTime(long restTime) {
        this.restTime = restTime;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();
        while (sum < distance) {
            try {
                Thread.sleep(runTime);
                sum++;
                System.out.println(name + "已经跑了" + sum + "米");
                if (sum % 10 == 0 && sum < distance) {
                    Thread.sleep(restTime);
                    System.out.println(name + "已经跑了" + sum + "米" + ",休息" + restTime + "秒");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        time = end - start;
        System.out.println(name + "跑了" + sum + "米，已到达终点，共用时" + (double) time / 1000 + "秒");
        finished = true;
    }
}
