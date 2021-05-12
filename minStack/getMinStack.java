import java.util.*;
/*
This approach will not work when difference between min and new element which is lesser than min thus becoming candidate
for being assigned to min will be greater than int range. for eg
    st.push(99999999);          here min will be 99999999
    st.push(-88888888);         here ele is smaller than min so we need to push -888888888 - (999999999 + 888888888)
                                                                                so -888888888 - 1888888887 => -2,777,777,775
                                                            overflow occurs here which messes up the program
 */
public class getMinStack {
    Deque<Integer> st;
    private int min;

    getMinStack() {
        st = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int ele) {
        if (st.isEmpty()) {
            st.push(ele);
            this.min = ele;
            return ;
        }
        if (ele > min) {                    // element being pushed is greater than current min
            st.push(ele);
            return;
        }
        st.push(ele - (this.min - ele));     // current element is going to be new min so push top = newMin - diff where diff = (currMin - newMin)
        this.min = ele;
    }

    public int peek() {
        return st.peek();
    }

    public int pop() {
        if (st.isEmpty())
            return getMin();
        int popped = st.pop();
        if (popped <= getMin()) {           // popped element is lesser or equals min so it is a special value
            int diff = getMin() - popped;       // diff = newMin - top (refer push function)
            popped = this.min;                
            this.min += diff;                  // add the diff to currMin to get prevMin
        }
        return popped;
    }

    public int getMin() {
        return this.min;
    }

    public int getSize() {
        return st.size();
    }
}
