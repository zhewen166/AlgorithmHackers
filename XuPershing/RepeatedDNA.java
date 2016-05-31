import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatedDNA {
	String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
	/**
	 * @param s
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015��12��14��
	 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
	 * for example: "ACGAATTCCG". When studying DNA, 
	 * it is sometimes useful to identify repeated sequences within the DNA.
	 * Write a function to find all the 10-letter-long sequences (substrings)
	 * that occur more than once in a DNA molecule.
	 * For example,Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
	 * Return:["AAAAACCCCC", "CCCCCAAAAA"].
	 */
	char[] dna={'A','C','G','T'};
	public List<String> findRepeatedDnaSequences(String s) {
		/*˼·�� �Ƚ��ַ����Ǻ��鷳�ģ�����4��DNA���ת����00,01,10,11�ĸ�������������ô10������Ĵ��Ϳ�����һ����������ʾ��
		 * ����0��ʾ10��A��
		 * ���������г���Ϊ10 �Ĵ�ת����lenth-9�����飬�ж������Ƿ����ظ������Ӵ��Ƿ����ظ�������ǱȽ����׵ģ�
		 * �ҵ��ظ����󣬻���Ҫת��������
		 * */
		List<String> result = new ArrayList<>();
		if (s.length() < 11) {
			return result;
		}
		int[] newChar = parser(s);
		Arrays.sort(newChar);
		for(int i = 9;i < s.length()-1;){
			int j=i+1;
			if (newChar[i] == newChar[j]) {
				result.add(reParser(newChar[i]));
			}
			while(j<s.length() && newChar[i] == newChar[j]){
				j++;
			}
			i = j;
		}
		return result;
        
    }
	private String reParser(int chars){
		char[] sub = new char[10];
		for(int i = 9;i>=0;i--){
			sub[i] = dna[chars&3];
			chars = chars>>2;
		}
		return String.valueOf(sub);
	}
	private int[] parser(String s){
		int[] newChar = new int[s.length()];
		int tmp = 0;
		for(int i = 0;i<s.length();i++){
			switch (s.charAt(i)) {
			case 'A':
				tmp = tmp<<2;
				break;
			case 'C':
				tmp = tmp<<2;
				tmp+=1;
				break;
			case 'G':
				tmp = tmp<<2;
				tmp+=2;
				break;
			case 'T':
				tmp = tmp<<2;
				tmp+=3;
				break;
			default:
				break;
		}
		newChar[i] = (tmp&1048575);//0xFFFFF
		}
		for(int i = 0;i<9;i++){
			newChar[i] = 0;
		}
		return newChar;
	}
	public static void main(String[] args ){
		RepeatedDNA rd = new RepeatedDNA();
		for (String string : rd.findRepeatedDnaSequences(rd.s)) {
			System.out.println(string);
		}
	}
}
