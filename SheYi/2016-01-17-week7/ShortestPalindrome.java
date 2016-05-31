package week7;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPalindrome {
/*	 public String shortestPalindrome(String s) {
		 if(s.length()<1) return s;
	       int index=0;
	       int rIndex=0;
		   for(int i=s.length()-1;i>0;i--){
			   if(s.charAt(0)==s.charAt(i)){
				   index=i;
				   break;
			   }
		   }
		   boolean flag=true;
		   while(index!=0){
			   flag=true;
			    int curIndex=index;
			    index=0;
			   for(int i=0,j=curIndex;i<j;i++,j--){
				   if(s.charAt(i)!=s.charAt(j)){
					  flag=false; break; 
				   }
			   }
			   if(flag){
				 rIndex=curIndex;  break;
			   }else{
				   for(int i=curIndex-1;i>0;i--){
					   if(s.charAt(0)==s.charAt(i)){
						   index=i;
						   break;
					   }
				   }
			   }
		   }
		   StringBuffer rs=new StringBuffer(s);
		   StringBuffer dif=new StringBuffer(s.substring(rIndex+1,s.length()));
		   return dif.reverse().toString()+rs.toString();
	    }*/
	
	//���ϵĽⷨ�������ϵ�˼·�ǰ�����ת��Ϊ��KMP�㷨next���������
	//�����������ڸ����ַ���ǰ�����ַ�����ʹ���Ϊ��̵Ļ��Ĵ� ����ʵ����Ҫ���ҵ����ַ�����ͷ�ַ���ʼ����ӻ��Ĵ���Ȼ��Ѻ���ʣ����ַ���ת�üӵ�ǰ��
	//����ӻ��Ĵ���ô���أ� ����Դ�ַ���s��ת��s_rev,Ȼ������ƴװ�����ַ���snew=s+��#��+s.rev������snew��next���飻
	//��KMP�㷨�У�next�����ʾ���ַ������ǰ׺��׺ƥ�䳤�ȣ������ַ�����abcdabd����next����Ϊ{0��0��0��0��1��2��0}
	//�ַ���ǰ��׺�Ķ��壺�����ַ�����abcda������ǰ׺��{"a","ab","abc","abcd"} ������׺Ϊ{"a","da","cda","bcda"}�����������ǰ��׺Ϊ��a������
	//next�����ֵΪ1��next������KMP�㷨�е��������ڷ��ֵ�i��Ԫ�ز�ƥ��󣬷�����һ�����i-1Ԫ����ͬ��Ԫ�أ�����һ��Ԫ���Ƿ�ƥ�䣬������ֱ�ӻص��ַ����Ŀ�ͷ
	 public String shortestPalindrome(String s) {
 	        StringBuilder builder = new StringBuilder(s);
	        return builder.reverse().substring(0, s.length() - getCommonLength(s)) + s;
	    }

	    private int getCommonLength(String str) {
	        StringBuilder builder = new StringBuilder(str);
	        String rev = new StringBuilder(str).reverse().toString();
	        builder.append("#").append(rev);
	        int[] next = new int[builder.length()];
	        next[0]=0; //j��ʾ��ǰ�Ѿ�ƥ����ַ���
	        for (int i = 1,j=0; i < next.length; i++) {
	            while (j > 0 && builder.charAt(i) != builder.charAt(j)) 
	            	j = next[j - 1];   //��������ƥ�䣬Ѱ����һ���γ���ƥ��
	            if(builder.charAt(i)==builder.charAt(j))
	            	j++;
	            next[i]=j;
	        }
	        return next[next.length - 1];   
	    }

	 public static void main(String [] args){
		 ShortestPalindrome p=new ShortestPalindrome();
		 String s="a";
		 String r=p.shortestPalindrome(s);
		 System.out.println("r="+r);
	 }
}
