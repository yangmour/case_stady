package com.xiwen.exercise1;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/24-10:40
 * @Version: 1.0
 */
public class MyArrayList<E> implements Iterable<E> {

    private Object[] elements = new Object[5];
    private int size;

    public void add(E e) {
        grow();
        elements[size++] = e;
    }

    public void add(int index, E e) {
        checkIndex(index, index > size);
        grow();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = e;
        size++;
    }

    private void grow() {
        if (size == elements.length) {
            // 1.5倍扩容
            elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }
    }

    /**
     * 1,2,3,4,5
     * index = 5
     *
     * @param index
     */
    public void remove(int index) {
        checkIndex(index, index >= size);

        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    public void remove(E e) {
        int i = indexOf(e);
        if (i != -1) {
            remove(i);
        }

    }

    private void checkIndex(int index, boolean index1) {
        if (index < 0 || index1) {
            throw new ArrayIndexOutOfBoundsException("下标超过范围！");
        }
    }

    public int indexOf(E e) {
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (e == elements[i]) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        if (e == null) {
            for (int i = size; i > 0; i--) {
                if (e == elements[i]) {
                    return i;
                }
            }
        } else {
            for (int i = size; i > 0; i--) {
                if (e.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    public void set(int index, E e) {
        checkIndex(index, index >= size);
        elements[index] = e;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {

        int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            return (E) elements[cursor++];
        }
    }
}
