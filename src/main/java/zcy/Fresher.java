package zcy;

import dev.failsafe.internal.util.RandomDelay;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fresher extends Thread {
    private static List<String> lUrlList = new ArrayList<>();
    private static List<String> lWDlist = new ArrayList<>();
    private static long iDelayFreshUrl = 60*10;
    private static long iPlaytime = 10;

    private String sWebDriverName;

    public Fresher(String sWebDriver){
        this.sWebDriverName = sWebDriver;
    }
    public static void main(String[] a){
        lUrlList.add("https://www.bilibili.com/video/BV16V411g7ob/?spm_id_from=333.1007.top_right_bar_window_history.content.click&vd_source=6e4ec5c42430e4caf93a1f4d83cd57cf");
        lUrlList.add("https://www.bilibili.com/video/BV1ym4y1J7i9/?vd_source=6e4ec5c42430e4caf93a1f4d83cd57cf");

        lWDlist.add(ChromeDriver.class.getName());
        lWDlist.add(EdgeDriver.class.getName());
//        for(int i=0;i<10;i++) {
//            System.out.println(RandomDelay.randomDelayInRange(3, 10, new Random().nextInt(16)));
////            System.out.println(RandomDelay.randomDelay(3, 30, 4));
//        }
//
//        System.exit(0);

        List<Thread> lThread = new ArrayList<>();
        for(String driver: lWDlist){
            Fresher f = new Fresher(driver);
            lThread.add(f);
            f.start();
        }
    }


    public void run(){
        while(true){
            try {
                Class<?> c = Class.forName(this.sWebDriverName);
                WebDriver driver = (WebDriver)c.newInstance();
                for (String url : this.lUrlList) {
                    System.out.println(String.format("tid: %s, drivername: %s, url: %s", this.threadId(), this.sWebDriverName, url));
                    driver.get(url);
                    try {
                        this.iPlaytime = RandomDelay.randomDelayInRange(3, 10, new Random().nextInt(16));
                        System.out.println(String.format("tid: %s, play %ss", this.threadId(), this.iPlaytime));
                        Thread.sleep(this.iPlaytime * 1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                driver.quit();
                this.iDelayFreshUrl = RandomDelay.randomDelayInRange(580, 611, new Random().nextInt(5));
                System.out.println(String.format("tid: %s, sleep %ss", this.threadId(), this.iDelayFreshUrl));

                Thread.sleep(this.iDelayFreshUrl * 1000);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
}
