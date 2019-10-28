package FormyTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeyToGoogle {


    // variables -- global

    String googleURL = "https://www.google.com";

    // locator  data type webelement

    // methods -- dynamic

    public void GetResultOfAnyProductFromGoogle(String product) throws InterruptedException {


        // object create
        WebDriver driver = new ChromeDriver();

        //go to google page
        driver.get(googleURL);

        //locate search box
        WebElement searchBoxLocator = driver.findElement(By.name("q"));
        searchBoxLocator.sendKeys(product);

        // send the keyword to the google search box
        searchBoxLocator.submit();

        // verify result
        /// store result then get text , then compare.
        WebElement resultLocator = driver.findElement(By.id("resultStats"));
        String result = resultLocator.getText();

        System.out.println(result);
        Assert.assertTrue(result.contains("results"));

        // ne yaptigini gormek beklemek icin
        Thread.sleep(2000);
        driver.quit();

    }


    // verify result

    @Test
    public void GoogleSearchIphone() throws InterruptedException {

        GetResultOfAnyProductFromGoogle("Telefon");

    }


    @Test
    public void GoogleSearchMouse() throws InterruptedException {

        GetResultOfAnyProductFromGoogle("Fare");

    }


    @Test
    public void GoogleSearchComputer() throws InterruptedException {

        GetResultOfAnyProductFromGoogle("computer");

    }

    @Test
    public void GoogleSearchToyota() throws InterruptedException {

        GetResultOfAnyProductFromGoogle("Corolla");

    }


//    DAta type  samples

//        int myNum = 5;               // Integer (whole number)
//        float myFloatNum = 5.99f;    // Floating point number
//        char myLetter = 'D';         // Character
//        boolean myBool = true;       // Boolean
//        String myText = "Hello";     // String
//        WebElement box = driver.findElement(By.id('name'));


//    WebElement in Selenium: Operations performed on the WebElements
//    In order to access WebElements, we need to perform a set of operations starting with browser actions
//    until the operations are performed on  frames.
    //    Operations performed on the browser
        //    Launch the browser
        //    Navigate to particular web page
        //    Close the current browser
        //    Close all browsers opened by WebDriver during execution
        //    Maximize browser
        //    Refresh the browser
    //    Operations on the web page
        //    Get page title
        //    Get page URL

//    public void GetName() {
//    }

//    dDatay type
//    method
//
//    method calll,
//
//    public String GetCAr() {
//        return;
//    }
//
//    parametreli method
//
//    public void getNAme(String a) {
//        return a;
//    }
//
//
//    Command , option, L == Format
//
//    resuable , dynamic method,
//
//    Assertion, --> compare Assert.assertTrue()
//
//        Junit Test execution
//

}
