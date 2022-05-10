public class MaxHeap{
    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    //부모 위치 반환
    private int parent(int pos){
        return pos / 2;
    }

    // 왼쪽 자식과 오른쪽 자식
    private int leftChild(int pos){
        return (2*pos);
    }

    private int rightChild(int pos){
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos){
        if(pos >= (size / 2) && pos <= size){
            return true;
        }
        return false;
    }  

    private void swap(int fpos, int spos){
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void maxHeapify(int pos){
        if(isLeaf(pos)){
            return;
        }

        if(Heap[pos] < Heap[leftChild(pos)] ||
        Heap[pos] < Heap[rightChild(pos)]) {
        if(Heap[leftChild(pos)] > Heap[rightChild(pos)]){
            swap(pos, leftChild(pos));
            maxHeapify(leftChild(pos));
        }
             else {
            swap(pos, rightChild(pos));
            maxHeapify(rightChild(pos));
            }
        }
    }  

    public void insert(int element){
        Heap[++size] = element;
        int current = size;
        
        while(Heap[current] > Heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }

    }

    public void print(){
        for(int i=1; i <=size; i++){
            System.out.print(Heap[i] + " ");
        }
    }

    public void inorder(int root){
        if(root<=size){
            inorder(root*2);
            System.out.print(Heap[root] + " ");
            inorder(root*2+1);
        }
    }
    public void postorder(int root){
        if(root<=size){
            postorder(root*2);
            postorder(root*2+1);
            System.out.print(Heap[root]+ " ");
        }
    }
    public void preorder(int root){
        if(root<=size){
            System.out.print(Heap[root] + " ");
            preorder(root*2);
            preorder(root*2+1);
        }
    }
    public int delete(){
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }
    
  public static void main(String[] args){
      MaxHeap maxHeap = new MaxHeap(15);
      maxHeap.insert(23);
      maxHeap.insert(39);
      maxHeap.insert(7);
      maxHeap.insert(20);
      maxHeap.insert(14);
      maxHeap.insert(15);
      maxHeap.insert(46);
      maxHeap.insert(66);
      maxHeap.insert(75);
      maxHeap.insert(49);
      maxHeap.insert(32);
 /*     System.out.print("inorder: ");
      maxHeap.inorder(1);
      System.out.println();
      System.out.print("preorder: ");
      maxHeap.preorder(1);
      System.out.println();
      System.out.print("postorder: ");
      maxHeap.postorder(1);
      System.out.println();
      System.out.println(); */
      for(int i =1; i <= 11; i++){
        System.out.println(maxHeap.delete());
          
      } 

  }
}