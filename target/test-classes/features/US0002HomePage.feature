Feature: Bir ziyaretci olarak headr kismindaki fonnksiyonlar erisilebilir olmalidir

  Background: Kullanicilar bu adimlar sayesinde ayni adimlari yazmalarina gerek kalmadan before mantiginda backrounda da calistirir
    Given Kullanici browseri acar adresine
    Then Kullanici "https://qa.mealscenter.com/" adresine


  Scenario: "Sign in"butonu gorunur oldugu dogrulanmali
    Given Uc cizgi butonuna tiklar
    Then Sign in butonun gorulebilir oldugunu dogrular
    And Kullanici sayfayi kapatir



  Scenario: header kismindaki logonun gorulebilir oldugu dogulanmali
    Given Kullanici header kisminda bulunan logonun gorulebilir oldugunu dogrular
    And Kullanici sayfayi kapatir
