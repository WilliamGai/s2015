package concurrent.bool;

import java.util.concurrent.atomic.AtomicBoolean;
/**
 * 模板
 */
public class TestVolatile0 {
	public volatile boolean update = false;
	public void init()
	{
	    if( update == false ){
	        update = true;
	        // some thing
	        update = false;
	    }
	}
	public static void main(String[] args) {

	}

}
