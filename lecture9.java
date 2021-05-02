import java.util.*;
public class lecture9 
{
    public static int cnt=0;
	public static void main(String[] args) {
	  //  DEC(6); //6 5 4 3 2 1
	  //  Inc(6); //1 2 3 4 5 6 
	   
	  //  System.out.println(Fibo(5));
	   int arr[]={1,2,5,6};
	   int tar=7;
	  //  Type1(tar,arr,0,"");
	  //  Type2(tar,arr,0,"",0);
	  //  Type3(tar,arr,0,"",0);
	   int vis[]= new int[arr.length];
	   Type4(tar,arr,0,"",vis);
	   System.out.println(cnt+" Total num of count");
	}
	public static void Type4(int tar,int arr[],int sum,String ans,int vis[]){
	    if(sum==tar){
	        System.out.println(ans);
	        cnt++;
	        return;
	    }
	    for(int i=0;i<arr.length;i++){
	        if(vis[i]==0&&sum+arr[i]<=tar){
	            vis[i]=1;
	            Type4(tar,arr,sum+arr[i],ans+arr[i],vis);
	            vis[i]=0;
	        }
	    }
	}
	
	
	public static void Type3(int tar,int arr[],int sum,String ans,int id){
	    if(sum==tar){
	        System.out.println(ans);
	        cnt++;
	        return;
	    }
	    
	    for(int i=id;i<arr.length;i++){
	        if(sum+arr[i]<=tar){
	            Type3(tar,arr,sum+arr[i], ans+arr[i],i+1);
	        }
	    }
	}
	public static void Type2(int tar,int arr[],int sum,String ans,int id){
	    if(sum==tar){
	        System.out.println(ans);
	        cnt++;
	        return;
	    }
	    
	    for(int i=id;i<arr.length;i++){
	        if(sum+arr[i]<=tar){
	            Type2(tar,arr,sum+arr[i], ans+arr[i],i);
	        }
	    }
	}
	
	public static void Type1(int tar,int arr[],int sum,String ans){
	    
	    if(sum==tar){
	        System.out.println(ans);
	        cnt++;
	        return;
	    }
	    
	    for(int i=0;i<arr.length;i++){
	        if(sum+arr[i]<=tar){
	            Type1(tar,arr,sum+arr[i], ans+arr[i]);
	        }
	    }
	}
	
	
	
	
	
	
	public static int Fibo(int n){
	    if(n==0||n==1){
	        return 1;
	    }
	    int a= Fibo(n-1);
	    int b= Fibo(n-2);
	    return a+b;
	    
	}
	
	
	public static void Inc(int n){
	    if(n==0){
	        return;
	    }
	   Inc(n-1);
	   System.out.print(n+" ");
	}
	public static void DEC(int n){
	    if(n==0){
	        return;
	    }
	   System.out.print(n+" ");   
	   DEC(n-1);
	}
}

