package pages.AppPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.ReusableMethods;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AileButcemPage {
        public AileButcemPage() {
            //bu yazimla beraber artik MobilElement kelimelerini kullanabiliriz
            PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(15)), this);
        }

        @FindBy(xpath = "//*[@text='E-mail Adresi']")
        public MobileElement mailBox;

        @FindBy(xpath = "//*[@text='Şifre']")
        public MobileElement passwordBox;

    @FindBy(xpath = "//*[@text='Başarıyla giriş yapıldı.']")
    public MobileElement girisBasariliText;

    @FindBy(xpath = " (//*[@class='android.widget.ImageView'])[1]")
    public MobileElement hesabim;


    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement name;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement surname;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    public MobileElement city;
    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[4]")
    public MobileElement age;
    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[5]")
    public MobileElement job;
    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    public MobileElement cinsiyet;


    @FindBy(xpath = "(//*[@class='android.widget.ImageView'])[5]")
    public MobileElement arti;
    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement aciklama;
   /* @FindBy(xpath = "//*[@text='Açıklama']")
    public MobileElement aciklama;*/
    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[3]")
    public MobileElement gelirTipi;
    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[4]")
    public MobileElement kategory;
    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[5]")
    public MobileElement tarihText;
    @FindBy(xpath = "(//*[@class='android.widget.ImageView'])[5]")
    public MobileElement takvim;
    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[6]")
    public MobileElement tutarDoviz;

    @FindBy(xpath = "//*[@text='Tutar']")
    public MobileElement tutarGonder;

    @FindBy(xpath = "//*[@text='Gelir eklendi.']")
    public MobileElement gelirEklendi;

    public void basariliGiris(){
        String actual=  girisBasariliText.getText();
        String expected="Başarıyla giriş yapıldı.";
        Assert.assertEquals("Giris Basarisiz",expected,actual);
    }
    public void kayitDEgisiklik(String ad,String soyad,String city1,String age1,String is,String cins){

        ReusableMethods.wait(1);
        name.sendKeys(ad);
        surname.sendKeys(soyad);
         city.sendKeys(city1);
        ReusableMethods.wait(1);
        cinsiyet.click();
        ReusableMethods.wait(1);
        ReusableMethods.scrollWithUiScrollable(cins);
        ReusableMethods.wait(1);
        age.sendKeys(age1);
        ReusableMethods.wait(1);
        job.sendKeys(is);
        ReusableMethods.wait(1);
        ReusableMethods.scrollWithUiScrollable("Kaydet");
    }
    public void degisiklikAssertion(String ad,String soyad,String city1,String age1,String is,String cins){
        assertEquals(ad, name.getText());
        assertEquals(soyad, surname.getText());
        assertEquals(city1, city.getText());
        assertEquals(cins,cinsiyet.getText());
        assertEquals(age1, age.getText());
        assertEquals(is, job.getText());

        ReusableMethods.wait(1);
    }
    }

