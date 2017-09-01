package fanshe;

public class TestBeiShuiDiaoyong {

	public static void main(String[] args) {
		hello();
	}
	public static void hello_call(){
		 hello();
	}
    public static void hello() {
    	int index=3;
        String className = Thread.currentThread().getStackTrace()[index].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[index].getMethodName();
        int lineNumber = Thread.currentThread().getStackTrace()[index].getLineNumber();
        
        System.out.println(className);
        System.out.println(methodName);
        System.out.println(lineNumber);
    }
}
