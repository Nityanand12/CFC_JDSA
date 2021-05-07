import java.util.*;
public class lecture11 {
  public static void main(String args[]){
    // nokiaKeyPad();
    // nqueen();
    // sudoku();
    // quickSort();
  }

  public static void quickSort(){
    int arr[]={5,4,3,2,1};
    quickSort(arr,0,arr.length-1);
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
  }
  public static int Partition(int arr[],int low,int high){
    int pivot= arr[low];
    int i=low,j=low+1;
    while(j<=high){
      if(arr[j]<=pivot){
        int temp= arr[i+1];
        arr[i+1]=arr[j];
        arr[j]=temp;
        i++;
      }
      j=j+1;
    }
    int temp= arr[low];
    arr[low]=arr[i];
    arr[i]=temp;
    return i;
  }
  public static void quickSort(int arr[],int low,int high){
    if(low<high){
      int pi= Partition(arr,low,high);
      quickSort(arr,low,pi-1);
      quickSort(arr,pi+1,high);
    }
  }
  public static void sudoku(){
    int board[][]={{5,3,0,0,7,0,0,0,0},{6,0,0,1,9,5,0,0,0},{0,9,8,0,0,0,0,6,0},
    {8,0,0,0,6,0,0,0,3},{4,0,0,8,0,3,0,0,1},{7,0,0,0,2,0,0,0,6},{0,6,0,0,0,0,2,8,0},{0,0,0,4,1,9,0,0,5},
    {0,0,0,0,8,0,0,7,9}};
    sudoku(board,0,0);
  }
  public static boolean isSafeForSudoku(int board[][],int i,int j, int val){
    // checking entire column
    for(int k=0;k<board[0].length;k++){
      if(board[i][k]==val){
        return false;
      }
    }
    // checking entire column
    for(int k=0;k<board.length;k++){
      if(board[k][j]==val){
        return false;
      }
    }
    // checking particular box
    i=(i/3)*3;
    j=(j/3)*3;
    for(int k=0;k<3;k++){
      for(int l=0;l<3;l++){
        if(board[i+k][j+l]==val){
          return false;
        }
      }
    }
    return true;
  }
  public static void sudoku(int board[][],int i,int j){
    if(i==board.length-1&&j==board[0].length){
      display(board);
      System.out.println();
      return ;
    }
    if(j==board[0].length){
      i=i+1;
      j=0;
    }
    if(board[i][j]!=0){
      sudoku(board,i,j+1);
    }
    else{
      for(int val=1;val<=9;val++){
        if(isSafeForSudoku(board,i,j,val)){
          board[i][j]=val;
          sudoku(board,i,j+1);
          board[i][j]=0;
        }
      }
    }

  }
  public static void nqueen(){
    int board[][]= new int[4][4];
    nqueen(board,0);
  }

  public static boolean isSafeForQueen(int board[][],int row,int col){
    // row ght rha h
    for(int i=row;i>=0;i--){
      if(board[i][col]==1){
        return false;
      }
    }
    // row ght rha h col bdh rha h
    for(int i=row,j=col;i>=0&&j<board[0].length;i--,j++){
      if(board[i][j]==1){
        return false;
      }
    }
    // row ght rha h col ght rha h
    for(int i=row,j=col;i>=0&&j>=0;i--,j--){
      if(board[i][j]==1){
        return false;
      }
    }
    return true;
  }
  public static void display(int board[][]){
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }
  public static void nqueen(int board[][], int row){
    if(row==board.length){
      display(board);
      System.out.println();
      return;
    }

    for(int col=0;col<board[0].length;col++){
      if(isSafeForQueen(board,row,col)){
        board[row][col]=1;
        nqueen(board,row+1);
        board[row][col]=0;
      }
    }
  }
  public static void nokiaKeyPad(){
    String arr[]={"*,:","abc","def","ghi","jkl","mno","pqr","stu","vwx","yz#"};
      String num="234";
      nokiaKeyPad(arr,num,"",0);
  }

  public static void nokiaKeyPad(String arr[],String num,String ans,int id){
    if(id==num.length()){
      System.out.println(ans);
      return;
    }
    char ch= num.charAt(id);
    for(int i=0;i<arr[ch-'0'].length();i++){
      nokiaKeyPad(arr,num,ans+arr[ch-'0'].charAt(i),id+1);
    }
  }
}
