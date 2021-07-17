package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[.='Log in']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }
    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//*[@type='submit']"));
    }

    public void clickOkButton() {
        click(By.xpath("//button[.='Ok']"));
    }

    public boolean isLogged() {
        return wd.findElements(By.xpath("//a[.='Log in']")).size()>0;
    }

    public void logout() {
        click(By.xpath("//a[.='logOut']"));
    }
}
