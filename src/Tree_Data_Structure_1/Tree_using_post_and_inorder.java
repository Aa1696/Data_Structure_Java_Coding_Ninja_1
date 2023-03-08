package Tree_Data_Structure_1;
/*
Construct Tree Using Inorder and PostOrder
Send Feedback
For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
Note:
Assume that the Binary Tree contains only unique elements.
Input Format:
The first line of input contains an integer N denoting the size of the list/array. It can also be said that N is the total number of nodes the binary tree would have.

The second line of input contains N integers, all separated by a single space. It represents the Postorder-traversal of the binary tree.

The third line of input contains N integers, all separated by a single space. It represents the inorder-traversal of the binary tree.
Output Format:
The given input tree will be printed in a level order fashion where each level will be printed on a new line.
Elements on every level will be printed in a linear fashion. A single space will separate them.
Constraints:
1 <= N <= 10^4
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
4 5 2 6 7 3 1
4 2 5 1 6 3 7
Sample Output 1:
1
2 3
4 5 6 7
Sample Input 2:
6
2 9 3 6 10 5
2 6 3 9 5 10
Sample Output 2:
5
6 10
2 3
9
 */
public class Tree_using_post_and_inorder {
    inaryTreeNode<int> *pre_po_binary_tree(int *postorder,int sipo,int enpo,int *inorder,int siin,int enin){
        if(sipo>enpo){
            return NULL;
        }
        BinaryTreeNode<int> *root = new BinaryTreeNode<int> (postorder[enpo]);
        int root_index = -1;
        for(int i=0;i<enin+1;i++){
            if (postorder[enpo] == inorder[i]) {
                root_index = i;
                break;
            }
        }
        // Managing left of Inorder and PostOrder
        int lie = root_index - 1;  // end index of left tree of inorder
        int lis = siin;            // starting index of left tree of inorder
        int lps = sipo;            // starting index of left tree of postorder
        int lpe = lie - lis + lps; // end index of left tree of post order

        // Managing right of Inorder and PostOrder
        int ris = root_index + 1; // starting inedx of right subtree of inorder
        int rie = enin;           // ending index of right subtree of inorder
        int rps = lpe + 1;  // starting index of right subtree of postorder
        int rpe = enpo - 1; // ending index of right subtree of postorder
        root->left = pre_po_binary_tree(postorder, lps, lpe, inorder, lis, lie);
        root->right =
                pre_po_binary_tree(postorder, rps, rpe, inorder, ris, rie);
        return root;

    }
    BinaryTreeNode<int>* buildTree(int *postorder, int postLength, int *inorder, int inLength) {
        // Write your code here
        return pre_po_binary_tree(postorder,0,postLength-1,inorder,0,inLength-1);
    }
}
