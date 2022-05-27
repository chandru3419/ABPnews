package programmes;

public class ExecutionOrder {
	
	static int a=100;
	int b;
	int c;
	static int n;
	
	public ExecutionOrder(int m) {
		System.out.print(a+","+b+","+c+","+m+","+n);
	}
	
	
	public static void main(String[] args) {
		ExecutionOrder order = new ExecutionOrder(n);

	}
	
	static{
		int a=60;
	}
	
	{
		b=30;
		n=20;
	}

}
