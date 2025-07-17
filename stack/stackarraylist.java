import java.util.ArrayList;

public class stackarraylist {
    static class stackB{
        static ArrayList<Integer> list = new ArrayList<>();
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static boolean isEmpty(){
            return list.size()==0;
        }
        public static int peek(){
            return list.get(list.size()-   1);
        } 
    }
    public static void main(String[] args) {
        stackB s = new stackB();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        System.out.println(s.pop());
    }
}
