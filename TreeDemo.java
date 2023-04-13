class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   private Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   /**
   * Insert method
   */
    public void insert(int value) {
      root = insert(root, value);
   }
   
   /**
   * Performs pre-order traversal of the given binary tree rooted at the specified node,
   * printing the value of each visited node in the order of root, left subtree, right subtree.
   *
   * @param root the root of the binary tree to traverse
    */
   public void preOrderTraversal(Node root){
      if (root == null) {
         return;
     }
     
     System.out.print(root.value + " ");
     preOrderTraversal(root.left);
     preOrderTraversal(root.right);
   }

   
   
   /**
   * Performs in-order traversal of the given binary tree rooted at the specified node,
   * printing the value of each visited node in the order of left subtree, root, right subtree.
   *
   * @param root the root of the binary tree to traverse
   */
   public void inOrderTraversal(Node root){
      if (root == null) {
         return;
      }
     
      inOrderTraversal(root.left);
      System.out.print(root.value + " ");
      inOrderTraversal(root.right);
   }
   
   
   
   /**
   * Performs post-order traversal of the given binary tree rooted at the specified node,
   * printing the value of each visited node in the order of left subtree, right subtree, root.
   *
   * @param root the root of the binary tree to traverse
   */
   public void postOrderTraversal(Node root){
      if (root == null) {
         return;
      }
     
      postOrderTraversal(root.left);
      postOrderTraversal(root.right);
      System.out.print(root.value + " ");
   }
   
   
   
   /**
   * Searches the binary tree rooted at the specified node for a node with the given value.
   *
   * @param root the root of the binary tree to search
   * @param key the value to search for
   * @return true if a node with the given value is found, false otherwise
   */
   public boolean find(Node root, int key){
	   if (root == null) {
         return false;
      }
      
      if (root.value == key) {
         return true;
      } else if (key < root.value) {
         return find(root.left, key);
      } else {
         return find(root.right, key);
      }       
   }
   
   
   
  /**
    * Returns the smallest value in the binary tree rooted at the specified node.
   *
   * @param root the root of the binary tree to search
   * @return the smallest value in the tree
   * @throws IllegalArgumentException if the tree is empty
   */
   public int getMin(Node root){
      if (root == null) {
         throw new IllegalArgumentException("Tree is empty");
      }
      
      while (root.left != null) {
         root = root.left;
      }
      
      return root.value;
   }
  
  
  
   /**
   * Returns the largestt value in the binary tree rooted at the specified node.
   *
   * @param root the root of the binary tree to search
   * @return the largest value in the tree
   * @throws IllegalArgumentException if the tree is empty
   */
   public int getMax(Node root){
	   if (root == null) {
         throw new IllegalArgumentException("Tree is empty");
      }
      
      while (root.right != null) {
         root = root.right;
      }
      
      return root.value;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}
