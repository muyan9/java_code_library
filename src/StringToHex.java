public class StringToHex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(HEXbyte("\\xba\\x83\\x53\\x83\\x00\\xff\\xd6\\x53\\x53\\x53\\x68\\x02\\x00"));
	}

	public static String byteHEX(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}

	public static String HEXbyte(String hex) {
		
		String t = hex;
		String sReturn = "";
		while (t.length()>0)
		{
			char c = t.charAt(0);
			if(c!='\\')
			{
				sReturn += c;
				t = t.substring(1);
			}
			else
			{
				String tt = t.substring(0,4);
				c = (char) (Integer.parseInt("" + tt.charAt(2), 16) << 4 | Integer
						.parseInt("" + tt.charAt(3), 16));
				sReturn += c;
				t = t.substring(4);
			}
		}
		return sReturn;
	}
}
