package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(100);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void kortinSaldoOnAlussaOikein() {
        assertTrue(kortti.saldo() == 100);
    }

    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(20);
        assertTrue(kortti.saldo() == 120);
    }

    @Test
    public void rahanOttaminenToimiiKunTarpeeksi() {
        kortti.otaRahaa(90);
        assertTrue(kortti.saldo() == 10);
    }

    @Test
    public void saldoEiMuutuJosRahatEiRiita() {
        kortti.otaRahaa(110);
        assertTrue(kortti.saldo() == 100);

    }
    @Test
    public void voiNostaaTasaRahan(){
        kortti.otaRahaa(100);
        assertTrue(kortti.saldo()==0);
    }

    @Test
    public void metodiPalauttaaTrueJosRahatRiittaa() {
        assertTrue(kortti.otaRahaa(10) == true);
    }

    @Test
    public void metodiPalauttaaFalseJosRahatEiRiita() {
        assertTrue(kortti.otaRahaa(120) == false);
    }
    @Test public void toStringMetodiToimii(){
        assertEquals("saldo: 1.0", kortti.toString());
    }
    @Test public void sentitMuuntuuOikein(){
        kortti.otaRahaa(95);
        assertEquals("saldo: 0.05", kortti.toString());
    }
}
