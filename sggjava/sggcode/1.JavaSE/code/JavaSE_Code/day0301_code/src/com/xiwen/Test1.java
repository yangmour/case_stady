package com.xiwen;

import org.junit.Test;

import java.io.File;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/1-18:33
 * @Version: 1.0
 */
public class Test1 {
    @Test
    public void test1() {
        //示例：replace(“aabbccbb”, “bb”, “dd”);  结果：aadccdd
        //注意：不能使用String及StringBuffer等类的replace等现成的替换API方法。
//        String res = replace("aabbccbb", "bb", "dd");


        int sum = 0;
        int mul = 1;
        for (int i = 1; i <= 5; i++) {
            mul *= i;
            sum += mul;
        }
        System.out.println(sum);
    }


    private String replace(String str, String oldStr, String newStr) {

        int len = str.length();
        for (int i = 0; i < len - oldStr.length(); i++) {
            String sub = str.substring(i, oldStr.length());
            if (sub.equals(oldStr)) {
                System.arraycopy(oldStr, 0, str, i, oldStr.length() - i);
            }
        }
        return null;
    }

    @Test
    public void test2() {
        File f = new File("http://asfsafsad/index.html");
        int i = f.getName().indexOf(".");
        String substring = f.getName().substring(i);
        System.out.println(substring);



    }
}
