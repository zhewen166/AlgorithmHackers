package com.josh.task7;

import org.junit.Test;
/*
 * ���⣺
 * �����д洢���µ�i��Ĺ�Ʊ�۸�
 * ����ѹ�Ʊ����ʱ��
 * ע��һ�������һ������Ϊһ�ν���
 */
public class BestTimeToBuyAndSellStockIII {
	@Test
	public void test(){
		int[] prices={3,2,6,5,0,3};
		System.out.println(maxProfit3(prices));
 	}
	/*
	 *Ҫ��ֻ����һ�ν��ף���������
	 *     ���������е����ֵ����Сֵ������СֵҪ�����ֵǰ��
	 */
    public int maxProfit1(int[] prices) {
    	if(prices.length <= 1) return 0;
		int minPrice = prices[0],maxPrice=prices[0],minPrice2 = prices[0];
		for(int i=0;i<prices.length;i++){
			if(prices[i]>maxPrice || prices[i]-minPrice2>maxPrice-minPrice){
				minPrice = minPrice2;
				maxPrice = prices[i];
			}
			if(prices[i]<minPrice2){
				minPrice2 = prices[i];
			}
		}
    	return maxPrice-minPrice; 
    }
    /*
     * �����ƽ��״�������������
     * ����̰���㷨����ǰ����ֻҪ�����棨ǰһ��Ⱥ�һ��۸�ͣ��ͽ���һ�ν��ף�Ȼ������л������
     */
    public int maxProfit2(int[] prices) {
    	if(prices.length < 2) return 0;
    	int minPrice = prices[0],maxPrice=prices[0],maxProfit = 0,i=0;
		while(i<prices.length-1){
			if(prices[i]<prices[i+1]){
				minPrice = prices[i];
				while(i<prices.length-1 && prices[i]<prices[i+1]){
					i++;
				}
				maxPrice = prices[i];
				maxProfit = maxProfit + (maxPrice - minPrice);
			}
			i++;
		}
		return maxProfit;
    }
    /*
     * ���������ν��ף���������
     * ������ǰ������һ�Σ������ֹ��i�죬֮ǰ��������棬��ͬ����1
     *    �Ӻ���ǰ����һ�Σ���ӵ�i�쿪ʼ��֮���������棬��ͬ����1
     *    Ȼ��һ�α���������������������
     */
    public int maxProfit3(int[] prices) {
    	if(prices.length < 2) return 0;
        int[] preProfit = new int[prices.length];
        int[] postProfit= new int[prices.length];
        int curMin = prices[0],curMax=prices[prices.length-1], maxProfit=0;
        for(int i=0;i<prices.length;i++){//˳�ű�����ֹ����i����������
        	curMin = Math.min(curMin, prices[i]);
        	maxProfit = Math.max(maxProfit, prices[i]-curMin);
        	preProfit[i] = maxProfit;
        }
        maxProfit = 0;
        for(int j=prices.length-1;j>=0;j--){//���ű�����i��֮����������
        	curMax = Math.max(curMax, prices[j]);
        	maxProfit = Math.max(maxProfit, curMax-prices[j]);
        	postProfit[j] = maxProfit;
        }
        maxProfit = preProfit[0]+postProfit[0];
        for(int k=0;k<prices.length;k++){
        	if(preProfit[k]+postProfit[k]>maxProfit){
        		maxProfit = preProfit[k]+postProfit[k];
        	}
        }
    	return maxProfit;
    }
}
