package zcy.swt;

import java.applet.Applet;
import java.awt.Graphics;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.swtdesigner.SWTResourceManager;

public class gcTest extends Applet  {
	
	static GC gc;
	Canvas can1;

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
//	public static void main(String[] args) {
//		try {
//			gcTest window = new gcTest();
//			window.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public void paint(Graphics g) {
		gcTest window = new gcTest();
		window.open();
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		{
			final Canvas canvas = new Canvas(shell, SWT.NONE);
			
			canvas.setBounds(46, 21, 234, 184);
			canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
			can1 = new Canvas(canvas, SWT.COLOR_DARK_CYAN);
			can1.setBounds(40, 40, 40, 40);
			
			gc = new GC(canvas);
			canvas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDoubleClick(MouseEvent e) {
					while(true)
					{
						int x = can1.getLocation().x;
						int y = can1.getLocation().y;
						if(x !=e.x)
							if(x<e.x)
								x++;
							else
								x--;
						if(y !=e.y)
							if(y<e.y)
								y++;
							else
								y--;
						try {
							Thread.sleep(10);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						
						can1.setLocation(x,y);
						
						canvas.redraw();
						if(can1.getLocation().x==e.x && can1.getLocation().y==e.y)
							break;
					}
				}
			});
			canvas.addMouseMoveListener(new MouseMoveListener() {
				public void mouseMove(MouseEvent arg0) {
//					can1.setBounds(arg0.x, arg0.y, 40, 40);
				}
			});
			
			
		}

	}
}
