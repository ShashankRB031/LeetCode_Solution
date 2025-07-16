import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    public void push(int x) {
        // Add the new element to q2
        q2.offer(x);

        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        // Swap q1 and q2 so that q1 always has the latest stack order
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    public int pop() {
        // Remove and return the top element
        return q1.poll();
    }
    public int top() {
        // Return the top element without removing
        return q1.peek();
    }
    public boolean empty() {
        // Return true if the stack is empty
        return q1.isEmpty();
    }
}
