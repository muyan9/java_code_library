package zcy.encodeDecode;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

class Base64 {
	/**
	 * The Base64 Alphabet * * Base64转换表
	 */
	private final static String base64chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

	/**
	 * 编码一个字符串
	 * 
	 * @param s
	 *            * @return String s
	 */
	public static String encode(String plainText) {
		// the result/encoded string, the padding string, and the pad count
		String encoded = ""; /* 结果字符串 */
		String paddingString = ""; /* Padding字符串 */
		int paddingCount = plainText.length() % 3; /* Padding数量 */
		// add a right zero pad to make this string a multiple of 3 characters
		// 在字符串的尾部填充\0,使一个字符串的字节数长度是3的倍数
		if (paddingCount > 0) {
			for (; paddingCount < 3; paddingCount++) {
				paddingString += "=";
				plainText += "\0";
			}
		}
		// increment over the length of the string, three characters at a time
		for (paddingCount = 0; paddingCount < plainText.length(); paddingCount += 3) {
			// we add newlines after every 76 output characters, according to
			// the MIME specs
			// 根据MIME规范,每输出76个字符后添加一个新行
			if (paddingCount > 0 && (paddingCount / 3 * 4) % 76 == 0)
				encoded += "\r\n";
			// these three 8-bit (ASCII) characters become one 24-bit number
			// 三个8位(ASCII)字符,编程一个24位数字
			int n = (plainText.charAt(paddingCount) << 16)
					+ (plainText.charAt(paddingCount + 1) << 8)
					+ (plainText.charAt(paddingCount + 2));
			// this 24-bit number gets separated into four 6-bit numbers
			// 24位数字分隔成4个6位数字
			int n1 = (n >> 18) & 63, n2 = (n >> 12) & 63, n3 = (n >> 6) & 63, n4 = n & 63;
			// those four 6-bit numbers are used as indices into the base64
			// character list
			// 这四个6位数字作为base64转换表的索引
			encoded += "" + base64chars.charAt(n1) + base64chars.charAt(n2)
					+ base64chars.charAt(n3) + base64chars.charAt(n4);
		}
		return encoded.substring(0, encoded.length() - paddingString.length())
				+ paddingString;
	}

	/**
	 * 解码一个Base64字符串 * * @param encodedText * @return String
	 */
	public static String decode(String encodedText) {
		// remove/ignore any characters not in the base64 characters list
		// or the pad character -- particularly newlines
		// 删除/忽略任何不再base64字符列表里面的字符,或pad字符
		encodedText = encodedText.replaceAll("[^" + base64chars + "=]", "");
		// replace any incoming padding with a zero pad (the 'A' character is
		// zero)
		String p = (encodedText.charAt(encodedText.length() - 1) == '=' ? (encodedText
				.charAt(encodedText.length() - 2) == '=' ? "AA" : "A") : "");
		String r = "";
		encodedText = encodedText.substring(0,
				encodedText.length() - p.length())
				+ p;
		// increment over the length of this encrypted string, four characters
		// at a time
		for (int c = 0; c < encodedText.length(); c += 4) {
			// each of these four characters represents a 6-bit index in the
			// base64 characters list which, when concatenated, will give the
			// 24-bit number for the original 3 characters
			int n = (base64chars.indexOf(encodedText.charAt(c)) << 18)
					+ (base64chars.indexOf(encodedText.charAt(c + 1)) << 12)
					+ (base64chars.indexOf(encodedText.charAt(c + 2)) << 6)
					+ base64chars.indexOf(encodedText.charAt(c + 3));
			// split the 24-bit number into the original three 8-bit (ASCII)
			// characters
			r += "" + (char) ((n >>> 16) & 0xFF) + (char) ((n >>> 8) & 0xFF)
					+ (char) (n & 0xFF);
		}
		// remove any zero pad that was added to make this a multiple of 24 bits
		return r.substring(0, r.length() - p.length());
	}

	public static String getBASE64(String s) {
		if (s == null)
			return null;
		return (new BASE64Encoder()).encode(s.getBytes());
	}

	// 将 BASE64 编码的字符串 s 进行解码
	public static String getFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		String s = "abcd";
		String encoded = encode("MAYA1982");
		System.out.println(encoded);
		String decoded = decode(encoded);
		System.out.println(decoded);
		System.out.println(decode("eGhfZHVmZW5n"));
		System.out.println(encode("xh_dufeng"));
		
		System.out.println(getBASE64(s));
		System.out.println(getFromBASE64(getBASE64(s)));
	}
}