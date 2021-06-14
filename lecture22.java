import java.util.*;

public class lecture22 {

  public static void display(int dp[][]){
    for(int i=0;i<dp.length;i++){
      for(int j=0;j<dp[0].length;j++){
        System.out.print(dp[i][j]+" ");
      }
      System.out.println();
    }
  }
  public static void EditDistance(){
    String x="Saturday";
    String y="Sudayn";
    int dp[][]= new int[x.length()+1][y.length()+1];
    // System.out.println(EditDistanceMemoization(x,y,x.length(),y.length(),dp));
    System.out.println(EditDistanceTabulation(x,y,dp));
    display(dp);
  }
  public static int EditDistanceTabulation(String x,String y,int dp[][]){
    for(int xPos=0;xPos<=x.length();xPos++){
      for(int yPos=0;yPos<=y.length();yPos++){
        if(xPos==0){
         dp[xPos][yPos]= yPos;
         continue;
        }
        if(yPos==0){
           dp[xPos][yPos]=  xPos;
           continue;
        }
        int ans=0;
        if(x.charAt(xPos-1)==y.charAt(yPos-1)){
          ans= dp[xPos-1][yPos-1];//same
        }
        else{
          int a= dp[xPos][yPos-1];//insertion
          int b= dp[xPos-1][yPos];//delition
          int c= dp[xPos-1][yPos-1];//swapping
          ans = Math.min(a,Math.min(b,c))+1;
        }
         dp[xPos][yPos]=  ans;
      }
    }
    return dp[dp.length-1][dp[0].length-1];
  }
  public static int EditDistanceMemoization(String x,String y,int xPos,int yPos,int dp[][]){
    if(xPos==0){
      return dp[xPos][yPos]= yPos;
    }
    if(yPos==0){
      return dp[xPos][yPos]=  xPos;
    }
    if(dp[xPos][yPos]!=0) return dp[xPos][yPos];
    int ans=0;
    if(x.charAt(xPos-1)==y.charAt(yPos-1)){
      ans= EditDistanceMemoization(x, y, xPos-1, yPos-1,dp);//same
    }
    else{
      int a= EditDistanceMemoization(x, y, xPos, yPos-1,dp);//insertion
      int b= EditDistanceMemoization(x, y, xPos-1, yPos,dp);//delition
      int c= EditDistanceMemoization(x, y, xPos-1, yPos-1,dp);//swapping
      ans = Math.min(a,Math.min(b,c))+1;
    }
    return dp[xPos][yPos]=  ans;
  }
  public static void LIS_Tabulation(){
    int arr[]={11,2,8,3,9,12,6,10,17,1};
    int dp[]= new int[arr.length];
    for(int i=0;i<arr.length;i++){
      int maximum=0;
      for(int j=i-1;j>=0;j--){
        if(arr[j]<arr[i]){
          maximum=Math.max(maximum,dp[j]);
        }
      }
      dp[i]= maximum+1;
    }
    int ans=0;
    for(int i=0;i<dp.length;i++){
      System.out.print(dp[i]+" ");
      ans=Math.max(ans, dp[i]);
    }
    System.out.println();
    System.out.println(ans);
  }
  public static int  eggDropMemozation(int floor,int egg,int dp[][]){
    if(floor==0) {
      return dp[egg][floor]= 0;
    }
    if(egg==1){
      return dp[egg][floor]= floor;
    }
    if(dp[egg][floor]!=0){
      return dp[egg][floor];
    }
    int ans=Integer.MAX_VALUE;
    for(int f=1;f<=floor;f++){
      int broken=eggDropMemozation(f-1,egg-1,dp);
      int notBroken= eggDropMemozation(floor-f,egg,dp);
      ans=Math.min(ans, Math.max(broken, notBroken)+1);
    }
    return dp[egg][floor]= ans;
  }
  public static int eggDropTabulation(int totalFloor,int totalEgg,int dp[][]){
    for(int egg=1;egg<=totalEgg;egg++){
      for(int floor=0;floor<=totalFloor;floor++){
        if(floor==0) {
           dp[egg][floor]= 0;
           continue;
        }
        if(egg==1){
           dp[egg][floor]= floor;
           continue;
        }
        int ans=Integer.MAX_VALUE;
        for(int f=1;f<=floor;f++){
          int broken=dp[egg-1][f-1];
          int notBroken= dp[egg][floor-f];
          ans=Math.min(ans, Math.max(broken, notBroken)+1);
        }
         dp[egg][floor]= ans;
      }
    }
    return dp[dp.length-1][dp[0].length-1];
  }
  public static void eggDrop(){
    int floor=10,egg=2;
    int dp[][]= new int [egg+1][floor+1];
    // System.out.println(eggDropMemozation(floor,egg,dp));
    System.out.println(eggDropTabulation(floor,egg,dp));
    display(dp);
  }
  public static void main(String[] args) {
    // LIS_Tabulation();
    // EditDistance();
    eggDrop();
  }
}
