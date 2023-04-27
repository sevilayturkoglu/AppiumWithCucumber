package stepDefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AppPage.AileButcemPage;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class aileButcemStep {
    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    TouchAction action = new TouchAction<>(driver);
    AileButcemPage page = new AileButcemPage();

    @Given("Kullanici kurulumlari tamamlar")
    public void kullanici_kurulumlari_tamamlar() {
        Driver.getAndroidDriver();
    }

    @Then("ilk ekran ayarlarini yapar {string} tiklar ve ardindan login sayfasina ulasin")
    public void ilkEkranAyarlariniYaparTiklarVeArdindanLoginSayfasinaUlasin(String girisYap) {
        ReusableMethods.wait(1);
        for (int i = 0; i < 7; i++) {
            action.press(PointOption.point(939, 1261))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(163, 1261)).release().perform();
        }
        ReusableMethods.scrollWithUiScrollable(girisYap);
    }

    @Then("{string} ve {string} bilgilerini girerek kullanici bilgileriyle {string} tiklanir")
    public void veBilgileriniGirerekKullaniciBilgileriyleTiklanir(String mail, String password, String giris) {
        page.mailBox.sendKeys(ConfigReader.getProperty(mail));
        page.passwordBox.sendKeys(ConfigReader.getProperty(password));
        ReusableMethods.scrollWithUiScrollable(giris);
    }

    @Then("uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin")
    public void uygulamaya_kullanici_bilgileriyle_giris_yapildigini_dogrulayin() {
        ReusableMethods.wait(2);
        page.basariliGiris();
    }

    @Then("sol kisimdaki menuden {string} bolumune gidin")
    public void solKisimdakiMenudenBolumuneGidin(String hesabim) {
        ReusableMethods.wait(4);
        page.hesabim.click();
        ReusableMethods.wait(1);
        ReusableMethods.scrollWithUiScrollable(hesabim);
/*action.press(PointOption.point(390,900))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();*/
    }

    @Then("hesabim sayfasindaki {string} {string} {string} {string} {string} {string} bilgileri degistirerek degisikleri kaydedin")
    public void hesabimSayfasindakiBilgileriDegistirerekDegisikleriKaydedin(String ad, String soyad, String city, String age, String is, String cins) {

        ReusableMethods.wait(1);
       page.kayitDEgisiklik(ad,soyad,city,age,is,cins);
        ReusableMethods.wait(1);
        page.degisiklikAssertion(ad,soyad,city,age,is,cins);
    }

    @Then("ardindan degisiklerin yapildigini dogrulayin")
    public void ardindan_degisiklerin_yapildigini_dogrulayin() {

    }
    @Then("anasayfadaki arti butonuna tiklayin")
    public void anasayfadakiArtiButonunaTiklayin() {
        ReusableMethods.wait(1);
        page.arti.click();
    }

    @Then("gelir ekle bolumune tiklayin")
    public void gelirEkleBolumuneTiklayin() {
ReusableMethods.scrollWithUiScrollable("Gelir Ekle");
    }

    @Then("{string} {string} {string} {string} belirleyin ve kaydedin")
    public void belirleyinVeKaydedin(String aciklama, String gelirTipi, String kategori, String tutar) {
        ReusableMethods.wait(2);
page.aciklama.sendKeys(aciklama);
        ReusableMethods.wait(1);
page.gelirTipi.click();
        ReusableMethods.wait(1);
ReusableMethods.scrollWithUiScrollable(gelirTipi);
        ReusableMethods.wait(1);
page.kategory.click();
ReusableMethods.scrollWithUiScrollable(kategori);
        ReusableMethods.wait(1);
page.takvim.click();
ReusableMethods.scrollWithUiScrollable("30");
        ReusableMethods.wait(1);
ReusableMethods.scrollWithUiScrollable("OK");
page.tutarDoviz.click();
        ReusableMethods.wait(1);
ReusableMethods.scrollWithUiScrollable(tutar);
page.tutarGonder.sendKeys("15000");
ReusableMethods.scrollWithUiScrollable("Kaydet");

    }

    @And("basariyla eklendigini dogrulayin")
    public void basariylaEklendiginiDogrulayin() {
        String actualGelirEklendiText = page.gelirEklendi.getText();
String expectedGelieEklendiText="Gelir eklendi.";
        Assert.assertEquals(expectedGelieEklendiText,actualGelirEklendiText);
    }



}

