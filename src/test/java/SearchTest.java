
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void positiveTestSendKey(){
        //with concatenate string
        app.search().typeSearchCurrentMonth("Haifa","07/26/2021","07/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isListOfCarAppeared());
    }
    @Test
    public void negativeTestSendKey(){
        //with concatenate string
        app.search().typeSearchCurrentMonth("Haifa","06/26/2021","06/30/2021");

        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isDataInPath());
        Assert.assertTrue(app.search().buttonYallaInactive());
    }

    @Test
    public void selectPeriodCurrentMonth(){
        app.search().typeSearchCurrentMonth("Haifa","07/26/2021","07/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isListOfCarAppeared());

    }

    @Test
    public void selectPeriodFuture(){
        app.search().fillSearchFormInFuture("Haifa","09/26/2021","10/30/2021");

        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isListOfCarAppeared());

    }



}