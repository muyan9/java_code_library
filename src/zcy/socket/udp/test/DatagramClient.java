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
        //{�������ݵĿͻ���}        
        byte[] ip={(byte)10,(byte)0,(byte)11,(byte)111};
        NetworkInterface tmp_ni=null;
        InetAddress tmp_ia=null;
        Enumeration ni=NetworkInterface.getNetworkInterfaces(); 
        String info="hello";
       
        
        ///////////////////////////////////////////////
        InetAddress target = InetAddress.getByAddress(ip);
        System.out.println("Sent to :"+target.getHostAddress()+":"+PORT);
        //�õ�Ŀ������ĵ�ַʵ��
        DatagramSocket ds = new DatagramSocket(SENDPORT);
        //��9999�˿ڷ������ݱ�
        InetAddress local=InetAddress.getLocalHost();
        String hello = info;
        //Ҫ���͵�����
        byte[] buf=hello.getBytes();
       
        //������ת����Byte����
        DatagramPacket op = new DatagramPacket(buf, buf.length, target, PORT);
        //��BUF�������е����ݴ��
        while(true){
        ds.send(op);
        System.out.println(info);
        Thread.sleep(1000);
        }
        //��������
        //ds.close();
        //�ر�����
       
        }catch(SocketException e1){System.out.println("SocketException");
        }catch( UnknownHostException e11){System.out.println("UnknownHostException");
        }catch(IOException e){ System.out.println("IOException");
        }catch(InterruptedException e1111){System.out.println("InterruptedException");}
    }
}
//�����������IP