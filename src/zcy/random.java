package zcy;

import java.util.Random;

public class random {
	public static void main(String[] args)
	{
		Random rand = new Random();
		for(int i=0;;i++)
		{
			float a = rand.nextFloat();
			//if(a==0 || a==100)
			System.out.println(a);
		}
	}
}
