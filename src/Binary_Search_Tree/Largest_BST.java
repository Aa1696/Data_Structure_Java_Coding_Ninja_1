package Binary_Search_Tree;
/*
Largest BST
Send Feedback
Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. You have to return the height of largest BST.
Note :
The binary tree will be consisting of only unique elements.
Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format:
The first and only line of output contains the height of the largest BST.
Constraints:
Time Limit: 1 second
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
2
 */
public class Largest_BST {
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {

        Pair ans = largestBSThelper(root);
        return ans.height;
    }
    public static Pair largestBSThelper(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair output = new Pair();
            output.max = Integer.MIN_VALUE;
            output.min = Integer.MAX_VALUE;
            output.isBST = true;
            output.height = 0;
            return output;
        }

        Pair left  = largestBSThelper(root.left);
        Pair right = largestBSThelper(root.right);

        Pair output = new Pair();

        int min = Math.min(root.data,Math.min(left.min,right.min));
        int max = Math.max(root.data,Math.max(left.max,right.max));

        output.min = min;
        output.max = max;

        output.isBST = left.max < root.data && right.min > root.data
                && left.isBST && right.isBST;

        if(output.isBST){
            output.height = Math.max(left.height,right.height) + 1;
        }else{
            output.height = Math.max(left.height,right.height);
        }

        return output;
    }
}

