package com.xingkong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time��2016��1��11�� ����10:46:32 
* class description
*/
public class PermutationsII_47 {
	private void swap(int[] nums, int index1, int index2) {
		// ����ʹ��nums[index1]=nums[index1]^nums[index2];
		// nums[index2]=nums[index1]^nums[index2];
		// nums[index1]=nums[index1]^nums[index2];
		// ��index1=index2ʱ������nums[index1]��nums[index2]ʹ�õĵ�ַ��ͬ���ᵼ��nums[index1]��nums[index2]��Ϊ0
		// �����ֵ��ֵ��a,b������a��b��ַ��ͬ�����Բ�������������
		int a = nums[index1];
		int b = nums[index2];
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		nums[index1] = a;
		nums[index2] = b;
	}
	HashSet<List<Integer>> result=new HashSet<List<Integer>>();
	//ÿ�δӺ���ȥһ����num[i]���滻num[cur]��
	//	��Ϊnum�ڴ�����ͬ������Ҳ����˵��num[k] ���ܺ�num[j]��ͬ��
	//	������num[i]�Ѿ���cur���λ���ϳ��ֹ�����num[j]����ֱ������ȥ�����ԣ�Ӧ�ô�curλ�ÿ�ʼһֱ��j������������ڲ鿴����num[i]�Ƿ�����num[j]��ͬ�����֣���cur<=i<j����
	boolean needSwap(int[]nums,int current,int j){
		while(nums[current]!=nums[j]&&current<j) current++;
		if(current==j) return true;
		else 
			return false;
	}
	private void backTrace(int[] nums,int currentIndex){
		if(currentIndex>=nums.length){
			List<Integer> temp=new ArrayList<Integer>();
			for(int value:nums){
				temp.add(value);
			}
			result.add(temp);
				
		}
		for(int i=currentIndex;i<nums.length;i++){
			if(!needSwap(nums,currentIndex,i))
				continue;
			swap(nums,currentIndex,i);
			backTrace(nums,currentIndex+1);
			swap(nums,currentIndex,i);
			
		}
	}
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		backTrace(nums,0);
		return new ArrayList<List<Integer>>(result);
        
    }
	public static void main(String[] args) {
		PermutationsII_47 pI=new PermutationsII_47();
		System.out.println(pI.permuteUnique(new int[]{1,1,2}));
	}

}
