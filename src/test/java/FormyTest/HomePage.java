package FormyTest;

import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage{

    WebDriver driver;

    @Test
    public void HomePageLogin() throws InterruptedException {

        // creating an chrome object
      driver = new ChromeDriver();

        // navigate to website with get methods
        driver.get("http://formy-project.herokuapp.com/");

        // key and mouse locator then click on it
        WebElement keyAndMouse = driver.findElement(By.xpath("/html/body/div/div/li[9]/a"));
        keyAndMouse.click();

        Thread.sleep(2000);
        // get key and mouse text
       WebElement getKeyAndMouse = driver.findElement(By.xpath("/html/body/div/h1"));
       String text = getKeyAndMouse.getText();
        System.out.println(text);

        // verify getText and Keyboard and Mouse Input"
        Assert.assertEquals(text, "Keyboard and Mouse Input");

    }


    @Test
    public void ppNetSearh(){

        //for using driver methods
        // create and object
    driver = new ChromeDriver();

        //navigate to php.net
        driver.get("https://www.php.net");

        // search eval
        WebElement searchBox = driver.findElement(By.name("pattern"));
        searchBox.sendKeys("eval");
        searchBox.submit();
        //searchBox.sendKeys(Keys.ENTER);

        //verify description keyword
        WebElement textDescription = driver.findElement(By.xpath("//*[@id='refsect1-function.eval-description']/h3"));
        String result = textDescription.getText();  // result String

        //verify text
        Assert.assertEquals(result, "Description ¶");
        Assert.assertTrue(result.contains("Description"));
    }







}
