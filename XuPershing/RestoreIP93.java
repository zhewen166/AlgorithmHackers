import java.util.ArrayList;
import java.util.List;

import javax.tools.ToolProvider;

public class RestoreIP93{
	/**
	 * @param s
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015��12��28��
	 * Given a string containing only digits, 
	 * restore it by returning all possible valid IP address combinations.
	 * For example:Given "25525511135",
	 * return ["255.255.11.135", "255.255.111.35"]. 
	 * (Order does not matter)
	 */
	public List<String> restoreIpAddresses(String s) {
		/*˼·������������i[]��¼ǰ�������ĳ���,
		 * ��ôi��ķ�Χ��1��2��3�����Ծ���3*3*3=27�ַַ���
		 * ������ֻҪ�ж��������ɵ�ip�Ƿ�Ϸ����ɣ�
		 * �����Լ�����֦����ĳһ����������255ʱ�����������iʧ�ܣ����Լ��ٱ�������
		 * �����ж��������е�ǰ��λ������1���ҵ�һ������0,���ǲ��Ϸ��� 
		 * ��ǰ���ܳ���Խ�磬
		 * ���һ������λ������3������С��1��
		 */
		 List<String> result = new ArrayList<>();
	        if(null == s ||s.length() <4){
	            return result;
	        }
	    int size = s.length();
        int current = 0;
        int[] i = {1,1,1};
        for(; i[0]<4;i[0]++){
        	if (Integer.valueOf(s.substring(0,i[0])) > 255) {
				break;
			}
        	if(i[0]>1 && s.charAt(0)=='0'){
    			break;
    		}
        	for(i[1]=1; i[1]<4;i[1]++){
        		current=i[0]+i[1];
        		if (current > size-2) {
					break;
				}
        		if (Integer.valueOf(s.substring(i[0],current)) > 255) {
					break;
				}
        		if(i[1]>1 && s.charAt(i[0])=='0'){
        			break;
        		}
        		for(i[2]=1; i[2]<4;i[2]++){
        			current = i[0]+i[1]+i[2];
        			if (current < size-3) {
						continue;
					}
        			if (current >size-1) {
						break;
					}else if(current < size-1 &&s.charAt(current)=='0'){
						continue;
					}
        			if (Integer.valueOf(s.substring(i[0]+i[1],current)) > 255) {
    					break;
    				}
        			if(i[2]>1 && s.charAt(i[0]+i[1])=='0'){
            			break;
            		}
        	       	if (current < size) {
						int last = Integer.valueOf(s.substring(current));
						if(last < 256 ) {
							StringBuffer sb = new StringBuffer();
							sb.append(s.substring(0, i[0]));
							sb.append("."+s.substring(i[0], i[0]+i[1]));
							sb.append("."+s.substring(i[0]+i[1], i[0]+i[1]+i[2]));
							sb.append("."+s.substring(i[0]+i[1]+i[2]));
							result.add(sb.toString());
						}
					}
                }
            }
        }
        return result;
    }
	public List<String> restoreIpAddressesBK(String s) {
		/*˼·������������i[]��¼�������λ�ã�����ĳ��index��ǰ�棩,
		 * ��ôi[0]��ķ�Χ��1��2��3,i[1]����i[0]+1,2,3,i[2]����i[1]+1,2,3��
		 * ���Ծ���3*3*3=27�ַַ�����ʵ�͵�һ����������
		 * ������ֻҪ�ж��������ɵ�ip�Ƿ�Ϸ����ɣ�
		 * �����Լ�����֦����ĳһ����������255ʱ�����������iʧ�ܣ����Լ��ٱ�������
		 * �����ж��������е�ǰ��λ������1���ҵ�һ������0,���ǲ��Ϸ��� 
		 * ��ǰ���ܳ���Խ�磬
		 * ���һ������λ������3������С��1��
		 */
		List<String> result = new ArrayList<>();
	    if(null == s ||s.length() <4||s.length() > 12){
	        return result;
	    }
	    int size = s.length();
        int[] i = {0,0,0};
        for(i[0]=1; i[0]<4;i[0]++){
        	if(i[0] > size-3||(i[0]>1 && s.charAt(0)=='0')||Integer.valueOf(s.substring(0,i[0])) > 255) {
				break;
			}
        	if (i[0] < size-9) {
				continue;
			}
        	for(i[1]=i[0]+1; i[1]<i[0]+4;i[1]++){
        		if (i[1] > size-2 ||(i[1]-i[0]>1 && s.charAt(i[0])=='0')||Integer.valueOf(s.substring(i[0],i[1])) > 255) {
					break;
				}
        		if (i[1] < size-6) {
        			continue;
        		}
        		for(i[2]=i[1]+1; i[2]<i[1]+4;i[2]++){
        			if (i[2] >size-1||(i[2]-i[1]>1 && s.charAt(i[1])=='0')||Integer.valueOf(s.substring(i[1],i[2])) > 255) {
						break;
					}
        			if (i[2] < size-3||(i[2] < size-1 &&s.charAt(i[2])=='0')) {
						continue;
					}
					int last = Integer.valueOf(s.substring(i[2]));
					if(last < 256 ) {
						StringBuffer sb = new StringBuffer();
						sb.append(s.substring(0, i[0]));
						sb.append("."+s.substring(i[0], i[1]));
						sb.append("."+s.substring(i[1], i[2]));
						sb.append("."+s.substring(i[2]));
						result.add(sb.toString());
					}
                }
            }
        }
        return result;
    }
	/*private int getValid(int start,String s,int n){
		int result = 0;
		if (n == 0) {
			int last = Integer.valueOf(s.substring(start));
			if(last < 256 ){
				System.out.println("."+last);
				return last;
			}else {
				return -1;
			}
		}else {
			if(start <s.length()-1 &&(result =getValid(start+1, s, n-1)) !=-1){
				System.out.println("."+s.substring(start, start+1));
			}
			if(start <s.length()-2 &&(result =getValid(start+2, s, n-1)) !=-1){
				System.out.println("."+s.substring(start, start+2));
			}
			if(start <s.length()-3 ){
				int tmp = Integer.valueOf(s.substring(start,start+3));
				if (tmp < 256) {
					if ((result=getValid(start+3, s, n-1)) != -1){
						System.out.println("."+s.substring(start, start+3));
					}
				}
			}
		}
		return -1;
	}*/
	public static void main(String[] args) {
		new RestoreIP93().restoreIpAddressesBK("010010");
	}

}
