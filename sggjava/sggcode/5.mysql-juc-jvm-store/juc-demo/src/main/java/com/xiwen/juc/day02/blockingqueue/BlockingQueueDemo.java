package com.xiwen.juc.day02.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/02 -15:56
 * @Version: 1.0
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {

        /**
         * BlockingQueue接口主要有以下7个实现类：
         *
         * ☆重要 1. <font color="red">ArrayBlockingQueue：由数组结构组成的有界阻塞队列。</font>
         * ☆重要 2. <font color="red">LinkedBlockingQueue：由链表结构组成的有界（但大小默认值为integer.MAX_VALUE）阻塞队列。</font>
         *   3. PriorityBlockingQueue：支持优先级排序的无界阻塞队列。
         *   4. DelayQueue：使用优先级队列实现的延迟无界阻塞队列。
         * ☆重要 5. <font color="red">SynchronousQueue：不存储元素的阻塞队列，也即单个元素的队列。</font>
         *  6. LinkedTransferQueue：由链表组成的无界阻塞队列。
         *  7. LinkedBlockingDeque：由链表组成的双向阻塞队列。
         */
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        /**
         * 更多操作          抛出异常            特殊值                阻塞                 超时
         * **插入           **add(e)          offer(e)              put(e)            offer(e, time, unit)
         * **移除           **remove()        poll()              take()              poll(time, unit)
         * **检查             **element()     peek()              不可用               不可用
         */
        // 第一组方法：add remove element
//        System.out.println(queue.add("a"));
//        System.out.println(queue.add("b"));
//        System.out.println(queue.add("c"));
//        // System.out.println(queue.add("d"));
//        // System.out.println(queue.element());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        //System.out.println(queue.remove());
//        //System.out.println(queue.element());
        // 第二组：offer poll peek
//        System.out.println(queue.offer("a"));
//        System.out.println(queue.offer("b"));
//        System.out.println(queue.offer("c"));
//        System.out.println(queue.offer("d"));
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
        // 第三组：put take
//        queue.put("a");
//        queue.put("b");
//        queue.put("c");
//        System.out.println(queue.take());
//        queue.put("d");
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take());
        // 第四组：offer poll
        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));
        System.out.println(queue.offer("d", 5, TimeUnit.SECONDS));

    }
}
