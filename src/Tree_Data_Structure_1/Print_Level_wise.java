package Tree_Data_Structure_1;
/*
Print Levelwise
Send Feedback
For a given a Binary Tree of type integer, print the complete information of every node, when traversed in a level-order fashion.
To print the information of a node with data D, you need to follow the exact format :

           D:L:X,R:Y

Where D is the data of a node present in the binary tree.
X and Y are the values of the left(L) and right(R) child of the node.
Print -1 if the child doesn't exist.
Example:
alt text

For the above depicted Binary Tree, the level order travel will be printed as followed:

1:L:2,R:3
2:L:4,R:-1
3:L:5,R:6
4:L:-1,R:7
5:L:-1,R:-1
6:L:-1,R:-1
7:L:-1,R:-1

Note: There is no space in between while printing the information for each node.
Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
Information of all the nodes in the Binary Tree will be printed on a different line where each node will follow a format of D:L:X,R:Y, without any spaces in between.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
 Sample Output 1:
8:L:3,R:10
3:L:1,R:6
10:L:-1,R:14
1:L:-1,R:-1
6:L:4,R:7
14:L:13,R:-1
4:L:-1,R:-1
7:L:-1,R:-1
13:L:-1,R:-1
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
 Sample Output 2:
1:L:2,R:3
2:L:4,R:5
3:L:6,R:7
4:L:-1,R:-1
5:L:-1,R:-1
6:L:-1,R:-1
7:L:-1,R:-1
 */
import java.util.*;
public class Print_Level_wise {
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) return;

        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            var front = pendingChildren.remove();
            if (front == null) {
                if (!pendingChildren.isEmpty()) {
                    pendingChildren.add(null);
                }
            } else {
                System.out.print(front.data + " : Left -> ");
//                For Left Child
                if (front.left != null) {
                    pendingChildren.add(front.left);
                    System.out.print(front.left.data + ", Right -> ");
                } else {
                    System.out.print("null" + ", Right -> ");
                }
//                For Right Child
                if (front.right != null) {
                    pendingChildren.add(front.right);
                    System.out.print(front.right.data);
                } else {
                    System.out.print("null");
                }
            }
            System.out.println();
        }
    }
}
