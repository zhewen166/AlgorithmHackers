/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-29 16:29
Description : 
Source      : https://leetcode.com/problems/bulb-switcher/
*******************************************/
#include <bool.h>
//TLE;
int bulbSwitch0(int n)
{
    bool *lights = (bool*)malloc(sizeof(bool)*n);
    memset(lights, 0, sizeof(bool)*n);
    for(int i = 0; i < n; i++)
    {
        int k = i;
        while(k < n)
        {
            lights[k] = !lights[k];
            k += i+1;
        }
    }
    int count = 0;
    for(int i = 0; i < n; i++)
        if(lights[i])
            count++;
    return count;
}

//AC - 0ms;
//https://leetcode.com/discuss/89449/the-simplest-and-most-efficient-solution-in-well-explained
int bulbSwitch(int n)
{
    return sqrt(n);
}
