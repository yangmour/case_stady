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
        super.run();
        runFlag = false;
    }
}
