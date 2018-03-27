/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author strohm
 */
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @Test
    public void alussaRahaOikein() {
        assertTrue(kassa.kassassaRahaa() == 100000);
        
    }
    
    @Test
    public void alussaEdullisiaMyytyNolla() {
        assertTrue(kassa.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void alussaMaukkaitaMyytyNolla() {
        assertTrue(kassa.maukkaitaLounaitaMyyty() == 0);
    }
    
    @Test
    public void kateisOstoEdullinenNostaaKassaa() {
        kassa.syoEdullisesti(500);
        assertTrue(kassa.kassassaRahaa() == 100240);
        
    }
    
    @Test
    public void kateisOstoEdullinenPalauttaaOikein() {
        assertTrue(kassa.syoEdullisesti(500) == 260);
    }
    
    @Test
    public void kateisOstoEdullinenJosMaksuOkMyytyjenLounaidenMaaraKasvaa() {
        kassa.syoEdullisesti(240);
        assertTrue(kassa.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void kateisOstoEdullinenJosEiVaraaNiinLounaitaMyytyEiKasva() {
        kassa.syoEdullisesti(230);
        assertTrue(kassa.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void kateisOstoEdullinenJosRahatEiRiitaKaikkiPalautetaan() {
        assertTrue(kassa.syoEdullisesti(239) == 239);
    }
    
    @Test
    public void kateisOstoMaukasNostaaKassaa() {
        kassa.syoMaukkaasti(500);
        assertTrue(kassa.kassassaRahaa() == 100400);
        
    }
    
    @Test
    public void kateisOstoMaukasPalauttaaOikein() {
        assertTrue(kassa.syoMaukkaasti(500) == 100);
    }
    
    @Test
    public void kateisOstoMaukasJosMaksuOkMyytyjenLounaidenMaaraKasvaa() {
        kassa.syoMaukkaasti(400);
        assertTrue(kassa.maukkaitaLounaitaMyyty() == 1);
    }
    
    @Test
    public void kateisOstoMaukasJosEiVaraaNiinLounaitaMyytyEiKasva() {
        kassa.syoMaukkaasti(390);
        assertTrue(kassa.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void kateisOstoMaukasJosRahatEiRiitaKaikkiPalautetaan() {
        assertTrue(kassa.syoMaukkaasti(390) == 390);
    }
    
    @Test
    public void korttiOstoPalauttaaTrueEdullisellaJosRahatRiittavat() {
        assertTrue(kassa.syoEdullisesti(kortti) == true);
    }
    
    @Test
    public void korttiOstoPalauttaaFalseEdullisellaJosRahatEiRiita() {
        kortti.otaRahaa(900);
        assertTrue(kassa.syoEdullisesti(kortti) == false);
        
    }
    
    @Test
    public void kortinSaldoVaheneeKunEdullinenMyydaan() {
        kassa.syoEdullisesti(kortti);
        assertTrue(kortti.saldo() == 760);
    }
    
    public void kortinSaldoEiMuutuKunRahatEiRiitaEdulliseen() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        kassa.syoEdullisesti(kortti);
        assertTrue(kortti.saldo() == 100);
    }
    
    @Test
    public void korttiOstoKasvattaaMyytyjaEdullisia() {
        kassa.syoEdullisesti(kortti);
        assertTrue(kassa.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void korttiOstoEiKasvataMyytyjaEdullisiaJosRahatEiRiita() {
        Maksukortti kortti2 = new Maksukortti(200);
        kassa.syoEdullisesti(kortti2);
        assertTrue(kassa.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void korttiOstoPalauttaaTrueMaukkaallaJosRahatRiittavat() {
        assertTrue(kassa.syoMaukkaasti(kortti) == true);
    }
    
    @Test
    public void korttiOstoPalauttaaFalseMaukkaallaJosRahatEiRiita() {
        kortti.otaRahaa(900);
        assertTrue(kassa.syoMaukkaasti(kortti) == false);
        
    }
    
    @Test
    public void kortinSaldoVaheneeKunMaukasMyydaan() {
        kassa.syoMaukkaasti(kortti);
        assertTrue(kortti.saldo() == 600);
    }
    
    public void kortinSaldoEiMuutuKunRahatEiRiitaMaukkaaseen() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        
        kassa.syoMaukkaasti(kortti);
        assertTrue(kortti.saldo() == 200);
    }
    
    @Test
    public void korttiOstoKasvattaaMyytyjaMaukkaita() {
        kassa.syoMaukkaasti(kortti);
        assertTrue(kassa.maukkaitaLounaitaMyyty() == 1);
    }
    
    @Test
    public void korttiOstoEiKasvataMyytyjaMaukkaitaJosRahatEiRiita() {
        Maksukortti kortti2 = new Maksukortti(200);
        kassa.syoMaukkaasti(kortti2);
        assertTrue(kassa.maukkaitaLounaitaMyyty() == 0);
    }

    @Test
    public void korttiMyyntiEiMuutaKassanRahoja() {
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertTrue(kassa.kassassaRahaa() == 100000);
    }

    @Test
    public void kortilleVoiLadataRahaa() {
        kassa.lataaRahaaKortille(kortti, 10);
        assertTrue(kortti.saldo() == 1010);
    }

    @Test
    public void kortilleEiVoiLadataNegatiivistaSummaa() {
        kassa.lataaRahaaKortille(kortti, -500);
        assertTrue(kortti.saldo() == 1000);
    }
}
