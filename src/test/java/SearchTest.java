
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test(groups = {"web"})
    public void positiveTestSendKey(){
        //with concatenate string
        app.search().typeSearchCurrentMonth("Haifa","08/26/2021","08/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(3000);
        Assert.assertTrue(app.search().isListOfCarAppeared());
    }
    @Test(groups = {"a","web"})
    public void negativeTestSendKey(){
        //with concatenate string
        app.search().typeSearchCurrentMonth("Haifa","08/29/2021","08/30/2021");

        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isDataInPath());
        Assert.assertTrue(app.search().buttonYallaInactive());
    }

    @Test
    public void selectPeriodCurrentMonth(){
        app.search().typeSearchCurrentMonth("Haifa","08/29/2021","08/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isListOfCarAppeared());

    }

    @Test
    public void selectPeriodFuture(){
        app.search().fillSearchFormInFuture("Haifa","08/26/2021","10/30/2021");
        app.carHelper().pause(3000);
        app.userHelper().submitForm();
        app.carHelper().pause(3000);
        Assert.assertTrue(app.search().isListOfCarAppeared());
    }



}