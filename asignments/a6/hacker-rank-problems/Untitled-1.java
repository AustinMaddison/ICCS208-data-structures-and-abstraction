
class Lecture19 <K extends Comparable<? super K>> {
    
    static class Node <T> {
        T val;
        Node left, right;
        
        public Node(T val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        
        public Node(T val){
           this(val, null, null);
        }
    }
    
    public static K lastkey(Node root) {
        
        Node current = root;
        
        while(current.left != null)
            current = root.left;
            
        return current.val;
    }
}