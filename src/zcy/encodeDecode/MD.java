package zcy.encodeDecode;

import java.security.MessageDigest;

class MD{
	
	/** 计算hash值
	 * @param s		hash类型
	 * @param input	计算数据
	 * @return
	 */
	public String getResult(String s, byte [] input){
		try{
			MessageDigest mess=null;
			mess=MessageDigest.getInstance(s);
			mess.update(input);
			byte [] output=mess.digest();
			int val;
			StringBuffer resultBuf=new StringBuffer("");
			for (int i=0; i<output.length; i++){
				//val = ((int) output[i] ) & 0xff; 
				val=output[i];
				if(val<0) val+= 256;
				if (val < 16) resultBuf.append("0");
				resultBuf.append(Integer.toHexString(val));
			}
			String result=resultBuf.toString();
			resultBuf.delete(0,resultBuf.length());;
			return result;
			
		}
		catch(Exception e){
			System.out.println("error");
			return null;
		}
	}

	public static void main(String [] args){
		MD md=new MD();
		System.out.println(md.getResult("MD5", "".getBytes()));
		System.out.println(md.getResult("sha", "".getBytes()));
		System.out.println(md.getResult("md5", "1".getBytes()));
		System.out.println(md.getResult("sha", "1".getBytes()));
		//d41d8cd98f00b204e9800998ecf8427e
		//da39a3ee5e6b4b0d3255bfef95601890afd80709
		//c4ca4238a0b923820dcc509a6f75849b
		//356a192b7913b04c54574d18c28d46e6395428ab
	}
}