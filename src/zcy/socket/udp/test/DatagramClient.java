package zcy.socket.udp.test;

import java.net.*;
import java.util.Enumeration;
import java.io.*;
class  DatagramClient
{
    private static int PORT=8122;//listen.....
    private static int SENDPORT=9999;//listen....
    
    public static void main(String[] args)
    {
        try{
        System.out.println("UDP CLient Start!");
        //{发送数据的客户端}        
        byte[] ip={(byte)10,(byte)0,(byte)11,(byte)111};
        NetworkInterface tmp_ni=null;
        InetAddress tmp_ia=null;
        Enumeration ni=NetworkInterface.getNetworkInterfaces(); 
        String info="hello";
       
        
        ///////////////////////////////////////////////
        InetAddress target = InetAddress.getByAddress(ip);
        System.out.println("Sent to :"+target.getHostAddress()+":"+PORT);
        //得到目标机器的地址实例
        DatagramSocket ds = new DatagramSocket(SENDPORT);
        //从9999端口发送数据报
        InetAddress local=InetAddress.getLocalHost();
        String hello = info;
        //要发送的数据
        byte[] buf=hello.getBytes();
       
        //将数据转换成Byte类型
        DatagramPacket op = new DatagramPacket(buf, buf.length, target, PORT);
        //将BUF缓冲区中的数据打包
        while(true){
        ds.send(op);
        System.out.println(info);
        Thread.sleep(1000);
        }
        //发送数据
        //ds.close();
        //关闭连接
       
        }catch(SocketException e1){System.out.println("SocketException");
        }catch( UnknownHostException e11){System.out.println("UnknownHostException");
        }catch(IOException e){ System.out.println("IOException");
        }catch(InterruptedException e1111){System.out.println("InterruptedException");}
    }
}
//向服务器报告IP