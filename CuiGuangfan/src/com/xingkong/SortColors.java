package com.xingkong;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time��2016��1��3�� ����9:22:34 class description
 */
public class SortColors {
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

	public void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int i = 0;
		while (i <= right) {
			if (nums[i] == 0) {
				swap(nums, left, i);
				i++;
				left++;
			} else if (nums[i] == 2) {
				swap(nums, right, i);
				right--;
			} else {
				i++;
			}
		}
		for (int j = 0; j < nums.length; j++)
			System.out.print(nums[j] + " ");
	}

	private void sortColors_improve(int[] nums) {
		int i = -1;
		int j = -1;
		int k = -1;
		for (int p = 0; p < nums.length; p++) {
			// ���ݵ�i�����֣�Ų��0~i-1����
			if (nums[p] == 0) {
				nums[++k] = 2; // 2����Ų
				nums[++j] = 1; // 1����Ų
				nums[++i] = 0; // 0����Ų
			} else if (nums[p] == 1) {
				nums[++k] = 2;
				nums[++j] = 1;
			} else
				nums[++k] = 2;
		}
		for (int kk = 0; kk < nums.length; kk++)
			System.out.print(nums[kk] + " ");
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1,0,1,1,2,0,1,2 };
		SortColors sc = new SortColors();
//		sc.sortColors(nums);
		sc.sortColors_improve(nums);
	}
}
