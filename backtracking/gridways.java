package backtracking;

public class gridways {
    public static int gridway(int i,int j,int n,int m){
        if(i==n-1&&j==m-1)return 1;
        else if(i==n||j==m)return 0;
        return gridway(i+1,j,n,m)+gridway(i,j+1,n,m);
    }
    public static void main(String[] args) {
        int n=2;
        int m=2;
        System.err.println(gridway(0,0,n,m));
    }
}
