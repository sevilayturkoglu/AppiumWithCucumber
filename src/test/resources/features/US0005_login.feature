Background: Kullanicilar bu adimlar sayesinde ayni adimlari yazmalarina gerek kalmadan before mantiginda backrounda da calistirir
Given Kullanici browseri acar adresine
Then Kullanici "https://qa.mealscenter.com/" adresine
Then Kullanici cokkies 406 1654 i kabul eder
Then Uc cizgi butonuna tiklar
Then Kullanici SignIn butonuna tiklar

Scenario: "Sign in" linkine tiklayinca login sayfasina yonlendirilmeli
Given Kullanici login sayfasina yonlendirildigini dogrular
And Kullanici sayfayi kapatir

Scenario:Gecerli email ve password ile login olabilmeli, basarili giris yapildiginde header sag ustte kullanici adı gorulmelidir
Given Kullanici emailBox a "mailMeal" passwordbox a bir "sifre" gonderir
Then  Kullanici giris islemini dogrular
And  Kullanici sayfayi kapatir

Scenario Outline: Kullanici gecersiz mail ve sifre bilgileriyle giris yapmamalidir
Given  Kullanici emailBox a "<mailMeal>" passwordbox a bir "<sifre>" gonderir
And  Kullanici sayfayi kapatir
Examples:
| mailMeal |sifre |
| olumsuzmail1 |olumsuzsifre1|
| olumsuzmail2 |olumsuzsifre2|
| olumsuzmail3 |olumsuzsifre3|
