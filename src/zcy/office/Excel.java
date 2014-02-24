package zcy.office;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Excel {
	public static void main(String[] args)
	{
//		String[][] aa = readExcel("F:\\Documents\\book1.xls");
//		for(int i = 0 ; i < aa.length ; i++)
//		{
//			for(int j = 0 ; j < aa[i].length ; j++)
//			System.out.println(aa[i][j]);
//		}
		try {
			SetDataToFile("f:\\aa.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String[][] readExcel(String fileNameTemp) 
	{
		String[][] strTemp = null;
		try {
			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			// 从输入流创建Workbook

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
	

	static public void SetDataToFile(String filepath) throws Exception
	{
		HSSFWorkbook workbook = new HSSFWorkbook();
		//HSSFSheet sheet = workbook.createSheet();
		FileOutputStream fOut = new FileOutputStream(filepath);
		workbook.write(fOut);
		fOut.flush();
		fOut.close();
		
		int i=1;
		int j=0;
		File dfd  = new File(filepath);
		dfd.createNewFile();
		dfd = null;
		System.gc();
		
		HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem().createDocumentInputStream(filepath));
		
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row 	= null;
        HSSFCell cell	= null;		
		while(true){
	        row = sheet.getRow(i+3);
	        if (row == null)
	            row = sheet.createRow(i+3);
			writeExcel(row,cell,j++,Integer.toString(i),wb);
			writeExcel(row,cell,j++,"dfdas",wb);
			writeExcel(row,cell,j++,"dfdas",wb);
			writeExcel(row,cell,j++,"dfdas",wb);
			j=0;
			i++;
			
			if(i>10) break;
		}
	    FileOutputStream fileOut = new FileOutputStream(filepath);
        wb.write(fileOut);
    	fileOut.close();			
	}
	
    static private void writeExcel(HSSFRow row,HSSFCell cell,int clums,String value,HSSFWorkbook wb){
        cell = row.createCell((short)clums); 
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(value);
		HSSFFont font = wb.createFont();;
		font.setFontHeightInPoints((short)9);
		HSSFCellStyle style = wb.createCellStyle();
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setRightBorderColor(HSSFColor.BLACK.index);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(HSSFColor.BLACK.index);
        style.setFont(font);
        style.setWrapText(true);
        cell.setCellStyle(style);
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
