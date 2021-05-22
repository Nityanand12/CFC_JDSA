import java.util.*;
// leetcode


// leetcode 445. Add Two Numbers II
// class Solution {
//   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
//       ListNode head1 = reverse(l1);
//       ListNode head2 = reverse(l2);
      
//         ListNode res = new ListNode(-1);
//        ListNode p = res;
//       int carry=0;
//       while(head2!=null||head1!=null||carry!=0)
//       {
//           if(head1!=null&&head2!=null){
//               int temp=(head1.val+head2.val+carry);
//           ListNode  k = new ListNode(temp%10);
//               p.next=k;
//               p=p.next;
//           carry=(head1.val+head2.val+carry)/10;
//           head1=head1.next;
//           head2=head2.next;
//           }
//           else if(head1!=null){
//               int temp=(head1.val+carry);
//               ListNode  k = new ListNode(temp%10);
//               p.next=k;
//               p=p.next;
//           carry=(head1.val+carry)/10;
//           head1=head1.next;
//           }
//           else if(head2!=null){
//               int temp=(head2.val+carry);
//               ListNode  k = new ListNode(temp%10);
//               p.next=k;
//               p=p.next;
//               carry=(head2.val+carry)/10;
//               head2=head2.next;
//           }
//           else{
//               int temp=(carry);
//           ListNode  k = new ListNode(temp%10);
//               p.next=k;
//               p=p.next;
//           carry=(carry)/10;
//           }
//       }
//       return reverse(res.next);   
//   }
//   public ListNode reverse(ListNode l1)
//   {
//       ListNode prev=null;
//       ListNode ahead;
//       ListNode curr=l1;
      
//       while(curr!=null)
//       {
//           ahead=curr.next;
//           curr.next=prev;
//           prev=curr;
//           curr=ahead;
//       }
      
//       return prev;
//   }
// }




// leetcode 160. Intersection of Two Linked Lists
// public class Solution {
//   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//       int l1= length(headA);
//       int l2= length(headB);
//       if(l1>l2) headA= ManageSize(headA,l1-l2);
//       if(l2>l1) headB= ManageSize(headB,l2-l1);
//       while(headA!=headB){
//           headA=headA.next;
//           headB=headB.next;
//       }
//       return headA;
//   }
//   public ListNode ManageSize(ListNode head,int cnt){
//       while(cnt>0){
//           cnt--;
//           head=head.next;
//       }
//       return head;
//   }
//   public int length(ListNode head){
//       int cnt=0;
//       while(head!=null){
//           head=head.next;
//           cnt++;
//       }
//       return cnt;
//   }
// }


// leetcode 234. Palindrome Linked List
// class Solution {
//   public boolean isPalindrome(ListNode head) {
//       ListNode fast= head, slow= head;
//       while(fast!=null&&fast.next!=null){
//           fast=fast.next.next;
//           slow=slow.next;
//       }
//       ListNode rev= reverse(slow);
//       while(rev!=null&&head!=null){
//           if(rev.val!=head.val) return false;
//           rev=rev.next;
//           head=head.next;
//       }
//       return true;
//   }
//   public ListNode reverse(ListNode head){
//       ListNode prev= null,curr=head,forw=head;
//       while(forw!=null){
//           forw= curr.next;
//           curr.next= prev;
//           prev=curr;
//           curr=forw;
//       }
//       return prev;
//   }
// }





// leetcode 141. Linked List Cycle
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         if(head==null||head.next==null)
//         return false;
//         ListNode slow=head,fast=head;
//         while(fast!=null&&fast.next!=null&&fast.next.next!=null)
//         {
//             // if(sl)
//             slow=slow.next;
//             fast=fast.next.next.next;
//             if(slow==fast)
//             return true;
//         }
//         return false;
//     }
// }





// leetcode 206. Reverse Linked List
// class Solution {
//   public ListNode reverseList(ListNode head) {
//       ListNode pre= null,curr=head,forw=head;
//      while(forw!=null){
//         forw= curr.next;
//          curr.next= pre;
//          pre=curr;
//          curr=forw;
//      }
//       return pre;
//   }
// }





//  leetcode 876. Middle of the Linked List
// class Solution {
//   public ListNode middleNode(ListNode head) {
//       if(head==null)
//       return null;
//       ListNode slow=head,fast=head;
//       while(fast!=null&&fast.next!=null)
//       {
//           fast=fast.next.next;
//           slow=slow.next;
//       }
//       return slow;
//   }
// }




public class lecture15 {
  static class node{
    int val;
    node next;
  }
 static class CustomLinkedList{
    int size=0;
    node head=null;
    node tail=null;
    public void addLast(int data){
      node n= new node();
        n.val=data;
        n.next=null;
      if(size==0){
        size++;
        head=n;
        tail=n;
      }
      else{
        size++;
        tail.next=n;
        tail=n;
      }
    }
    public void addFirst(int data){
      if(size==0){
        addLast(data);
        return;
      }
      node n= new node();
      n.val=data;
      n.next=head;
      head=n;
      size++;
    }
    public Integer removeLast(){
      if(head==null){
        System.out.println("LinkedList is empty");
        return null;
      }
      size--;
      if(head.next==null){
        int k= head.val;
        head=null;
        tail=null;
        return k;
      }
      node k=head;
      while(k.next!=tail){
        k=k.next;
      }
      int dataWhichIsRemoved=tail.val;
      tail=k;
      k.next=null;
      return dataWhichIsRemoved;
      
    }
    public Integer removeFirst(){
      if(head==null){
        System.out.println("LinkedList is empty");
        return null;
      }
      if(head.next==null){
        return removeLast(); 
      }
      size--;
      int dataWhichIsRemoved= head.val;
      head=head.next;
      return dataWhichIsRemoved;
    }
    public void display(){
      node temp= head;
      while(temp!=null){
        System.out.print(temp.val+" ");
        temp=temp.next;
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    CustomLinkedList obj= new CustomLinkedList();
    obj.addFirst(10);
    obj.addLast(20);
    obj.addLast(30);
    obj.addFirst(40);
    obj.display();
    System.out.println(obj.removeFirst());
    System.out.println(obj.removeLast());
    obj.display();
  }
}
