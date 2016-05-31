package week7;

import java.util.LinkedList;
import java.util.List;

public class CountRightSmaller315 {
	public TreeNode root;
	public class TreeNode{
		int val;
		int children;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {val = x;children = 0;}
	}
	//ƫ���BST��children ��ʾ��ǰ�ڵ�ĺ�������
	/**
	 * @param value
	 * @return ���ر��²�����С��Ԫ�ظ���
	 * @author xpxstar@gmail.com
	 * @2016��1��12��
	 * ʱ�临�Ӷ�O(lgN)
	 */
	public int  addNode(int value){
		int num = 0;
        if(this.root == null){
            this.root = new TreeNode(value);
            return num;
        }
        TreeNode parent = null, node = root;
        while(node != null){
        	parent = node;
        	node.children++;
            if(value > node.val){
            	num+= node.left == null?1:node.left.children+2;
            	node = node.right;
            }else{
            	node = node.left;
            }
        }
        /* Have found the new node's position. Insert it into the tree. */
        if(value > parent.val)
            parent.right = new TreeNode(value);
        else
            parent.left = new TreeNode(value);
        
        return num;
    }
	
	/**
	 * @param nums
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016��1��12��
	 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
	 */
	public List<Integer> countSmaller(int[] nums) {
		/*˼·������BST����Ŀ������log(N)��ʱ����Ѱ�ҵ�����֪��С�����ĸ�����
		 * Ϊ�ˣ���BST�������޸ģ�1)BST�����ظ�����ƫ��ģ�����ȵ���������������
		 * 2)����children ��¼��ǰ�ڵ�ĺ��Ӹ���
		 * ����������������ʱ���жϵ�·���Ͻ��к��Ӹ������£����ң�ÿ�����Ҳ���ʱ���ۼƵ�ǰ�����������ĺ�����Ŀ������ǰ��֧��Ŀ��С�ĸ�����
		 * �ҵ��²�������ͬʱҲ����Ŀ����С�ĸ������������
		 */
		LinkedList<Integer> result = new LinkedList<Integer>();
		if (0> nums.length) {
			return result;
		}
		for (int i = nums.length-1; i > -1; i--) {
			result.addFirst(addNode(nums[i]));
		}
        return result;
    }
	public static void main(String[] args) {
		int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,32,78,9,21,84,66,65};
		CountRightSmaller315 cr = new CountRightSmaller315();
		System.out.println(cr.countSmaller(nums));
	}

}
