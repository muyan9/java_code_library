package zcy.webservice;    

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
    
public class Client {   
    public static void main(String[] args) {   
        //创建WebService客户端代理工厂      
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();      
        //注册WebService接口      
        factory.setServiceClass(iWebService.class);      
        //设置WebService地址      
        factory.setAddress("http://192.168.0.102:8080/t/Java6WebService");           
        iWebService userServices = (iWebService)factory.create();      
        System.out.println("invoke userinfo webservice...");  
//        userServices.putCommand("df", "dddddd");
//        userServices.putCommand("df1", "dddddd1");
//        userServices.putCommand("df2", "dddddd2");
//        userServices.putCommand("df3", "dddddd3");
//        String a = userServices.getCommand();
        for(int i=0;i<3;i++)
        System.out.println(userServices.getCommand());
    }    
       
}  
