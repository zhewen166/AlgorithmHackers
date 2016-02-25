/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-02-25 20:26
Description : 

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.

Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]


Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

Source      : https://leetcode.com/problems/combination-sum-iii/
*******************************************/
void helper(int* nums, int size, int start, int k, int target, int* stack, int top, int*** arr, int** colSizes, int* returnSize)
{
    if(target < 0 || (top==k-1 && target>0)) return ;
    if(target == 0)
    {
        *returnSize += 1;
        *colSizes = (int*)realloc(*colSizes, sizeof(int)*(*returnSize));
        (*colSizes)[*returnSize-1] = k;
        printf("Before allocating for *arr...\n");
        *arr = (int**)realloc(*arr, sizeof(int*)*(*returnSize));
        printf("After allocating for *arr...\n");
        (*arr)[*returnSize-1] = (int*)malloc(sizeof(int)*k);
        for(int i = 0; i < k; i++)
            (*arr)[*returnSize-1][i] = stack[i];
    }
    for(int i = start+1; i < size; i++)
    {
        stack[top+1] = nums[i];
        helper(nums, size, i, k, target-nums[i], stack, top+1, arr, colSizes, returnSize);
    }
}
int** combinationSum3(int k, int target, int** colSizes, int* returnSize)
{
    int nums[] = {1,2,3,4,5,6,7,8,9};
    int size = sizeof(nums)/sizeof(int);
    int** arr = (int**)malloc(sizeof(int*));
    *returnSize = 0;
    int stack[2];
    int top = -1;
    for(int i = 0; i < sizeof(nums)/sizeof(int); i++)
    {
        stack[top+1] = nums[i];
        helper(nums, size, i, k, target-nums[i], stack, top+1, &arr, colSizes, returnSize);
    }
    return arr;
}
