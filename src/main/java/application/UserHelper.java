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

    public void openRegForm() {
        click(By.xpath("//a[text()='Sign up']"));
    }

    public void fillRegForm(User user) {
        type(By.cssSelector("input#name"), user.getName());
        type(By.cssSelector("input#lastName"), user.getLastName());
        type(By.cssSelector("input#email"), user.getEmail());
        type(By.cssSelector("input#password"), user.getPassword());
    }
    public void fillRegForm(String name, String lastName, String email, String password) {
        type(By.cssSelector("input#name"), name);
        type(By.cssSelector("input#lastName"), lastName);
        type(By.cssSelector("input#email"), email);
        type(By.cssSelector("input#password"), password);
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

    public void checkboxIAgree() {
        click(By.xpath("//label[contains(text(),'I agree to the')]"));
    }

    public void clickOkButton() {
        click(By.xpath("//button[.='Ok']"));
    }

    public void clickSubmitButton() {
        click(By.xpath("//button[.='Y’alla!']"));
        pause(10000);
    }

    public boolean isLogged() {
        return wd.findElements(By.xpath("//a[.='Log in']")).size() > 0;
    }

    public void logout() {
        click(By.xpath("//a[.='logOut']"));
    }
}
