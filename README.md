

# Projekti Laivanupotus

Laivanupotuksessa käyttäjä pyrkii löytämään kaikki kartalle piilotetut laivat saaden tehdä 
vain rajatun määrän vääriä arvauksia.

sovellus tarjoaa kolme vaikeutta, käyttäjien voittojen seurannan ja ennätyslistat kullekkin vaikeus asteelle.

laivojen muotoja on kolme: suora kolmen ruudun pituinen, L:än muotoinen viiden ruudun pituinen ja U:n muotoinen seitsemän
ruudun pituinen. 

## Dokumentaatio

[vaatimusmäärittely](Battleships/Dokumentaatio/vaatimusmaarittely.md)

[arkkitehtuurikuvaus](Battleships/Dokumentaatio/arkkitehtuuri.md)

[käyttöohje](Battleships/Dokumentaatio/käyttöohje.md)

[tuntikirjanpito](Battleships/Dokumentaatio/tuntikirjanpito.md)

[testaus](Battleships/Dokumentaatio/testausdokumentti.md)

## Releaset

[release 3.0 (FINAL)](https://github.com/Radiant92/otm-harjoitustyo/releases/tag/viikko7)

[release 2.0 (VANHA)](https://github.com/Radiant92/otm-harjoitustyo/releases/tag/viikko6)

[release 1.0 (VANHA)](https://github.com/Radiant92/otm-harjoitustyo/releases/tag/viikko5)

# Komentorivitoiminnot

## Testaus

### Testit suoritetaan komennolla:

mvn test

### Testikattavuusraportti luodaan komennolla:

mvn jacoco:report

### raporttia voi lukea selaimella ja sen html löytyy hakemistosta:

target/site/jacoco/index.html

## Jarin generointi

### komennolla:

mvn package

### Jar tiedosto generoituu hakemistoon target:

Battleships-1.0-SNAPSHOT.jar

## JavaDoc

### Komento:

mvn javadoc:javadoc

### JavaDocin saa auki selaimessa ja sen html tiedosto löytyy:

target/site/apidocs/index.html

## Checkstyle

### Tiedostoon [checkstyle.xml](Battleships/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

mvn jxr:jxr checkstyle:checkstyle

### mahdolliset virheilmoitukset saa aiki selaimessa ja sen html tiedosto löytyy:

target/site/checkstyle.html
