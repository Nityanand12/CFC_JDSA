import java.util.*;
public class lecture20 {



// Leetcode  347. Top K Frequent Elements
//   class Solution {
//     public class node implements Comparable<node>{
//         int val,freq;
//         node(int val,int freq){
//             this.val=val;
//             this.freq=freq;
//         }
//         node(){
            
//         }
//         @Override
//         public int compareTo(node o){
//             return o.freq-this.freq;
//         }
//     }
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap<Integer,Integer>map=new  HashMap<Integer,Integer>();
//         for(int i=0;i<nums.length;i++){
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         }
//         PriorityQueue<node>pq= new PriorityQueue<node>();
//         for(int ele: map.keySet()){
//             pq.add(new node(ele,map.get(ele)));   
//         }
//         int ans[]= new int[k];
//         int l=0;
//         while(l<k){
//             node w= pq.remove();
//             ans[l]=w.val;
//             l++;
//         }
//         return ans;
//     }
// }






// Leetcode  703. Kth Largest Element in a Stream
// class KthLargest {
//   PriorityQueue<Integer>pq= new PriorityQueue<Integer>();
//   int w=0;
//   public KthLargest(int k, int[] nums) {
//       w=k;
//       for(int i=0;i<k&&i<nums.length;i++){
//           pq.add(nums[i]);
//       }
//       for(int i=k;i<nums.length;i++){
//           if(nums[i]>pq.peek()){
//               pq.remove();
//               pq.add(nums[i]);
//           }
//       }
//   }
  
//   public int add(int val) {
//       if(pq.size()==w&&val>pq.peek()){
//           pq.poll();
//           pq.add(val);
//       }
//       else if(pq.size()<w){
//           pq.add(val);
//       }
//       return pq.peek();
//   }
// }





// Leetcode  1046. Last Stone Weight
//   class Solution {
//     public int lastStoneWeight(int[] stones) {
//       if(stones.length==0) return 0;
//         PriorityQueue<Integer>pq= new PriorityQueue<Integer>();
//         for(int i=0;i<stones.length;i++){
//             pq.add(-1*stones[i]);
//         }
//         while(pq.size()>1){
//             int a=-1*pq.remove();
//             int b= -1*pq.remove();
//             if(a==b) continue;
//             pq.add(-1*Math.abs(a-b));
//         }
//         if(pq.size()==0) return 0;
//         return -1*pq.remove();
//     }
// }



  static class Student implements Comparable<Student>{
    String name;
    int roll;
    int marks;
    Student(String name,int roll,int marks){
      this.name=name;
      this.roll=roll;
      this.marks=marks;
    }
    Student(){

    }
    @Override
    public int compareTo(Student o){
      return o.roll-this.roll;
    }
  }
  public static void main(String[] args) {
  // PriorityQueue<Integer>pq= new PriorityQueue<Integer>(Collections.reverseOrder());
  PriorityQueue<Integer>pq= new PriorityQueue<Integer>((a,b) -> b-a);
  pq.add(15);
  pq.add(10);
  pq.add(12);
  pq.add(25);
  pq.add(9);
  pq.add(29);
  while(pq.size()!=0){
    System.out.println(pq.poll());
  }
  // PriorityQueue<Student>pq= new PriorityQueue<Student>();
  // pq.add(new Student("Popatlal",16,87));
  // pq.add(new Student("Jethalal",12,97));
  // pq.add(new Student("Bhide",4,91));
  // pq.add(new Student("Iyer",10,85));
  // while(pq.size()!=0){
  //   Student k= pq.poll();
  //   System.out.println(k.name+" "+k.roll+" "+k.marks);
  // }
  }
}
