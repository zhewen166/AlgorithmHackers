
public class SortColors75 {
	/**
	 * @param nums
	 * @author xpxstar@gmail.com
	 * @2015��12��28��
	 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
	 */
	public void sortColors(int[] nums) {
		/* 
		 * ˼·��������ָ�룬left��right��mid
		 * leftָ����ߵ�һ������0��λ�ã�rightָ���ұߵ�һ������2��λ��
		 * midָ��left���һ������1��λ��
		 * �������У�
		 * l	r	mid
		 * 1	0	0		
		 * 1	1	0
		 * 2	0	0
		 * 2	1	0
		 * 
		 * 1	0	2
		 * 1	1	2
		 * 2	0	2
		 * 2	1	2
		 * ��������У�l=2������r=0 �򽻻�l r
		 * ��l=r=1����mid=0���򽻻�mid��l��
		 * ��mid=2������mid��r
		 * ֱ��mid��r�غϡ�
		 */
		if (nums.length<2) {
			return;
		}
        int l = 0,mid = 0,r = nums.length-1;
        while(mid<=r){
        	while(nums[l]==0){
        		l++;
        		if (l==r) {
					return;
				}
        	}
        	while(nums[r]==2) {
        		r--;
        		if (l==r) {
					return;
				}
			}
        	if (nums[l]==2) {
        		swap(nums,l,r);
			}else if (nums[r]==0) {
				swap(nums,l,r);
			}else {
				mid = l;
				while(nums[mid]==1){
					mid++;
					if (mid==r) {
						return;
					}
				}
				if (nums[mid]==2) {
					swap(nums, mid, r);
					r--;
					mid++;
				}else{
					swap(nums, mid, l);
					mid++;
					l++;
				}
			}
        }
    }
	private void swap(int[] nums,int l,int r ){
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2,2,2,0,0,0,1,1}; 
		new SortColors75().sortColors(nums);
		for (int i : nums) {
			System.out.println(i+",");
		}
		
	}

}
