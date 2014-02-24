package zcy.performance.server;

import java.io.IOException;

public class ThreadApp extends Thread {

	private int i=0;
	
	private boolean flag;

	public ThreadApp(boolean flag) {this.flag = flag;}
	//TODO 不完整
	public void run() {
		try {
			TestPost.testPost("http://localhost/");
			sleep((int) (Math.random() * 100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}