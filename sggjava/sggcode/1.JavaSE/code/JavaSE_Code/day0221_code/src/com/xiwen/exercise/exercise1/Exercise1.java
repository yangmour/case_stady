package com.xiwen.exercise.exercise1;

import org.junit.Test;

import java.util.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/21-10:28
 * @Version: 1.0
 */
public class Exercise1 {
    @Test
    public void test() {

        Random random = new Random();
        Collection collection = new ArrayList();

        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(100);
            collection.add(r);
        }
        collection.add(33);


        System.out.println(collection);

        collection.removeIf((o) -> {
            if ((Integer) o % 10 == 3) {
                return true;
            }
            return false;
        });
        System.out.println(collection);

        //
        int nextInt;
        while (true) {
            System.out.print("请输入一个【0-100】的整数：");
            Scanner scanner = new Scanner(System.in);
            nextInt = scanner.nextInt();
            if (nextInt >= 0 && nextInt <= 100) {
                break;
            }
        }

        boolean b = collection.remove(nextInt);
        System.out.println(b ? "删除成功" : "删除失败");
        System.out.println(collection);


    }

    @Test
    public void test2() {
        Collection collection = new ArrayList();
        collection.add(new Employee(1, "张三", 42340.0));
        collection.add(new Employee(2, "李四", 10000.0));
        collection.add(new Employee(3, "王五", 12222.0));
        collection.add(new Employee(4, "赵六", 70000.0));
        collection.add(new Employee(5, "小明", 14000.0));

        collection.removeIf((o) -> {
            if (((Employee) o).salary > 15000) {
                return true;
            }
            return false;
        });
        System.out.println(collection);


        System.out.println("请输入一个员工姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        boolean flag = false;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Employee next = (Employee) iterator.next();
            if (next.name.equals(name)) {
                flag = true;
                System.out.println(next);
                break;
            }
        }
        System.out.println(flag ? "在" : "不在");
        System.out.println(collection);

    }

    @Test
    public void test3() {
        Random random = new Random();
        Collection collection1 = new ArrayList();

        for (int i = 0; i < 5; i++) {
            int r = random.nextInt(100);
            collection1.add(r);
        }
        collection1.add(33);

        System.out.println(collection1);

        Collection collection2 = new ArrayList();

        for (int i = 0; i < 5; i++) {
            int r = random.nextInt(59);
            collection2.add(r);
        }
        collection2.add(33);


        System.out.println(collection2);

        collection1.retainAll(collection2);
        System.out.println(collection1);
    }
}

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

}