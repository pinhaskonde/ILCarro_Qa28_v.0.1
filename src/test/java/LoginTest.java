import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginTestPositive(){

        click(By.xpath("//a[.='Log in']"));
        type(By.id("email"),"noa@gmail.com");
        type(By.id("password"),"Nnoa12345$");
//      click(By.xpath("//*[text()='']"));
        click(By.xpath("//*[@type='submit']"));
        pause(3000);
//      String loginS = wd.findElement(By.xpath("//div[@class='dialog-container']//h2")).getText();
        String loginS = getText(By.xpath("//div[@class='dialog-container']//h2"));
        click(By.xpath("//button[.='Ok']"));
        Assert.assertEquals(loginS,"Logged in success");



    }
}
