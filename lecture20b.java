import java.util.*;
public class lecture20b {
  public static void climbingStair(){
    // for k=3
    int n=5;
    int dp[]= new int[n+1];
    // System.out.println(climbingStairMemoization(0,n,dp));
    // for(int i=0;i<=n;i++){
    //   System.out.print(dp[i]+" ");
    // }
    // System.out.println();
    System.out.println(climbingStairTabulation(n,dp));
  }
  public static int climbingStairTabulation(int target,int dp[]){
    for(int i=target;i>=0;i--){
      if(i==target) {
        dp[i]=1;
        continue;
      }
      int a=0;
      // can use loop for greater k value
      if(i+1<dp.length){
        a+=dp[i+1];
      }
      if(i+2<dp.length){
        a+=dp[i+2];
      }
      if(i+3<dp.length){
        a+=dp[i+3];
      }
      dp[i]=a;
    }
    return dp[0];
  }
  public static int climbingStairMemoization(int myPos,int target, int dp[]){
    if(myPos>target) return 0;
    if(myPos==target) return dp[myPos]= 1;
    if(dp[myPos]!=0){
      return dp[myPos];
    }
    int a= climbingStairMemoization(myPos+1,target, dp);
    int b= climbingStairMemoization(myPos+2,target, dp);
    int c= climbingStairMemoization(myPos+3,target, dp);
    return dp[myPos]= a+b+c;
  }
  public static void fibonacci(){
    int n=6;
    int dp[]= new int[n+1];
    System.out.println(fibonacciMemoization(n,dp));
    System.out.println(fibonacciTabulation(n,dp));
  }
  public static int fibonacciTabulation(int n,int dp[]){
    for(int i=0;i<=n;i++){
      if(i<=1){
        dp[i]=i;
        continue;
      }
      dp[i]= dp[i-1]+dp[i-2];
    }
    return dp[n];
  }
  public static int fibonacciMemoization(int n,int dp[]){
    if(n<=1){
      return dp[n]=n;
    }
    int left= fibonacciMemoization(n-1,dp);
    int right= fibonacciMemoization(n-2,dp);
    return dp[n]= left+right;
  }
  public static void main(String[] args) {
    // fibonacci();
    climbingStair();
  }
}
