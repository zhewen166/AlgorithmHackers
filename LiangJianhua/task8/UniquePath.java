package com.josh.task8;

import org.junit.Test;

public class UniquePath {
	@Test
	public void test(){
		System.out.println(uniquePaths(1, 2));
	}
	/*
	 * ��һ�������Ѱ�Ҵ����ϵ����²�ͬ��·��һ���м���
	 * DP:
	 * ��ǰλ�õ�·������=��ǰ��λ��·������+���Ϸ�λ��·������
	 * ��ʼ״̬��dp[0][j]=0,dp[i][0]=0
	 * ���ƹ�ʽ��dp[i][j]=dp[i][j-1]+dp[i-1][j]
	 * 
	 */
	public int uniquePaths(int m,int n){
		 int[][] dp = new int[m][n];
	     //��ʼ״̬����һ�к͵�һ����Ϊ1
		 for(int i=0;i<m;i++){//�г�ʼ��
			 dp[i][0]=1;
		 }
		 for(int j=0;j<n;j++){//�г�ʼ��
			 dp[0][j]=1;
		 }
		 for(int i=1;i<m;i++){//��̬�滮���
			 for(int j=1;j<n;j++){
				 dp[i][j]=dp[i][j-1]+dp[i-1][j];
			 }
		 }
		 return dp[m-1][n-1];
	}
	//�ⷨͬ����һ
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid[0][0]==1 || obstacleGrid.length==0) return 0;//��ʼλ�þ����ϰ���
	    for(int i=0;i<obstacleGrid.length;i++){//���³�ʼ����-1��ʾ�ϰ���
	    	if(obstacleGrid[i][0]==1){//�ӵ�ǰλ�ÿ�ʼ���涼��0�����ɴ�
	    		for(;i<obstacleGrid.length;i++){
	    			obstacleGrid[i][0]=0;
	    		}
	    	}else{
	    		obstacleGrid[i][0]=1;
	    	}
	    }
	    for(int j=1;j<obstacleGrid[0].length;j++){
	    	if(obstacleGrid[0][j]==1){
	    		for(;j<obstacleGrid[0].length;j++){
	    			obstacleGrid[0][j]=0;
	    		}
	    	}else{
	    		obstacleGrid[0][j]=1;
	    	}
	    }
	    for(int i=1;i<obstacleGrid.length;i++){//��̬�滮���
			 for(int j=1;j<obstacleGrid[0].length;j++){
				 if(obstacleGrid[i][j]==1){
					 obstacleGrid[i][j]=0;
				 }else{
					 obstacleGrid[i][j]=obstacleGrid[i][j-1]+obstacleGrid[i-1][j];
				 }
			 }
		 }
		return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]; 
	}
//    public int uniquePaths1(int m, int n) {
//    	if(m*n==0) return 0;
//    	if(m==1 || n==1) return 1;
//    	int count = 0;//��¼��·����Ŀ
//        int[][] grid = new int[m][n];//��ʼ�����
//        int[][] visit = new int[m][n];//����Ƿ����
//        for(int i=0;i<m;i++){
//        	for(int j=0;j<n;j++){
//        		grid[i][j] = 0;
//        		if(i==m-1 ||j==n-1) visit[i][j]=1;
//        		else visit[i][j]=2;
//        	}
//        }
//        
//        int x=0,y=0,preX=m-1,preY=n-1;
//        grid[0][0]=1;//��ʼλ��
//        visit[0][0]=2;//visit[m-1][n-1]=0;
//        while((x<m || y<n)){
//        	if(y+1<n && grid[x][y+1]==0 && visit[x][y+1]>0){//������
//            	if(x==0 && y==0) visit[0][0]--;
//        		grid[x][y+1]=1;
//        		visit[x][y+1]--;
//        		y++;
//        	}else if(x+1<m && grid[x+1][y]==0 && visit[x+1][y]>0){//������
//        		if(x==0 && y==0) visit[0][0]--;
//        		grid[x+1][y]=1;
//        		visit[x+1][y]--;
//        		x++;
//        	}else{//���¶��߲�ͨ�����������1 ���߲����ˣ�������һ����2 �����յ��ˣ�Ҳ���˵���һ��
//        		if(visit[0][0]==0) break;
//        		if(x==m-1 && y==n-1){//�����յ㡢������һ��
//            		count++;
//            		visit[x][y]=1;
////            		if(count==2){
////            			System.err.println("ee");
////            		}//����ѭ��
//            	}
//        		grid[preX][preY]=0;//ǰһλֵ�ɷ���
//        		preX=x;preY=y;
//        		grid[preX][preY]=-1;//��ǰһλ��������Ϊ-1
//        		if(y>=1 && grid[x][y-1]==1){//���˵���һ��λ��
//        			y=y-1;
//        		}else if(x>=1 && grid[x-1][y]==1){
//        			x=x-1;
//        		}else {
//					//break;
//				}
//        	}
//        }
//    	return count;
//    }
}
