import java.util.*;
public class stack {
    public static void pushatbottom(Stack<Integer> stack,int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top=stack.pop();
        pushatbottom(stack, data);
        stack.push(top);
    }
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        // String result = new String("");
        // using string
        // while(!s.isEmpty()){
        //     char curr=s.pop();
        //     result+=curr;
        // }
        // return result;
        // using stringbuilder
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char curr=s.pop();
            result.append(curr);
        }
        return result.toString();
    }
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverseStack(s);
        pushatbottom(s, top);
    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop()); 
        }
    }
    public static void main(String[] args) {
        //  java--collection--frameworks
        Stack<Integer> s= new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushatbottom(s,4);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        System.out.println(reverseString("abcde"));
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        // printStack(st); 
        reverseStack(st);
        printStack(st);
    }
}
