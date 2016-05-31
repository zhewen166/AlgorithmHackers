package com.xingkong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time��2016��3��8�� ����8:26:06 
* class description
*/
public class N_15_3Sum {
	public static List<List<Integer>> threeSum_0(int[] nums) {//��һ�泬ʱ����Ϊ��ʹ����һ��list
		Set<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int p1=0;p1<nums.length-2;p1++){
			//�Ż���1
			if(p1>0&&nums[p1]==nums[p1-1]) continue;
			int p2=p1+1;
			int p3=nums.length-1;
			while(p2<p3){
				if(nums[p1]+nums[p2]+nums[p3]==0){
					ArrayList<Integer> list=new ArrayList<Integer>();
					list.add(nums[p1]);
					list.add(nums[p2]);
					list.add(nums[p3]);
					if(!set.contains(list)){
						set.add(list);
						result.add(list);
					}
					p2++;
					p3--;
				}else if(nums[p1]+nums[p2]+nums[p3]>0){
					p3--;
				}else{
					p2++;
				}
			}
		}
        return result;
    }
	public List<List<Integer>> threeSum_1(int[] nums) {//ȥ����result��7%��49ms
        Set<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
		//List<List<Integer>> result=new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int p1=0;p1<nums.length-2;p1++){
			int p2=p1+1;
			int p3=nums.length-1;
			while(p2<p3){
				if(nums[p1]+nums[p2]+nums[p3]==0){
					ArrayList<Integer> list=new ArrayList<Integer>();
					list.add(nums[p1]);
					list.add(nums[p2]);
					list.add(nums[p3]);
					if(!set.contains(list)){
						set.add(list);
						//result.add(list);
					}
					p2++;
					p3--;
				}else if(nums[p1]+nums[p2]+nums[p3]>0){
					p3--;
				}else{
					p2++;
				}
			}
		}
        return new ArrayList<List<Integer>>(set);
    }
	public static List<List<Integer>> threeSum_2(int[] nums) {//9ms
        //Set<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
		List<List<Integer>> result=new ArrayList<List<Integer>>();//�Ż���1
		Arrays.sort(nums);
		for(int p1=0;p1<nums.length-2;p1++){
			if(p1>0&&nums[p1]==nums[p1-1]) continue;//�Ż���2
			int p2=p1+1;
			int p3=nums.length-1;
			while(p2<p3){
				if(nums[p1]+nums[p2]+nums[p3]==0){
					ArrayList<Integer> list=new ArrayList<Integer>();
					list.add(nums[p1]);
					list.add(nums[p2]);
					list.add(nums[p3]);
//					if(!set.contains(list)){
//						set.add(list);
//						//result.add(list);
//					}
					result.add(list);//�����Ż�������ã����ԣ�����Ҫset��
					while (p2 < p3 && nums[p3] == nums[p3 - 1]){//�Ż���3�������ظ���
						p3--;
                    }
					p3--;
                    while (p2 < p3 && nums[p2] == nums[p2+1]){//�Ż���4
                    	p2++;
                    }
                    p2++;
				}else if(nums[p1]+nums[p2]+nums[p3]>0){
					while (p2 < p3 && nums[p3] == nums[p3 - 1]){//�Ż���5
						p3--;
                    }
					p3--;
				}else{
					while (p2 < p3 && nums[p2] == nums[p2+1]){//�Ż���6
                    	p2++;
                    }
                    p2++;
				}
			}
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_15_3Sum.threeSum_2(new int[]{-2,0,1,1,2}));
	}

}
