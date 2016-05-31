package com.xingkong;

/** 
* @author cuiguangfan 736068048@qq.com: 
* @version create time��2016��1��4�� ����8:35:38 
* class description
*/
public class LongestPalindromicSubstring {
	//�����ִ�ͳ�������ᵼ�³�ʱ�����Ӷ�Ϊo(n3)
	public String longestPalindrome1(String s) {
		int maxPalinLength = 0;
		String longestPalindrome = null;
		int length = s.length();

		// check all possible sub strings
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int len = j - i;
				String curr = s.substring(i, j + 1);
				if (isPalindrome(curr)) {
					if (len > maxPalinLength) {
						longestPalindrome = curr;
						maxPalinLength = len;
					}
				}
			}
		}

		return longestPalindrome;
    }
	private static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}

		return true;
	}
	public String longestPalindrome(String s){
		char[] chars=s.toCharArray();
		boolean[][] records=new boolean[chars.length][chars.length];
		for(int i=0;i<chars.length;i++){
			for(int j=0;j<chars.length;j++){
				if(i>=j) records[i][j]=true;//������=����Ϊ[i][i]Ҳ�ǻ���
				else records[i][j]=false;
			}
		}
		int maxLengthOfPalind=1;
		int begin = 0;
		int end=chars.length-1;
		for (int j = 1; j < chars.length; j++) {
			for (int i = 0; i < j; i++) {
				if(chars[i]==chars[j]){
					records[i][j]=records[i+1][j-1];
					if(records[i][j]==true){
						if(j-i+1>maxLengthOfPalind){
							maxLengthOfPalind=j-i+1;
							begin=i;
							end=j;
						}
					}
				}else{
					records[i][j]=false;
					}
				}
			}
		return s.substring(begin,end+1);//end+1����Ϊbegin��end�ǻ��ģ����Խ�ȡ��ĩβӦ��+1
	}
	public static void main(String[] args){
		LongestPalindromicSubstring lps=new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("aaabaaaa"));
	}
}
