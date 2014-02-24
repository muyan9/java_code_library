package zcy.performance.memory;


public class JMemoryDemo {

	public static void main(String[] args) throws InterruptedException {
		while(true)
		{
			System.out.printf("    总内存大小：%s\n",Runtime.getRuntime().totalMemory() / 1024);
			System.out.printf("空闲内存大小：%s\n",Runtime.getRuntime().freeMemory() / 1024);
			System.out.printf("最大内存大小：%s\n",Runtime.getRuntime().maxMemory() / 1024);
			
			Thread.sleep(2000);
		}
	}

}