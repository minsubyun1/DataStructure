class TreeNode{
  public TreeNode root;
  public Integer size = 10;
  

  Object data;
  TreeNode llink;
  TreeNode rlink;
  public TreeNode(){
    this.llink=null;
    this.rlink=null;
    this.root = null;
    this.size=10;
  }
  public TreeNode(Object data){
      this.data=data;
      this.llink=null;
      this.rlink=null;
      this.root = this;
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
  public void inorder(TreeNode root){
    if(root==null){
        return;
    }
    inorder(root.llink);
    System.out.print(root.data + " ");
    inorder(root.rlink);
}
void postorder(TreeNode root ){
    if(root!=null){
    postorder(root.llink);
    postorder(root.rlink);
    System.out.print(root.data + " ");
    }
  }
  void preorder(TreeNode root){
    if(root!=null){
    System.out.print(root.data + " ");
    preorder(root.llink);
    preorder(root.rlink);
    }
  }
public boolean Add(Object data){
    TreeNode newNode = new TreeNode(data);
    TreeNode cursor = this.root;
    if(root==null){
        this.root = newNode;
        size++;
        
        
    }else{
        while(true){
            if((int) cursor.data > (int) data){
              if(cursor.llink == null){
                cursor.llink = newNode;
                return true;
              } else{
                cursor = cursor.llink;
              }
            } else{
                if(cursor.rlink == null){
                  cursor.rlink = newNode;
                  return true;
              } else{
                  cursor = cursor.rlink;
              }
            }

            
        }
    }
    return false;
}
public static int Height(TreeNode root){
  int height = 0;
  
   if(root!=null) {
       height = 1+ Math.max(Height(root.llink),Height(root.rlink));
   }
   return height;
}
public void higher(int test){
    int [] first = new int[10];
    TreeNode ori = this.root;
    if((int) ori.data == test){
      first[0] = test;
      for(int i=1; i <= first.length(); i++){
        if((int) ori.data > test){
          
        }
      }
      
    }
}
  
  public class ExamTree{
    
  public static void main(String args[]){
    TreeNode m = new TreeNode(23);
    m.Add(39);
    m.Add(7);
    m.Add(20);
    m.Add(14);
    m.Add(15);
    m.Add(46);
    m.Add(66);
    m.Add(75);
    m.Add(49);
    m.Add(32);

    System.out.print("Preorder : ");
    m.preorder(m);
    System.out.println();
    System.out.print("Inorder : ");
    m.inorder(m);
    System.out.println();
    System.out.print("Postorder : ");
    m.postorder(m);
    System.out.println();
    System.out.print("Tree의 Height:");
    System.out.print(m.Height(m));
  
    
    // 순회 방법에 따라 출력
  }
  }
}

