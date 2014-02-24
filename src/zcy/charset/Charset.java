package zcy.charset;

public class Charset {
	public static void main(String[] args) {
		try {
			String str = "������";
			String code = "gb2312";
			System.out.println(str);
			System.out.println(str.getBytes());
			System.out.println(str.getBytes(code));
			System.out.println(new String(str.getBytes(code),"gbk"));
			System.out.println(new String(str.getBytes("gbk"),code));
			System.out.println(new String(str.getBytes(code),code));
			
			System.out.println(java.net.URLEncoder.encode("���ͳ��"));
			System.out.println(java.net.URLEncoder.encode("���ͳ��","gb2312"));
			System.out.println(java.net.URLEncoder.encode("���ͳ��","gbk"));
			System.out.println(java.net.URLEncoder.encode("���ͳ��","utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String str = "����";
			String code = "utf-8";
			System.out.println(str);
			System.out.println(str.getBytes());
			System.out.println(str.getBytes(code));
			System.out.println(new String(str.getBytes(code),"gbk"));
			System.out.println(new String(str.getBytes("gbk"),code));
			System.out.println(new String(str.getBytes(code),code));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
