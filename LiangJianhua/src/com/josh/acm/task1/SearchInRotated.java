package com.josh.acm.task1;

import org.junit.Test;

/**
 * ��ת�������ҵ�ָ��key
 * Search in Rotated Sorted Array,and Get the key.
 * 
 * ���ַ�����
 * 
 * @author Summer
 *
 */

public class SearchInRotated {
	
	@Test
	public void test(){
		
		int[] nums = {1,3,5};
		search(nums,1);
		//System.out.println((1+2/2));
		
	}
	
    public boolean search(int[] nums, int target) {
        //����Ϊ��ʱ��ֱ�ӷ���false
    	if(nums.length == 0){
    		return false;
    	}

    	//Ŀ��key��index
    	int targetIndex=-1;
    	
    	//����߽磬�е�
    	int left=0;
    	int right=nums.length-1;
    	//System.out.println(targetIndex);
    	//���ַ�����
    	while(left<=right){
    		int mid=(left+right)/2;
    		//�е㼴Ϊtarget,ֱ�ӷ���true
    		if(target==nums[mid]){
        		targetIndex=mid;
        		System.out.println(targetIndex);
        		return true;
        	}
    		if(nums[mid]==nums[right]){//�����Ҳ�߽�
    			right=right-1;
    		}else if(nums[mid]==nums[left]){//�������߽�
    			left=left+1;
    		}else if(nums[mid]<nums[right]){//˵����mid��right����
        		if(target>nums[mid] && target<=nums[right]){//˵��target���Ҳ�����Χ��
        			left=mid+1;//�������߽�
        		}else{//˵��target���������Χ��
        			right=mid-1;//�����Ҳ�߽�
        		}
        	}else{//˵����left��mid����
        		if(target<nums[mid] && target>=nums[left]){//˵��target���������Χ��
        			right=mid-1;//�����Ҳ�߽�
        		}else{//˵��target���Ҳ�����Χ��
        			left=mid+1;//�������߽�
        		}
        	}
    	}
    	System.out.println(targetIndex);
		return false;
    }
}
