import zcy.charset.convert.ByteConvert;


public class testsocket {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int l = 36851340;
		byte[] b = new byte[4];
		
		ByteConvert.putInt(b, l);
		
		System.out.println(ByteConvert.byteToHex(b));
	}

}
