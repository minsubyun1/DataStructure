class TreeNode{
  Object data;
  TreeNode llink;
  TreeNode rlink;

  void inorder(TreeNode p){
    if(p!=null){
      inorder(p.llink);
      System.out.print(p.data + " "); //VISIT
      inorder(p.rlink);
    }
  }
  void postorder(TreeNode p ){
    if(p!=null){
    postorder(p.llink);
    postorder(p.rlink);
    System.out.print(p.data + " ");
    }
  }
  void preorder(TreeNode p){
    if(p!=null){
    System.out.print(p.data + " ");
    preorder(p.llink);
    preorder(p.rlink);
    }
  }
  static TreeNode build(TreeNode L, Object data, TreeNode R){
    TreeNode temp = new TreeNode();
    temp.data = data;
    temp.llink= L;
    temp.rlink= R;
    return temp;
  }
  static TreeNode createBST(){
    // (1) Treminal Node 먼저 만들기
    // (2) Parent Node ~ Ancestor Node 구성하기
    // (3) Root Node 만들기
    TreeNode n24 = TreeNode.build(null, 24, null);
    TreeNode n12 = TreeNode.build(null, 12, n24);
    TreeNode n37 = TreeNode.build(null, 37, null);
    TreeNode n67 = TreeNode.build(null, 67, null);
    TreeNode n48 = TreeNode.build(null, 48, n67);
    TreeNode n45 = TreeNode.build(n37, 45, n48);

    TreeNode root = build(n12, 35, n45);


    return root;
  }
  public class TreeNodeTraversal{
    public static void main(String args[]){
      TreeNode n = TreeNode.createBST();
      System.out.print("preorder:");
      n.preorder(n);
      System.out.println();
      System.out.print("Inorder:");
      n.inorder(n);
      System.out.println();
      System.out.print("postorder:");
      n.postorder(n);
      // 순회 방법에 따라 출력
    }
  }
}
