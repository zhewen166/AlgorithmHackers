package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time��2016��3��1�� ����5:23:15 
* class description
*/
public class N_319_Bulb_Switcher {
	/**
	 * ˼·���տ�ʼ����i��λ�ã�i�ᱻ��1��toggle���ᱻ��i��toggle���ᱻi������m*n��n*m toggle��ż����toggle������ı�Ƶ�״̬������ǹرգ���ֻ��������toggle���õ�
	 * on������toggle������Ϊ�������������ֻ��j*j==i���������ô�����ǻ�ó������п����ĵƵ�index������j*j==index�����Գ����·�������������Ƿ��֣���ʵ��
	 * ���forѭ��������(int)sqrt(n)��ֵ�����ԣ�ֻ��һ�оͽ���ˡ�
	 */
	public static int bulbSwitch(int n) {
		//if(n==1) return 1;
//		int[]isPrime=new int[n+1];
//		isPrime[1]=1;
//        for(int i=2;i<=n;i++)
//        	isPrime[i]=0;
		int count=0;
        for(int i=1;i*i<=n;i++){
        	//if(isPrime[i]==0) continue;
//        	isPrime[i*i]++;
        	count++;
//        	for(int j=i*i;j<=n;j+=i){
//        		if(j==i*i){
//        			isPrime[j]++;
//        		}
//        	}
        }
//        int count=0;
//        for(int i=1;i<=n;i++){
//        	if(isPrime[i]%2==0) count++;
//        }
        return count;
    }
	public static int bulbSwitchBetter(int n) {
		return (int)Math.sqrt(n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N_319_Bulb_Switcher.bulbSwitch(4);
	}

}
