#include <stdio.h>
#include <string.h>
//void main(){
//	int myAtoi(char* str);
//	char* str="9223372036854775809";
//	int result=myAtoi(str);
//	printf("reslut=%d",result);
//}
/**
  ���ַ���תΪint�� String to Integer (atoi)
*/
int myAtoi(char* str) {
	bool isSign(char c);
	bool isNum(char c);
    bool containSign=false;
	bool isFirst=true;
	int start=-1;
	long long result=0;
	long long maxInt=2147483647;
	if(strlen(str)==0) return 0;

    for(int i=0;i<strlen(str);i++){
		if(str[i]==' '&&start<0) continue; //�ַ��еĿո�
		
		if(isFirst){     //��һ���ǿո��ַ�
			isFirst=false;
			start=i;
	     if(isSign(str[i])){ //�Ƿ��ǡ�+������-����
		    containSign=true;  //�з���  
		    continue;
		   }
		}

	   if(isNum(str[i]))           //���δ���ÿһ���ַ�
		   result=result*10+(str[i]-48);  
	   else                       //����������ֹͣ
		break;

	   if(result>(maxInt+1)) break;  //����int��ʾ�ķ�Χ
	    
	}
	 if(containSign&&str[start]==45){  //�жϷ���
	    result=-result;
	 }

	  if(result>maxInt)            //�ȽϽ���Ƿ���int�ı�ʾ�ķ�Χ��
		  return maxInt;
	  else if(result<-(maxInt+1))
		  return -(maxInt+1);
	  else 
		  return result;

}

bool isNum(char c){
   if(c>47&&c<58)
	   return true;
   else
	   return false;
}

bool isSign(char c){
	if(c==43||c==45)
	   return true;
     else
	   return false;
  
}
