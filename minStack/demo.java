import java.io.*;

public class demo {
    public static void main(String[] args)
    {
        getMinStack s = new getMinStack();

        // for showing where error could occur
        // s.push(999999999);
        // System.out.println("The top is " + s.peek());
        // System.out.println("the min in stack is " + s.getMin());
        // s.push(-888888888);
        // System.out.println("The top is " + s.peek());
        // System.out.println("the min in stack is " + s.getMin());
        // s.push(-999999999);
        // System.out.println("the min in stack is " + s.getMin());
        // System.out.println("the element popped is : " + s.pop());
        // System.out.println("the element popped is : " + s.pop());
        // System.out.println("the min in stack is " + s.getMin());
        // System.out.println("The top is " + s.peek());
        // end here
        s.push(6);
        System.out.println("The top is " + s.peek());
        System.out.println("the min in stack is " + s.getMin());
        s.push(-2);
        System.out.println("The top is " + s.peek());
        System.out.println("the min in stack is " + s.getMin());
        s.push(-5);
        System.out.println("the min in stack is " + s.getMin());
        System.out.println("the element popped is : " + s.pop());
        System.out.println("the element popped is : " + s.pop());
        System.out.println("the min in stack is " + s.getMin());
        System.out.println("The top is " + s.peek());
    }
    
}
