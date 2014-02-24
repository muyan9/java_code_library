package zcy.socket.convert;

public class ByteConvert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byteHex();
	}

	/*
	 * 十六进制表示
	 */
	private static void byteHex() {
		byte[] array = new byte[] { (byte) 0xa2, (byte) 0x0F, (byte) 0xF0,
				(byte) 0xaF, (byte) 0xa1 };
		for (int i = 0; i < array.length; i++)
			System.out.println("byte >> hexString=" + byteToHex(array[i]));
	}

	/*
	 * To convert a byte to it's hexadecimal equivalent 转换byte为十六进字符
	 */
	public static String byteToHex(byte b) {
		int i = b & 0xFF;
		String s = Integer.toHexString(i);
		if (s.length() % 2 != 0) {
			// Pad with 0
			s = "0" + s;
		}
		return s.toUpperCase();
	}

	/*
	 * To convert byte array to it's hexadecimal equivalent 转换byte数组为十六进字符
	 */
	public static String byteToHex(byte[] b) {
		String s = "";
		for(int i=0;i<b.length;i++)
		{
			int ii = b[i] & 0xFF;
			String t = Integer.toHexString(ii);
			if (t.length() % 2 != 0) {
				// Pad with 0
				t = "0" + t;
			}
			
			s += " " + t;
		}
		return s.trim().toUpperCase();
	}

	// 转换为无符合的int
	public static int unsignedByteToInt(byte b) {
		return (int) b & 0xFF;
	}
}
