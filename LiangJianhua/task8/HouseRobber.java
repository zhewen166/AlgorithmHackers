package com.josh.task8;


import org.junit.Test;
/*
 * ��һ��������ȡ��һ����������������ʹ������
 * ��̬�滮
 */
public class HouseRobber {
	@Test
	public void test(){
		int[] nums = {2,1,1,2};
		System.out.println(rob2(nums));
	}
   /*
    * ��̬�滮 �ؼ������ҵ�״̬ת�Ʒ��̺ͳ�ʼ״̬
    * ��������dp[i]�洢��λ��iʱ�����ֵ
    * ״̬ת�Ʒ��̣�dp[i] = max(dp[i-1],dp[i-2]+nums[i])
    * ��󷵻�dp[nums.length-1]
    */
	public int rob(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		int[] dp = new int[nums.length];
		dp[0] = nums[0];//��ʼ״̬
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i=2;i<nums.length;i++){
			dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);//״̬ת�Ʒ���
		}
		return dp[nums.length-1]; 
    }
	/*
	 *ȡֵҪô������λ��Ҫô��ż��λ�ã�����������a��b����¼����λ�ú�ż��λ�õ�ȡֵ
	 *
	 */
	public int rob2(int[] nums){
		int a=0,b=0;
		for(int i=0;i<nums.length;i++){
			if(i%2==0){//ȡż��λ�õ���
				a+=nums[i];
				a=Math.max(a,b);//�������ֵ
			}else{
				b+=nums[i];
				b=Math.max(a, b);
			}
		}
		return Math.max(a, b);
	}
}
