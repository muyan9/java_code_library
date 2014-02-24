package zcy.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

//import org.eclipse.swt.graphics;

public class gcTest2{
	Display display = Display.getDefault();
	protected Shell shell;
	
	Image image = new Image(display, 200, 200); //建立表大小的图像image
	Image image1 = new Image(display, 200, 200); //建立表大小的图像image

	public static void main(String[] args) {
		try {
			//TODO 试验swt能否实现applet
			gcTest2 window = new gcTest2();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		
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
		
		final GC gc = new GC(image);
		final Canvas canvas = new Canvas(shell, SWT.NONE);
	    canvas.setBounds(100, 100, 200, 200);
	    canvas.redraw();
		Listener listener = new Listener() {
			int lastX = 0, lastY = 0;

			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.MouseMove:
					if ((event.stateMask & SWT.BUTTON1) == 0)
						break; // 判断是否为鼠标左键，如果不是跳出
//					image = new Image(display, 200, 200);
//					image = image1;
					gc.drawLine(lastX, lastY, event.x, event.y);
					System.out.println("move++++++++");
//					gc.drawPoint(event.x, event.y);
					gc.drawRoundRectangle(lastX, lastY, 30, 30, 70, 100);
					canvas.setBackgroundImage(image);
					
					canvas.redraw();
					break;
					// FALL THROUGH
				case SWT.MouseDown:
					lastX = event.x;
					System.out.println("down----");
					lastY = event.y;
					
					break;
				}
			}
		};
		
		
		
		

	    canvas.addPaintListener(new PaintListener() {
	        public void paintControl(PaintEvent e) {
	         e.gc.drawImage(image, 0, 0);
	         canvas.setBackgroundImage(image);
	        }
	       });
	    
	    canvas.addListener(SWT.MouseDown, listener);
	    canvas.addListener(SWT.MouseMove, listener);
	}
}
