package FormyTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubmitForm {
    // global driver
    WebDriver driver;

    // variables

    String baseURL = "http://formy-project.herokuapp.com/";
    String submitFormURL = "http://formy-project.herokuapp.com/form";

//    String firstName = "Mehmet";
//    String lastName = "Sample";
//    String jobTitle = "Computer Engineer";

    // methods

    public void SubmitFormFormWebsite(String firstName, String lastName, String jobTitle) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //navigate formy url
        driver.get(baseURL);

        //locators of submit form link then click
        WebElement submitFormLink = driver.findElement(By.cssSelector("body > div > div > li:nth-child(18) > a"));
        submitFormLink.click();
        Thread.sleep(2000);

        //verify that title appeared when navigate tho submit form.
        WebElement webFormText = driver.findElement(By.cssSelector("body > div > h1"));
        String textTitle = webFormText.getText();
        Assert.assertEquals(textTitle, "Complete Web Form");

        //verify that first name text appeared
        WebElement firstNameText = driver.findElement(By.cssSelector("form > div > div:nth-child(1) label"));
        String firsNameTitleText = firstNameText.getText();
        Assert.assertEquals("yanlissa fail yaptsin. ",firsNameTitleText, "First name");


//       sendkey to first name input box
        WebElement firstNameInputBox= driver.findElement(By.cssSelector("input[id='first-name']"));
        firstNameInputBox.sendKeys(firstName);

        WebElement lastNameInputBox = driver.findElement(By.cssSelector("input[id='last-name']"));
        lastNameInputBox.sendKeys(lastName);

        WebElement jobTitleInputBox = driver.findElement(By.cssSelector("#job-title"));
        jobTitleInputBox.sendKeys(jobTitle);

        WebElement submitButton = driver.findElement(By.linkText("Submit"));
        submitButton.click();
        Thread.sleep(2000);


        WebElement thankAlertMessage = driver.findElement(By.cssSelector("div[role='alert']"));
        String textMessage = thankAlertMessage.getText();
        Assert.assertEquals("Alert mesaji gozukmedi",textMessage,"The form was successfully submitted!");

        driver.close();

    }

    //locator datatype WebElement

    //Test execution

    @Test
    public void TestCase() throws InterruptedException {
       SubmitFormFormWebsite("Oguz","Kaan","Teacher");
    }
    @Test
    public void TestCase3() throws InterruptedException {
        SubmitFormFormWebsite("Oguzd","Kaan","Teacher");
    }


    @Test
    public void Testcase2() throws InterruptedException {
        SubmitFormFormWebsite("Samet","Muhtar","Doctor");
    }

    @Test
    public void SubmitFormTest3() throws InterruptedException {
        SubmitFormFormWebsite("Oguz11","Kaan1","Teacher1");
    }


    @Test
    public void SubmitFormTest4() throws InterruptedException {
        SubmitFormFormWebsite("Samet2","Muhtar3","Doctor55");
    }




}
