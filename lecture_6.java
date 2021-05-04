import java.util.*;

public class lecture_6
{
	public static void main(String[] args) {
	   // insertionSort();
	   // bubbleSort();
	   //selectionSort();
	   countingSort();
	}
	public static void countingSort(){
	    int A[]={1,4,1,2,2,4,3};
	    int B[]= new int[A.length];
	    int max_=0;
	    for(int i=0;i<A.length;i++){
	        if(max_<A[i]){
	            max_=A[i];
	        }
	    }
	    int C[]= new int[max_+1];
	    for(int i=0;i<A.length;i++){
	        C[A[i]]=  C[A[i]]+1;
	    }
	   // prefix sum
	   for(int i=1;i<C.length;i++){
	       C[i]=C[i]+C[i-1];
	   }
	   for(int i=A.length-1;i>=0;i--){
	       B[C[A[i]]-1]=A[i];
	       C[A[i]]=C[A[i]]-1;
	   }
	   for(int i=0;i<B.length;i++){
	        System.out.println(B[i]);
	    }
	    
	}
	
	
	
	
	
	public static void selectionSort(){
	    int arr[]={5,4,3,2,1};
	    int n= arr.length;
	    for(int i=0;i<n-1;i++){
	        int iMin=i;
	        for(int j=i+1;j<n;j++){
	            if(arr[j]<arr[iMin]){
	                iMin=j;
	            }
	        }
	        if(iMin!=i){
	            int temp= arr[iMin];
	            arr[iMin]= arr[i];
	            arr[i]= temp;
	        }
	    }
	    for(int i=0;i<arr.length;i++){
	        System.out.println(arr[i]);
	    }
	}
	public static void bubbleSort(){
	    int arr[]={5,4,3,2,1};
	    int n= arr.length;
	    for(int i=0;i<n-1;i++){
	        boolean swap= false;
	       for(int j=0;j<n-i-1;j++){
	           if(arr[j]>arr[j+1]){
	               swap= true;
	               int temp= arr[j];
	               arr[j]= arr[j+1];
	               arr[j+1]= temp;
	           }
	       }
	       if(swap==false){
	           break;
	       }
	    }
	    for(int i=0;i<arr.length;i++){
	        System.out.println(arr[i]);
	    }
	}
	public static void insertionSort(){
	    int arr[]={5,4,3,2,1};
	    for(int i=1;i<arr.length;i++){
	        int key=arr[i];
	        int j=i-1;
	        while(j>=0&&arr[j]>key){
	            arr[j+1]=arr[j];
	            j=j-1;
	        }
	        arr[j+1]=key;
	    }
	    for(int i=0;i<arr.length;i++){
	        System.out.println(arr[i]);
	    }
	}
}

