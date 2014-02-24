import java.util.Date;

public class d {  
  
    public static void main(String[] args) {
    	while(true)
    	{
    		System.out.println(new Date().toLocaleString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }  
}  

