#include <stdio.h>
#include <stdlib.h>
#include<math.h>
int main()
{
	int nums[4]={-4,2,0,1};
	int numSize=4;
        int threeSumClosest(int* nums, int numsSize, int target);
	int result=threeSumClosest(nums,numSize,2);
  	printf("result= %d",result);
}

/**3Sum Closest**/
int threeSumClosest(int* nums, int numsSize, int target) {
    void quicksort(int* s, int l, int r);//����
	int twoSumClosest(int* nums,int numsSize, int target);//������ 2sum
	int* temp=(int*)malloc(sizeof(int) * (numsSize-1)); //new int[numsSize-1];
	 quicksort(nums,0,numsSize-1);
	int start=0;
	int* interResult=(int*)malloc(sizeof(int) * (numsSize)); //new int[numsSize];
	for(int i=0;i<numsSize;i++){
		start=0;
		for(int j=0;j<numsSize;j++){
		     if(i==j) continue;
			 temp[start++]=nums[j];	 
		}
	    interResult[i]=nums[i]+twoSumClosest(temp,numsSize-1,target-nums[i]);
	} 
	int result=interResult[0];
	for(int k=1;k<numsSize;k++){
       if(abs(result-target)>abs(interResult[k]-target))
		   result=interResult[k];
	}
	return result;
}



int twoSumClosest(int* nums,int numsSize, int target){
    int head=0,tail=numsSize-1;
	int distance; //��ǰhead �� tail��ֵ��target�Ĳ�ֵ
	int tempSum;
	int curNearest=nums[head]+nums[tail];//pow(2.0,31.0)-1; //��ǰ��targetֵ��ӽ�����������
	while(head<tail){
		tempSum=nums[head]+nums[tail];
		distance=tempSum-target;
	if(distance<0){
		head++;
	}else if(distance>0){
	    tail--;
	}else
	   return target;
	   if(abs(distance)<abs(curNearest-target))
			curNearest=tempSum;
	}
	return curNearest;
}

//�����ҵĿ��������㷨
void quicksort (int* a, int lo, int hi)
{
//  lo is the lower index, hi is the upper index
//  of the region of array a that is to be sorted
    int i=lo, j=hi, h;

    // comparison element x
    int x=a[(lo+hi)/2];

    //  partition
    do
    {    
        while (a[i]<x) i++; 
        while (a[j]>x) j--;
        if (i<=j)
        {
            h=a[i]; a[i]=a[j]; a[j]=h;
            i++; j--;
        }
    } while (i<=j);

    //  recursion
    if (lo<j) quicksort(a, lo, j);
    if (i<hi) quicksort(a, i, hi);
}