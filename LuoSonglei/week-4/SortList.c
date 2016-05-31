/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-24 20:00
Description : 
Source      : https://leetcode.com/problems/sort-list/
*******************************************/
#include<stdio.h>
struct ListNode
{
    int val;
    struct ListNode *next;
};

//AC - 24ms;
struct ListNode* merge(struct ListNode* l, struct ListNode* r)
{
    struct ListNode* head = (struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode* p = (struct ListNode*)malloc(sizeof(struct ListNode));
    head->next = p;
    while(l && r)
    {
        if(l->val <= r->val)
        {
            p->next = l;
            l = l->next;
        }
        else
        {
            p->next = r;
            r = r->next;
        }
        p = p->next;
    }
    p->next = l == NULL ? r : l;
    return head->next->next;
}

struct ListNode* sortList(struct ListNode* head)
{
    if(head == NULL || head->next == NULL)
        return head;
    struct ListNode *s1 = head, *s2 = head->next;
    while(s2 && s2->next)
    {
        s1 = s1->next;
        s2 = s2->next->next;
    }
    s2 = s1->next;
    s1->next = NULL;
    return merge(sortList(head), sortList(s2));
}

//AC - 20ms;
struct ListNode* merge1(struct ListNode* l, struct ListNode* r)
{
    struct ListNode head;
    struct ListNode* p = &head;
    while(l && r)
    {
        if(l->val <= r->val)
        {
            p->next = l;
            l = l->next;
        }
        else
        {
            p->next = r;
            r = r->next;
        }
        p = p->next;
    }
    p->next = (l == NULL ? r : l);
    return head.next;
}

struct ListNode* partition(struct ListNode* head, struct ListNode* tail)
{
    if(head == tail || head->next == tail)
        return head;
    int pivot = head->val;
    struct ListNode left, mid, right;
    struct ListNode *l=&left, *m=&mid, *r=&right;
    while(head != tail)
    {
        if(head->val < pivot)
        {
            l->next = head;
            l = l->next;
        }
        else if(head->val > pivot)
        {
            r->next = head;
            r = r->next;
        }
        else
        {
            m->next = head;
            m = m->next;
        }
        head = head->next;
    }
    r->next = tail;
    m->next = partition(right.next, tail); 
    l->next = mid.next;
    return partition(left.next, l->next);
}


//http://www.geeksforgeeks.org/quicksort-on-singly-linked-list/
//AC - 16ms;
struct ListNode* swiftSort(struct ListNode* head)
{
    return partition(head, NULL);
}
