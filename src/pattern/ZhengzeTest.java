package pattern;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZhengzeTest {

	public static void main(String[] args) {
		test4();
	}
    public static void test1()
    {
       String str = "我我...我要...要要...要要...学学学...学学...编编编...编程..程.程程...程...程";
        str = str.replaceAll("\\.+", "");
        System.out.println(str);
       
        str = str.replaceAll("(.)\\1+", "$1");

        System.out.println(str);
    }
    public static void test2(){
    	String str = "ming tian jiu yao fang gia le,da jia.";      
        String reg = "[a-z]{3}";

        Pattern p = Pattern.compile(reg);       //将规则封装成对象 
        Matcher m = p.matcher(str);				//让正则对象作用字符串，获取匹配器对象
        while (m.find())//将规则作用到字符串上，并进行符合规则的字串查找
        {
            System.out.println(m.group());//获取匹配后结果
        }

    }
    public static void test3(){
    	String str = "<div><b>2</b><c>4</c><d/><e></e><f/></div>";     //<换行   ; </换行  ;  >空格加一  />
        String reg = "<>";

//        str = str.replaceAll("<", "\n<");
        String ss[] = str.split("<(?!/)");
//        String ss[] = str.split("[<,</,>,/>]");
        String rst=ss[0];
        int _num = 1;
        for (int i = 1; i < ss.length; i++) {
        	_num ++;
        	if(rst.contains("</")){
        		_num --;
        	}
        	rst= rst + "\n" + repeatString(" ",_num)+ "<" + ss[i];
		}
        System.err.println(rst);//获取匹配后结果
        String ss2[] = rst.split("/>");
       	rst=ss2[0];
        int _num2 = 1;
        for (int i = 1; i < ss2.length; i++) {
        	_num2 ++;
        	if(rst.contains("</")){
        		rst= rst + "/》" + ss2[i].replaceAll("<(?!/)", "L<");
        		_num2 --;
        	}else{
        		rst= rst + "/》" + ss2[i];
        	}
//        	rst= rst + "/》" + repeatString(" ",_num2)+ ss2[i];
		}
        String a = repeatString("U2",3);
        System.out.println(rst);//获取匹配后结果
       

    }
    public static void test4(){
    	String str = "<div><b>U</b><c>E</c><d/><e></e><f/></div>";     //<换行   ; </换行  ;  >空格加一  />
        String reg = "<>";

//        str = str.replaceAll("<", "\n<");
        String ss[] = str.split("<");
//        String ss[] = str.split("[<,</,>,/>]");
        String rst=ss[0];
        int _num = 1;
        for (int i = 1; i < ss.length; i++) {
        	
        	ss[i] = "<"+ss[i];
        	int add=ss[i].split("<(?!/)").length-1;
        	int dec=ss[i].split("/>").length -1 + ss[i].split("</").length-1;
            System.err.println(ss[i]+","+add+","+dec);//获取匹配后结果

        	int count =  _num-dec ;
        	
//        	count = _num + count;
        	rst= rst + "\n" + repeatString(" ",count) + ss[i] + add+dec+"count="+count+",num="+_num;
        	_num ++;
//        	if(count<=0){
//        		_num = _num + count;
//        	}
		}
        String a = repeatString("U2",3);
        System.out.println(rst);//获取匹配后结果
       

    }
    public static String repeatString(String s, int num){
    	StringBuilder sb = new StringBuilder();
    	if(num <=0 || num > 64){
    		return s;
    	}
    	while (num-->0){
    		sb.append(s);
    	}
    	return sb.toString();
    }


}
