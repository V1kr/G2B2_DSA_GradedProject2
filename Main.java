package convertToSkew;

public class Main{
  public static void main(String[] args) {

    Node root = new Node(50);
    root.left = new Node(30);
    root.right = new Node(60);
    root.left.left = new Node(10);
    root.left.right = new Node(55);
    
    Node skewedRoot = BST.convertToSkewedTree(root);

    System.out.println("Tree values in ascending order:");
    BST.displayAscendingOrder(skewedRoot);
  }
}
