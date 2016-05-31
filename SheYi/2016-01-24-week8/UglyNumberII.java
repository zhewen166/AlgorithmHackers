package week8;

public class UglyNumberII {
	
	//��򵥵Ľⷨ�����ǳ�ʱ��һ�α���ÿһ�������ǲ��ǳ���
	/* public int nthUglyNumber(int n) {
		  if(n==1) return 1;
		   int preNum=1,count=1;
		  while(count<n){
			  if(isUgly(++preNum)){
				  count++;
			  }
		  }
	        return preNum;
	    }
	 public boolean isUgly(int num) {
	        if(num<1) return false;
	       while(num%2==0)
	       num=num/2;
	       while(num%3==0)
	       num=num/3;
	       while(num%5==0)
	       num=num/5;
	       if(num!=1)
	       return false;
	       else
	       return true;
	    }
	*/
	
	//���ϵĽⷨ  
/*  ˼·��
 * 	1��N�ĳ���Ϊ 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, �� �� 
	���Էֳ��������飺

	(1) 1��2, 2��2, 3��2, 4��2, 5��2, ��
	(2) 1��3, 2��3, 3��3, 4��3, 5��3, ��
	(3) 1��5, 2��5, 3��5, 4��5, 5��5, ��
	ֻ��Ҫ��֤ÿ�ε����Ĺ�����ѡȡ��С�ĳ���������˵�������������������Ϊ�����������ǰ����������2,3,5�ĳ˻���*/
	public int nthUglyNumber(int n) {
		int factor2=2,factor3=3,factor5=5;
		int index2=0,index3=0,index5=0;
		int[] ugly=new int[n];
		for(int i=1;i<n;i++){
			int minNum=min3(factor2,factor3,factor5);
			ugly[i]=minNum;
			
			if(factor2==minNum)
				factor2=2*ugly[++index2];
			if(factor3==minNum)
				factor3=3*ugly[++index3];
			if(factor5==minNum)
				factor5=5*ugly[++index5];
		}
		return ugly[n-1];
	}

	public int min3(int a,int b,int c){
		if(a<b)
			return a<c?a:c;
		else
			return b<c?b:c;
	}

	 
	 public static void main(String [] args){
		 UglyNumberII u=new UglyNumberII();
		 int r=u.nthUglyNumber(12);
		 System.out.println("result="+r);
	 }
}
