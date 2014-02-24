package zcy.game;

public class geti {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		geti a = new geti();
		geti b = new geti();
		a.gongji = 20;
		a.fangyu = 30;
		while (true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int adb = b.fang(a.attack());
			if(adb==-1)
			{
				System.out.println("die");
				break;
			}
			else{
				System.out.println(String.format("a da b %s xue, b sheng %s", adb,b.xueliang));
			}
			
			int bda = a.fang(b.attack());
			if(bda==-1)
			{
				System.out.println("dir");
				break;
			}
			else
				System.out.println(String.format("b da a %s xue, a sheng %s", bda,a.xueliang));
		}

	}
	
	public int xueliang = 100;
	public int fangyu = 30;
	public int gongji = 50;
	
	public int attack()
	{
		return this.gongji;
	}
	
	public int fang(int gongjili)
	{
		int diaoxue = gongjili - fangyu;
		if(diaoxue>=xueliang)return -1;
		else 
		{
			this.xueliang = this.xueliang - diaoxue;
			return diaoxue;
		}
	}
}
