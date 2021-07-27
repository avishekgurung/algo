package practice;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class LabTest {


    private static String infixToPostfix(String infix) {
        String output = "";
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('-', 0);
        priority.put('+', 1);
        priority.put('*', 2);
        priority.put('/', 3);


        for(int i=0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if(c == '-' || c == '+' || c == '*' || c == '/') {
                while(!stack.isEmpty() && stack.peek() != '(' && priority.get(c) <= priority.get(stack.peek())) {
                    output = output + stack.pop();
                }
                stack.push(c);
            }
            else if(c == '(') {
                stack.push(c);
            }
            else if(c == ')') {
                while(stack.peek() != '(') {
                    output = output + stack.pop();
                }
                stack.pop();
            }
            else {
                output = output + c;
            }
        }

        while(!stack.isEmpty()) {
            output = output + stack.pop();
        }

        return output;

    }

    private static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if(c == '-' || c == '+' || c == '*' || c == '/') {
                int y = stack.pop();
                int x = stack.pop();
                if(c == '-') stack.push(x - y);
                if(c == '+') stack.push(x + y);
                if(c == '*') stack.push(x * y);
                if(c == '/') stack.push(x / y);
            }
            else {
                stack.push(Integer.parseInt(c+""));
            }
        }
        return stack.pop();
    }

    private static int evaluateInfix(String infix) {
        String arr[] = infix.split(" ");
        Map<String, Integer> priority = new HashMap<>();
        priority.put("-", 0);
        priority.put("+", 1);
        priority.put("*", 2);
        priority.put("/", 3);
        Stack<Integer> operand = new Stack<>();
        Stack<String> operator = new Stack<>();

        for(int i=0; i < arr.length; i++) {
            String element = arr[i];

            if(element.equals("-") || element.equals("+") || element.equals("*") || element.equals("/")) {
                while(!operator.isEmpty() && !operator.peek().equals("(") && priority.get(element) <= priority.get(operator.peek())) {
                    int y = operand.pop();
                    int x = operand.pop();
                    String op = operator.pop();

                    if(op.equals("-")) {
                        operand.push(x-y);
                    }
                    if(op.equals("+")) {
                        operand.push(x+y);
                    }
                    if(op.equals("*")) {
                        operand.push(x*y);
                    }
                    if(op.equals("/")) {
                        operand.push(x/y);
                    }
                }
                operator.push(element);
            }
            else if(element.equals("(")) {
                operator.push(element);
            }
            else if(element.equals(")")) {
                while(!operator.peek().equals("(")) {
                    int y = operand.pop();
                    int x = operand.pop();
                    String op = operator.pop();

                    if(op.equals("-")) {
                        operand.push(x-y);
                    }
                    if(op.equals("+")) {
                        operand.push(x+y);
                    }
                    if(op.equals("*")) {
                        operand.push(x*y);
                    }
                    if(op.equals("/")) {
                        operand.push(x/y);
                    }
                    operator.pop();
                }
            }
            else {
                operand.push(Integer.parseInt(element));
            }
        }

        while(!operator.isEmpty()) {
            int y = operand.pop();
            int x = operand.pop();
            String element = operator.pop();
            if(element.equals("-")) {
                operand.push(x-y);
            }
            if(element.equals("+")) {
                operand.push(x+y);
            }
            if(element.equals("*")) {
                operand.push(x*y);
            }
            if(element.equals("/")) {
                operand.push(x/y);
            }
        }
        return operand.pop();

    }


    private static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int x = stack.pop();
        reverse(stack);
        helper(stack, x);
    }

    private static void helper(Stack<Integer> stack, int element) {
        if(stack.isEmpty()) {
            stack.push(element);
            return;
        }
        int x = stack.pop();
        helper(stack, element);
        stack.push(x);
    }


    private static void span(int arr[]) {
        System.out.println(Arrays.toString(arr));
        int span[] = new int[arr.length];
        for(int i=0; i < arr.length; i++) span[i]=1;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                stack.add(arr[i]);
            }
            else {
                while(arr[i] > stack.peek()) {
                    span[i] = span[i] + getSpan(span, arr, stack.pop());
                }
                stack.push(arr[i]);
            }
        }

        System.out.println(Arrays.toString(span));

    }

    private static int getSpan(int span[], int arr[], int element) {
        for(int i=0; i < arr.length; i++) {
            if(element == arr[i]) {
                return span[i];
            }
        }
        return -1;
    }

    private static void sort(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int element = stack.pop();
        sort(stack);
        helperSort(stack, element);

    }

    private static void helperSort(Stack<Integer> stack, int element) {
        if(stack.isEmpty()) {
            stack.push(element);
            return;
        }

        if(element > stack.peek()) {
            int top = stack.pop();
            helperSort(stack, element);
            stack.push(top);
        }
        else {
            stack.push(element);
        }
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(3);

        sort(stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }


    }
}
