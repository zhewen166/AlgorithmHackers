/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-15 21:11
Description : 
Source      : https://leetcode.com/problems/regular-expression-matching/
*******************************************/
#include<stdbool.h>

//this is version is too slow repeating the calculation process too many times - try to use DP to replace it;
bool match(char* s, char* p)
{
    return (*p == *s || (*p == '.' && *s != '\0'));
}
bool isMatch(char* s, char* p)
{
    if(*p == '\0')
        return *s == '\0';
    if(*p != '*')
    {
        if(!match(s,p))
            return false;
        else
            return isMatch(s+1, p+1);
    }
    else
    {
        while(*s!= '\0')
            if(isMatch(s++, p+1))
                return true;
        return false;
    }
}


