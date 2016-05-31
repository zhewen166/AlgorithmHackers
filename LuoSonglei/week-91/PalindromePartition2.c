/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-13 20:16
Description : 
Source      : https://leetcode.com/problems/palindrome-partitioning-ii/
*******************************************/
#include <stdbool.h>
//AC - 12ms;
int minCut(char *s)
{
    int len = strlen(s);
    if(len == 0) return 0;
    bool **isPal = (int**)malloc(sizeof(bool*)*len); //Used to record the whether the substring from i to j inclusive is a palindrome or not;
    for(int i=0; i<len; i++)
    {
        isPal[i] = (bool*)malloc(sizeof(bool)*len);
        memset(isPal[i], 0, sizeof(bool)*len);
    }
    int *minCuts = (int*)malloc(sizeof(int)*len); //record the minimal cuts in the substring from index till end;
    for(int i=len-1; i > -1; i--)
    {
        minCuts[i]=len-i-1; //the default minimal cuts;
        for(int j=i; j<len; j++) //to find the minimal cuts from the current index till end;
        {
            if(s[i]==s[j] && (j-i<2 || isPal[i+1][j-1])) //once it's a palindrome from i to j inclusive;
            {
                isPal[i][j] = true;
                if(j==len-1)
                    minCuts[i] = 0;
                else if(minCuts[j+1]+1<minCuts[i])
                    minCuts[i] = minCuts[j+1]+1;
            }
        }
    }
    return minCuts[0];
}
