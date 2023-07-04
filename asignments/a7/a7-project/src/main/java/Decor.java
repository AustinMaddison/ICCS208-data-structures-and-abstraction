public class Decor {

    private enum Order{
        PREORDER, INORDER
    }

    public static String display(BinaryTreeNode T, Order order){

    }

    private static String displayInorder(BinaryTreeNode T){
        if(T == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(displayPreorder(T.left)).append(T.key).append(" ");
        sb.append(displayPreorder(T.right));
        return sb.toString();
    }

    private static String displayPreorder(BinaryTreeNode T){
        if(T == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(displayPreorder(T.left)).append(T.key).append(" ");
        sb.append(displayPreorder(T.right));
        return sb.toString();
    }




}
