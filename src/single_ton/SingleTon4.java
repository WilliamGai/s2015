package single_ton;

public class SingleTon4 {
	private static volatile SingleTon4 instance = null;
	private SingleTon4(){}
	public static SingleTon4 getInstance(){
		if(instance == null){
			synchronized (SingleTon4.class) {
				if(instance == null){
					instance = new SingleTon4();
				}
			}
		}
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
