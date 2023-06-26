package L18;



class Node<T> {
    T key;

    Node<T> left, right;

    public Node(Node<T> left, Node<T> right, T key) {
        this.left = left;
        this.right = right;
        this.key = key;
    }
}

public class Tree {

    static<T> int depth (Node<T> root) {
        if(root == null) return 0;

        if(root.left == null & root.right == null) return 1;
        int leftDepth = 1 + depth(root.left);
        int rightDepth = 1 + depth(root.right);

        return leftDepth > rightDepth ? leftDepth: rightDepth;
    }

    public static void main(String[] args) {


        Node<Character> tree1 = new Node<>(null, null, 'a');
        Node<Character> tree2 = new Node<>(null, new Node<>(null, null, 'b'), 'a');

        System.out.println(depth(tree2));

    }


}
