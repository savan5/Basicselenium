package profiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class ProfilesDemo {
    public static void main(String[] args) {
        String baseURL = "http://www.letskodeit.com";
        WebDriver driver;
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile fxProfile = profile.getProfile("automationprofile");
       // FirefoxOptions  options = new FirefoxOptions();
       // options.setProfile(fxProfile);

      //  driver = new FirefoxDriver(options);
       // driver.manage().window().maximize();
        //driver.get(baseURL);
    }
}
