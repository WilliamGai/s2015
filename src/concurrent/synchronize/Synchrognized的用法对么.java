package concurrent.synchronize;

/**
 * Created by bao on 2017/9/1.
 */
public class Synchrognized的用法对么 {
    private static class Article{
        public String id;
        public String content;
        public int clicks;
    }
    public void read(Article article){
        synchronized (article.id){
            article.clicks ++;
            save(article);
        }
    }
    public void read2(Article article){
        synchronized (article.id.intern()){
            article.clicks ++;
            save(article);
        }
    }
    public void save(Article article){

    }

    /**
     * 下面的这段代码negative锁住不
     */
    private String lock ="a";
    public void testLock(){
        synchronized (lock){
            //....
        }
    }
}
