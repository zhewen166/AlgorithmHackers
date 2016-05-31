public class NQueenII52 {
	/**
	 * @param n
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015��12��28��
	 * Follow up for N-Queens problem.
	 * Now, instead outputting board configurations, 
	 * return the total number of distinct solutions.
	 */
	int result = 0;
	public int totalNQueens(int n) {
		/*
		 * ˼·�����ݣ����ѡ�
		 * ����ÿһ�У�����һ�кϷ��Ļʺ�λ�ã�pos��¼��ǰ�Ѿ��ߵ�λ��
		 * n��ʾ��һ�е��кţ�size�ǻʺ������
		 * ����Ϸ�����������һ�У�������Ϸ���������ǰ�㣬��һ����������Ϸ�λ�á�
		 * ����ĺϷ�����pos����ͬλ�ã�����б�Խǵ�λ�ã�ʹ��ԭ�����뵱ǰ�в�Ӽ�ԭ��λ�ã���λб�Խǣ�
		 * �����ѵ�n���ʺ�֮�󣬽���
		 *
		 */
		if (n<1) {
			return 0;
		}
		int[] pos = new int[n];
		findNext(pos, 0, n);
		return result;
    }
	private void findNext(int[] pos,int n,int size){
		if (n==size) {
			result++;
			return;
		}
		for (int i= 0;i<size;i++) {
				if(checkVaild(pos, n, i)){
					pos[n] = i;
					findNext(pos, n+1, size);
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
		int r = new NQueenII52().totalNQueens(9);
		System.out.println(r);
		
	}

}
