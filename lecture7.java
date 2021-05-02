import java.util.*;
public class lecture7
{
	public static void main(String[] args) {
	   // transpose();
	   // rotate90();
	   // exitPoint();
	   //spiral();
	   ArrayList();
	}
	public static void ArrayList(){
	   // ArrayList<Integer>al= new ArrayList<Integer>();
	   // System.out.println(al.size());
	   // System.out.println(al);
	   // al.add(10);
	   // al.add(20);
	   // al.add(30);
	   // al.add(40);
	   // al.add(50);
	   // System.out.println(al);
	   // al.add(2,16);
	   // System.out.println(al);
	    
	   //// al[1];
	   //int val=al.get(1);
	   //System.out.println(val);
	   
	   ////al[1]=14;
	   //al.set(1,14);
	   
	   //System.out.println(al);
	   
	   //al.remove(1);
	   
	   //System.out.println(al);
	   
	   //System.out.println(al.size());
	   
	   
	   //for(int i=0;i<al.size();i++){
	   //    System.out.print(al.get(i)+" ");
	   //}
	   //System.out.println();
	   //for(int ele: al){
	   //    System.out.print(ele+" ");
	   //}
	   ArrayList<ArrayList<Integer>>al2d= new ArrayList<>();
	   System.out.println(al2d);
	   for(int i=0;i<5;i++){
	       al2d.add(new ArrayList<Integer>());
	   }
	   System.out.println(al2d);
	   al2d.get(1).add(10);
	   al2d.get(1).add(20);
	   al2d.get(1).add(30);
	   al2d.get(4).add(50);
	   System.out.println(al2d);
	   al2d.get(1).set(1,15);
	}
	
	
	
	
	
	
	
	
	
	public static void spiral(){
	    int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
	    int tle= arr.length*arr[0].length;
	    int dir=-1;
	    int sr=0,er=arr.length-1,sc=0,ec=arr[0].length-1;
	    while(tle!=0){
	        dir=(dir+1)%4;
	        if(dir==0){
	            for(int i=sc;i<=ec;i++){
	            System.out.print(arr[sr][i]+" ");
	            tle--;
	          }
	          sr++;
	        }
	        else if(dir==1){
	            for(int i=sr;i<=er;i++){
	                System.out.print(arr[i][ec]+" ");
	                tle--;
	            }
	            ec--;
	        }
	        else if(dir==2){
	            for(int i=ec;i>=sc;i--){
	                System.out.print(arr[er][i]+" ");
	                tle--;
	            }
	            er--;
	        }
	        else{
	            for(int i=er;i>=sr;i--){
	                System.out.print(arr[i][sc]+" ");
	                tle--;
	            }
	            sc++;
	        }
	    }
	}
	public static void exitPoint(){
	    int arr[][]={{0,0,1,1},{0,1,0,1},{0,1,1,0}};
	    int dir=0;
	    int i=0,j=0;
	    while(true){
	       dir=(dir+arr[i][j])%4;
	       if(dir==0){
	           j++;
	       }
	       else if(dir==1){
	           i++;
	       }
	       else if(dir==2){
	           j--;
	       }
	       else{
	           i--;
	       }
	       if(i<0){
	           i++;
	           break;
	       }
	       else if(j<0){
	           j++;
	           break;
	       }
	       else if(i==arr.length){
	           i--;
	           break;
	       }
	       else if(j==arr[0].length){
	           j--;
	           break;
	       }
	    }
	    System.out.println(i+" "+j);
	}
	public static void rotate90(){
	    int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
	    for(int i=0;i<arr.length;i++){
	        for(int j=i+1;j<arr[0].length;j++){
	            int temp= arr[i][j];
	            arr[i][j]=arr[j][i];
	            arr[j][i]= temp;
	        }
	    }
	    for(int i=0;i<arr.length;i++){
	        int l=0,h=arr.length-1;
	        while(l<h){
	            int temp= arr[i][l];
	            arr[i][l]=arr[i][h];
	            arr[i][h]=temp;
	            l++;
	            h--;
	        }
	    }
	}
	
	public static void transpose(){
	    int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
	    for(int i=0;i<arr.length;i++){
	        for(int j=i+1;j<arr[0].length;j++){
	            int temp= arr[i][j];
	            arr[i][j]=arr[j][i];
	            arr[j][i]= temp;
	        }
	    }
	    for(int i=0;i<arr.length;i++){
	        for(int j=0;j<arr[0].length;j++){
	            System.out.print(arr[i][j]+" ");
	        }
	        System.out.println();
	    }
	}
}

