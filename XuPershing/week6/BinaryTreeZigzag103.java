import java.beans.Visibility;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class BinaryTreeZigzag103 {
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
		 public void setChildren(TreeNode l,TreeNode r){
				left = l;
				right = r;
		}
			public void setVal(int x){
				val = x;
			}
	}
	public List<List<Integer>> horizonVisit(TreeNode root) {
        LinkedList<TreeNode> ll = new LinkedList<>();
        TreeNode next;
        ll.addFirst(root);
        while(!ll.isEmpty()){
        	next = ll.removeFirst();
        	System.out.println(next.val);
        	if (null != next.left) {
				ll.addLast(next.left);
			}
        	if (null != next.right) {
				ll.addLast(next.right);
			}
        	
        }
        return null;
    }
	/**
	 * @param root
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016��1��7��
	 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		visit(root,result,0);
		return result;
	}
	private void visit(TreeNode root,List<List<Integer>> result, int level){
		/*˼·���ݹ���ʣ�ÿ��һ�����顣
		 * �ؼ��㣬���ϵ��£��������ұ�������¼��ǰ���
		 * ����Ӧ��ε�����ӵ���Ӧ��������С�
		 * ��ʱ�������ʱ������������ӣ�����ӵ�listͷ
		 */
		if (root == null) {
			return;
		}
		if (result.size() <= level) {
			result.add(new LinkedList<Integer>());
		}
		if ((level&1) == 1) {
			result.get(level).add(0,root.val);//��ǰ�����
		}else{
			result.get(level).add(root.val);
		}
		visit(root.left, result, level+1);
		visit(root.right, result, level+1);
		
		
	}
	public static void main(String[] args) {
		BinaryTreeZigzag103 btz = new BinaryTreeZigzag103();
		TreeNode init[] = new TreeNode[7];
		for (int i = 1; i < 8; i++) {
			init[i-1] = btz.new TreeNode(i);
		}
		init[0].setChildren(init[1], init[2]);
//		init[1].setChildren(init[3], null);
		init[2].setChildren(init[5], init[6]);
		btz.zigzagLevelOrder(init[0]);
	}
}
