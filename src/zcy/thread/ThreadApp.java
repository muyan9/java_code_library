package zcy.thread;

public class ThreadApp extends Thread {

	private int i=0;
	
	private boolean flag;

	public ThreadApp(boolean flag) {this.flag = flag;}

	public void run() {
		while(true)
		{
			if(flag)
				i++;
			else
				i--;
			System.out.println(i);
	
			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}