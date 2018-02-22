
public class DriverStackOfObjects {
	public static void main (String[] args) {
		StackOfObjects stack = new StackOfObjects();
		stack.push("one");
		System.out.println(stack.size());
		stack.push("two");
		System.out.println(stack.size());
		stack.push("three");
		System.out.println(stack.size());
		System.out.println( stack.pop() );
		System.out.println(stack.size());
		stack.push("hello");
		System.out.println(stack.size());
		stack.push("again");
		System.out.println(stack.size());
		System.out.println( stack.pop() );
		System.out.println(stack.size());
	}
}
