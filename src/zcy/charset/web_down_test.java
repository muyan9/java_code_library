/*
* TextRead.java
* �ı���ȡ
* �ڲ���TestCharset�����ı�����
* readFile��ȡ�ļ�
* ��Ҫorg.mozilla.intl.chardet��֧�֣���
* Created on 2007��1��29��, ����10:43
*
* To change this template, choose Tools | Template Manager
* and open the template in the editor.
*/

package zcy.charset;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.mozilla.intl.chardet.nsDetector;
import org.mozilla.intl.chardet.nsICharsetDetectionObserver;
import org.mozilla.intl.chardet.nsPSMDetector;

/**
*
* @author Administrator
*/
public final  class web_down_test {
    public String readFile(File f) throws FileNotFoundException, IOException{
        BufferedInputStream imp = new BufferedInputStream(new FileInputStream(f));
        byte[] b1=new byte[1024];
        int le=imp.read(b1);
        TestCharset tc=new TestCharset(b1);
        Charset cset1=tc.getCharset();
        imp.close();
        //��ʼ��ȡ�ļ���
        StringBuffer sb;
        File s1=f;
        long l=s1.length();
        if (l>90)
            return null;
        if (s1.canRead()){
            int readlen;
            char[] read1=new char[255];
            sb=new StringBuffer((int)l+20);
            BufferedReader fr1=new BufferedReader(new InputStreamReader(new FileInputStream(s1),cset1));
            while((readlen = fr1.read(read1)) != -1)
                sb.append(read1,0,readlen);
            fr1.close();
        }else{
            return null;
        }
        return sb.toString();
    }
    public static void main(String[] arg) throws FileNotFoundException, IOException{
        JFileChooser jfc=new JFileChooser();
        JFrame f=new JFrame();
        f.setVisible(true);
        int i=jfc.showOpenDialog(f);
        if(i==jfc.APPROVE_OPTION){
            System.out.println(new web_down_test().readFile(jfc.getSelectedFile()));
        }
        f.dispose();
    }
    public static final class TestCharset {
        public TestCharset(byte[] bb){
            testCharset(bb);
        }
        private  Charset cset=Charset.defaultCharset();
        private  boolean found = false ;
        public void testCharset(byte[] bb){
            //Charset cset=Charset.defaultCharset();
            final Charset cset1;
            // Initalize the nsDetector() ;
            nsDetector det = new nsDetector(nsPSMDetector.ALL) ;//������������
            // Set an observer...
            // The Notify() will be called when a matching charset is found.

            det.Init(new nsICharsetDetectionObserver() {//nsICharsetDetectionObserver.Notify����ʶ��ɹ������
                public void Notify(String charset) {
                    cset=Charset.forName(charset);
                    found=true;
                }
            });
            boolean isAscii = true ;
            isAscii = det.isAscii(bb,bb.length);//�Ȳ���Ascii
            if (!isAscii)
                det.DoIt(bb,bb.length, false);//����
            det.DataEnd();//���Խ�����
            if (isAscii) {
                cset=Charset.forName("ASCII");
                found=true;
            }
            if (!found) {//û�ҵ��趨һ�����п��ܵı��룡��
                String prob[] = det.getProbableCharsets() ;
                cset=Charset.forName(prob[0]);
            }
        }
        public Charset getCharset(){
            return cset;
        }
    }
}
