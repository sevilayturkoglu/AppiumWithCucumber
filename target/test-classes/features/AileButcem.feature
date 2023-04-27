Feature:Aile butcem login page




  Scenario Outline:Kullanici aile butcesi uygulamasina basarili sekilde giris yapar

    Given Kullanici kurulumlari tamamlar
    Then ilk ekran ayarlarini yapar "Giriş Yap" tiklar ve ardindan login sayfasina ulasin
    Then "mail" ve "password" bilgilerini girerek kullanici bilgileriyle "Giriş Yap" tiklanir
    Then uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin
    Then sol kisimdaki menuden "Hesabım" bolumune gidin
    Then hesabim sayfasindaki "<name>" "<surname>" "<city>" "<age>" "<jobTitle>" "<Cinsiyetim>" bilgileri degistirerek degisikleri kaydedin
    And ardindan degisiklerin yapildigini dogrulayin

    Examples:
      | name   | surname | city   | age | jobTitle | Cinsiyetim |
      | Derya | Reyhan  | Ankara | 32  | QA       | Kadın      |


  Scenario Outline:

    Given Kullanici kurulumlari tamamlar
    Then ilk ekran ayarlarini yapar "Giriş Yap" tiklar ve ardindan login sayfasina ulasin
    Then "mail" ve "password" bilgilerini girerek kullanici bilgileriyle "Giriş Yap" tiklanir
    Then uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin
    Then anasayfadaki arti butonuna tiklayin
    Then gelir ekle bolumune tiklayin
    Then "<aciklama>" "<gelirTip>" "<kategori>" "<tutari>" belirleyin ve kaydedin
    And basariyla eklendigini dogrulayin

    Examples:
      | aciklama    | gelirTip | kategori    | tutari |
      | Total Gelir | Düzensiz  | Maaş Geliri | USD    |