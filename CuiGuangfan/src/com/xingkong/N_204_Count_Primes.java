package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time��2016��2��29�� ����8:49:52 
* class description
*/
public class N_204_Count_Primes {
	public static int countPrimes(int n) {
        boolean[]isPrime=new boolean[n];
        for(int i=2;i<n;i++)
        	isPrime[i]=true;
        for(int i=2;i*i<n;i++){
        	if(!isPrime[i]) continue;//��ʼʱ����д����break�����ºܶ�������25Ҳ���������
        	for(int j=i*i;j<n;j+=i){
        		isPrime[j]=false;
        	}
        }
        int count=0;
        for(int i=2;i<n;i++){
        	if(isPrime[i]) {
        		//System.out.print(i+" ");
        		count++;
        	}
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_204_Count_Primes.countPrimes(10000));
	}

}
