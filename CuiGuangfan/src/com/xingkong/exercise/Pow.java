package com.xingkong.exercise;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time��2016��2��24�� ����10:20:03 
* ������
*/
public class Pow {
	public static long pow(long x,int n){
		if(n==0)
			return 1;
		if(n==1)
			return x;
		if(n%2==0)//���n��ż��
			return  pow(x*x,n/2);
		else//���n������
			return pow(x*x,n/2)*x;
	}
}
