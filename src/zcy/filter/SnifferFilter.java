package zcy.filter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;

import zcy.db.DBConn;

public class SnifferFilter {

	private Table table;
	protected Shell shell;

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SnifferFilter window = new SnifferFilter();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window
	 */
	public void open() {
		final Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	/**
	 * Create contents of the window
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("SWT Application");

		table = new Table(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL
				 | SWT.SELECTED);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 115, 472, 223);
		//
		DBConn db = new DBConn();
		String sql = "select * from temp";
		ResultSet rs = db.getResultSet(sql);
		ResultSetMetaData rsmd;
		try {
			rsmd = rs.getMetaData();
			int iColCount = rsmd.getColumnCount();
			for(int i = 0;i<iColCount;i++)
			{
				TableColumn ti = new TableColumn(table,SWT.NONE);
				ti.setText(rsmd.getColumnName(i+1));
			}
			
			while(rs.next())
			{
				TableItem ti = new TableItem(table,SWT.NONE);
				for(int i=0;i<iColCount;i++)
				{
					String stmp=rs.getString(i+1);
					if(stmp==null)
						stmp="";
					ti.setText(i,stmp);
				}
			}
			for (int i = 0; i < iColCount; i++) {
				table.getColumn(i).pack();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
