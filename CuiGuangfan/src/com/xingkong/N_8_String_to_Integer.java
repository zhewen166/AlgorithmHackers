package com.xingkong;
/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time��2016��3��5�� ����7:38:57 
* class description
*/
public class N_8_String_to_Integer {
	public static int myAtoi(String str) {
		str=str.trim();
		boolean negative=false;
		int i=0;
		int limit=-Integer.MAX_VALUE;
		int radix=10;
		int result = 0;
        if(str.length()>0){
        	char firstChar=str.charAt(0);
        	if(firstChar<'0'){
        		if(firstChar=='-'){
        			negative=true;
        			limit=Integer.MIN_VALUE;
        		}else if(firstChar!='+'){
        			return 0;
        		}
        		if(str.length()==1){
        			return 0;
        		}
        		i++;
        	}
        	int multmin=limit/radix;
        	int digit=0;
        	while(i<str.length()){//�������������Ǹ���������һ���İ취��-������Ϊ�����������࣬�������������ָ��ô���
        		digit=Character.digit(str.charAt(i++), radix);
        		if(digit<0) 
        			return negative?result:-result;
        		if(result<multmin){//���result>=multmin����ô�������result*=radix����overflow
        			return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        		}
        		result*=radix;
        		if(result<limit+digit){//��ֹ��һ����result-=digitԽ��
        			//����д��result-digit<limit���������Ǵ�ģ���������-2147483649��ʱ��
        			//��Ϊ�������-2147483649����ô��������result=-214748364ʱ����-digit�������Խ�磬���������
        			return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        		}
        		result-=digit;
        	}
        }else{
        	return 0;
        }
        return negative?result:-result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(N_8_String_to_Integer.myAtoi("-2147483649"));
		//System.out.println(Integer.valueOf("-2147483649"));
	}

}
