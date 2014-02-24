package zcy.io;

import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.io.FileInputStream;
import java.io.File;

public class crc {
	public static String getFileCRCCode(File file) throws Exception {
		FileInputStream fileinputstream = new FileInputStream(file);
		CRC32 crc32 = new CRC32();
		for (CheckedInputStream checkedinputstream =
		new CheckedInputStream(fileinputstream, crc32);
		checkedinputstream.read() != -1;
		)
		{
		}
		return Long.toHexString(crc32.getValue());

	}

	public static void main(String[] args) throws Exception {
		File f = new File("D:\\Documents\\program\\java\\pickup-five-tuple\\src\\binaries\\146d61fca77d748f5a5ecff53afd30e4");
		System.err.println(getFileCRCCode(f));
	}
}