package com.xingkong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time��2015��12��29�� ����8:38:48 class description
 */
public class SubsetsII {
	public HashSet<List<Integer>> tempSet = new HashSet<List<Integer>>();

	/**
	 * @param nums
	 * @param selectFlag
	 * @param index
	 * @description ��������������ÿ��Ԫ��ֻ�����������ȡ���ǲ�ȡ����ô�ݹ�ÿ��Ԫ�أ�ȡ���ǲ�ȡ������
	 */
	public void backTrack(int[] nums, int[] selectFlag, int index) {
		if (index == nums.length) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < selectFlag.length; i++) {
				if (selectFlag[i] != 0)
					list.add(nums[i]);
			}
			// Collections.sort(list);//after using Arrays.sort,there is no need
			// to use this,improve 5ms
			tempSet.add(list);
			return;
		}
		selectFlag[index] = 1;
		backTrack(nums, selectFlag, index + 1);
		selectFlag[index] = 0;
		backTrack(nums, selectFlag, index + 1);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);// optimization,just sort one time,then there is no
							// need to sort again
		backTrack(nums, new int[nums.length], 0);
		return new ArrayList<List<Integer>>(tempSet);
	}

	public static void main(String[] args) {
		SubsetsII ss = new SubsetsII();
		System.out.println(ss.subsetsWithDup(new int[] { 2, 1, 2 }));
	}
}
