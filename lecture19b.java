import java.util.*;
class CustomHeap<K extends Comparable<K>> {
  ArrayList<K>al;
  CustomHeap(){
    al= new ArrayList<>();
  }
  public void insert(K value){
    al.add(value);
    upHeapify(al.size()-1);
  }
  private void upHeapify(int idx){
    if(idx==0){
      return;
    }
    int par= parent(idx);
    if(al.get(par).compareTo(al.get(idx))>0){
      K temp= al.get(idx);
      al.set(idx, al.get(par));
      al.set(par, temp);
    }
    upHeapify(par);
  }
  public K remove(){
    if(al.size()==0)return null;
    if(al.size()==1) return al.remove(0);
    K data= al.get(0);
    al.set(0, al.get(al.size()-1));
    al.remove(al.size()-1);
    downHeapify(0);
    return data;
  }
  private int leftChild(int idx){
    return 2*idx+1;
  }
  private int rightChild(int idx){
    return 2*idx+2;
  }
  public void downHeapify(int idx){
    int minimum= idx;
    int l= leftChild(idx);
    int r= rightChild(idx);
    if(l<al.size() && al.get(l).compareTo(al.get(minimum))<0){
      minimum= l;
    }
    if(r<al.size()&&al.get(r).compareTo(al.get(minimum))<0){
      minimum= r;
    }
    if(minimum!=idx){
      K temp= al.get(idx);
      al.set(idx, al.get(minimum));
      al.set(minimum, temp);
      downHeapify(idx);
    }
  }
  private int parent(int idx){
    return (idx-1)/2;
  }
  @Override
  public String toString(){
    return al.toString();
  }

}
public class lecture19b{
  public static void main(String[] args) {
    CustomHeap<Integer>cs= new CustomHeap<>();
    cs.insert(10);
    cs.insert(1);
    cs.insert(101);
    cs.insert(15);
    cs.insert(51);
    cs.insert(6);
    cs.insert(27);
    System.out.println(cs);
    System.out.println(cs.remove());
    System.out.println(cs);
  }
}