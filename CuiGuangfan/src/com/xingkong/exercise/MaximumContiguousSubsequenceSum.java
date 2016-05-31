package com.xingkong.exercise;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time��2016��2��24�� ����10:08:24 
* ���Ӷ�O(n)
*/
public class MaximumContiguousSubsequenceSum {
	public static int maxSubSumn(int[]a){
		int maxSum=0,thisSum=0;
		for(int j=0;j<a.length;j++){
			thisSum+=a[j];
			if(thisSum>maxSum)
				maxSum=thisSum;
			else if(thisSum<0){
				thisSum=0;
			}
		}
		return maxSum;
	}
}
