package zcy;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.NoSuchDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchBrowser {
    public static void main(String[]a){
        Logger logger = LoggerFactory.getLogger(SearchBrowser.class);

        try {
            FirefoxDriver driver = new FirefoxDriver();
            driver.get("http://www.baidu.com");
        }catch(SessionNotCreatedException e){
            System.out.println("-------");
            System.out.println(e.getClass().getName());
        }catch(NoSuchDriverException e){
            logger.info("+++++++++++++++");
        }
    }
}
