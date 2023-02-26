package com.xiwen.exercise.map;

import org.junit.Test;

import java.util.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/25-9:32
 * @Version: 1.0
 */
public class MapTest {
    @Test
    public void test1() {
        //（1）从键盘输入本组学员的姓名和他的手机号码，存放到HashMap<K,V>中
        // ，泛型指定为<String,String>，姓名为key,手机号码为value，并且遍历显示
        HashMap<String, String> student = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.print("请输入本组学员的姓名:");
            String name = scanner.next();
            System.out.print("请输入本组学员的手机号:");
            String phone = scanner.next();
            student.put(name, phone);
        }
        System.out.println();

        Set<Map.Entry<String, String>> entrySet = student.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry);
        }

        //（2）再从键盘输入姓名，查询他的手机号码
        System.out.print("请输入要姓名查询手机号:");
        String inputName = scanner.next();
        System.out.println();
        String s = student.get(inputName);
        System.out.println(s == null ? "未查询到！" : inputName + "学生的手机号为：" + s);

    }

    @Test
    public void test2() {
        //1）创建HashMap对象，泛型为<Integer, ArrayList<String>>，
        //
        //（2）存储咱们班每组学员信息，组号为key，组员们的姓名为value
        //
        //（3）遍历显示每一个小组信息
        //
        //（4）从键盘输入一个学员姓名，查找这个学员是否咱们班

        HashMap<Integer, ArrayList<String>> classStudent = new HashMap<>();
        ArrayList<String> groupStudent1 = new ArrayList<>();
        groupStudent1.add("zhangsan1");
        groupStudent1.add("zhangsan2");
        groupStudent1.add("zhangsan3");
        classStudent.put(1, groupStudent1);

        ArrayList<String> groupStudent2 = new ArrayList<>();
        groupStudent2.add("zhangsan11");
        groupStudent2.add("zhangsan22");
        groupStudent2.add("zhangsan33");
        classStudent.put(2, groupStudent2);
        ArrayList<String> groupStudent3 = new ArrayList<>();
        groupStudent3.add("zhangsan111");
        groupStudent3.add("zhangsan222");
        groupStudent3.add("zhangsan333");
        classStudent.put(3, groupStudent3);

        for (Map.Entry<Integer, ArrayList<String>> entry : classStudent.entrySet()) {
            System.out.println("第" + entry.getKey() + "组学员:");
            ArrayList<String> groupStudent = entry.getValue();
            for (String s : groupStudent) {
                System.out.println(s);
            }
        }
        Scanner scanner = new Scanner(System.in);
        //（2）再从键盘输入姓名，查询他的手机号码
        System.out.print("请输入要姓名:");
        String inputName = scanner.next();
        System.out.println();
        boolean flag = false;
        for (Map.Entry<Integer, ArrayList<String>> entry : classStudent.entrySet()) {
            ArrayList<String> groupStudent = entry.getValue();
            if (groupStudent.contains(inputName)) {
                flag = true;

            }
        }
        System.out.println(flag ? "在" : "不在");


    }
}
