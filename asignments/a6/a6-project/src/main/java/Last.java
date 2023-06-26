public class Last {


    class Node {
        int key;
        Node left, right;

        public Node(int item, Node left, Node right) {
            this.key = item;
            this.left = left;
            this.right = right;
        }

        public Node(int item) {
            this(item, null, null);
        }

    }


    class BinaryTree {
        Node root;

        BinaryTree(int key) {
            this.root = new Node(key);
        }
        BinaryTree() {
            this.root = null;
        }

        public void add(int item) {
            addHelper(root, new Node(item));
        }

        private void addHelper(Node p, Node node) {
            if(p == null) {
                p = node;
                return;
            }

            if(node.key < p.key) {
                addHelper(p.left, node);
            }
            else {
                addHelper(p.right, node);
            }
        }
    }


    class BinarySearchTree {
        BinaryTree binaryTree = new BinaryTree();

        Bin
    }

    public static Integer binarySearchLast(int[] a, int k) {

    }

}
