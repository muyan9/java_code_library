package zcy.socket.convert;

public class test {
	public static void main(String[] args)
	{
		byte[] byte_array_temp = {(byte)2,(byte)17,(byte)29,(byte)0,(byte)-111,(byte)0,(byte)0,(byte)-9};
		System.out.println(ByteConvert.byteToHex(byte_array_temp));
		
		byte b = (byte)0x91;
		System.out.println(b);
	}

}
