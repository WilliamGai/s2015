package listMapSet;

import java.util.HashMap;
import java.util.UUID;
/**
 * ���سǰ�ȫ��hashMap,��������cpu100%
 * HashMap�ڲ���ִ��put������ʱ���������ѭ��������Ϊ���̵߳���HashMap��Entry�����γɻ������ݽṹ��һ���γɻ��ν����Entry��next�ڵ����Զ��Ϊ�գ�
 * �ͻ������ѭ����ȡEntry
 * Ŀǰ��δ�����java7 �Ῠ������java8����
 */
public class HashMapUnsafe {
	static final HashMap<String,String> map = new HashMap<String,String>(2);
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<100000; i++){
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");							
						}
					},"unsafe map" + i).start();
					
				}
			}
		},"main");
		t.start();
		t.join();
	}
}
