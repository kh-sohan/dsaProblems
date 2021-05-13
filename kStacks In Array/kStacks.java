import java.util.*;

public class kStacks {
    int cap, freeSlot, size;
    int[] arr;
    int[] next;     // gives next free slot when ele is pushed into k stack [-1] if no slot available. ALso used for giving previous slot when stack k ele is popped
    int[] top;

    kStacks(int cap, int k) {
        this.cap = cap;
        arr = new int[cap];
        next = new int[cap];
        top = new int[k];
        this.freeSlot = 0;
        Arrays.fill(top, -1);
        for (int i = 0; i < cap - 1; i++) {
            next[i] = i + 1;
        }
        next[cap - 1] = -1;
        this.size = 0;
    }

    boolean isEmpty(int stno) {
        if (top[stno] == -1)
            return true;
        return false;
    }

    boolean isFull(int stno) {
        return (freeSlot == -1);
    }

    void push(int ele, int stno) {
        if (isFull(stno)) {
            System.out.println("No space available");
            return;
        }
        int index = freeSlot;
        arr[index] = ele;
        freeSlot = next[index];
        next[index] = top[stno];
        top[stno] = index;
    }

    void pop(int stno) {
        if (isEmpty(stno)) {
            System.out.println("Stack is empty.");
            return;
        }
        int index = top[stno];
        top[stno] = next[index];
        next[index] = freeSlot;
        freeSlot = index;
        System.out.println(arr[index] + " is popped.");
    }

}

