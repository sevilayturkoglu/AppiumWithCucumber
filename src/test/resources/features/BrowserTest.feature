Feature: Kullanici Browser Testlerini Gerceklestirir
@wip
  Scenario: Kullanici Basarili bir sekilde Amazon Web sitesindeki gorevleri yerine getirir

    Given Kullanici "https://www.amazon.com" adresine
    Then Kullanici arama kutusunda "nutella" aratir

