package backtracking;

public class subsets {
    public static void subset(StringBuilder string,StringBuilder subset,int i){
        if (i==string.length()){
            if (subset.length()==0){
                System.out.println("null");
                return;
            }
            System.out.println(subset);
            return;
        }
        subset(string,new StringBuilder(subset.append(string.charAt(i))) ,i+1);
        subset.deleteCharAt(subset.length()-1);
        subset(string,new StringBuilder(subset),i+1);  
    }
    public static void main(String[] args) {
        StringBuilder string=new StringBuilder("abcde");
        StringBuilder subset=new StringBuilder("");
        subset(string,subset,0);
    }
}
