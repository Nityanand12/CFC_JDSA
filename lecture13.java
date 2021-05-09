import java.util.*;

class dynamicStack extends customStack {
  public void push(int data) {
    if (isFull()) {
      Integer temp[] = new Integer[super.arr.length * 2];
      for (int i = 0; i < super.arr.length; i++) {
        temp[i] = super.arr[i];
      }
      super.arr = temp;
    }
    super.push(data);
  }
}

class customStack {
  protected Integer arr[];
  private int top;
  private static int defaultSize = 10;

  customStack() {
    this.arr = new Integer[defaultSize];
    this.top = -1;
  }

  public void push(int data) {
    if (isFull()) {
      System.out.println("Stack is full");
      return;
    }
    top = top + 1;
    this.arr[top] = data;
  }

  public Integer pop() {
    if (isEmpty()) {
      System.out.println("Stack is underflow");
      return null;
    }
    int ret = arr[top];
    top = top - 1;
    return ret;
  }

  public Integer peek() {
    if (isEmpty()) {
      System.out.println("Stack is underflow");
      return null;
    }
    return arr[top];
  }

  public Integer size() {
    return top + 1;
  }

  public boolean isFull() {
    if (top == arr.length - 1) {
      return true;
    }
    return false;
  }

  public boolean isEmpty() {
    if (top == -1) {
      return true;
    }
    return false;
  }
}

public class lecture13 {
  public static void main(String[] args) {
    // customStack st= new customStack();
    // st.push(54);
    // st.push(52);
    // st.push(73);
    // st.push(5);
    // System.out.println(st.peek());
    // System.out.println(st.pop());
    // System.out.println(st.pop());
    // System.out.println(st.size());
    // System.out.println(st.pop());
    // st.push(17);
    // System.out.println(st.pop());
    // System.out.println(st.peek());
    // System.out.println(st.isEmpty());
    // System.out.println(st.size());
    // System.out.println(st.isFull());

    // dynamicStack ds= new dynamicStack();
    // for(int i=1;i<=25;i++){
    // ds.push(i);
    // }
    // System.out.println(ds.peek());

    // balancedParanthesis();
    // balancedParanthesisPart2();
    // fourBasicTypeQuestion();
    // removeDuplicate();

    // paranthesisScore();
    dailyTemparature();
  }
  public static void dailyTemparature(){
    int arr[]={73, 74, 75, 71, 69, 72, 76, 73};
    Stack<Integer> st= new Stack<Integer>();
    int ans[]= new int[arr.length];
    for(int i=0;i<arr.length;i++){
      while(st.size()!=0&&arr[i]>arr[st.peek()]){
        ans[st.peek()]=i-st.peek();
        st.pop();
      }
      st.push(i);
    }
    for(int i=0;i<ans.length;i++){
      System.out.print(ans[i]+" ");
    }
  }
  public static void paranthesisScore(){
    String s="((()(()))())";
    Stack<Integer> st= new Stack<Integer>();
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)=='('){
        st.push(-1);
      }
      else{
        int sum=0;
        while(st.peek()!=-1){
          sum+=st.pop();
        }
        st.pop();
        sum=sum*2;
        if(sum==0) sum=1;
        st.push(sum);
      }
    }
    int ans=0;
    while(st.size()!=0){
      ans+=st.pop();
    }
    System.out.println(ans);
  }


  public static void removeDuplicate(){
    String s="abbaca";
    Stack<Character> st= new Stack<Character>();
    for(int i=0;i<s.length();i++){
      if(st.size()==0){
        st.push(s.charAt(i));
        continue;
      }
      if(s.charAt(i)==st.peek()){
        st.pop();
      }
      else{
        st.push(s.charAt(i));
      }
    }
    String ans="";
    while(st.size()!=0){
      ans=st.pop()+ans;
    }
    System.out.println(ans);
  }
  public static void balancedParanthesisPart2(){
    String s="()))((";
    Stack<Character> st= new Stack<Character>();
    for(int i=0;i<s.length();i++){
      if(st.size()!=0&&s.charAt(i)==')'&&st.peek()=='('){
        st.pop();
      }
      else{
        st.push(s.charAt(i));
      }
    }
    System.out.println(st.size());
  }
  public static void fourBasicTypeQuestion(){
    // nextGreaterElement();
    // nextSmallerElement();
    // previousGreaterElement();
    // previousSmallerElement();
  }
  public static void previousSmallerElement() {
    
    int arr[] = { 2, 100, 5, 7, 3, 1, 9 };
    Stack<Integer> st1 = new Stack<Integer>();
    int ans[] = new int[arr.length];
    for (int i = arr.length-1; i >=0; i--) {
      if (st1.size() == 0) {
        st1.push(i);
        continue;
      }
      while (st1.size() != 0 && arr[st1.peek()] > arr[i]) {
        ans[st1.peek()]=arr[i];
        st1.pop();
      }
      st1.push(i);
    }
    while(st1.size()!=0){
      ans[st1.pop()]= -1;
    }
    for(int i=0;i<ans.length;i++){
      System.out.println("previous smaller element of "+arr[i]+" is "+ans[i]);
    }
  }
  public static void previousGreaterElement(){
    int arr[] = { 2, 100, 5, 7, 3, 1, 9 };
    Stack<Integer> st1 = new Stack<Integer>();
    int ans[] = new int[arr.length];
    for (int i = arr.length-1; i >=0; i--) {
      if (st1.size() == 0) {
        st1.push(i);
        continue;
      }
      while (st1.size() != 0 && arr[st1.peek()] < arr[i]) {
        ans[st1.peek()]=arr[i];
        st1.pop();
      }
      st1.push(i);
    }
    while(st1.size()!=0){
      ans[st1.pop()]= -1;
    }
    for(int i=0;i<ans.length;i++){
      System.out.println("previous greater element of "+arr[i]+" is "+ans[i]);
    }
  }

  public static void nextSmallerElement(){
    int arr[] = { 2, 100, 5, 7, 3, 1, 9 };Stack<Integer> st1 = new Stack<Integer>();
    int ans[] = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if (st1.size() == 0) {
        st1.push(i);
        continue;
      }
      while (st1.size() != 0 && arr[st1.peek()] > arr[i]) {
        ans[st1.peek()]=arr[i];
        st1.pop();
      }
      st1.push(i);
    }
    while(st1.size()!=0){
      ans[st1.pop()]= -1;
    }
    for(int i=0;i<ans.length;i++){
      System.out.println("next smaller element of "+arr[i]+" is "+ans[i]);
    }
  }
  public static void nextGreaterElement() {
    int arr[] = { 2, 100, 5, 7, 3, 1, 9 };
    // Stack<Integer> st= new Stack<Integer>();
    // for(int i=0;i<arr.length;i++){
    // if(st.size()==0){
    // st.push(arr[i]);
    // continue;
    // }
    // while(st.size()!=0&&st.peek()<arr[i]){
    // System.out.println("next greater element of "+st.peek()+" is "+arr[i]);
    // st.pop();
    // }
    // st.push(arr[i]);
    // }
    // while(st.size()!=0){
    // System.out.println("next greater element of "+st.pop()+" is -1");
    // }
    Stack<Integer> st1 = new Stack<Integer>();
    int ans[] = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if (st1.size() == 0) {
        st1.push(i);
        continue;
      }
      while (st1.size() != 0 && arr[st1.peek()] < arr[i]) {
        ans[st1.peek()]=arr[i];
        st1.pop();
      }
      st1.push(i);
    }
    while(st1.size()!=0){
      ans[st1.pop()]= -1;
    }
    for(int i=0;i<ans.length;i++){
      System.out.println("next greater element of "+arr[i]+" is "+ans[i]);
    }
  }

  public static void balancedParanthesis() {
    String s = "()({}[])([{}]{)";
    Stack<Character> st = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
        st.push(s.charAt(i));
      } else {
        char ch = mereCorrespondingOpenBracket(s.charAt(i));
        if (ch != st.peek()) {
          System.out.println("False");
          return;
        } else {
          st.pop();
        }
      }
    }
    System.out.println(st.size() == 0);
  }

  public static char mereCorrespondingOpenBracket(char ch) {
    if (ch == '}')
      return '{';
    if (ch == ']')
      return '[';
    return '(';
  }
}
