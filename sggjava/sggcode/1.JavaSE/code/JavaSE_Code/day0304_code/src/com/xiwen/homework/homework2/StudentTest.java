package com.xiwen.homework.homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/4-23:30
 * @Version: 1.0
 */
public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("谢霆锋", 85));
        list.add(new Student("章子怡", 63));
        list.add(new Student("刘亦菲", 77));
        list.add(new Student("黄晓明", 33));
        list.add(new Student("岑小村", 92));

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getScore(), o2.getScore());
            }
        });

        Collections.sort(list, (o1, o2) -> Double.compare(o1.getScore(), o2.getScore()));
        Collections.sort(list, Comparator.comparingDouble(Student::getScore));

        System.out.println(list);
    }
}
