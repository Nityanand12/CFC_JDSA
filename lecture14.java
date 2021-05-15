import java.util.*;

// class HumanBeing implements LivingBeing{
// 	@Override
// 	public void breathe(){
// 		System.out.println("Human being can breathe with nose");
// 	}
// 	@Override
// 	public void grow(){
// 		System.out.println("Human being can grow");
// 	}
// }

// abstract class LivingBeing(){
// 	abstract void breathe();
// 	void grow(){
// 		System.out.println("Can grow");
// 	}
// }

// interface LivingBeing(){
// 	 void breathe();
// 	 void grow();
// }


class CustomCircularQueue{
	protected Integer arr[];
	protected int size=0,rear=-1,front=0;
	public CustomCircularQueue(){
		arr= new Integer[15];
	}
	public void add(int data){
		if(isfull()){
			System.out.print("Queue is already Filled");
			return;
		}
		size++;
		rear=(rear+1)%arr.length;
		arr[rear]= data;
	}
	public Integer remove(){
		if(isEmpty()){
			System.out.print("Queue is already empty");
			return null;
		}
		size--;
		int ans= arr[front];
		front=(front+1)%arr.length;
		return ans;
	}
	public boolean isfull(){
		if(size==arr.length) return true;
		return false;
	}
	public boolean isEmpty(){
		if(size==0) return true;
		return false;
	}
}

class DynamicCircularQueue extends CustomCircularQueue{
	@Override
	public void add(int data){
		if(isfull()){
			Integer temp[]= new Integer[super.arr.length*2];
			for(int i=0;i<size;i++){
				temp[i]= super.arr[(front)%size];
				front++;
			}
			super.arr= temp;
			super.rear=size-1;
			super.front=0;
		}
		super.add(data);
	}
}


public class lecture14{
	public static void main(String[] args) {
		// asteroidCollision();
		// LivingBeing obj= new LivingBeing();
		// CustomCircularQueue obj1= new CustomCircularQueue();
		// for(int i=1;i<=18;i++){
		// 	obj1.add(i);
		// }
		// DynamicCircularQueue obj2= new DynamicCircularQueue();
		// for(int i=15;i<=50;i++){
		// 	obj2.add(i);
		// }
		// System.out.println(obj2.size);
		// System.out.println(obj2.remove());

		// Queue<Integer> que= new LinkedList<Integer>();
		// que.add(10);
		// que.add(20);
		// que.add(30);
		// que.add(40);
		// que.add(50);
		// while(que.size()!=0){
		// 	System.out.println(que.remove());
		// }
		// Queue<String>que= new LinkedList<String>();		
		// int cnt=10;
		// que.add("1");
		// while(cnt>1){
		// 	String k= que.remove();
		// 	System.out.println(k);
		// 	que.add(k+"0");
		// 	cnt--;
		// 	if(cnt>1)
		// 	que.add(k+"1");
		// 	cnt--;
		// }
		// while(que.size()!=0){
		// 	System.out.println(que.remove());
		// }
		Stack<Integer> st= new Stack<Integer>();
		int height[]={4,6,3,2,5,7,4};
		int ans=0;
		for(int i=0;i<height.length;i++){
			if(i==0){
				st.push(i);
				continue;
			}
			if(height[i]<=height[st.peek()]){
				st.push(i);
			}
			else{
				while(st.size()!=0&&height[i]>=height[st.peek()]){
					int k= st.pop();
					if(st.size()>0)
					ans+= (Math.min(height[st.peek()],height[i])-height[k])*(i-st.peek()-1);
				}
				st.push(i);
			}
		}
		System.out.println(ans);
	}
	public static void asteroidCollision(){
		int arr[]={5,10,-5};
		Stack<Integer>st= new Stack<Integer>();
		for(int ele: arr){
			if(ele>0){
				st.push(ele);
			}
			else{
				// -ve
				while(st.size()!=0 &&st.peek()>0&&st.peek()<Math.abs(ele)){
					st.pop();
				}
				if(st.size()==0||st.peek()<0){
					st.push(ele);
				}
				else if(ele+st.peek()==0){
					st.pop();
				}
			}
		}
		int ans[]= new int[st.size()];
		int l= st.size()-1;
		while(st.size()>0){
			ans[l]= st.pop();
			l--;
		}
		for(int i=0;i<ans.length;i++){
			System.out.print(ans[i]+" ");
		}
	}
}
