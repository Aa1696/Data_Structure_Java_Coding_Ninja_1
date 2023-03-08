package Tree_Data_Structure_1;

public class BinaryTreeNode<T> {
    BinaryTreeNode<T>left;
    BinaryTreeNode<T>right;
    T data;
    BinaryTreeNode(T data){
        this.left=null;
        this.right=null;
        this.data=data;
    }

}
