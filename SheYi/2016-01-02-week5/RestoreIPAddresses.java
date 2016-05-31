/*package algorithm;

import java.util.ArrayList;
import java.util.List;
//���ǿ��ǲ�0�����   �� ��45��--> 4.5.0.0 
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
    	List<String> str=new ArrayList<String>();
    	 int k=0;
    	 int a[]=new int[4];
    	 backtrace(a,k,s,str);
    	for(int i=0;i<str.size();i++)
    	System.out.println(str.get(i));
    	return str;
        
    }
    
    
    public boolean  isValid(String s){
          return "".equals(s)||(s.length()<4)&&(Integer.parseInt(s)<256);
    }
    
    public  void backtrace(int a[],int k,String s,List<String> str){
    	int[] c=new int[4];//��Ӧ���ܵ�4�к�ѡ���
    	int ncandidates;//��Ӧÿ��ĺ�ѡ��
        int i; //counter
        if(is_a_solution(a,k,s))
        	process_solution(a,k,s,str);
        else if(k<3){
        	k=k+1;         
        	ncandidates=construct_candidates(a,k,s,c);
        	for(i=ncandidates;i>-1;i--){
        	    a[k]=c[i];
        	 //   make_move(a,k,s);
        	    backtrace(a,k,s,str);
        	 // unmake_move(a,k,s);
        	 //    if(finished) return;
        	} k=k-1;
        }
    }
      public boolean is_a_solution(int a[],int k,String s){
    	  if(k==3&&isValid(s.substring(a[1]+a[2]+a[3], s.length())))
    		  return true;
    	  else
    		  return false;
      }
      
      public void process_solution(int a[],int k,String s,List<String> str){
    	    String result="";
    	  if("".equals(s.substring(0, a[1])))  //1
    		  result+="0.";
    	  else
    		  result+= Integer.parseInt(s.substring(0, a[1]))+".";
    	  
      	  if("".equals(s.substring(a[1], a[1]+a[2])))   //2
    		  result+="0.";
    	  else
    		  result+= Integer.parseInt(s.substring(a[1], a[1]+a[2]))+".";
      	  
      	  if("".equals(s.substring(a[1]+a[2], a[1]+a[2]+a[3])))    //3
    		  result+="0.";
    	  else
    		  result+= Integer.parseInt(s.substring(a[1]+a[2], a[1]+a[2]+a[3]))+".";
      	  
      	  if("".equals(s.substring(a[1]+a[2]+a[3], s.length())))   //4
    		  result+="0";
    	  else
    		  result+= Integer.parseInt(s.substring(a[1]+a[2]+a[3], s.length()));
      	  if(!str.contains(result))
    	  str.add(result);
      }
      
      public int construct_candidates(int a[],int k,String s,int c[]){
    	   int count=0;
    	   int sum=0;
    	   for(int m=1;m<k;m++){
    		    sum+=a[m];
    	   }
    	   switch(s.length()-sum){
    	   default:
    	   case 3: if(isValid(s.substring(sum, sum+3))){
	               c[3]=3;count++;
                    }
    	   case 2: c[2]=2;count++;
    	   case 1: c[1]=1;count++;
    	   case 0: c[0]=0;
    	   }
    	   
    	  return count;
      }
      
      
      public static void main(String [] args){
    	  int k=0;
    	  int a[]=new int[4];
    	  String s="0000";
    	  RestoreIPAddresses p=new RestoreIPAddresses();
    	  p.restoreIpAddresses(s);
      }
}
*/


package algorithm;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	/**
	 * ���ַ���������IP��ַ
	 * ˼·�����ַ���������IP��ַ��Ҫȷ�������ָ�������λ�ã����н�ռ�a=(a1,a2,a3);�����û��ݵķ����������������н⣻
	 * a1,a2,a3��ѡ��ֵΪ1��2��3����Щ��ѡ��ֵ����Ϲ�����һ�Ž�ռ�������DFS�������н�
	 *  ʱ�� 4ms
	 *  ���Ӷ�
	 * @param s
	 * @return
	 */
    public List<String> restoreIpAddresses(String s) {
    	List<String> str=new ArrayList<String>();
    	int k=0;
    	int a[]=new int[4];
    	backtrace(a,k,s,str);
    	for(int i=0;i<str.size();i++)
    	System.out.println(str.get(i));
    	return str;
        
    }
    
    /**
     * �������
     * @param a  ��ռ����� ���ݴ�СΪ3 a[i]��ʾ��i����������ַ�
     * @param k   k���������
     * @param s   ������ַ���
     * @param str  ����list
     */
    public  void backtrace(int a[],int k,String s,List<String> str){
    	int[] c=new int[4];//��Ӧ���ܵ�4�к�ѡ���
    	int ncandidates;//��Ӧÿ��ĺ�ѡ��
        int i; //counter
        if(is_a_solution(a,k,s))   //�Ƿ��ǺϷ��Ľ�
        	process_solution(a,s,str);  //���浱ǰ��
        else if(k<3){              //���ǺϷ��Ľ⣬�������С��3���������
        	k=k+1;             
        	ncandidates=construct_candidates(a,k,s,c); //������k���ѡ��
        	for(i=ncandidates;i>0;i--){      //���α���������ѡ
        	    a[k]=c[i];                   //��ռ丳ֵ
        	    backtrace(a,k,s,str);        //������һ��
        	} k=k-1;                  //������֮�󣬻��ݵ���һ��
        }                                      
    }
    /**
     * �жϵ�ǰ�Ƿ��ѵõ�һ���Ϸ��Ľ�
     * @param a  ��ռ�����
     * @param k  ��ǰ�������
     * @param s  �������ַ���
     * @return
     */
      public boolean is_a_solution(int a[],int k,String s){   
    	  //���������������һ�㣬��ʣ����ַ���Ҳ��һ��0-255֮��Ϸ�ֵ
    	  if(k==3&&isValid(s.substring(a[1]+a[2]+a[3], s.length())))
    		  return true;
    	  else
    		  return false;
      }
      /**
       * �ж��Ƿ���0-255֮�����
       * @param s
       * @return
       */
      public boolean  isValid(String s){
      	if("".equals(s)) return false;   //���ܲ������κ�����
      	if(s.length()>1&&s.startsWith("0"))  //������ֲ����ԡ�0����ͷ
      		return false;                     
      	else if((s.length()<4)&&(Integer.parseInt(s)<256))  //������3���ַ����ڣ���ҪС�ڵ���255  
      	   return true;
      	else 
      		return false;
      }
      /**
       * ���õ��ĵ�ǰ�Ᵽ�浽str��
       * @param a
       * @param k
       * @param s
       * @param str
       */
      public void process_solution(int a[],String s,List<String> str){
    	     String result="";
    		  result+= s.substring(0, a[1])+"."
    	       +s.substring(a[1], a[1]+a[2])+"."
               + s.substring(a[1]+a[2], a[1]+a[2]+a[3])+"."
      	       + s.substring(a[1]+a[2]+a[3], s.length());
    	     
    		  str.add(result);
      }
      
      /*
       * ������ѡ��
       */
      public int construct_candidates(int a[],int k,String s,int c[]){
    	   int count=0;
    	   int sum=0;  
    	   for(int m=1;m<k;m++){
    		    sum+=a[m];    //���㵱ǰ�����ʼ����
    	   }
    	   switch(s.length()-sum){   //���ݺ��滹ʣ����ַ������������ѡ��
    	   default:
    	   case 3: if(isValid(s.substring(sum, sum+3))){
	               c[3]=3;count++;
                    }
    	   case 2: if(isValid(s.substring(sum, sum+2))){
    		        c[2]=2;count++;
    	           }
    	   case 1: c[1]=1;count++;
    	   case 0: break;
    	   }
    	   
    	  return count;
      }
      
      
      public static void main(String [] args){
    	  int k=0;
    	  int a[]=new int[4];
    	  String s="0000";
    	  RestoreIPAddresses p=new RestoreIPAddresses();
    	  p.restoreIpAddresses(s);
      }
}
