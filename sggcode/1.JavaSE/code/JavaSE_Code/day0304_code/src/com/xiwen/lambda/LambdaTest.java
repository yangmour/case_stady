package com.xiwen.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/4-10:34
 * @Version: 1.0
 */
public class LambdaTest {
    @Test
    public void test() {

        ArrayList<Character> characterArrayList = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            characterArrayList.add((char) ('a' + i));
        }

        characterArrayList.forEach((c) -> System.out.println(c));
    }

    @Test
    public void test2() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "C");
        map.put(3, "Python");
        map.put(4, "C++");
        map.put(5, "C#");
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @Test
    public void test3() {
        //案例需求：使用Lambda表达式给Supplier接口赋值，实现产生1个100以内的整数功能。
        Supplier<Integer> supplier = () -> (int) (Math.random() * 100);
        System.out.println(supplier.get());

    }


    @Test
    public void test4() {
        //案例需求
        //- 声明一个Employee员工类型，包含属性编号、姓名、薪资，属性私有化，提供有参构造，get/set，重写toString。
        //- 添加n个员工对象到一个HashMap<Integer,Employee>集合中，其中员工编号为key，员工对象为value。
        //- 调用Map的forEach遍历集合
        //- 调用Map的replaceAll方法，将其中薪资低于10000元的，薪资设置为10000。
        //- 再次调用Map的forEach遍历集合查看结果
        HashMap<Integer, Employee> map = new HashMap<>();
        map.put(1, new Employee(1, "张三", 2000));
        map.put(2, new Employee(2, "李四", 4000));
        map.put(3, new Employee(3, "王五", 3000));
        map.put(4, new Employee(4, "王2", 15000));
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        map.replaceAll((k, v) -> {
            if (v.getSalary() < 10000) {
                v.setSalary(10000);
            }
            return v;
        });
        System.out.println("_-----------------");
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @Test
    public void test5() {
/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/4-10:48
 * @Version: 1.0
 */
        class Employee {
            private int id;
            private String name;
            private String gender;
            private int age;
            private double salary;

            public Employee(int id, String name, double salary) {
                this.id = id;
                this.name = name;
                this.salary = salary;
            }

            public Employee(int id, String name, String gender, int age, double salary) {
                this.id = id;
                this.name = name;
                this.gender = gender;
                this.age = age;
                this.salary = salary;
            }

            public Employee() {
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getSalary() {
                return salary;
            }

            public void setSalary(double salary) {
                this.salary = salary;
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", gender='" + gender + '\'' +
                        ", age=" + age +
                        ", salary=" + salary +
                        '}';
            }
        }

        class EmployeeSerice {
            private ArrayList<Employee> all;

            public EmployeeSerice(ArrayList<Employee> all) {
                this.all = all;
            }

            public void add(Employee e) {
                all.add(e);
            }

            public ArrayList<Employee> getAll() {
                return all;
            }

            public ArrayList<Employee> get(Predicate<Employee> p) {
                ArrayList<Employee> employees = new ArrayList<>();
                all.forEach(e -> {
                    if (p.test(e)) {
                        employees.add(e);
                    }
                });
                return employees;
            }
        }

        //案例需求：
        //
        //（1）声明一个Employee员工类型，包含编号、姓名、性别，年龄，薪资。属性私有化，提供有参构造，get/set，重写toString。
        //
        //（2）声明一个EmployeeSerice员工管理类
        //
        //- 包含一个private 的属性ArrayList<Employee> all。
        //- 包含public void add(Employee emp)方法，可以添加员工到all集合中
        //- 包含public ArrayList<Employee> get(Predicate<Employee> p)，即将满足p指定的条件的员工，添加到一个新的ArrayList<Employee> 集合中返回。
        //
        //
        //（3）在测试类中创建EmployeeSerice员工管理类的对象，添加一些员工对象，之后调用get方法，分别获取：
        //
        //* 所有员工对象
        //* 所有年龄超过35的员工
        //* 所有薪资高于15000的女员工
        //* 所有编号是偶数的员工
        //* 名字是“张三”的员工
        //* 年龄超过25，薪资低于10000的男员工
        ArrayList<Employee> employees = new ArrayList<>();
        EmployeeSerice employeeSerice = new EmployeeSerice(employees);
        employeeSerice.add(new Employee(1, "张三", "男", 26, 4000));
        employeeSerice.add(new Employee(2, "李四", "女", 36, 8000));
        employeeSerice.add(new Employee(3, "王五", "男", 10, 12000));

        employeeSerice.getAll().forEach(v -> System.out.println(v));

        System.out.println("---------------");
        ArrayList<Employee> ageList = employeeSerice.get(e -> e.getAge() > 35);
        ageList.forEach(v -> System.out.println(v));

        System.out.println("---------------");
        ArrayList<Employee> salaryAndGenderList = employeeSerice.get(e -> e.getSalary() > 15000 && "女".equals(e.getGender()));
        salaryAndGenderList.forEach(v -> System.out.println(v));

        System.out.println("---------------");
        ArrayList<Employee> idList = employeeSerice.get(e -> e.getId() % 2 == 0);
        idList.forEach(v -> System.out.println(v));

        System.out.println("---------------");
        ArrayList<Employee> zhangSanList = employeeSerice.get(e -> "张三".equals(e.getName()));
        zhangSanList.forEach(v -> System.out.println(v));

        System.out.println("---------------");
        ArrayList<Employee> ageSalaryGenderList = employeeSerice.get(e -> e.getAge() > 25 && e.getSalary() < 10000 && "男".equals(e.getGender()));
        ageSalaryGenderList.forEach(v -> System.out.println(v));
    }

    @Test
    public void test6() {
        String str = "1234234324";
        String[] split = str.split("|");
        System.out.println(Arrays.toString(split));

    }

    // 新特性文本块
//    @Test
//    public void test7() {
//
//        String text = """
//
//                人最宝贵的东西是生命，生命对人来说只有一次。\
//
//                因此，人的一生应当这样度过：当一个人回首往事时，\
//
//                不因虚度年华而悔恨，也不因碌碌无为而羞愧；\
//
//                这样，在他临死的时候，能够说，\
//
//                我把整个生命和全部精力都献给了人生最宝贵的事业\
//
//                ——为人类的解放而奋斗。
//
//                """;
//        System.out.println(text);
//    }
//
//    @Test
//    public void test8() {
//        String str = """
//                <html>
//                  <body>
//                      <p>Hello, world</p>
//                  </body>
//                </html>
//                """;
//        System.out.println(str);
//    }

}
