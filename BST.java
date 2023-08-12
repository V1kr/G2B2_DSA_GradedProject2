package convertToSkew;

public class BST {
  
  public static Node convertToSkewedTree(Node root) {
    if (root == null)
      return null;

    while (root.left != null) {
      Node leftNode = root.left;
      root.left = leftNode.right;
      leftNode.right = root;
      root = leftNode;
    }

    root.right = convertToSkewedTree(root.right);

    return root;
  }

  public static void displayAscendingOrder(Node root) {
    if (root == null)
      return;

    System.out.print(root.val + " ");
    displayAscendingOrder(root.right);
  }
}
