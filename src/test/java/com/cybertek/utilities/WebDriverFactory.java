package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    //Task:
    //write a static method that takes a string parameter name: browserType
    //based on the value of parameter
    //it will setup the browser and
    //the method will return chromedriver or firefoxdriver object.
    //name of the method: getDriver

    public static WebDriver getDriver(String browserType){

        WebDriver driver = null;

        //Chrome,CHROME,ChrOme
        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                break;

            case "chrome_extensionHandled":
                WebDriverManager.chromedriver().setup();

                // to disable of the Chrome extensions that might pop up in our browser
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);

                driver = new ChromeDriver(options);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
        }
        return driver;
    }


}
