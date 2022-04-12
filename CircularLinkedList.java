class Node {
	Object data;
	Node link;

	public Node() {
	}

	public Node(Object data) {
		this(data, null);
	}

	public Node(Object data, Node link) {
		this.data = data;
		this.link = link;
	}
}

@FunctionalInterface
interface Visitor {
	void visit(Node n);
}

@FunctionalInterface
interface ItemComparator {
	int compare(Object lhs, Object rhs);
}

public class CircularLinkedList {
	Node begin;

	public CircularLinkedList() {
		begin = new Node();
		begin.link = begin;
	}

	public boolean isEmpty() {
		return begin.link == begin;
	}

	public void traverse(Node L, Visitor visitor) {
		// 수정 전
		// for(Node p=L ; p.link!=L ; p=p.link) {
		Node p;
		for (p = L; p.link != L; p = p.link) {
			visitor.visit(p);
		}
		if (L != begin && L != begin.link) {
			visitor.visit(L);
		} else {
			// 추가됨
			visitor.visit(p);
		}
	}

	public void traverse(Node L, Node E, Visitor visitor) {
		for (Node p = L; p != E; p = p.link) {
			visitor.visit(p);
		}
		visitor.visit(E);
	}

	public void traverse(Visitor visitor) {
		this.traverse(begin.link, visitor);
	}

	public Node search(Node L, Object data, ItemComparator comparator) {
		Node p = L;
		Node found = L;
		while (p.link != L && comparator.compare(p.data, data) <= 0) {
			found = p;
			p = p.link;
		}
		if (L.link != L && comparator.compare(p.data, data) <= 0) {
			found = p;
		}
		return found;
	}

	public Node search(Object data, ItemComparator comparator) {
		return this.search(begin.link, data, comparator);
	}

	public Node add(Object data, ItemComparator comparator) {
		Node insert = new Node(data);
		if (isEmpty()) {
			// 변경됨
			begin.link = insert;
			insert.link = insert;
		} else {
			Node pos = search(begin.link, data, comparator);
			insert.link = pos.link;
			pos.link = insert;
			// 변경됨 begin link 를 변경
			if (comparator.compare(pos.data, insert.data) > 0) {
				this.begin.link = insert;
			}
		}
		return insert;
	}

	void invert() {
		if (this.begin != null) {
			Node prev = this.begin;
			Node temp = this.begin;
			Node current = this.begin.link;

			prev.link = prev;

			while (current != this.begin) {
				temp = current.link;
				current.link = prev;
				this.begin.link = current;
				prev = current;
				current = temp;
			}
			this.begin = prev;
		}
	}

	public void concatenate(CircularLinkedList otherList) {

		Node po1;
		Node po2;

		Node first = this.begin.link;
		Node second = otherList.begin.link;

		for (po1 = first; po1.link != first; po1 = po1.link) {
		}
		for (po2 = second; po2.link != second; po2 = po2.link) {
		}

		po1.link = otherList.begin.link;
		po2.link = this.begin.link;

	}

	public static void main(String[] args) {


		  CircularLinkedList L1 = new CircularLinkedList();
      ItemComparator a = (Ihs, rhs) -> {
        int i1 = (Integer) Ihs; int i2 = (Integer) rhs; return i1 - i2;
      };
      Visitor v = (n) -> {System.out.print(n.data+" ");};
      L1.add(1,a);
      L1.add(2,a);
      L1.add(3,a);
      L1.add(7,a);
      L1.add(9,a);

			CircularLinkedList L4 = new CircularLinkedList();
			L4.add(2,a);
			L4.add(10, a);
			L4.add(12,a);
			L4.add(20, a);
			L1.concatenate(L4);
			L1.traverse(v);
    //  L1.invert();
    //  L1.traverse(v);

      CircularLinkedList L2 = new CircularLinkedList();
      final ItemComparator c = (lhs, rhs) -> {
        return ((String) lhs).compareTo((String) rhs); };
      final Node begin = L2.begin;
    /*  Visitor v = (n) -> {if (begin.link == n) {System.out.print("(");}System.out.print(n.data);
      if(n.link == n || c.compare(n.data, n.link.data)> 0) {System.out.println(")");}
      else{
        System.out.print(", ");
      }
    }; */
			CircularLinkedList L3 = new CircularLinkedList();

  //  Visitor v = (n) -> {System.out.print(n.data);};

    L2.add("Ant", c);
    L2.add("Cat", c);
//		L2.add("Bear", c);
//		L2.add("Dog", c);
//	L2.invert();
//		L2.traverse(v);
		L3.add("Bear", c);
		L3.add("Dog", c);
		L2.concatenate(L3);
		L2.traverse(v);

	}
}
