package com.xiwen;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/18-11:16
 * @Version: 1.0
 */
public class Test1 {

//    public static void main(String[] args) {
//
////        Properties properties = System.getProperties();
////        System.out.println(properties);
////
////        int[] arr = {1,2,3,4,5};
////        int[] arr2 = new int[5];
////        System.out.println(Arrays.toString(arr));
////
////        System.arraycopy(arr,1,arr2,0,4);
////        System.out.println(Arrays.toString(arr2));
//
//

//    }
}

class Db {
    int i=20;
    int j=30;
    void f() {
        System. out . print("" + i);
    }
}



class DbTest2 extends Db {
    int i=30;
    int k=40;

    public static void main(String[] args) {

        Db d = new DbTest2();
        System.out.println(d.i);//20
        d.f();//30
        DbTest2 d2 = (DbTest2) d;
        System. out. println(d2.i);//30
        d2.f();//30

    }

    void f() {
        System. out.print("" + i);
    }

    void g() {
        System. out.print("" + k);
    }

}