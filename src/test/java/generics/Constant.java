package generics;

import org.openqa.selenium.WebDriver;

import com.sun.javafx.PlatformUtil;

public class Constant {

	public static final  String RootPath = System.getProperty("user.dir").replace("\\", "/");
	public static void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", RootPath+"/driver/chromedriver");
            System.out.println("Mac");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", RootPath+"/driver/chromedriver.exe");
            System.out.println("Windows");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", RootPath+"/driver/chromedriver");
            System.out.println("Linux");
        }
    }
	//public static final String ChromeDriverPath=RootPath+"/driver/chromedriver.exe";
	public static String URL;
	public static WebDriver driver;
	public static String platform;
}
