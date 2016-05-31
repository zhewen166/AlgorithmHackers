package com.josh.task8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class UglyNumber {
	@Test
	public void test(){
		System.out.println(nthUglyNumber3(1510));
	}
	/*
	 * ��֮ǰ�Ѿ����ڵĳ�ª�����ֱ����2,3,5�õ����³�ª��
	 * ���³�ª��ȡֵ��������С��
	 * ������ָ���¼2,3,5��λ��
	 */
	public int nthUglyNumber3(int n){
		if(n==1) return 1;
		List<Integer> res = new ArrayList<>();
		int p2=0,p3=0,p5=0,curUglyNum=1,v2=0,v3=0,v5=0;
		res.add(1);
		while(res.size()<n){
			v2=res.get(p2)*2;
			v3=res.get(p3)*3;
			v5=res.get(p5)*5;
			curUglyNum = Math.min(v2, v3);
			curUglyNum = Math.min(curUglyNum, v5);
			if(curUglyNum == v2) p2++;
			if(curUglyNum == v3) p3++;
			if(curUglyNum == v5) p5++;
			res.add(curUglyNum);
		}
		return res.get(res.size()-1);
	}
	//����5��ʱ��ֱ��Խ���������ֵ��������Сֵ���ڵõ�һ����С���������˴���ע�������쳣
	public int nthUglyNumber2(int n){
		if(n==1) return 1;
		List<Integer> list = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		res.add(1);
		while(res.size()<n){
			if(!list.contains(res.get(res.size()-1)*2) && (res.get(res.size()-1)*2)>0) 
				list.add(res.get(res.size()-1)*2);
			if(!list.contains(res.get(res.size()-1)*3) && (res.get(res.size()-1)*2)>0 && (res.get(res.size()-1)*3)>0) 
				list.add(res.get(res.size()-1)*3);
			if(!list.contains(res.get(res.size()-1)*5) && (res.get(res.size()-1)*2)>0 && (res.get(res.size()-1)*3)>0 && (res.get(res.size()-1)*5)>0) 
				list.add(res.get(res.size()-1)*5);
			Collections.sort(list);
			res.add(list.get(0));
			list.remove(0);
		}
		return res.get(res.size()-1);
	}
	/*
	 * �ж�һ�����Ƿ��ǳ�ª����ֻ��2,3����5�����������ӣ�1Ҳ�ǳ�ª��
	 * e.g. 1,2,3,4,5,6,8,9,10,12,����
	 * �ܱ�2,3,5��ȫ����
	 * 
	 */
    public boolean isUgly(int num) {
    	if(num==0) return false;
    	while(num%2==0){
    		num=num/2;
    	}
    	while(num%3==0){
    		num=num/3;
    	}
    	while(num%5==0){
    		num=num/5;
    	}
    	if(num==1) return true;
    	else return false;
    }
    /*
     * ���n����ª��
     */
    public int nthUglyNumber(int n) {
		int count = 0;
		int i=1;
		while(count!=n){
			if(isUgly(i)){
				count++;
			}
			i++;
		}
    	return i-1;
    }

}
