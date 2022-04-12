class BidirectNode {
  Object data;
  BidirectNode llink; // previous
  BidirectNode rlink; // next
}

@FunctionalInterface
interface Visitor {
  void visit(BidirectNode n);
}

@FunctionalInterface
interface ItemComparator {
  int compare(Object lhs, Object rhs);
}

public class Lab0411 {
  public static void testCase1(){
/*    DoubleLinkedList list = new DoubleLinkedList();
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
    System.out.println("ADD A");
    list.add("A", c);
    list.traverse(v);
    System.out.println("ADD F");
    list.add("F", c);
    list.traverse(v);
    System.out.println("ADD G");
    list.add("G", c);
    list.traverse(v);
    System.out.println("ADD E");
    list.add("E", c);
    list.traverse(v);


    System.out.println("Remove A");
    list.remove("A", c);
    list.traverse(v);
    System.out.println("Remove G");
    list.remove("G", c);
    list.traverse(v);
    System.out.println("ADD B");
    list.add("B", c);
    list.traverse(v);
    System.out.println("ADD A");
    list.add("A", c);
    list.traverse(v); */
    // list = Create DoubleLinkedList
    // System.out.println("Add 'A'");
    // List.add("A")
    // List.traverse(visitor);

    // Adds "F", "G", "E".

    // System.out.println("Remove 'A'");
    // list.remove("A");
    // list.traverse(visitor);

    // Remove "G"
    // Adds "B", "A"
  }
  public static void testCase2(){
    DoubleLinkedList list1 = new DoubleLinkedList();
    ItemComparator a = (Ihs, rhs) -> {
      int i1 = (Integer) Ihs; int i2 = (Integer) rhs; return i1 - i2;
    };
    Visitor v = (n) -> {System.out.print(n.data+" ");};
    Object LastOne;
    list1.add(1,a);
    list1.add(2,a);
    list1.add(3,a);
    list1.add(7,a);
    list1.add(9,a);
    list1.traverse(v);
    System.out.println("");

    list1.removeFirst();
    list1.removeFirst();
    System.out.println("Remove first - 1");
    System.out.println("Remove first - 3");

    list1.add(8,a);
    list1.removeFirst();
    list1.removeFirst();
    System.out.println("Remove first - 5");
    System.out.println("Remove first - 7");
    list1.add(24,a);
    list1.removeFirst();
    list1.removeFirst();
    System.out.println("Remove first -9");
    System.out.println("Remove first -15");
    list1.add(48,a);


    list1.add(144,a);
    list1.removeFirst();
    list1.removeFirst();
    System.out.println("Remove first -24");
    System.out.println("Remove first -48");

    list1.traverse(v);
    System.out.println("");

    LastOne = list1.removeFirst();
    System.out.println("Result " + LastOne);
    // Handle Integer
    // list = Create DoubleLinkedList

    // list.add(1); list.add(3); list.add(5);...
    // (1,3,5,7,9)
    // list.traverse(visitor);

    // while(items in list >= 2){
    // int x = list.removeFirst();
    // System.out.println("Remove first - " + x);
    // int y = list.removeFirst("Remove first - " + y);
    // int n = (x+y) * 2;
    // System.out.println("Add" + n);
    //list.add(n);
    // list.traverse(visitor);
  //}

    // LastOne = list.removeFirst();
    // System.out.println("Result " + LastOne);
  }
  public static void main(String[] args){
    testCase1();
    testCase2();
  }
}
