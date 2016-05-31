package com.josh.acm.task1;

import org.junit.Test;

public class ThreeSumClosest {

	@Test
	public void test(){
		
		int[] nums = {0,1,2};
		//		67;
		SumClosest(nums,0);
		//System.out.println((1+2/2));
		
	}
	
	public int SumClosest(int[] nums, int target) {
		
		//�ж������Ƿ���������
		if(nums.length<3){
			return -1;
		}
		
		//������С�����������ĺ�
		int threeSum = 0;
		//��ʼ�����target����̾���
		int minDistance = target-nums[0]-nums[1]-nums[2];
		if(minDistance<0){
			minDistance=-minDistance;
		}
		//��������ð������
		int len = nums.length-1;
		for(int i=len; i>0;i--){
			for(int j=0;j<i;j++){
				//int j = len - i;
				if(nums[j]> nums[j+1]){
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		//�̶������������ݺ���target�ȽϵĴ�С�仯��������
		for(int k=0;k<nums.length-2;k++){
			int h=k+1;
			int z=nums.length-1;
			while(h<z){
				int tempThreeSum = nums[k]+nums[h]+nums[z];
				//���嵱ǰ�������target�ľ���
				int temDistance;
				if(tempThreeSum<target){//����֮��С��target��ָ��ڶ��������ڶ���������ָ�������ƶ�һλ��ʹ�ͱƽ�target
					temDistance=target-tempThreeSum;
					if(temDistance<=minDistance){
						minDistance=temDistance;
						threeSum = nums[k]+nums[h]+nums[z];
					}
					h++;
				}else if(tempThreeSum>target){//����֮�ʹ���target��ָ�����Ҳࣨ���ֵ����ָ�������ƶ�һλ��ʹ�ͱƽ�target
					temDistance=tempThreeSum-target;
					if(temDistance<=minDistance){
						minDistance=temDistance;
						threeSum = nums[k]+nums[h]+nums[z];
					}
					z--;
				}else{//����֮�����õ���target������Ϊ0
					minDistance = 0;
					threeSum = nums[k]+nums[h]+nums[z];
					System.out.println("��̾��룺"+minDistance);
					System.out.println("������֮�ͣ�"+threeSum);
					return threeSum;
				}
			}
		}
		System.out.println("��̾��룺"+minDistance);
		System.out.println("������֮�ͣ�"+threeSum);
		return threeSum;
    }
}
