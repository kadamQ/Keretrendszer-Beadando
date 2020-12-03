package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.exception.HorgaszatAlreadyAdded;
import uni.eszterhazy.keretrendszer.model.Horgaszat;


import java.util.Collection;

public interface HorgaszatService {
    void addHorgaszat(Horgaszat horgaszat) throws HorgaszatAlreadyAdded;
    Collection<Horgaszat> getAllHorgaszat();
    Horgaszat getHorgaszatById(String id);
    void updateHorgaszat(Horgaszat horgaszat);
    void removeHorgaszat(Horgaszat horgaszat);
    //Collection<Horgaszat> readAllHorgaszatHely(String horgaszatHely);
    //double atlagHalDarab();
    //Map<Horgaszat,Double> atlagHalDarabHelyenként();
}
