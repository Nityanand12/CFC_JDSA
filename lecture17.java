import java.util.*;
class BinaryTree<k>{
  class Node{
    k value;
    Node left;
    Node right;
    Node(k value){
      this.value=value;
    }
    Node(Node left,Node right,k value){
      this.value=value;
      this.right=right;
      this.left=left;
    }
  }
  Node root;
  public void insert(k value,String dirs){
    this.root=insert(root,value, dirs,0);
  }
  public Node insert(Node node , k value, String dirs,int idx){
    if(node ==null){
      node = new Node(value);
      return node;
    }
    if(dirs.length()==idx){
      node.value=value;
      return node;
    }
    if(dirs.charAt(idx)=='L'){
      node.left=insert(node.left, value,dirs,idx+1);
    }
    else{
      node.right=insert(node.right, value,dirs,idx+1);
    }
    return node;
  }
  public boolean find(k value){
    return find(root,value);
  }
  public boolean find(Node node ,k value){
    if(node==null){
      return false;
    }
    if(node.value.equals(value)){
      return true;
    }
    return find(node.left,value)||find(node.right,value);
  }
  public void display(){
    display(root);
  }
  public void display(Node node){
    if(node == null){
      return;
    }
    if(node.left==null){
      System.out.print(" -> ");
    }
    else{
      System.out.print(node.left.value+" -> ");
    }
    System.out.print(node.value);
    if(node.right==null){
      System.out.print(" <- ");
    }
    else{
      System.out.print(" <- "+node.right.value);
    }
    System.out.println();
    display(node.left);
    display(node.right);
  }
}
public class lecture17 {
  public static void main(String[] args) {
  //  twoSum();
  //  firstNonRepeatingCharacter();
  // subarraySumK();
  // uniqueNumOccurence();
  BinaryTree<Integer>bt= new BinaryTree<>();
  bt.insert(10, "");
  bt.insert(20, "R");
  bt.insert(15, "L");
  bt.insert(16, "LL");
  bt.insert(11, "RL");
  bt.insert(18, "RR");
  bt.insert(28, "RLR");
  bt.insert(48, "RRL");
  bt.display();
  }
  public static void uniqueNumOccurence(){
    int arr[]={1,2,3,2,3,4,1,4};
    HashMap<Integer,Integer>map= new HashMap<Integer,Integer>();
    for(int i=0;i<arr.length;i++){
      map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
    }
    int check=-1;
    for(int ele: map.keySet()){
      if(map.get(ele)!=check){
        if(check==-1){
          check= map.get(ele);
        }
        else{
          System.out.println("FASLE");
          return;
        }
      }
    }
    System.out.println("True");
  }
  public static void subarraySumK(){
    int arr[]={-1,1,3,1,-1,3,4,6,2,1};
    int pre[]= new int[arr.length];
    for(int i=0;i<arr.length;i++){
      if(i==0){
        pre[i]=arr[i];
        continue;
      }
      pre[i]= pre[i-1]+arr[i];
    }
    int ans=0;
    int k=3;
    HashMap<Integer,Integer>map= new HashMap<Integer,Integer>();
    map.put(0,1);
    for(int i=0;i<pre.length;i++){
      if(map.containsKey(pre[i]-k)){
        ans= ans+map.get(pre[i]-k);
      }
      map.put(pre[i],map.getOrDefault(pre[i], 0)+1);
    }
    System.out.println(ans);
  }
  public static void firstNonRepeatingCharacter(){
    int arr[]= new int[26];
    String s="aabccbdefd";
    for(int i=0;i<s.length();i++){
      arr[s.charAt(i)-'a']++;
    }
    for(int i=0;i<s.length();i++){
      if(arr[s.charAt(i)-'a']==1){
        System.out.println(i);
        return ;
      }
    }
    System.out.println(-1);
  }
  public static void twoSum(){
    int arr[]={2,3,5,7,6};
    int tar=10;
    int x=-1,y=-1;
    HashMap<Integer,Integer>map= new HashMap<>();
    for(int i=0;i<arr.length;i++){
      if(map.containsKey(tar-arr[i])){
        x= map.get(tar-arr[i]);
        y=i;
        break;
      }
      map.put(arr[i],i);
    }
    System.out.println(x+" "+y);
  }
}
