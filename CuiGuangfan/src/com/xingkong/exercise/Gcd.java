package com.xingkong.exercise;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time��2016��2��24�� ����10:16:05 
* ŷ������㷨 ���������
*/
public class Gcd {
	public static long gcd(long m,long n){
		//if(m<n)��ô����
		while(n!=0){
			long rem=m%n;
			m=n;
			n=rem;
		}
		return m;
	}
}
