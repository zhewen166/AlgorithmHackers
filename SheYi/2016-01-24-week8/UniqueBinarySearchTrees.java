package week8;

public class UniqueBinarySearchTrees {
	//AC 0ms  s[i]��ʾ1��i���Թ��ɵ�Ψһ�����������ĸ��� �����α���ÿһ��������ߵ���Ϊ���������ұߵ���Ϊ������ ��������������� 
	//��̬�滮��˼�� �ֽ�Ϊ���������
	public int numTrees(int n) {
		 int[] s=new int[n+1];
        s[0]=1;
        s[1]=1;
	     for(int i=2;i<=n;i++){
	    	  int temp=0;
	    	 for(int j=1;j<=i;j++){
	    	  temp+=s[j-1]*s[i-j];
	    	 }
	    	 s[i]=temp;
	     }
	     return s[n];
	 }
}
