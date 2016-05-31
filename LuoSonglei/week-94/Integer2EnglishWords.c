/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-29 20:54
Description : 
Source      : https://leetcode.com/problems/integer-to-english-words/
*******************************************/
#define LEN 100
const *units[] = {"Billion", "Million", "Thousand", "Hundred"};
const int unitsN[] = {1000000000, 1000000, 1000, 100};
const *tens[] = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
const int tensN[] = {20, 30, 40, 50, 60, 70, 80, 90};
const *specials[] = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
const specialsN[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
void helper(int* num, char* s)
{
    for(int i = 0; i < sizeof(unitsN)/sizeof(int); i++) //only this part can be handled for several times;
    {
        if(*num >= unitsN[i])
        {
            int t = *num/unitsN[i];
            helper(&t, s); //get number of this unit;
            strcat(s, " ");
            strcat(s, units[i]);
            *num %= unitsN[i];
            helper(num, s); //get all after this unit;
            return ;
        }
    }
    for(int i = sizeof(tensN)/sizeof(int)-1; i > -1; i--) //only be handled once for each number;
    {
        if(*num >= tensN[i])
        {
            int t = *num - tensN[i];
            if(*s) //in case that the number is just this, avoid preceding white space;
                strcat(s, " ");
            strcat(s, tens[i]);
            *num -= tensN[i]; 
            break;
        }
    }
    for(int i = sizeof(specialsN)/sizeof(int)-1; i > -1; i--) //only be handled once for each number;
    {
        if(*num == specialsN[i])
        {
            if(*s) //in case that the number is just this, avoid preceding white space;
                strcat(s, " ");
            strcat(s, specials[i]);
            break;
        }
    }
}

//AC - 4ms;
char* numberToWords(int num)
{
    if(!num) return "Zero"; //special case handled first, prevent messing the whole structure;
    char* s = (char*)malloc(sizeof(char)*LEN);
    *s = '\0'; //to use strcat normally;
    helper(&num, s); //using pointer to record the modified num for latter use;
    return s;
}
