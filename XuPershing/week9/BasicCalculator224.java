package week9;


public class BasicCalculator224 {
	public static int position = 0;
	public static int calculate(String s){
		/*˼·����Ӧ�жϣ�����ǡ�(��,��ʾһ���µ�����ʽ���͵ݹ顣�����)����ʾ��ǰ����ʽ����
		 * �ؼ��㣺��λ��ʱ����ȡ��
		 * ʱ�临�Ӷ���O(n)
		 */
		int sum = 0,tmp;
		boolean plus = true;
		while (position < s.length()) {
			switch (s.charAt(position)) {
			case ' ':
				position++;
				break;
			case '+':
				position++;
				plus = true;
				break;
			case '-':
				plus = false;
				position++;
				break;
			case '(':
				position++;
				sum+=plus?calculate(s):-calculate(s);
				break;
			case ')':
				position++;
				return sum;
			default:
				tmp = s.charAt(position)-48;
				while(position+1 < s.length() && s.charAt(position+1) >47 &&s.charAt(position+1) <58){
					position++;
					tmp = tmp*10+s.charAt(position)-48;
				}
				sum+=plus?tmp:-tmp;
				position++;
				break;
			}
		}
		return sum;
	}
	public static int simpleCalculate(char s[],int start,int end){
		int sum = 0,tmp;
		boolean plus = true;
		while(start< end){
			if (s[start] == '+') {
				plus = true;
			}else if (s[start] == '-') {
				plus = false;
			}else {
				tmp = s[start]-48;
				while(start+1 < end && s[start+1] != '+'&&s[start+1] != '-'){
					start++;
					tmp = tmp*10+s[start]-48;
				}
				sum+=plus?tmp:-tmp;
			}
			start++;
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculate("(8-((12-4)-3+(32 - 2)) )"));
	}

}
