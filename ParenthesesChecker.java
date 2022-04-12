public class ParenthesesChecker {
	char[] open;
	char[] close;
	CharArrayStack stack;


	public class CharArrayStack{
		int top=-1;
		int maxSize=0;
		char[] elements;
		public CharArrayStack(int maxStackSize) {
			top = -1;
			elements = new char[maxStackSize];
		}
		public boolean isFull(){
			return top >= elements.length-1;
		}
		public CharArrayStack add(char item) {
			if(isFull()) {
				throw new RuntimeException("Stack is full!");
			}
			top++;
			elements[top] = item;
			return this;
		}
		public boolean isEmpty() {
			return top<0;
		}
		public char delete(){
			if(isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			return elements[top--];
		}
		public Object clear() {
			top = -1;
			return elements;
		}
	}

	public ParenthesesChecker(char[] open, char[] close) {
		this.open = open;
		this.close = close;
		stack = new CharArrayStack(100);
	}

	boolean isParentheses(char p) {
		if(isOpen(p) || isClose(p)) return true;
		else return false;
	}
	boolean isOpen(char p) {
		if(p == '(' || p == '[' || p =='<') return true;
		else return false;
	}
	boolean isClose(char p) {
		if(p == ')' || p == ']' || p == '>') return true;
		else return false;
	}
	boolean isMatch(char p1, char p2) {
		if(!isOpen(p1)) return false;
		if(!isClose(p2)) return false;
		int i1=0;
		int i2=0;
		for(int i=0; i<open.length; i++) {
			if(open[i]==p1) {
				i1 = i;
			}
		}
		for(int i=0; i<close.length; i++) {
			if(close[i]==p2) {
				i2 = i;
			}
		}
		return i1==i2;
	}
	//검사함수
	boolean validate(String expression) {
		stack.clear();
		for(int i=0; i<expression.length(); i++) {
			char test = expression.charAt(i);
			if(!isParentheses(test)) continue;
			if(isOpen(test)) {
				stack.add(test);
			}
			else {
				char last = stack.delete();
				if(!isMatch(last, test)) return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		//test1-1
    char [] a1 = new char[10];
		a1[0] = '(';
		a1[1] = '[';
		a1[2] = '<';
    char [] a2 = new char[10];
		a2[0] = ')';
		a2[1] = ']';
		a2[2] = '>';
		ParenthesesChecker checker = new ParenthesesChecker(a1,a2);
		String e1 = "(1+2)";
    String e2 = "2+(2+[3+<4*5>]-9)/2";
    String e3 = "(3+(3+(4+5]))";
    String e4 =  "(4*[1+(3-5]))";
    String e5 = "5+(5+6*7+(9+[2/5])";
		System.out.print("(1+2):=");
		if(checker.validate(e1)) {
			System.out.println("true");
		}
		else System.out.println("ok,,error");
    System.out.print("2+(2+[3+<4*5>]-9)/2:=");
    if(checker.validate(e2)) {
			System.out.println("true");
		}
		else System.out.println("ok,,error");
    System.out.print("(3+(3+(4+5])):=");
    if(checker.validate(e3)) {
			System.out.println("true");
		}
		else System.out.println("ok,,error");
    System.out.print("(4*[1+(3-5])):=");
    if(checker.validate(e4)) {
			System.out.println("true");
		}
		else System.out.println("ok,,error");
    System.out.print("5+(5+6*7+(9+[2/5]):=");
    if(checker.validate(e5)) {
			System.out.println("true");
		}
		else System.out.println("ok,,error");
		//e1 = "(1+2)";
		//e2 = "2+(2+[3+<4*5>]-9/2";
		//e3 = "(3+(3+(4+5]))";
		//e4 = "(4*[1+(3-5]))";
		//e5 = "5+(5+6*7+(9+[2/5])";
	}
}
