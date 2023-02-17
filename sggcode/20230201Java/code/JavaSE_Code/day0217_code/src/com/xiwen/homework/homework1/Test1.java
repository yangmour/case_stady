package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-18:10
 * @Version: 1.0
 */
public class Test1 {
        public static void main(String[] args) {
            new Child("mike");
            // 132

        }
    }

    class People {
        private String name;

        public People() {
            System.out.print("1");
        }

        public People(String name) {
            System.out.print("2");
            this.name = name;
        }
    }

    class Child extends People {
        People father;

        public Child(String name) {
            System.out.print("3");
            father = new People(name + " F");
        }

        public Child() {
            System.out.print("4");
        }
    }

