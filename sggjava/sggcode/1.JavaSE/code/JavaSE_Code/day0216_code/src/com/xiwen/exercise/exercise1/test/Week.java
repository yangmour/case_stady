package com.xiwen.exercise.exercise1.test;

public enum Week {
    MONDAY("星期一",1),
    TUESDAY("星期二",2),
    WEDNESDAY("星期三",3),
    THURSDAY("星期四",4),
    FRIDAY("星期五",5),
    SATURDAY("星期六",6),
    SUNDAY("星期日",7);

    private final String name;
    private final int value;

    //构造器默认就是private，也只能是private
/*    Week() {
        name = "";
        value = 0;
    }*/

    Week(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString() + "，名称：" + name + "，星期值：" + value;
    }

}

/*public class Week {
   public static final Week MONDAY = new Week("星期一",1);
   public static final Week TUESDAY = new Week();
   public static final Week WEDNESDAY = new Week();
   public static final Week THURSDAY = new Week();
   public static final Week FRIDAY = new Week();
   public static final Week SATURDAY = new Week();
   public static final Week SUNDAY = new Week();

   private String name;
   private int value;

    private Week(){

    }
    private Week(String name, int value){
        this.name = name;
        this.value = value;
    }

    ///....省略一堆方法

    @Override
    public String toString() {
        return "Week{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}*/
