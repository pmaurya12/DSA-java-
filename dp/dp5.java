package dp;

public class dp5 {
  public static int cn(int n,int[] dp){
    if(n==0 || n==1){
        return 1;
    }
    if(dp[n]!=0){
        return dp[n];
    }
    int ans=0;
    for(int i=0;i<n;i++){
        ans+=cn(i,dp)*cn(n-i-1,dp);
    }
    dp[n] =ans;
    return dp[n];
  }
  public static void main(String[] args) {
    int n=5;
    int[] dp=new int[n+1]; 
    System.out.println(cn(n,dp));
    int dptab[]=new int[n+1];
    dptab[0]=1;
    dptab[1]=1;
    for(int i=2;i<n+1;i++){
      for(int j=0;j<i;j++){
        dptab[i]+=dptab[j]*dptab[i-j-1];
      }
    }
    System.out.println(dptab[n]);
  }  
}
