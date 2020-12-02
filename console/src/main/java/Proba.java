import uni.eszterhazy.keretrendszer.dao.HorgaszatDAO;
import uni.eszterhazy.keretrendszer.dao.json.HorgaszatDAOJSON;
import uni.eszterhazy.keretrendszer.dao.relational.HorgaszatDAORelational;
import uni.eszterhazy.keretrendszer.exception.*;
import uni.eszterhazy.keretrendszer.model.*;
import uni.eszterhazy.keretrendszer.service.HorgaszatService;
import uni.eszterhazy.keretrendszer.service.impl.HorgaszatServiceImpl;

import java.io.IOException;
import java.time.LocalDate;

public class Proba {
    public static void main(String[] args) throws HorgaszatHelyNemlehetUres, HorgaszatDatumNemLehetAJovoben, HorgaszDarabNemLehetKisebbMint1, HalDarabNemLehetKisebbMint0, IOException {
        HorgaszatDAO dao = new HorgaszatDAOJSON("adatok.json");
        HorgaszatService service = new HorgaszatServiceImpl(dao);

        Horgaszat horgaszat = new Horgaszat();
        horgaszat.setHorgaszatHely("Eldorádó Horgásztó");
        horgaszat.setHorgaszatDatum(LocalDate.of(2020,11,5));
        horgaszat.setHorgaszDarab(3);
        horgaszat.setHalDarab(5);
        Sor sor = new Sor("aranyfacan",2);
        sor.setHorgaszat(horgaszat);
        horgaszat.setSor(sor);
        Hal hal = new Hal("keszeg");
        Fogas f = new Fogas(hal,4.5, Horgaszbot.FENEKEZO, Csali.EGYEB);
        Fogas f1 = new Fogas(hal,3.7,Horgaszbot.FENEKEZO, Csali.ELO);
        try {
            service.addHorgaszat(horgaszat);
        } catch (HorgaszatAlreadyAdded horgaszatAlreadyAdded) {
            horgaszatAlreadyAdded.printStackTrace();
        }
        System.out.println(service.getAllHorgaszat());

    }
}
