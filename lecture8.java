import java.util.*;
public class lecture8
{
	public static void main(String[] args) {
	
	   //bits();
	   string();
	   
	}
	public static void string(){
	   // String s1= new String("Hello");
	   // String s2= new String("Hello");
	   // System.out.println(s1==s2);
	    
	   // String s1= "Hello";
	   // String s2="Fello";
	   // System.out.println(s1==s2);
	   
	   
	   String s="codeforcause";
	   //System.out.println(s.length());
	   
	   //System.out.println(s.charAt(1));
	   //System.out.println(Character.isUpperCase(s.charAt(0)));
	   //System.out.println(Character.isLowerCase(s.charAt(0)));
	   
	   
	   //char ch='h';
	   
	   //ch= Character.toUpperCase(ch);
	   //System.out.println(ch);
	   //ch= Character.toLowerCase(ch);
	   //System.out.println(ch);
	   
	   //System.out.println(s.substring(5));
	   //System.out.println(s.substring(3,8));
	   
	   //if(s.contains("focau")){
	   //    System.out.println("Yes");
	   //}
	   //else{
	   //    System.out.println("No");
	   //}
	   
	   //s=s.replace("c","d");
	   //System.out.println(s);
	   
	   //char ch[]= s.toCharArray();
	   //System.out.println(ch.length);
	   
	   //StringBuilder sb= new StringBuilder("Hello");
	   //System.out.println(sb);
	   //sb.append("w");
	   //System.out.println(sb);
	   
	   //sb.setCharAt(0,'d');
	   //System.out.println(sb);
	   
	   //sb.deleteCharAt(1);
	   //System.out.println(sb);
	   
	   //sb.insert(2,"d");
	   //System.out.println(sb);
	   
	   //String st=sb.toString();
	   //System.out.println(st);
	   
	   
	   //System.out.println(gcd(29,5));
	   
	   
	   seive();
	}
	
	public static void seive(){
	    int prime[]= new int[101];
	    prime[0]=1;
	    prime[1]=1;
	    for(int i=2;i*i<=100;i++){
	        if(prime[i]==0){
	            for(int j=i*i;j<=100;j+=i){
	                prime[j]=1;
	            }
	        }
	    }
	    
	    for(int i=0;i<=100;i++){
	        if(prime[i]==0){
	            System.out.print(i+" ");
	        }
	    }
	}
	public static int gcd(int a,int b){
	    if(b==0) return a;
	    return gcd(b,a%b);
	}
	public static void bits(){
	     //   ques1();
// 	 ques2();
	}
	public static void ques2(){
	    int arr[]={4,5,2,7,3,4,5,7};
	    int ans=0;
	    for(int i=0;i<arr.length;i++){
	        ans=(ans^arr[i]);
	    }
	    int fans= ans, cnt=0,ans2=0;
	    
	    while(ans%2!=1){
	        ans= ans/2;
	        cnt++;
	    }
	    cnt=(1<<cnt);
	    for(int i=0;i<arr.length;i++){
	        if((cnt&arr[i])==0){
	            ans2=(ans2^arr[i]);
	        }
	    }
	    System.out.println(ans2+" "+(ans2^ans));
	}
	public static void ques1(){
	    int arr[]={9,8,8,9,54,67,54};
	    int ans=0;
	    for(int i=0;i<arr.length;i++){
	        ans=(ans^arr[i]);
	    }
	    System.out.println(ans);
	}
}

