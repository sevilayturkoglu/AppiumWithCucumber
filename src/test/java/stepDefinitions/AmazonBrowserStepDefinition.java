package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.BrowserPage.AmazonPage;
import utils.BrowserDriver;


public class AmazonBrowserStepDefinition {
AmazonPage amazonPage=new AmazonPage();


@Given("Kullanici arama kutusunda {string} aratir")
    public void kullanici_arama_kutusunda_aratir(String aranacakKelime) {
        amazonPage.amazonAramaKutusu.sendKeys(aranacakKelime+Keys.ENTER);
    }
    }

