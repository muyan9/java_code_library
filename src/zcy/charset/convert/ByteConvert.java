package zcy.charset.convert;

public class ByteConvert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byteHex();
	}

	/*
	 * ʮ�����Ʊ�ʾ
	 */
	private static void byteHex() {
		byte[] array = new byte[] { (byte) 0xa2, (byte) 0x0F, (byte) 0xF0,
				(byte) 0xaF, (byte) 0xa1 };
		for (int i = 0; i < array.length; i++)
			System.out.println("byte >> hexString=" + byteToHex(array[i]));
	}

	/*
	 * To convert a byte to it's hexadecimal equivalent ת��byteΪʮ�����ַ�
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
	 * To convert byte array to it's hexadecimal equivalent ת��byte����Ϊʮ�����ַ�
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
			
			String sSplit = " ";
			switch(i%16)
			{
			case 8:
				sSplit = "-";break;
			case 0:
				sSplit = "\n";break;
			default:
				sSplit = " ";break;
			}
			s += sSplit + t;
		}
		return s.trim().toUpperCase();
	}

	/*
	 * To convert byte array to it's hexadecimal equivalent ת��byte����Ϊʮ�����ַ�
	 * column ָ����ʾ������
	 */
	public static String byteToHex(byte[] b, int column) {
		String s = "";
		for(int i=0;i<b.length;i++)
		{
			int ii = b[i] & 0xFF;
			String t = Integer.toHexString(ii);
			if (t.length() % 2 != 0) {
				// Pad with 0
				t = "0" + t;
			}
			
			String sSplit = " ";
			switch(i%column)
			{
			case 8:
				sSplit = "-";break;
			case 0:
				sSplit = "\n";break;
			default:
				sSplit = " ";break;
			}
			s += sSplit + t;
		}
		return s.trim().toUpperCase();
	}

	// ת��Ϊ�޷��ϵ�int
	public static int unsignedByteToInt(byte b) {
		return (int) b & 0xFF;
	}
	
	public static void putInt(byte[] bb, int x) {
		bb[0] = (byte) (x >> 24);
		bb[1] = (byte) (x >> 16);
		bb[2] = (byte) (x >> 8);
		bb[3] = (byte) (x >> 0);
	}
}
