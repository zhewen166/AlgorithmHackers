package com.xingkong;

import java.util.HashMap;
import java.util.Map;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time��2016��3��3�� ����2:24:34 
* class description
* û�н��
*/
public class N_166_Fraction_to_Recurring_Decimal {
	public static String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) return "0";
        if (denominator == 0) return "";
        
        String ans = "";
        
        //������Ϊ����
        if ((numerator < 0) ^ (denominator < 0)) {
            ans += "-";
        }
        
        //����Ҫ����������תΪ������Ϊ���������intתΪlong
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        
        //�������������
        long res = num / den;
        ans += String.valueOf(res);
        
        //����ܹ����������ؽ��
        long rem = (num % den) * 10;
        if (rem == 0) return ans;
        
        //�����С������
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        ans += ".";
        while (rem != 0) {
            //���ǰ���Ѿ����ֹ�����������ô���Ὺʼѭ��
            if (map.containsKey(rem)) {
                int beg = map.get(rem); //ѭ���忪ʼ��λ��
                String part1 = ans.substring(0, beg);
                String part2 = ans.substring(beg, ans.length());
                ans = part1 + "(" + part2 + ")";
                return ans;
            }
            
            //�������³�
            map.put(rem, ans.length());
            res = rem / den;
            ans += String.valueOf(res);
            rem = (rem % den) * 10;
        }
        
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_166_Fraction_to_Recurring_Decimal.fractionToDecimal(1, 99));
		//System.out.println(1*1.0/90);
	}

}
