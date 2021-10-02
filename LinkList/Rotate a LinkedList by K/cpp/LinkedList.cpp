// Problem:-
//Given a linked list node and a non-negative integer k, rotate the list to the right by k places.

//Logic:- 

/*

1) Take 2 Pointers, I have taken curr & end.
2) First we move the end pointer k times in the list. Now we run a loop till the end pointer reaches the end of list & 
    simultaneously move the curr pointer as well.
3) Now, the end pointer points to the last element of the list (when k != size of the list) and to NULL (when k = size of the list). 
    Our curr pointer points to the new tail of the list, i.e. the new last element.
4) If the end pointer does not point to NULL we connect it to the head of the linked list.
    Point the node pointer (head) to the next of curr (As that will be the new head) and 
    finally make the next of curr pointer point to NULL.


*/


/**
 * class LLNode {
 *     public:
 *         int val;
 *         LLNode *next;
 * };
 */
LLNode* solve(LLNode* node, int k) {
    LLNode *curr = node, *end = node;
    while (k--) {
        end = end->next;
    }
    while (end != NULL and end->next != NULL) {
        curr = curr->next;
        end = end->next;
    }
    if (end != NULL) {
        end->next = node;
        node = curr->next;
        curr->next = NULL;
    }
    return node;
}