package week7;

public class CountRangeSum327 {
	public TreeNode root;
	public class TreeNode{
		long val;
		int children;
		TreeNode left;
		TreeNode right;
		public TreeNode(long x) {val = x;children = 0;}
		public TreeNode(TreeNode l,TreeNode r) {left = l;right = r;}
	}
	//ƫ���BST��children ��ʾ��ǰ�ڵ�ĺ�������
	/**
	 * @param value
	 * @return ���رȵ�ǰֵС��Ԫ�ظ�����
	 * @author xpxstar@gmail.com
	 * @2016��1��12��
	 * ʱ�临�Ӷ�O(lgN)
	 */
	public void  addNode(long value){
		if(this.root == null){
            this.root = new TreeNode(value);
            return;
        }
        TreeNode parent = null, node = root;
        while(node != null){
        	parent = node;
        	node.children++;
            if(value > node.val){
            	node = node.right;
            	}
            else{
            	node = node.left;
            }
        }
        if(value > parent.val)
            parent.right = new TreeNode(value);
        else
            parent.left = new TreeNode(value);
    }
	/**
	 * @param bottom
	 * @param top
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016��1��18��
	 * ���Ҹ��������޷�Χ�ڵ���
	 * �����ұ�����С�ĸ���
	 * ���ұ����޸ߵĸ���
	 * �������飬ʱ�临�Ӷ���O(lgN)
	 */
	public int searchBetween(long bottom,long top){
		/* ˼·���Ѿ�������BST
		 * ��ô�ұ�bottomС�ĸ���ʱ��ֻҪ�жϵ�ǰ�ڵ��Ƿ��bottomС��
		 * ����ǣ�˵����ǰ�ڵ��Լ���ǰ�ڵ�����Ӷ�����bottomС������Ҳ����Ҫ���ϵ�ǰ�ڵ㡢��ǰ�ڵ�����������Լ��������ĺ��Ӹ���
		 * ��Ȼ�������ǰ�ڵ�û����������ֻ��Ҫ�������ϵ�ǰ�ڵ���С�
		 * �����ǰ�ڵ�Ҫ����ô����������������
		 * 
		 */
		int num = 0;
        TreeNode node = root;
        while(node != null){
        	 if(bottom > node.val){
            	num+= node.left == null?1:node.left.children+2;
            	node = node.right;
            }else{
            	node = node.left;
            }
        }
        node = root;
        while(node != null){
        	 if(top < node.val){
            	num+= node.right == null?1:node.right.children+2;
            	node = node.left;
            }else{
            	node = node.right;
            }
        }
        return num;
    }
	/**
	 * @param nums
	 * @param lower
	 * @param upper
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016��1��12��
	 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i �� j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
	 */
	public int countRangeSum(int[] nums, int lower, int upper) {
		/*˼·������ת������sum[i],��0~i��������ͣ���ôĳ������ i~j�ĺ�(������i)�Ϳ��Ա�ʾΪsum[j]-sum[i]��
		 * ������������õ���sum[j],���֪����jǰ���ĳsum[i]������ lower <=sum[j]-sum[i] <= upper
		 * Ҳ����˵��jǰ�����sum[i] ���ڵ��� sum[j]-upper ��С�ڵ���sum[j]-lower �����ҵ���i~j(������i)�ĺͷ��Ϸ�Χ��
		 * ��BST �÷���Count315��ͬ��
		 */
		int size = nums.length;
		if (1>size) {
			return size;
		}
	     int count = 0;
	     long sum = 0;
	     for(int i = 0;i<nums.length;i++){
	    		addNode(sum);
				sum+= nums[i];
				count+=i+1-searchBetween(sum-upper, sum-lower);
			}
	     return count;
	}
	public int countRangeSumAb(int[] nums, int lower, int upper) {
		long sum = 0;
		int count = 0;
	     for(int i = 0;i<nums.length;i++){
	    	 sum = 0;
	    	 for (int j = i;j < nums.length; j++) {
	    		sum += nums[j];
				if (sum>=lower && sum <= upper) {
					count++;
				}
			}
	     }
	     return count;
	}
	public static void main(String[] args) {
		CountRangeSum327 cr = new CountRangeSum327();
		int[] nums = {2147483647,-2147483648,-1,0};
		System.out.println(cr.countRangeSum(nums, -1, 0));
	}
}
