package zcy.office;
import java.io.*;
import jxl.*;

public class Excel1 {
	public static void main()
	{
		String[][] aa = readExcel("F:\\Documents\\book1.xls");
		for(int i = 0 ; i < aa.length ; i++)
		{
			for(int j = 0 ; j < aa[i].length ; j++)
			System.out.println(aa[i][j]);
		}
	}
	public static String[][] readExcel(String fileNameTemp) 
	{
		String[][] strTemp = null;
		try {
			// ����Workbook����, ֻ��Workbook����
			// ֱ�Ӵӱ����ļ�����Workbook
			// ������������Workbook

			InputStream is = new FileInputStream(fileNameTemp);
			jxl.Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0);
			int rows = rs.getRows();
			int cols = rs.getColumns();
			// System.out.println(rows+" "+cols);
			strTemp = new String[rows][cols];
			for (int i = 0; i < rows; i++) 
			{
				for (int j = 0; j < cols; j++) 
				{
					Cell ctemp = rs.getCell(j, i);
					strTemp[i][j] = ctemp.getContents();
				}
			}
			rwb.close();
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		return strTemp;
	}
}

/*
 * import java.io.*; import jxl.Workbook; import jxl.WorkbookSettings; import
 * jxl.write.WritableWorkbook; import jxl.write.WritableSheet; import
 * jxl.write.WritableFont; import jxl.write.WritableCellFormat; import
 * jxl.write.Label; import jxl.write.Number; import jxl.write.WriteException;
 * public class Excel { private WritableWorkbook workbook;
 * 
 * public void write(CountSzyfView cs, java.io.OutputStream outputStream) throws
 * IOException, WriteException { WorkbookSettings ws = new WorkbookSettings();
 * ws.setLocale(new Locale("zh","CN")); workbook =
 * Workbook.createWorkbook(outputStream, ws); WWritableSheet(cs,"sheet1",
 * workbook); workbook.write(); workbook.close(); }
 * 
 * private void WWritableSheet(CountSzyfView cs, String str, WritableWorkbook
 * workbook) throws IOException, WriteException { WritableSheet s =
 * workbook.createSheet(str, 0); WritableFont arial12pt = new
 * WritableFont(WritableFont.ARIAL, 12); WritableCellFormat arial12format = new
 * WritableCellFormat(arial12pt); arial12format.setWrap(true);
 * s.setColumnView(0, 20); Label lr = new Label(0, 0, "123123", arial12format);
 * s.addCell(lr); lr = new Label(1, 0, "bt", arial12format); s.addCell(lr);
 * cellLabel(cs, s); }
 * 
 * private void cellLabel(CountSzyfView cs, WritableSheet ss) { Label lr; if (cs !=
 * null) { lr = new Label(0, i + 1, cobject.getName()); ss.addCell(lr); }
 *  } }
 */