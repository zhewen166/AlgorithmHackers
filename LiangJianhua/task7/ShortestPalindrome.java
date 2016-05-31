package com.josh.task7;

import org.junit.Test;
/*
 * ����һ���ַ���������С���Ĵ�
 */
public class ShortestPalindrome {
	@Test
	public void test(){
		String str = "aabaaa";
		System.out.println(shortestPalindrome(str));
		//System.out.println(isPalindrome(str));
	}
	//�����жϸ������ַ����Ƿ��ǻ��Ĵ������ǣ�ֱ������������ǣ�������̻���
    public String shortestPalindrome(String s) {
		if(s.length()==0 || isPalindrome(s)) return s;
		int mid=0;//note��cbabcd - dcbabcd not dcbabcbabcd
		for(int i=0;i<s.length();i++){//Ѱ�һ����е�
			int pre = i-1,next = i+1;
			while((pre>=0 && next<s.length()) && s.charAt(pre) == s.charAt(next)){
				pre--;
				next++;
			}
			if(pre<0) mid = i;
		}
		String subStr = s.substring(2*mid+1, s.length());//��ȡ�����ַ���
		String reverseSubStr = reverse(subStr);//������Ĳ���
    	return reverseSubStr+s;
        
    }
    public boolean isPalindrome(String s){
    	if(s.length() == 1) return true;
    	int head = 0,end = s.length()-1;//ǰ��λ��ָ��
    	while(head<end){
    		if(s.charAt(head) != s.charAt(end)) return false;
    		head ++;
    		end --;
    	}
    	return true;
    }
    public String reverse(String str){
    	if(str.length() == 0) return null;
    	String reverseStr = str.substring(str.length()-1, str.length());
    	for(int i=str.length()-2;i>=0;i--){
    		reverseStr = reverseStr + str.charAt(i);
    	}
    	return reverseStr;
    }
}
