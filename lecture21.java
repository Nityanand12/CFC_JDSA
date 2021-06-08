import java.util.*;
public class lecture21 {
  public static void main(String[] args) {
    // knapSack();
    // LCS();
    // MCM();
  }
  public static void MCM(){
    int arr[]= {10,20,30,40};
    int dp[][]= new int[arr.length][arr.length];
    for(int i=0;i<dp.length;i++){
      for(int j=0;j<dp[0].length;j++){
        dp[i][j]=-1;
      }
    }
    System.out.println(MCM_Memoization(0,arr.length-1,arr,dp));
  }
  public static int MCM_Memoization(int i,int j,int arr[],int dp[][]){
    if(i+1==j){
      return 0;
    }
    if(dp[i][j]!=-1) return dp[i][j];
    int l=arr[i],r=arr[j];
    int ans=Integer.MAX_VALUE;
    for(int cut=i;cut<j-1;cut++){
      int left= MCM_Memoization(i,cut+1,arr,dp);
      int right= MCM_Memoization(cut+1,j,arr,dp);
      ans=Math.min(ans,left+right+l*r*arr[cut+1]);
    }
    return dp[i][j]= ans;
  }
  public static void LCS(){
    String x="Saturday";
    String y="Sunday";
    int dp[][]= new int[x.length()+1][y.length()+1];
    for(int i=0;i<dp.length;i++){
      for(int j=0;j<dp[0].length;j++){
        dp[i][j]=-1;
      }
    }
    // System.out.println(LCS_Memoization(x,y,x.length(),y.length(),dp));
    System.out.println(LCS_Tabulation(x,y,dp));
    for(int i=0;i<dp.length;i++){
      for(int j=0;j<dp[0].length;j++){
        System.out.print(dp[i][j]+" ");
      }
      System.out.println();
    }
  }
  public static int LCS_Tabulation(String x,String y,int dp[][]){
    for(int i=0;i<=x.length();i++){
      for(int j=0;j<=y.length();j++){
        if(i==0||j==0){
          dp[i][j]=0;
          continue;
        }
        if(x.charAt(i-1)==y.charAt(j-1)){
          dp[i][j]=dp[i-1][j-1]+1;
        }
        else{
          dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    return dp[dp.length-1][dp[0].length-1];
  }
  public static int LCS_Memoization(String x,String y,int xPos,int yPos,int dp[][]){
    if(xPos==0||yPos==0){
      return 0;
    }
    if(dp[xPos][yPos]!=-1) return dp[xPos][yPos];
    if(x.charAt(xPos-1)==y.charAt(yPos-1)){
      dp[xPos][yPos]=LCS_Memoization(x, y, xPos-1, yPos-1,dp)+1;
    }
    else{
      int a=LCS_Memoization(x,y,xPos-1,yPos,dp);
      int b= LCS_Memoization(x,y,xPos,yPos-1,dp);
      dp[xPos][yPos]=Math.max(a, b);
    }
    return dp[xPos][yPos];
  }
  public static void knapSack(){
    int wt[]={2,3,5,4};
    int val[]={10,8,12,27};
    int cap=7;
    int dp[][]=new int[wt.length+1][cap+1];
    // System.out.println(knapSackMemoization(wt,val,cap,wt.length,dp));
    System.out.println(knapSackTabulation(wt,val,cap,dp));
    for(int i=0;i<dp.length;i++){
      for(int j=0;j<dp[0].length;j++){
        System.out.print(dp[i][j]+" ");
      }
      System.out.println();
    }

  }
  public static int knapSackTabulation(int wt[],int val[],int cap,int dp[][]){
    for(int i=0;i<=wt.length;i++){
      for(int j=0;j<=cap;j++){
        if(i==0||j==0){
          // jus for base case
           dp[i][j]= 0;
           continue;
        }
        int left=0,right=0;
        if(j>=wt[i-1]){
          left= dp[i-1][j];
          right= dp[i-1][j-wt[i-1]]+val[i-1];
        }
        else{
          left= dp[i-1][j];
        }
         dp[i][j]= Math.max(left,right);
      }
    }
    return dp[dp.length-1][dp[0].length-1];
  }
  public static int knapSackMemoization(int wt[],int val[],int cap,int pos,int dp[][]){
    if(pos==0||cap==0){
      return dp[pos][cap]= 0;
    }
    if(dp[pos][cap]!=0){
      return dp[pos][cap];
    }
    int left=0,right=0;
    if(cap>=wt[pos-1]){
      left= knapSackMemoization(wt,val,cap,pos-1,dp);
      right= knapSackMemoization(wt,val,cap-wt[pos-1],pos-1,dp)+val[pos-1];
    }
    else{
      left= knapSackMemoization(wt,val,cap,pos-1,dp);
    }
    return dp[pos][cap]= Math.max(left,right);
  }
}
