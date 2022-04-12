class ArrayLinearList{
  private int N; // Index of last element in list;
  private int size; // Array size
  private int increment; // Array size Increment
  private int[] itemList; // Memory Mapping

  public ArrayLinearList(){ //Constructor
    N = -1;
    size = 50;
    increment = 10;
    itemList = new int[size];
  }
  public boolean isEmpty(){
    return N == -1; // or N <0
  }
  public void insert(int x) {
    int pos = 0;
    // 배열이 꽉 찬 경우
    if(N == size - 1){
      size += increment;
    }
    if(N == -1){
      N++;
      itemList[N] = x;
    }
    else {
      for(int i=0; i<=N; i++){
        if(x > itemList[i]) pos++;
      }
      for(int i=N+1; i>pos; i--){
        itemList[i] = itemList[i-1];
      }
      itemList[pos] = x; //찾은 위치에 원소 추가
      N++;
    }
  }
public void delete(int x){
  if(isEmpty()){
    System.out.println("List is Empty");
  }
  else {
    int loc = -1;
    for(int i=0; i<=N; i++) // 삭제할 위치(loc) 찾기
      if(x == itemList[i])
        loc=i;
      if(loc == -1){
                  System.out.println("삭제할 원소 " + x + "가 없습니다.");
      }
      else{
        for(int i = loc; i < N; i++){ // 원소를 찾은
          itemList[i] = itemList[i+1];
        }
        N--;
      }

  }
}
public void print() {
  for(int i =0; i<N; i++)
    System.out.print(itemList[i] + ", ");
  System.out.println(itemList[N]);
}
public static void main(String[] args){
  ArrayLinearList list1= new ArrayLinearList();
  list1.insert(12);
  list1.insert(24);
  list1.insert(36);
  list1.insert(58);
  list1.insert(79);
  System.out.println("*** Show List after insert ***");
  list1.print();

  list1.delete(24);
  System.out.println("*** Show List after delete 24 ***");
  list1.print();

  list1.delete(58);
  System.out.println("*** Show List after delete 58 ***");
  list1.print();

  list1.delete(12);
  System.out.println("*** Show after delete 12 ***");

  list1.delete(10);
  System.out.println("*** Show after delete 10 ***");
  list1.print();

  System.out.println("isEmpty ? " + list1.isEmpty());
}
}
