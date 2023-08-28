package oj.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ImplementStackusingQueues_225 {
    class MyStack {

        ArrayList<Integer> queue;
        public MyStack() {
            queue = new ArrayList<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            return queue.remove(queue.size()-1);
        }

        public int top() {
            return queue.get(queue.size()-1);
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
