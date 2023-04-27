package utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class BrowserDriver {

    private static AndroidDriver<MobileElement> browserDriver;

    public static AndroidDriver getBrowserDriver() {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http:127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (browserDriver == null) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL2");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            //  caps.setCapability(MobileCapabilityType.NO_RESET,false);
            //ONEMLIIIIIIIIIIIIIIIIIIIII
            //Eger chrome driver acilmadiysa chrome surumunuz uyumlu degildir, buraya telefonumuzun chrome versionuna uygun chrome versionu bulup asagidaki yere yapistirdik
            //benim 74... noktaydi o chromu bulduk netten exe dosyasini aldik proje icinde actigimiz ayri Driver(APP altinda) clasi icine attik
            //ve absolute pathini asagi yapistirdik.Bunu Appiun inspector ayarlarina da eklemeliyiz
              caps.setCapability("chromedriverExecutable","C:\\Users\\sevil\\IdeaProjects\\T-108AppiumWithCucumber\\Driver\\temsiliChromePath");
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome"); // kullanacak oldugumuz mobil browser tanimi

            if (ConfigReader.getProperty("platformName").equals("Android")) {

                browserDriver = new AndroidDriver<>(appiumServerURL, caps);
                browserDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {

                throw new UnsupportedOperationException("Invalid Platform Name ");

            }

        }

        return browserDriver;
    }
//COOOK ONEMLI
    //https://chrome.google.com/webstore/detail/mobile-simulator-responsi/ckejmhbmlajgoklhgbapkiccekfoccmk
    // BU SITEYI CHROME EKLENTI yaptik BU BIZE SANAL CIHAZ OLUSTURDU INCPECT ALMAMIZI SAGLIYOR Artik inspector
    // kullanmayacagiz,sadece browser testler icin.Adi Mobile simulator - responsive testing tool


    public static void quitAppiumDriver() {
        if (browserDriver != null) {
            browserDriver.quit();
            browserDriver = null;
        }
    }
}