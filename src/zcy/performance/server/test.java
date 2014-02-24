package zcy.performance.server;

import java.util.ArrayList;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<ThreadApp> t = createThreads(10000);
		for(int i=0;i<t.size();i++)
		{
			t.get(i).start();
		}
	}
	
	public static ArrayList<ThreadApp> createThreads(int iThreadNum)
	{
		ArrayList<ThreadApp> threads = new ArrayList<ThreadApp>();
		for(int i=0;i<=iThreadNum;i++)
		{
			ThreadApp t = new ThreadApp(true);
			threads.add(t);
		}
		
		return threads;
	}
}
