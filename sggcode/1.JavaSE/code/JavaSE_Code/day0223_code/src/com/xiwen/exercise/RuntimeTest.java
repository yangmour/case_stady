package com.xiwen.exercise;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/23-11:06
 * @Version: 1.0
 */
public class RuntimeTest {
    @Test
    public void test() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.maxMemory());
        StringBuilder line = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        try {
            Process exec = runtime.exec("cmd /c dir");
            inputStreamReader = new InputStreamReader(exec.getInputStream(), "gbk");
            bufferedReader = new BufferedReader(inputStreamReader);
            line = new StringBuilder();
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                line.append(s).append("\n");

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (inputStreamReader!=null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }


        }
        System.out.println(line);
    }
}
