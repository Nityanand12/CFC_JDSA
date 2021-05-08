
class access{
 protected void fun(){
    System.out.println("This is class abc");
  }
}
class mahindraMarazzo extends car{
  int seat=8;
  public mahindraMarazzo(){
    super();
  }
  public void backward(){
    System.out.println("Mahindra Marazzo is accelerating backward");
  } 
}

class car{//blue print
  int mileage;//properties
  String color;

  static int wheel=4;
  public static void forward(){//behavior
    System.out.println("My car is accelerating forward");
  }

  public void forward(int n){
    System.out.println(mileage);
    System.out.println("My car is accelerating forward with "+n+" meter per second square");
  }
  public void backward(){
    System.out.println("My car is accelerating backward");
  }

  public car(){
    System.out.println("This is constructor");
  }
  public car(int mileage, String color){
    // this keyword
    this();
    this.mileage=mileage;
    this.color=color;
  }
}
public class lecture12 {
  public static void main(String args[]){ 
    // car c1=new car();
    // c1.color="White";
    // c1.mileage=20;
    // c1.forward();
    // System.out.println(c1.color);

    // car c2= new car();
    // c2.color="Blue";
    // c2.mileage=16;
    // c2.forward(5);
    // System.out.println(c2.mileage);

    // //Static keyword
    // car.forward();
    // System.out.println(car.wheel);


    // car c3=new car(17,"Purple");
    // System.out.println(c3.mileage);
    // mahindraMarazzo mm= new mahindraMarazzo();
    // mm.backward();
    

    // slidingWindow();
    // slidingWindowMaximumValueInKLengthSubarray();

    access g= new access();
    g.fun(); 

  } 




  public static void slidingWindowMaximumValueInKLengthSubarray(){
    int arr[]={10,15,6,-5,12,20,11,17,-1};
    int left[]= new int[arr.length];
    int right[]= new int[arr.length];
    int k=3;
    for(int i=0;i<arr.length;i++){
      if(i%k==0){
        left[i]=arr[i];
      }
      else{
        left[i]=Math.max(left[i-1],arr[i]);
      }
    }
    for(int i=arr.length-1;i>=0;i--){
      if((i+1)%k==0||i==arr.length-1){
        right[i]=arr[i];
      }
      else{
        right[i]=Math.max(right[i+1],arr[i]);
      }
    }
    for(int i=k-1;i<arr.length;i++){
      int ans=Math.max(left[i],right[i-k+1]);
      System.out.println(ans);
    }
  }

  public static void slidingWindow(){
    int arr[]={10,15,6,-5,12,20,11,17,-1};
    int k=3;
    int ans=Integer.MIN_VALUE;
    for(int i=0;i<=arr.length-k;i++){
      int sum=0;
      for(int j=i;j<i+k;j++){
        sum+=arr[j];
      }
      ans=Math.max(ans,sum);
      System.out.println(sum);
    }
    System.out.println("Maximum sum of sub array with size 3"+ans);


    System.out.println();


    ans=Integer.MIN_VALUE;
    int i=0,j=0,sum=0;
    while(j<k){
      sum+=arr[j];
      j++;
    }
    System.out.println(sum);
    ans=Math.max(ans,sum);
    while(j<arr.length){
      sum-=arr[i];
      sum+=arr[j];
      System.out.println(sum);
      i++;
      j++;
    }


  }
}
