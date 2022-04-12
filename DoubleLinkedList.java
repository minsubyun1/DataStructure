

public class DoubleLinkedList{
  BidirectNode begin;

  public  DoubleLinkedList() {
    begin = new BidirectNode();
    begin.rlink = begin;
  }
  void insertAfter(BidirectNode pos, BidirectNode insert){
    // 완성
    BidirectNode next = pos.rlink;
    insert.rlink = next;
    pos.rlink = insert;
    insert.llink =pos;
    next.llink = insert;
  }
  void delete(BidirectNode delete) {
    // 완성
    BidirectNode prev = delete.llink;
    BidirectNode next = delete.rlink;
    prev.rlink = next;
    next.llink = prev;
  }
  public Object removeFirst(){
    if(isEmpty()) {return null;}
    BidirectNode first = begin.rlink;
    Object removedData = first.data;

    first.llink.rlink = first.rlink;
    first.rlink.llink = first.llink;
    begin.rlink = first.rlink;
    return removedData;
  }

  public boolean isEmpty() {
     return begin.rlink == begin;
  }
  public void traverse(BidirectNode L, Visitor visitor) {
     BidirectNode p;
     for(p=L ; p.rlink!=L ; p=p.rlink) {
       visitor.visit(p);
     }
     if(L!=begin && L!=begin.rlink) {
       visitor.visit(L);
     } else {
       visitor.visit(p);
     }
   }

   public void traverse(Visitor visitor) {
     this.traverse(begin.rlink, visitor);
  }

  public BidirectNode search(BidirectNode L, Object data, ItemComparator comparator) {
      BidirectNode p = L;
      BidirectNode found = L;
      while( p.rlink!=L && comparator.compare(p.data, data) <= 0) {
        found = p;
        p = p.rlink;
      }
      if(L.rlink!=L && comparator.compare(p.data, data) <= 0) {
        found = p;
      }
      return found;
    }


  public BidirectNode search(Object data, ItemComparator comparator) {
      return this.search(begin.rlink, data, comparator);
  }
  public BidirectNode deleteSearch(BidirectNode L, Object data, ItemComparator comparator) {
      BidirectNode p = L;
      if(comparator.compare(p.data, data) == 0) return p;
      while( p.rlink!=L && comparator.compare(p.data, data) != 0) {
        p = p.rlink; // Move Next node
      }
      if(comparator.compare(p.data, data) != 0) return begin;
      return p;
    }


    public BidirectNode deleteSearch(Object data, ItemComparator comparator) {
      return deleteSearch(begin.rlink, data, comparator);
  }
  public BidirectNode add(Object data, ItemComparator comparator) {
      BidirectNode insert = new BidirectNode();
      insert.data = data;
      if( isEmpty() ) {
        begin.rlink = insert;
        insert.rlink = insert;
        insert.llink = insert;
      } else {
        BidirectNode pos = search(begin.rlink, data, comparator);
        insertAfter(pos, insert);
        if(comparator.compare(pos.data, insert.data)>0) {
          this.begin.rlink = insert; //head 노드를 새로운 노드로 옮김 작은 노드가 비긴 노드를 가리키도록 추가하면 됨.
        }
      }
      return insert;
  }
  public Object remove(Object data, ItemComparator comparator) {
     if(isEmpty()) return null; // isEmpty
     BidirectNode pos = deleteSearch(begin.rlink, data, comparator);
     if(pos==begin) return null; // Not Found
     delete(pos);

     if(pos==begin.rlink) {
       if(pos.rlink == pos) { // Last One
         begin.rlink = begin;
       } else { // Remove First
         begin.rlink = pos.rlink;
       }
     }
     return pos.data;
  }
  // 출력 및 테스트 예시
/*  public static void main(String[] args) {
     DoubleLinkedList list = new DoubleLinkedList();
     final ItemComparator c = (lhs, rhs) -> {
       return ((String)lhs).compareTo((String)rhs);
     };
     final BidirectNode begin = list.begin.rlink;
     Visitor v = (n) -> {
       // form "(data:Ant) -> "
       if(begin.rlink == n) {
         System.out.print("LIST = (");
       }
       System.out.print(n.data);
       if(n.rlink == begin.rlink) {
         System.out.println(")");
       } else {
         System.out.print(", ");
       }
     };
     list.traverse(v);
     System.out.println("ADD Bear");
     list.add("A", c);
     list.traverse(v);
     System.out.println("ADD Ant");
     list.add("F", c);
     list.traverse(v);
     System.out.println("ADD Dog");
     list.add("G", c);
     list.traverse(v);
     System.out.println("ADD Cat");
     list.add("Cat", c);
     list.traverse(v);


     System.out.println("Remove Cat");
     list.remove("Cat", c);
     list.traverse(v);
     System.out.println("Remove Ant");
     list.remove("Ant", c);
     list.traverse(v);
     System.out.println("Remove Bee");
     list.remove("Bee", c);
     list.traverse(v);
     System.out.println("Remove Dog");
     list.remove("Dog", c);
     list.traverse(v);
     System.out.println("Remove Bear");
     list.remove("Bear", c);
     list.traverse(v);
     System.out.println("Remove Bee");
     list.remove("Bee", c);
     list.traverse(v);
   } */
}
