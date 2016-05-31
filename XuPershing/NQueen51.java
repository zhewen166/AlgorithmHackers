import java.util.ArrayList;
import java.util.List;

public class NQueen51 {
	/**
	 * @param n
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015��12��28��
	 * The n-queens puzzle is the problem of placing n queens on an n��n chessboard 
	 * such that no two queens attack each other.
	 * Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, 
where 'Q' and '.' both indicate a queen and an empty space respectively.
For example,
There exist two distinct solutions to the 4-queens puzzle:
	 * [
	 * [".Q..",  // Solution 1
	 *  "...Q",
	 *  "Q...",
	 *  "..Q."],
	 *  ["..Q.",  // Solution 2
	 *  "Q...",
	 *  "...Q",
	 *  ".Q.."]
	 *  ]
	 */
	char[] initc;
	public List<List<String>> solveNQueens(int n) {
		/*˼·�����ݣ����ѡ�
		 * ����ÿһ�У�����һ�кϷ��Ļʺ�λ�ã�pos��¼��ǰ�Ѿ��ߵ�λ��
		 * n��ʾ��һ�е��кţ�size�ǻʺ������
		 * ����Ϸ�����������һ�У�������Ϸ���������ǰ�㣬��һ����������Ϸ�λ�á�
		 * ����ĺϷ�����pos����ͬλ�ã�����б�Խǵ�λ�ã�ʹ��ԭ�����뵱ǰ�в�Ӽ�ԭ��λ�ã���λб�Խǣ�
		 * ʹ��initc�����ʼ��'.'��
		 * �����ѵ�n���ʺ�֮�󣬽���
		 */
		List<List<String>> result = new ArrayList<>();
		if (n<1) {
			return result;
		}
		int[] pos = new int[n];
		initc = new char[n];
		for (int i = 0; i < n; i++) {
			initc[i] = '.';
		}
		findNext(pos, result, 0, n);
		return result;
    }
	private void findNext(int[] pos,List<List<String>> result,int n,int size){
		if (n==size) {
			List<String> newSolution = new ArrayList<>();
			for (int i= 0;i<size;i++) {
				char[] newc = initc.clone();
				newc[pos[i]] = 'Q';
				newSolution.add(new String(newc));
			}
			result.add(newSolution);
			return;
		}
		for (int i= 0;i<size;i++) {
				if(checkVaild(pos, n, i)){
					pos[n] = i;
					findNext(pos, result, n+1, size);
				}
			}
	}
	private boolean checkVaild(int[] pos,int n,int test){
		for (int i = 0; i < n; i++) {
			if (test == pos[i]||test == n-i+pos[i]||test == pos[i]-n+i) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> r = new NQueen51().solveNQueens(9);
		for(List<String> tmp :r){
			for(String i : tmp){
				System.out.println(i);
			}
			System.out.println();
		}
		System.out.println(r.size());
		
	}

}
