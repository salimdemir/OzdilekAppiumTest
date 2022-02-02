import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class StepImplementation extends BaseTest{
    Logger logger = LogManager.getLogger(StepImplementation.class);

    @Step("<time> saniye kadar bekle")
    public void wait(int time) throws InterruptedException {
            Thread.sleep(time*1000);
    }

@Step("<id> id li elementi <text> text ifadesini alarak kontrol et")
    public void checkId(String id,String text){
        Assert.assertTrue("Uygulama Açılamadı...",appiumDriver.findElement(By.id(id)).getText().contains(text));
}

@Step("<id> id li elemanı bul tıkla")
    public void clickId(String id){
        try {
            appiumDriver.findElement(By.id(id)).click();
            System.out.println(id + "id li elemente tıklandı");
        }catch (Exception e){
            System.out.println(id + "id li elemente tıklanamadı...");
        }
    }


    @Step("<xpath> xpath li elementi <text> text ifadesini alarak kontrol et")
    public void chechXpath(String xpath,String text){
        Assert.assertTrue("Görüntüleme Başarısız...",appiumDriver.findElement(By.xpath(xpath)).getText().contains(text));
    }


    @Step("<xpath> xpath li elemanı bul tıkla")
    public void clickXpath(String xpath){
        try {
            appiumDriver.findElement(By.xpath(xpath)).click();
            System.out.println(xpath + "xpath li elemente tıklandı...");
        }
        catch (Exception e){
            System.out.println(xpath + "xpath li elemente tıklanamadı...");
        }
    }

    @Step("Sayfayı kaydır")
    public void scrollAction() throws InterruptedException {

            final int ANIMATION_TIME =200;
            final int PRESS_TIME =200;
            int edgeBorder = 10;
            PointOption pointOptionStart, pointOptionEnd;
            Dimension dims = appiumDriver.manage().window().getSize();
            pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
            pointOptionEnd = PointOption.point(dims.width/2, edgeBorder);
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
    }

    @Step("<xpath> liste ile rastgele bir ürün seç")
    public void randomClick(String xpath){

        try {
            List<MobileElement>list = appiumDriver.findElements(By.xpath(xpath));
            System.out.println(list.size());
            Random random = new Random();
            int i = random.nextInt(list.size());
            list.get(i).click();
            System.out.println("rastgele bir ürün seçildi...");
        }catch (Exception e){
            System.out.println("rastgele bir ürün seçilemedi...");
        }

    }

    @Step("<xpath> xpath li elementi bul ve <text> değerini gir")
    public void sendKeys(String xPath,String text){
         try {
             appiumDriver.findElement(By.xpath(xPath)).sendKeys(text);
             System.out.println(text + "text ifadesi yazıldı...");
         }catch (Exception e){
             System.out.println(text + "text ifadesi istenilen yere yazılamadı...");
         }
    }







}




