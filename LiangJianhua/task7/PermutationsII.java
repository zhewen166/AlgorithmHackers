package com.josh.task7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
 * ����һ�����飬�������ظ�Ԫ�أ������в��ظ����������
 */
public class PermutationsII {
	@Test
	public void test(){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		//Set<List<Integer>> set = new HashSet<List<Integer>>();
		int[] nums = {3,3,0,0,2,3,2};
		//per(nums, 0, nums.length-1, set);
		list = permuteUnique(nums);
		//������
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.get(i).size();j++){
				System.out.print(list.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	//��������������洢��set�У�ȥ�أ������
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	Set<List<Integer>> set = new HashSet<List<Integer>>();
    	per(nums,0,nums.length-1,set);
    	Iterator<List<Integer>> it = set.iterator();
    	while(it.hasNext()){//��set�е�Ԫ��ת����list��
    		list.add(it.next());
    	}
    	return list;  
    }
    //������nums����������
    /*
     * �ݹ�
     */
    public Set<List<Integer>> per(int[] nums,int start,int end ,Set<List<Integer>> set){
    	if(start == end){//��ֻ��һ��Ԫ��ʱ��һ�����ȫ����
    		List<Integer> perList = new ArrayList<Integer>();
    		for(int i=0;i<nums.length;i++){
    			perList.add(nums[i]);
    		}
    		set.add(perList);
    	}else{
    		for(int i=start;i<=end;i++){
    			int temp = nums[start];//����startԪ�غ���֮���Ԫ��
    			nums[start] = nums[i];
    			nums[i] = temp;
    			per(nums, start+1, end, set);
    			temp = nums[start];//��������
    			nums[start] = nums[i];
    			nums[i] = temp;
    		}
    	}
    	return set;
    }
}
