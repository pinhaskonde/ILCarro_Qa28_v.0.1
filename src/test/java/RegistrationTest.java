import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.userHelper().isLogged()) {
            app.userHelper().logout();
        }
    }

    @Test
    public void registrationTestPositive() {
        User user = new User();
        user.withName("Alexey").withLastName("Pusshkin0").withEmail("aqpuvsdinn@gmail.com").withPassword("tFggg97$");
        app.userHelper().openRegForm();
        app.userHelper().fillRegForm(user);
        app.userHelper().checkboxIAgree();
        app.userHelper().pause(5000);
        app.userHelper().clickSubmitButton();
        String regSuccess = app.userHelper().getText(By.xpath("//div[@class='dialog-container']//h2"));
        app.userHelper().clickOkButton();
        Assert.assertEquals(regSuccess,"You are logged in success");
    }
//    @Test
//    public void regTestUserPositive(String name,String lastName,String email, String password){
//        app.userHelper().openRegForm();
//        app.userHelper().pause(3000);
//        app.userHelper().fillRegForm("Piterr","Lastnamee","piterr@.gmail.com","Adode12#");
//        app.userHelper().checkboxIAgree();
//        app.userHelper().clickSubmitButton();
//        String regSuccess = app.userHelper().getText(By.xpath("//div[@class='dialog-container']//h2"));
//        app.userHelper().clickOkButton();
//        Assert.assertEquals(regSuccess,"You are logged in success");
//
//    }

}
