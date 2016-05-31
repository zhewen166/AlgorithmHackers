package com.xingkong;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time��2016��1��5�� ����9:14:00 class description
 */
public class UniqueBinarySearchTrees {
	//��һ�ַ��������õݹ���㣬ע�⣬��Ҫ�����ظ�����
	public int backTrace(int i,int[]result){
		if(i==0||i==1) return 1;
		if(result[i]!=0){//�����ظ����㡣ԭ����д����result[i]=0������ֹresult[i]���ظ��ӡ����������ᵼ�³�ʱ
			return result[i];
		}
		for(int j=0;j<i;j++){
			int temp1=backTrace(j,result);
			int temp2=backTrace(i-j-1,result);
			//System.out.println("backTrace("+j+")"+temp1+"*"+"backTrance("+(i-j-1)+")"+temp2);
			result[i]+=temp1*temp2;
		}
		return result[i];
	}
	public int numTrees1(int n) {
		return backTrace(n,new int[n+1]);
	}
	//�ڶ��ַ�������̬�滮���Զ��������ظ�����
	public int numTrees(int n) {
		if(n==0) return 1;
		int[] result = new int[n+1];//������n+1
		result[0]=1;
		result[1]=1;
		for(int i=2;i<=n;i++){
			//result[i]=0;
			for (int j = 0; j < i; j++) {
				result[i]+=result[j]*result[i-j-1];
			}
		}
		return result[n];
		
	}
	public static void main(String[] args) {
		UniqueBinarySearchTrees ubs=new UniqueBinarySearchTrees();
		//System.out.println(ubs.numTrees(3));
		System.out.println(ubs.numTrees1(3));
	}
}
