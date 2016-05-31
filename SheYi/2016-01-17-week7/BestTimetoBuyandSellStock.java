package week7;

public class BestTimetoBuyandSellStock {
	//121. Best Time to Buy and Sell Stock
	//AC 4ms  
	/* public int maxProfit(int[] prices) {
		 if(prices.length <2) return 0;
	     int min=Integer.MAX_VALUE;
	     int profit=0;
	     for(int i=0;i<prices.length;i++){
	       if(maxOrMin(prices,i)==0) continue;
	       else if(maxOrMin(prices,i)==1){
	    	   if(prices[i]<min) {
	    		   min=prices[i]; 
	    	   }
	       }else if(maxOrMin(prices,i)==2){
	    	   if(prices[i]>min){
	    		   int tempProfit=prices[i]-min;
	    		   if(tempProfit>profit){
	    			   profit=tempProfit;
	    		   }
	    	   }
	       }
	     }
		 return profit;   
	    }
	 
	 private int maxOrMin(int[] nums,int index){
		 if(index==0){
			 if(nums[0]<=nums[1]) return 1;
			 else return 0;
		 }else if(index==nums.length-1){
			 if(nums[index-1]<=nums[index]) return 2;
			 else return 0;
		 }else if(nums[index]<=nums[index+1]&&nums[index-1]>=nums[index]){
				 return 1;
			 }
		 else if(nums[index]>=nums[index-1]&&nums[index]>=nums[index+1]){
			    return 2;
		 }else 
			 return 0;
		 
		 
	 }*/
	
	//122. Best Time to Buy and Sell Stock II  AC 3m
	/*   public int maxProfit(int[] prices) {
		   if(prices.length <2) return 0;
	       int min=0,profit=0;
	       boolean flag=false;
		   for(int i=0;i<prices.length;i++){
			   if(maxOrMin(prices,i)==1){
				   flag=true;
				   min=prices[i];
			   }else if(maxOrMin(prices,i)==2&&flag){
				   profit+=prices[i]-min;
				   flag=false;
			   }
		   }
		   
		   return profit;
	    }
	 
	   private int maxOrMin(int[] nums,int index){
			 if(index==0){
				 if(nums[0]<=nums[1]) return 1;
				 else return 0;
			 }else if(index==nums.length-1){
				 if(nums[index-1]<=nums[index]) return 2;
				 else return 0;
			 }else if(nums[index]<=nums[index+1]&&nums[index-1]>=nums[index]){
					 return 1;
				 }
			 else if(nums[index]>=nums[index-1]&&nums[index]>=nums[index+1]){
				    return 2;
			 }else 
				 return 0;
	   }*/
	//III AC 6ms
	//˼·������I��II����֪������1�����ν��׵���ȡ�õ��������һ������һ�ν���ȡ�õ�������棻��2�����׵�һ���������еļ���ֵ��ͼ�Сֵ�㡣����
	//start��end����ֱ��ʾ�ڵڼ��콻�� ��start��ʾ���룬end��ʾ������������ʾ�ڼ��ν��ף�
	//��������ǰn��Ԫ�ؿ���ȡ�õ��������(2�ν���)Ϊ�ֱ����ڵ�start[0]�����룬�ڵ�end[0]���׳��͵�start[1]�����룬��end[1]�׳�����ô
	//���ű��������ҵ����ף�start[2]��end[2]������ʱ��Ҫ�Ƚ��������鼫ֵ�У��ҵ�ʹ���ν��������������ϣ���Ҫ��profit(start[0],end[1])+profit(start[2],end[2])
	//��profit(start[0],end[0])+profit(start[1],end[2])�и����һ����Ȼ�����start��end���飨Ҳ����getRange����������������
	  public int maxProfit(int[] prices) {
		  if(prices.length <2) return 0;
	      int profit=0;
		  int[] start=new int[3];
	      int[] end=new int[3];
	      boolean flag=false;
	      int j=0,k=0;
		     for(int i=0;i<prices.length;i++){  //һ�α�������
		    	 if(maxOrMin(prices,i)==1){  //��Сֵ
		    	  if(j<2)   
		    	  start[j++]=i;
		    	  else{   //�Ѿ������ν���
		    		  if(start[2]==0)  start[j++]=i;  //��ǰΪ�����ν��׵���ʼֵ ��
		    		  else{
		    		  if(prices[i]<prices[start[2]])   //��¼�ӵڶ��ν��׽���֮�󣬵����ν����������Сֵ
		    			  start[j++]=i;
		    		  else
		    			  j++;
		    		  }
		    	  }
		    	  flag=true;
		       }else if(maxOrMin(prices,i)==2&&flag){  //����ֵ
		    	   flag=false;
		    	   end[k++]=i;
		    	   if(k==3&&j==3){     //����õ���һ�����еĵ����ν��� ����Ҫ�����Ƿ���Եõ�һ�����������2�ν��׵����
		    		   getRange(start,end,prices);  // ����ҵ��͸���
		    		   k=2;j=2;  //k��j����Ϊ2������ȥѰ�ҿ��еĵ����ν�������������������
		    	   }
		       }
		     }
		   int length=end.length<2?end.length:2;  //ֻ�������ν��׵�
		  for(int i=0;i<length;i++){
		     profit+=prices[end[i]]-prices[start[i]];
		  }
		     return profit;
	    }
	  
	  //�жϵ��������н����Ƿ����ȡ�ø�������ν���������棬������Ծ͸���start��end��ֵ
	  //(start[0],end[0]),(start[1],end[1])ָ����ǵ�ĿǰΪֹȡ���������Ľ���
	  public void getRange(int[] start,int[] end,int[] prices){
		   int num10=prices[end[0]]-prices[start[0]];
		   int num11=prices[end[1]]-prices[start[1]];
		   int num12=prices[end[2]]-prices[start[2]];
		   int num20=prices[end[1]]-prices[start[0]];
		   int num21=prices[end[2]]-prices[start[1]];
		   int[] r1=new int[2];
		   int[] r2=new int[2];
		   maxThreeNums(num10,num11,num20,r1);
		   maxThreeNums(num11,num12,num21,r2);
		   if(r1[0]+num12>r2[0]+num10){   
			   switch(r1[1]){
			   case 1:break;
			   case 2:start[0]=start[1];end[0]=end[1];break;
			   case 3: end[0]=end[1];break;
			   default:break;
			   }
			   start[1]=start[2];end[1]=end[2];start[2]=0;end[2]=0;
		   }else{
			   switch(r2[1]){
			   case 1:break;
			   case 2:start[1]=start[2];end[1]=end[2];start[2]=0;end[2]=0;break;
			   case 3:end[1]=end[2];start[2]=0;end[2]=0;break;
			   default: break;
			   }
		   }
		   
	  }
	  //�Ƚ�3���� ��һ������  result[0]������ֵ result[1]������ֵ������
	  public void maxThreeNums(int num1,int num2,int num3,int[] result){
		  int maxNum=max(max(num1,num2),num3);
		  if(maxNum==num1)  result[1]=1;
		  else if(maxNum==num2)  result[1]=2;
		  else if(maxNum==num3)  result[1]=3;
		  else result[1]=0;
		  result[0]=maxNum;
	  }
	  
	  public int max(int num1,int num2){
		  return num1>num2?num1:num2;
	  }
	  //�ж��Ƿ��Ǽ�ֵ  ��Сֵ����1 ����ֵ����2 ���Ǽ�ֵ����0
	  private int maxOrMin(int[] nums,int index){
			 if(index==0){
				 if(nums[0]<=nums[1]) return 1;
				 else return 0;
			 }else if(index==nums.length-1){
				 if(nums[index-1]<=nums[index]) return 2;
				 else return 0;
			 }else if(nums[index]<=nums[index+1]&&nums[index-1]>nums[index]){
					 return 1;
				 }
			 else if(nums[index]>=nums[index-1]&&nums[index]>nums[index+1]){
				    return 2;
			 }else 
				 return 0;
	   }
	 public static void main(String [] args){
		 BestTimetoBuyandSellStock best=new BestTimetoBuyandSellStock();
		 int[] prices={1,3,5,4,3,7,6,9,2,4};
		 
		 int r=best.maxProfit(prices);
		 System.out.println("max profit is "+r);
	 }
}
