import java.util.*;
public class lecture10{
  public static void main(String args[]){
  //   int arr[]={1,2,3};
  //   allSubsetWithoutReturnType(arr,2," ");
  //   ArrayList<String>ans= allSubsetWithReturnType(arr, 2);
  //   for(String ele: ans){
  //    System.out.println(ele);
  //  }
    //  ratInMazeWithoutReturnType(0,0,2,2,"");

    // ArrayList<String>ans= ratInMazeWithReturnType(0,0,2,2);
    // for(String ele: ans){
    //   System.out.println(ele);
    // }

    int arr[]={5,6,1,3,4,9,-3,4,6};
    MergeSort(arr,0,arr.length-1);
    for(int ele:arr){
      System.out.println(ele);
    }
  }
  public static void Merge(int arr[],int low,int mid,int high){
    int n1=mid-low+1;
    int n2=high-mid;
    int left[]= new int[n1];
    int right[]= new int[n2];
    for(int i=low;i<=mid;i++){
      left[i-low]=arr[i];
    }
    for(int i=mid+1;i<=high;i++){
      right[i-(mid+1)]=arr[i];
    }

    int i=0,j=0,l=low;
    while(i<left.length&&j<right.length){
      if(left[i]<=right[j]){
        arr[l]=left[i];
        i++;
      }
      else{
        arr[l]=right[j];
        j++;
      }
      l++;
    }
    while(i<left.length){
      arr[l]=left[i];
      i++;
      l++;
    }
    while(j<right.length){
      arr[l]=right[j];
      l++;
      j++;
    }
  } 
  public static void MergeSort(int arr[],int low,int high){
    if(low<high){
      int mid=(low+high)/2;
      MergeSort(arr,low,mid);
      MergeSort(arr, mid+1, high);
      Merge(arr,low,mid,high);
    }
  }
  public static ArrayList<String> ratInMazeWithReturnType(int sr,int sc,int er,int ec){
    if(sr==er&&sc==ec){
      ArrayList<String>base= new ArrayList<String>();
      base.add("");
      return base;
    }
    ArrayList<String>ans= new ArrayList<String>();
    if(sc+1<=ec){
      ArrayList<String>east= ratInMazeWithReturnType(sr,sc+1,er,ec);
      for(String ele:east){
        ans.add("H"+ele);
      }
    }
    if(sr+1<=er){
      ArrayList<String>south= ratInMazeWithReturnType(sr+1,sc,er,ec);
      for(String ele:south){
        ans.add("V"+ele);
      }
    }
    return ans;
  }
  public static void ratInMazeWithoutReturnType(int sr,int sc,int er,int ec,String ans){
    if(sr==er&&sc==ec){
      System.out.println(ans);
      return;
    }

    if(sc+1<=ec)
    ratInMazeWithoutReturnType(sr,sc+1,er,ec,ans+"H");
    if(sr+1<=er)
    ratInMazeWithoutReturnType(sr+1, sc, er, ec, ans+"V");
  }


  public static ArrayList<String> allSubsetWithReturnType(int arr[],int id){
    if(id==-1){
      ArrayList<String>base= new ArrayList<String>();
      base.add("");
      return base;
    }
   ArrayList<String>ans= allSubsetWithReturnType(arr,id-1);
   ArrayList<String>myans= new ArrayList<String>();
   for(String ele: ans){
     myans.add(ele);//not included
   }
   for(String ele: ans){
     myans.add(arr[id]+" "+ele); //include
   }
   return myans;
  }


  public static void allSubsetWithoutReturnType(int arr[],int id,String ans){
    if(id==-1){
      System.out.println(ans);
      return;
    }
    allSubsetWithoutReturnType(arr, id-1, ans);
    allSubsetWithoutReturnType(arr, id-1, ans+arr[id]+" ");
  }
}