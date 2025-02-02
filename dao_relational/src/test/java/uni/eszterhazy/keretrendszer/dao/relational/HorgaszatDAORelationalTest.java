package uni.eszterhazy.keretrendszer.dao.relational;

import org.junit.Test;
import uni.eszterhazy.keretrendszer.dao.HorgaszatDAO;
import uni.eszterhazy.keretrendszer.exception.*;
import uni.eszterhazy.keretrendszer.model.Fogas;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
import uni.eszterhazy.keretrendszer.model.Hal;
import uni.eszterhazy.keretrendszer.model.Horgaszbot;
import uni.eszterhazy.keretrendszer.model.Csali;
import uni.eszterhazy.keretrendszer.model.Sor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HorgaszatDAORelationalTest {

    @Test
    public void test() throws HorgaszatHelyNemlehetUres, HalDarabNemLehetKisebbMint0, HorgaszatDatumNemLehetAJovoben, HorgaszDarabNemLehetKisebbMint1 {
        HorgaszatDAO dao = new HorgaszatDAORelational();
        Horgaszat horgaszat = new Horgaszat();
//        horgaszat.setHorgaszatHely("Eldorádó Horgásztó");
//        horgaszat.setHorgaszatDatum(LocalDate.of(2020, 11, 5));
//        horgaszat.setHorgaszDarab(3);
//        horgaszat.setHalDarab(5);
//        Sor sor = new Sor("heineken", 4);
//        sor.setHorgaszat(horgaszat);
//        horgaszat.setSor(sor);
//        Hal hal = new Hal("keszeg");
//        Fogas f = new Fogas(hal, 3.3, Horgaszbot.GYURUNELKULI, Csali.EGYEB);
//        Fogas f1 = new Fogas(hal, 2.2, Horgaszbot.FENEKEZO, Csali.ELO);
//        List fogasok = new ArrayList<>();
//        fogasok.add(f);
//        fogasok.add(f1);
//        horgaszat.setFogasok(fogasok);
//        try {
//            dao.createHorgaszat(horgaszat);
//        } catch (HorgaszatAlreadyAdded horgaszatAlreadyAdded) {
//            horgaszatAlreadyAdded.printStackTrace();
//        }
//        System.out.println(dao.readAllHorgaszat());
//
//
        Collection<Horgaszat> horgaszatok =
        dao.findAllBetweenKetDatum(LocalDate.of(2020, 11, 3),LocalDate.of(2020, 11, 10));
        System.out.println(horgaszatok);
    }
}