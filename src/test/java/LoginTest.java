import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        if (!app.userHelper().isLogged()){
            app.userHelper().logout();
        }
    }

    @Test
    public void loginTestPositive(){


        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.userHelper().submitLogin();
        app.userHelper().pause(3000);
        String loginS = app.userHelper().getText(By.xpath("//div[@class='dialog-container']//h2"));
        app.userHelper().clickOkButton();
        Assert.assertEquals(loginS,"Logged in success");

    }
}
