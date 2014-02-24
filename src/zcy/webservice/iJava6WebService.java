package zcy.webservice;

import javax.jws.WebService;

@WebService 
public interface iJava6WebService { 
        /** 
         * Web服务中的业务方法 
         * 
         * @return 一个字符串 
         */ 
        public String doSomething(String a); 
        public Pojo doSomething1(String a);

}