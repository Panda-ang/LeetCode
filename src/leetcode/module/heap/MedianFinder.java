package leetcode.module.heap;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>((a ,b) -> a - b);

    public void addNum(int num) {
        if (left.size() == right.size()){
            right.add(num);
            left.add(right.poll());
        }else {
            left.add(num);
            right.add(left.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()){
            return left.peek();
        }else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}
