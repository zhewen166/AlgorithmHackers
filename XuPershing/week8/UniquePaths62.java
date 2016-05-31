package week8;

public class UniquePaths62 {
	/**
	 * @param m
	 * @param n
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016��1��21��
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
	 */
	public int uniquePaths(int m, int n) {
		/*˼·��������Ҫô����Ҫô���ң��ܹ���m-1�����º�n-1�����ң�
		 * ������n-1�����ҵĹ����У���������ѡ��ĳ�գ�����m-1�����µĹ��̡�
		 * �����ܵĴ�����A(m-1,m+n-2)/(m-1)!
		 * 
		 */
		int up = n+m-2;
		int small = m>n?n:m;
		long result=1;
        for(int i = 1 ;i < small;i++){
        	result*=up--;
        	result/=i;
        }
        return (int)result;
    }
	/**
	 * @param m
	 * @param n
	 * @return
	 * @author xpxstar@gmail.com
	 * @2016��1��22��
	 * 
	 */
	public int uniquePathsII(int[][] obstacleGrid) {
		/*˼·����̬�滮��pp[i][j]��ʾ���ýڵ��·������������ϰ�����ֵ0
		 * ��ôpp[i][j]��·����Ȼ����pp[i-1][j]��pp[i][j-1],������·���ĺͣ���Ϊ����û�н����·����
		 * 
		 * 
		 */
		int m = obstacleGrid.length;
		if (m<1) {
			return 1;
		}
		int n = obstacleGrid[0].length;
		int[][] pp = new int[m][n];
		boolean stuck = false;
		for (int i = 0; i < m; i++) {
			stuck = stuck || obstacleGrid[i][0]==1;
			pp[i][0] = stuck?0:1;
		}
		stuck = false;
		for (int i = 0; i < n; i++) {
			stuck = stuck || obstacleGrid[0][i]==1;
			pp[0][i] = stuck?0:1;
		}
		for(int i = 1; i < m; i++){
			for (int j = 1; j < n; j++) {
				if (1== obstacleGrid[i][j]) {
					pp[i][j] = 0;
				}else{
					pp[i][j] = pp[i-1][j]+pp[i][j-1];
				}
			}
		}
		
        return pp[m-1][n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePaths62 up = new UniquePaths62();
		int[][] test = {
		                {0,0,0,1,0},
		                {0,1,0,0,0},
		                {1,0,1,0,0},
		                {0,0,0,0,0}
		              };
		System.out.println(up.uniquePathsII(test));
	}

}
