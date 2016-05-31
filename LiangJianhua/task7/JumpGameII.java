package com.josh.task7;
import org.junit.Test;

/*
 * ����һ���Ǹ����飬�����е�Ԫ�ش���ӵ�ǰλ�ÿ����ƶ��������
 * ��ʼ��λ��0
 */
public class JumpGameII {

	@Test
	public void test(){
		int[] nums = {1,1,1,0};
		int i = jump(nums);
		System.out.print(i);
		boolean b = canJump(nums);
		System.out.println(b);
	}
	//Jump Gam II
	/*
	 * �󵽴�����ĩβ�����ٲ���
	 * �������ӿ�ʼλ��Ѱ�ҿɵ�����Զ�������һ����
	 * 	        ֱ�������ӿ�ʼλ���ܵ������Զ����λ��Ϊ����ʼλ������+��ʼλ�õ�Ԫ��ֵ=��Զλ������
	 *     ����ʵ�������������ǻ�Ҫ����"��ʼλ��"��"��ʼλ������+��ʼԪ��ֵ"λ��֮�������Ԫ��
	 *     �������ܵ������Զ�����Ƿ��"��Զλ������"Զ����Զ���Ե�ǰλ��Ϊ��һ����ʼλ��
	 */
    public int jump(int[] nums) {
    	int steps = 1;
    	if(nums.length == 0 || nums.length == 1) return 0;
    	if(nums[0]>=(nums.length-1)) return 1;
    	return findPosi(nums, 0, steps);    
    }
    public int findPosi(int[] nums ,int start,int steps){
    	while(start + nums[start]<nums.length-1){
    		int end = start + nums[start];
    		int maxLen = end+nums[end];//start��һ���ɵ������Զ����
    		for(int i=start;i<=end;i++){
        		if((i+nums[i])>=maxLen){
        			maxLen = i+nums[i];
        			start = i;
        		}
        	}
    		steps++;
    	}
    	return steps;
    }
    //Jump Gam I
    //����ĩβ�Ƿ�ɴ�
    /*������
     * ���ɴ�λ��һ������0�����֣����Ա������飬��û��0�����Ȼ�ɴ�
     * ����0����0λ�ÿ�ʼ�жϣ�֮ǰ�����Ƿ���Ծ���0�������ɾ��������ʾ���ɴ���ɾ������ɴ�
     * 
     */
    public boolean canJump(int[] nums) {
    	if(nums.length == 0) return false;
    	if(nums.length == 1 || nums[0]>=(nums.length-1)) return true;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i] == 0 && i!=nums.length-1){
    			boolean flag = false;//���0֮ǰ��λ���ϵ�Ԫ���Ƿ���Ծ���0λ��,������ܾ�����list.add(i)��
    			for(int j=i;j>=0;j--){
    				if(j+nums[j]>i+nums[i]){
    					flag = true;
    					break;//���Ծ���0λ�ã�����ѭ��
    				}
    			}
    			if(flag == false) return false;
    		}
    	}
    	return true;
    }
}
