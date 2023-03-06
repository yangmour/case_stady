package com.xiwen.exercise.exercise1;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-11:32
 * @Version: 1.0
 */
public class Exercise5 {
    public static void main(String[] args) {
        //（1）在数组工具类MyArrays中声明如下泛型方法：
        //
        //- 可以在任意类型的对象数组中，查找某个元素的下标，按照顺序查找，如果有重复的（equals相同），就返回第一个找到的，如果没有返回-1
        //- 可以在任意类型的对象数组中，查找最大值，要求元素或元素的父类必须实现Comparable接口，即<T>可以是T或T的父类
        //- 可以在任意类型的对象数组中，查找最大值，使用定制比较器来比较元素大小，定制比较器的<T>可以是T或T的父类。
        //
        //（2）声明Person类型，包含属性编号（int）、姓名（String），年龄（int），属性私有化，提供有参构造、get/set方法、重写toString方法，重写hashCode和equals方法。
        //
        //
        //（2）声明员工类型Employee，继承Person类型，包含属性薪资（double），属性私有化，提供有参构造、get/set方法、重写toString方法，重写hashCode和equals方法。
        //
        //（3）Person类实现java.lang.Comparable<T>接口，指定T为Person类型，重写抽象方法int compareTo(T t)，按照编号比较大小。
        //
        //（4）声明EmployeeSalaryComparator比较器，实现java.util.Comparator<T>接口，重写int compare(T t1, T t2)方法，指定T为Employee类型，按照薪资比较大小，体重相同的按照姓名字典顺序（使用java.text.Collatord compare方法）比较大小
        //
        //（5）声明PersonAgeComparator比较器，实现java.util.Comparator<T>接口，重写int compare(T t1, T t2)方法，指定T为Person类型，按照年龄比较大小，体重相同的按照编号比较大小
        //
        //（6）在测试类中创建员工对象数组，并调用MyArrays的三个方法测试
        Employee2[] employee2s = new Employee2[5];
        employee2s[0] = new Employee2(3, "张三", 30, 5000D);
        employee2s[1] = new Employee2(2, "李四", 40, 8000D);
        employee2s[2] = new Employee2(1, "汤姆", 10, 1000D);
        employee2s[3] = new Employee2(5, "杰瑞", 40, 6000D);
        employee2s[4] = new Employee2(4, "王五", 20, 4000D);

        Employee2 max = MyArrays.max(employee2s);
        System.out.println(max);

        Person2 person2Age = MyArrays.max(employee2s, new PersonAgeComparator());
        System.out.println(person2Age);

        Employee2 employee2Salary = MyArrays.max(employee2s, new EmployeeSalaryComparator());
        System.out.println(employee2Salary);

        int tomIndex = MyArrays.orderSearch(employee2s, new Employee2(1, "汤姆", 10, 1000D));
        System.out.println("tom下标:" + tomIndex);

    }
}

//（1）在数组工具类MyArrays中声明如下泛型方法：
class MyArrays {

    //- 可以在任意类型的对象数组中，查找某个元素的下标，按照顺序查找，如果有重复的（equals相同），就返回第一个找到的，如果没有返回-1
    public static <T> int orderSearch(T[] t, T v) {
        if (t == null || t.length == 0) {
            return -1;
        }
        for (int i = 0; i < t.length; i++) {
            if (t[i].equals(v)) {
                return i;
            }
        }
        return -1;

    }

    //- 可以在任意类型的对象数组中，查找最大值，要求元素或元素的父类必须实现Comparable接口，即<T>可以是T或T的父类
    public static <T extends Comparable<? super T>> T max(T[] t) {
        if (t == null || t.length == 0) {
            return null;
        }

        T max = t[0];
        for (int i = 1; i < t.length; i++) {
            if (max.compareTo(t[i]) < 0) {
                max = t[i];
            }
        }

        return max;
    }

    //- 可以在任意类型的对象数组中，查找最大值，使用定制比较器来比较元素大小，定制比较器的<T>可以是T或T的父类。
    public static <E> E max(E[] e, Comparator<? super E> comparator) {
        if (e == null || e.length == 0) {
            return null;
        }

        E max = e[0];
        for (int i = 1; i < e.length; i++) {
            if (comparator.compare(max, e[i]) < 0) {
                max = e[i];
            }
        }
        return max;

    }
}

//（2）声明Person类型，包含属性编号（int）、姓名（String），年龄（int），属性私有化，提供有参构造、get/set方法、重写toString方法，重写hashCode和equals方法。
//（3）Person类实现java.lang.Comparable<T>接口，指定T为Person类型，重写抽象方法int compareTo(T t)，按照编号比较大小。
class Person2 implements Comparable<Person2> {
    private int id;
    private String name;
    private int age;

    public Person2(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person2 person = (Person2) o;

        if (id != person.id) return false;
        if (age != person.age) return false;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person2 o) {
        return id - o.getId();
    }
}


//（2）声明员工类型Employee，继承Person类型，包含属性薪资（double），属性私有化，提供有参构造、get/set方法、重写toString方法，重写hashCode和equals方法。
class Employee2 extends Person2 {
    private double salary;

    public Employee2(int id, String name, int age, double salary) {
        super(id, name, age);
        this.salary = salary;
    }

    public Employee2() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee2{" + super.toString() +
                "salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee2 employee2 = (Employee2) o;

        return Double.compare(employee2.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

//（4）声明EmployeeSalaryComparator比较器，实现java.util.Comparator<T>接口，重写int compare(T t1, T t2)方法，指定T为Employee类型
// ，按照薪资比较大小，体重相同的按照姓名字典顺序（使用java.text.Collatord compare方法）比较大小
class EmployeeSalaryComparator implements Comparator<Employee2> {
    @Override
    public int compare(Employee2 o1, Employee2 o2) {
        int dCompare = Double.compare(o1.getSalary(), o2.getSalary());
        if (dCompare == 0) {
            return Collator.getInstance(Locale.CHINA).compare(o1.getName(), o2.getSalary());
        }
        return dCompare;
    }
}

//（5）声明PersonAgeComparator比较器，实现java.util.Comparator<T>接口，重写int compare(T t1, T t2)方法
// ，指定T为Person类型，按照年龄比较大小，体重相同的按照编号比较大小
class PersonAgeComparator implements Comparator<Person2> {

    @Override
    public int compare(Person2 o1, Person2 o2) {
        int i = o1.getAge() - o2.getAge();
        if (i == 0) {
            return o1.compareTo(o2);
        }
        return i;
    }
}