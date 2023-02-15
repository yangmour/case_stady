package com.xiwen.exercise.exercise6;

import java.util.Iterator;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-15:30
 * @Version: 1.0
 */
public class MyArrayList implements Iterable<Object> {

    private static Object[] all;
    private int total;

    public MyArrayList() {
        if (all == null) {
            all = new Object[10];
        }
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("hello");
        myArrayList.add("java");
        myArrayList.add("world");
        myArrayList.add("world");
        myArrayList.add("world");
        myArrayList.add("world");
        myArrayList.add("world");
        myArrayList.add("world");
        myArrayList.add("world");
        myArrayList.add("world");
        myArrayList.add("world");

        Iterator<Object> iterator = myArrayList.iterator2();
        /**
         * while (iterator.hasNext()) {
         *   System.out.println(iterator.next());
         * }
          */

        iterator.forEachRemaining(System.out::println);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Object> iterator() {
        return new Itr();
    }

    public Iterator<Object> iterator2() {
        return new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return total != 0;
            }

            @Override
            public Object next() {
                return all[all.length - total--];
            }
        };
    }

    public void add(Object element) {
        if (total == all.length) {
            System.out.println("数组已满！");
            return;
        }
        all[total++] = element;
    }

    private class Itr implements Iterator<Object> {

        int cursor;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return cursor < total;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws if the iteration has no more elements
         */
        @Override
        public Object next() {
            return all[cursor++];
        }

        /**
         * Returns an iterator over elements of type {@code T}.
         *
         * @return an Iterator.
         */

    }
}
