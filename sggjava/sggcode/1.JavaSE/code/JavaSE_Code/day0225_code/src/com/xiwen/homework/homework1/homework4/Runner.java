package com.xiwen.homework.homework1.homework4;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-15:38
 * @Version: 1.0
 */
public class Runner extends com.xiwen.homework.homework1.homework3.Runner {

    private static boolean runFlag = true;    //用于标记是否继续跑，即结束线程的标记

    public Runner(String name, long runTime, long restTime) {
        super(name, runTime, restTime);
    }

    public static boolean isRunFlag() {
        return runFlag;
    }

    public static void setRunFlag(boolean runFlag) {
        Runner.runFlag = runFlag;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (getSum() < getDistance() && runFlag) {
            try {
                Thread.sleep(getRunTime());
                setSum(getSum() + 1);
                System.out.println(getName2() + "已经跑了" + getSum() + "米");
                if (getSum() % 10 == 0 && getSum() < getDistance()) {
                    Thread.sleep(getRestTime());
                    System.out.println(getName2() + "已经跑了" + getSum() + "米" + ",休息" + getRestTime() + "秒");
                }
            } catch (InterruptedException e) {
                System.out.println(getName2() + "跑步中断了！");
                setFinished(false);
            }
        }

        long end = System.currentTimeMillis();
        setTime(end - start);

        if (getSum() == 30) {
            setFinished(true);
        }
        if (isFinished()) {
            System.out.println(getName2() + "跑了" + getSum() + "米，已到达终点，共用时" + (double) getTime() / 1000 + "秒");

        } else {
            System.out.println(getName2() + "跑了" + getSum() + "米,没有到达终点！");
        }
        runFlag = false;
    }
}
