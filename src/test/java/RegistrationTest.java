import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (!app.userHelper().isLogged()) {
            app.userHelper().logout();
        }
    }

    @Test(groups = {"web"})
    public void registrationTestPositive() {
        User user = new User();
        user.withName("Alexey").withLastName("Pusshkin0").withEmail("aqpuvsdinn@gmail.com").withPassword("tFggg97$");
        logger.info("Registration with --> Name: " + user.getName() + " --> LastName: "
                        + user.getLastName()+" --> Email: " + user.getEmail()+" --> Password: " + user.getPassword());
        app.userHelper().openRegForm();
        app.userHelper().fillRegForm(user);
        app.userHelper().checkboxIAgree();
        app.userHelper().pause(5000);
        app.userHelper().clickSubmitButton();
        String regSuccess = app.userHelper().getText(By.xpath("//div[@class='dialog-container']//h2"));
        app.userHelper().clickOkButton();
        Assert.assertEquals(regSuccess,"You are logged in success");
        logger.info("Test passed");
    }
    @Test
    public void regTestUserPositive(){
        app.userHelper().openRegForm();
        app.userHelper().fillRegForm("Pitterrr","Lastnameee","pitterrr@gmail.com","bAzode12#");
        app.userHelper().checkboxIAgree();
        app.userHelper().clickSubmitButton();
        app.userHelper().pause(3000);
        String regSuccess = app.userHelper().getText(By.xpath("//div[@class='dialog-container']//h2"));
        app.userHelper().clickOkButton();
      Assert.assertEquals(regSuccess,"You are logged in success");

    }

}
