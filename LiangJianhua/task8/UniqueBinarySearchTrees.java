package com.josh.task8;

import org.junit.Test;

public class UniqueBinarySearchTrees {
	@Test
	public void test(){
		System.out.println(numTrees2(3));
	}
	//���������ⷨ
    public int numTrees(int n) {
        long[] c = new long[n+1];
        c[0] = 1;
        for(int i=1;i<n+1;i++){
        	c[i] = (4*i-2)*c[i-1]/(i+1);
        }
    	return new Long(c[n]).intValue();
    }
    /*
     * ��̬�滮�ⷨ
     * ��ǰ���ڵ�Ϊi����ô1��i-1Ϊ���ڵ�i����������i+1��nΪ���ڵ�i��������
     * ������������m�����з�ʽ����������n�����з�ʽ����ô���ڵ�i����ĿΪm*n��
     * ע����m=0����n=0����i�ĸ�����Ϊm�ĸ�������n�ĸ���[���Գ�ʼ��res0=1����֤��ʽһ��]
     * ��ʼ״̬��res[0]=1,res[1]=1
     * ���ƹ�ʽ��res[i]=res[i] + res[j]*res[i-j-1]
     * 
     */
  
    /*
     * ��ʼ�� ��ʼ״̬��res[0]=1
     * e.g.n=1 ��1λ���ڵ㣺��1С��������0������1�����������Ϊ0����res[1]=res[0]*res[0]��res[1]=sum(res[1])
     * 	   n=2  ��1Ϊ���ڵ㣺��1С��������0������1�����������Ϊ1����res[2]=res[0]*res[1]
     * 		       ��2Ϊ���ڵ㣺��2С��������1������2�����������Ϊ0����res[2]=res[1]*res[0]��res[2]=sum(res[2])
     *     n=3 ��1Ϊ���ڵ㣺��1С��������0������1�����������Ϊ2����res[2]=res[0]*res[2]
     * 		        ��2Ϊ���ڵ㣺��2С��������1������2�����������Ϊ1����res[2]=res[1]*res[1]
     *         ��3Ϊ���ڵ㣺��3С��������2������1�����������Ϊ0����res[2]=res[2]*res[0]��res[3]=sum(res[3])
     *     ������
     */
    public int numTrees2(int n) {
    	if(n<=0)  return 0;  
    	int[] res = new int[n+1];  
    	res[0] = 1;  
    	res[1] = 1;  
    	for(int i=2;i<=n;i++){
    		for(int j=1;j<=i;j++){
    			res[i]+=res[j-1]*res[i-j];
    		}
    	}
    	return res[n];
    }
}
