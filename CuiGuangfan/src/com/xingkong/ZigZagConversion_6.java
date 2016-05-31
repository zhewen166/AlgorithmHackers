package com.xingkong;

import java.util.HashMap;
import java.util.Map;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time��2016��2��27�� ����8:45:29 
* class description
*/
public class ZigZagConversion_6 {
	public static String convert(String s, int numRows) {
        String[] array=new String[s.length()];
        Map<Integer,String> map=new HashMap<Integer,String>();
        for(int i=0;i<numRows;i++)
        	map.put(i, "");
        int margin=numRows>=3?numRows-2:0;
        int index=0;
		while(true){
			//һ����ȡnumRows��
			String temp=index+numRows<=s.length()?s.substring(index, index+numRows):s.substring(index);
			for(int i=0;i<temp.length();i++){
				map.put(i, map.get(i)+temp.substring(i, i+1));
			}
			//����б�ŵĲ��֣�һ����ȡnumRows-2��
			index+=numRows;
			if(index>=s.length()) break;
			temp=index+margin<=s.length()?s.substring(index, index+margin):s.substring(index);
			for(int i=0;i<temp.length();i++){
				map.put(margin-i, map.get(margin-i)+temp.substring(i, i+1));
			}
			if(index+margin>=s.length())
				break;
			index+=margin;
		}
		String finalString="";
		for(int i=0;i<numRows;i++)
			finalString+=map.get(i);
		System.out.println(finalString);
		return finalString;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversion_6.convert("ABCDE", 4);
	}

}
