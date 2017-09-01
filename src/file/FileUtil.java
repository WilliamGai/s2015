package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtil {	
	public static byte[] readFileBytes(InputStream is){
		byte[] data = null;
		try {
			if(is.available()==0){//严谨起见,一定要加上这个判断,不要返回data[]长度为0的数组指针
				return data;
			}
			data = new byte[is.available()];
			is.read(data);
			is.close();
			return data;
		} catch (IOException e) {
			e.printStackTrace();
			return data;
		}
	}
	public static byte[] nioRead(String file) throws IOException {  
	    FileInputStream in = new FileInputStream(file);  
	    FileChannel channel = in.getChannel();  
	  
	    ByteBuffer buffer = ByteBuffer.allocate(1024);  
	    channel.read(buffer);  
	    byte[] b = buffer.array();  
	    System.out.println(new String(b));  
	    return b;
	}  
}
