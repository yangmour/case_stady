package com.xiwen.hashtable;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/16-18:50
 * @Version: 1.0
 */
public class HashTableDemo {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("del: 删除雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();

                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTable.findEmpById(id);
                    break;
                case "del":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTable.delEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }

        }

    }

}

class HashTable {
    private EmpLindeList[] empLindeListArray;
    private int size;

    public HashTable(int size) {
        this.empLindeListArray = new EmpLindeList[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            empLindeListArray[i] = new EmpLindeList();
        }
    }

    public void add(Emp emp) {
        int hashFunNO = hashFun(emp.id);
        empLindeListArray[hashFunNO].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLindeListArray[i].list(i);

        }
    }

    public void findEmpById(int id) {
        int hashFunNO = hashFun(id);
        Emp emp = empLindeListArray[hashFunNO].findEmpById(id);

        if (emp != null) {
            System.out.print("找到了:" + emp);
        } else {
            System.out.println("没找到");
        }

    }

    public void delEmpById(int id) {
        int hashFunNO = hashFun(id);
        boolean emp = empLindeListArray[hashFunNO].delEmpById(id);

        if (emp) {
            System.out.println("删除成功");
        } else {
            System.out.println("没找到");
        }

    }


    // 编写散列函数 使用简答的取模方法
    public int hashFun(int id) {
        return id % size;
    }


}

// 管理链表
class EmpLindeList {
    public Emp head;

    public EmpLindeList() {
    }

    /**
     * 添加
     *
     * @param emp 添加的数据
     */
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }


        Emp curTemp = head;
        while (true) {
            if (curTemp.next == null) {
                curTemp.next = emp;
                return;
            }
            curTemp = curTemp.next;

        }

    }

    // 显示链表的数据
    public void list(int i) {
        if (head == null) {
            System.out.println("第" + (i + 1) + "链表为空！");
            return;
        }

        Emp curTemp = head;

        System.out.print("第" + (i + 1) + "链表:\t");
        while (true) {
            System.out.print("=> " + curTemp);
            if (curTemp.next == null) {
                System.out.println();
                return;
            }
            curTemp = curTemp.next;
        }


    }

    public Emp findEmpById(int id) {

        if (head == null) {
            System.out.println("链表为空！");
            return null;
        }

        Emp cur = head;

        while (true) {

            if (cur.id == id) {
                return cur;
            }

            if (cur.next == null) {
                return null;
            }
            cur = cur.next;
        }
    }

    public boolean delEmpById(int id) {

        if (head == null) {
            //System.out.println("链表为空！");
            return false;
        }

        Emp cur = head;
        boolean flag = false;

        while (true) {
            // 先确定当前的id是不是
            if (cur.id == id) {
                head = cur.next;
                flag = true;
                break;
            }

            if (cur.next == null) {
                break;
            }

            // 判断下一个是不是
            if (cur.next.id == id){
                cur.next = cur.next.next;
                flag = true;
                break;
            }

            cur = cur.next;
        }

        return flag;


    }


}

// 创建链表
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
