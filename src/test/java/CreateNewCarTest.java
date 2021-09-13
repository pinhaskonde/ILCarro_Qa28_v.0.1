import models.Car;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewCarTest extends TestBase {
    @BeforeMethod
    public void precondition() {
//--------Homework-------------------------------Homework---------------------Homework---------------------------
        app.carHelper().login();
    }

    @Test
    public void createNewCar() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        System.out.println("I = " + i);

        Car car = Car.builder()
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.0")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("217-12-"+i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of")
                .about("The very good car")
                .build();
        System.out.println("Car Num -->"+car.getCarRegNumber());
        System.out.println(car.getCarRegNumber());

        app.carHelper().openCarForm();
        app.carHelper().fillCarForm(car);
        app.carHelper().attachPhoto();
        app.carHelper().pause(7000);

        Assert.assertTrue(app.carHelper().isCarAdded());

        @AfterMethod
        public void postCondition(){
            app.carHelper().submitCar();
        }


//--------Homework-------------------------------Homework---------------------Homework---------------------------
        app.userHelper().click(By.xpath("//button[@type='submit']"));
        app.carHelper().pause(7000);
        String carCreatedSuccess = app.carHelper().getText(By.xpath("//h1[text()='Car added']"));
        Assert.assertEquals(carCreatedSuccess,"Car added");
        app.userHelper().click(By.xpath("//button[text()='Show car']"));
        app.carHelper().pause(5000);


    }
}
