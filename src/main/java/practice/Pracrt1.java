package practice;

import java.util.Stack;

public class Pracrt1 {

    Stack<Integer> stack = new Stack<>();
    int limit = 1048575;
    boolean error = false;

    private void push(Integer n) {
        if(n > limit) {
            error = true;
            return;
        }
        stack.push(n);
        //display();
    }

    private void pop() {
        if(stack.isEmpty()) {
            error = true;
            return;
        }
        stack.pop();
        //display();
    }

    private void dup() {
        if(stack.isEmpty()) {
            error = true;
            return;
        }
        int r = stack.peek();
        stack.push(r);
        //display();
    }

    private void plus() {
        int x = stack.pop();
        int y = stack.pop();
        int r = x + y;
        if(r > limit) {
            error = true;
            return;
        }
        stack.push(r);
        //display();
    }

    private void minus() {
        if(stack.isEmpty()) {
            error = true;
            return;
        }
        int x = stack.pop();

        if(stack.isEmpty()) {
            error = true;
            return;
        }

        int y = stack.pop();
        int r = x - y;
        if(r < 0) {
            error = true;
            return;
        }
        stack.push(r);
        //display();
    }

    private Integer result() {
        if(stack.isEmpty()) {
            error = true;
        }

        if(error) return -1;
        return stack.pop();
    }

    public int solution(String S) {
        String arr[] = S.split(" ");
        for(int i=0;  i< arr.length; i++) {
            String word = arr[i];
            if(word.equals("POP")) {
                pop();
            } else if(word.equals("DUP")) {
                dup();
            } else if (word.equals("+")) {
                plus();
            } else if (word.equals("-")) {
                minus();
            } else {
                Integer n = Integer.parseInt(word);
                push(n);
            }
        }
        return result();
    }

    private void display() {
        Stack<Integer> aux = new Stack<>();

        while(!stack.isEmpty()) {
            Integer n = stack.pop();
            System.out.println(n);
            aux.push(n);
        }

        System.out.println("----------------------");
        while(!aux.isEmpty()) {
            stack.push(aux.pop());
        }
        System.out.println("----------------------");

    }




    public static void main(String[] args) {
        Pracrt1 obj = new Pracrt1();
        System.out.println(obj.solution("4 5 6 - 7 +"));;
    }

}
