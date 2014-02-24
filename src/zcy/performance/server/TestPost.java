package zcy.performance.server;                                                                                 
                                                                                                  
import java.io.BufferedReader;                                                                    
import java.io.IOException;                                                                       
import java.io.InputStream;                                                                       
import java.io.InputStreamReader;                                                                 
import java.io.OutputStreamWriter;                                                                
import java.net.URL;                                                                              
import java.net.URLConnection;                                                                    
                                                                                                  
public class TestPost {                                                                           
                                                                                                  
    public static void testPost(String str) throws IOException {                                            
                                                                                                  
        /**                                                                                       
         * ����Ҫ��URL�µ�URLConnection�Ի��� URLConnection���Ժ����׵Ĵ�URL�õ������磺 // Using 
         *  java.net.URL and //java.net.URLConnection                                             
         */                                                                                       
        URL url = new URL(str);                         
        URLConnection connection = url.openConnection();                                          
        /**                                                                                       
         * Ȼ���������Ϊ���ģʽ��URLConnectionͨ����Ϊ������ʹ�ã���������һ��Webҳ��           
         * ͨ����URLConnection��Ϊ���������԰����������Webҳ���͡��������������               
         */                                                                                       
        connection.setDoOutput(true);                                                             
        /**                                                                                       
         * ���Ϊ�˵õ�OutputStream�������������Լ����Writer���ҷ���POST��Ϣ�У����磺 ...   
         */                                                                                       
        OutputStreamWriter out = new OutputStreamWriter(connection                                
                .getOutputStream(), "8859_1");                                                    
        out.write("username=kevin&password=*********"); //post�Ĺؼ����ڣ�                        
        // remember to clean up                                                                   
        out.flush();                                                                              
        out.close();                                                                              
        /**                                                                                       
         * �����Ϳ��Է���һ����������������POST��                                                 
         * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:                                         
         * text/plain Content-type: application/x-www-form-urlencoded                             
         * Content-length: 99 username=bob password=someword                                      
         */                                                                                       
        // һ�����ͳɹ��������·����Ϳ��Եõ��������Ļ�Ӧ��                                       
        String sCurrentLine;                                                                      
        String sTotalString;                                                                      
        sCurrentLine = "";                                                                        
        sTotalString = "";                                                                        
        InputStream l_urlStream;                                                                  
        l_urlStream = connection.getInputStream();                                                
        // ��˵�е������װ����                                                                   
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(                       
                l_urlStream));                                                                    
        while ((sCurrentLine = l_reader.readLine()) != null) {                                    
            sTotalString += sCurrentLine + "\r\n";                                                
                                                                                                  
        }                                                                                         
//        System.out.println(sTotalString);                                                         
    }                                                                                             
                                                                                                  
    public static void main(String[] args) throws IOException {                                   
                                                                                                  
        testPost("http://localhost/");                                                                               
                                                                                                  
    }                                                                                             
                                                                                                  
}                                                                                                 