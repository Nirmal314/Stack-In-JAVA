import java.util.ArrayList;

interface stk<T> {
    void push(T val);

    T pop();

    T peek();

    void display();
}

class StackOverFlowException extends Exception {
    public StackOverFlowException() {
        System.out.println("Stack Overflow !!");
    }
}

class StackUnderFlowException extends Exception {
    public StackUnderFlowException() {
        System.out.println("Stack Underflow !!");
    }
}

class St<T> implements stk<T> {
    private int stackSize;
    private int sp = -1;

    St(int stackSize) {
        this.stackSize = stackSize;
    }

    private ArrayList<T> arr = new ArrayList<T>(stackSize);

    @Override
    public void push(T val) {
        if (sp == stackSize - 1) {
            try {
                throw new StackOverFlowException();
            } catch (Exception e) {
                return;
            }
        } else {
            sp++;
            arr.add(val);
            System.out.println(val + " pushed");
        }
    }

    @Override
    public T pop() {
        if (sp == -1) {
            try {
                throw new StackUnderFlowException();
            } catch (Exception e) {
                return null;
            }
        } else {
            T tmp = arr.get(sp);
            sp--;
            System.out.println(tmp + " popped");
            return tmp;
        }
    }

    @Override
    public T peek() {
        if (sp == -1) {
            try {
                throw new StackUnderFlowException();
            } catch (Exception e) {
                return null;
            }
        } else {
            System.out.println("peek : " + arr.get(sp));
            return arr.get(sp);
        }
    }

    @Override
    public void display() {
        if (sp == -1) {
            try {
                throw new StackUnderFlowException();
            } catch (Exception e) {
                System.out.println("Nothing to display.");
                return;
            }
        } else {
            for (int i = 0; i <= sp; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
        }
    }
}

public class Stack {
    public static void main(String[] args) {
        St<Integer> s = new St<Integer>(5);
        s.push(1); // ? push
        s.push(2); // ? push
        s.push(3); // ? push
        s.push(4); // ? push
        s.push(5); // ? push
        s.push(6); // ! stack overflow
        s.display(); // ? 1 2 3 4 5
        s.pop(); // ? pop 5
        s.pop(); // ? pop 4
        s.display(); // ? 1 2 3
        s.peek(); // ? 3
        s.display(); // ? 1 2 3
        s.pop(); // ? pop 3
        s.pop(); // ? pop 2
        s.pop(); // ? pop 1
        s.pop(); // ! stack underflow
        s.peek(); // ! stack underflow
        s.display(); // ! stack underflow
    }
}