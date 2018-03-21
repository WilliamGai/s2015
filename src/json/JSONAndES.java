package json;

import com.alibaba.fastjson.JSON;

public class JSONAndES {
	public static void main(String argsp[]){
		ESTest es = new ESTest("testid", 1, "testindex", "testtype", true);
		String json = JSON.toJSONString(es);
		System.out.println(json);
		
		ESTest es2 = JSON.parseObject(json, ESTest.class);
		System.out.println(JSON.toJSONString(es2));
	}
	public static class ESTest{
		public String _id;
		public Integer _version;
		public String _index;
		public String _type;
		public Boolean found;
		
		public ESTest() {
			super();
		}

		public ESTest(String _id, Integer _version, String _index, String _type, Boolean found) {
			super();
			this._id = _id;
			this._version = _version;
			this._index = _index;
			this._type = _type;
			this.found = found;
		}
	}
}
