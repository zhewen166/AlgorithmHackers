package com.josh.task7;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
/*
 * ���⣺
 * ����һ�����飬һ�����޺�����
 * ��������������ڸ�������֮������ĸ���
 * ע�������е�����������������޷�Χ��Ҳ��
 */
public class CountOfRangeSum {
    @Test
	public void test(){  
        int[] a = {-2,5,1};  
        int i = countRangeSum(a,-2,2); 
        System.out.println(i);
    } 
    /*
     * ������������������������������ÿ������Ӻͣ����Ƿ���������
     */
    public int countRangeSum(int[] nums, int lower, int upper) { 
        if(null == nums || nums.length == 0)  
            return 0;  
        int[] b = new int[nums.length];  
        List<Integer> list = new ArrayList<>();
        getCombination(nums, 0, b, 0,lower,upper,list);  
        return list.size();
    }  
    //��ȡ����a�����������������b�д����a��һ��������
    private void getCombination(int[] a, int begin, int b[], int index,int lower,int upper,List<Integer> list) {          
        if(index >= a.length)  
            return;  
        for(int i = begin; i < a.length; i++){                
            b[index] = a[i];  
            //printArray(b,index);  
            sum(b, index,lower,upper,list);
            getCombination(a, i+1, b, index+1,lower,upper,list);  
        }  
    }
    //��b������Ԫ�صĺ�
    private void sum(int[] b, int index ,int lower,int upper,List<Integer> list) {  
        int sum = 0;
        for(int i = 0; i < index+1; i++){ 
        	sum = sum + b[i];
            //System.out.print(b[i] + " ");  
        }
        //List<Integer> list = new ArrayList<>();
        if(sum>=lower && sum<=upper) list.add(sum);
        //System.out.println(sum);  
    }
//    private void printArray(int[] b, int index) {  
//              
//        for(int i = 0; i < index+1; i++){  
//            System.out.print(b[i] + " ");  
//        }  
//        System.out.println();  
//    }  
          
}
