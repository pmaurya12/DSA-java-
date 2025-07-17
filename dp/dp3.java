package dp;

public class dp3 {
    public static int rodCutting(int length[],int price[],int totRod){
        int n=length.length;
        int dp[][]=new int[n+1][totRod+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<totRod+1;j++){
                if(length[i-1]<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][totRod];
    }
     public static int longestCommonSubsequence(String text1, String text2) {
          if(text1.length()==0 || text2.length()==0){
            return 0;
          }
          else if(text1.charAt(text1.length()-1)==text2.charAt(text2.length()-1)){
            return 1+longestCommonSubsequence(text1.substring(0,text1.length()-1),text2.substring(0,text2.length()-1));
          }
          else{
            return Math.max(longestCommonSubsequence(text1,text2.substring(0,text2.length()-1)),longestCommonSubsequence(text1.substring(0,text1.length()-1),text2));
          }
    }
    public static void main(String[] args) {
        int length[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int totRod=8;
        System.out.println(rodCutting(length, price, totRod));
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }
}
