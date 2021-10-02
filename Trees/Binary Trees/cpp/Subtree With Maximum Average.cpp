/*
Implementation:- 


1) A new function maxAvg is used to help with the implementation.

Newly defined parameters:
2) c - Count of total no. of nodes in a Tree/Sub-tree with root as their root node
3) sum - Sum of nodes in that Tree/Sub-tree
4) big - maximumAverage in that Tree/Sub-tree

Inside the function:
5) lCount - Count of total no. of nodes in left sub-tree
6) rCount - Count of total no. of nodes in right sub-tree
7) lSum - Sum of nodes in left sub-tree
8) rSum - Sum of nodes in right sub-tree
9) avg - Average of values of nodes in the Tree/Sub-tree

*/



/**
 * class Tree {
 *     public:
 *         int val;
 *         Tree *left;
 *         Tree *right;
 * };
 */
void maxAvg(Tree* root, int& c, int& sum, double& big) {
    if (!root) return;
    sum += root->val;
    c += 1;
    int lCount = 0, rCount = 0, lsum = 0, rsum = 0;
    maxAvg(root->left, lCount, lsum, big);
    maxAvg(root->right, rCount, rsum, big);
    c += lCount + rCount;
    sum += lsum + rsum;
    double avg = (double)sum / (1.0 * c);
    if (avg > big) big = avg;
}
double solve(Tree* root) {
    if (!root) return 0.0;
    double res = 0;
    int c = 0;
    int sum = 0;
    maxAvg(root, c, sum, res);
    return res;
}