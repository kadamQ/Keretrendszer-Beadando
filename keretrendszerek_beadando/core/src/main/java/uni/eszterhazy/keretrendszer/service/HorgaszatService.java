package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.model.Horgaszat;


import java.util.Collection;

public interface HorgaszatService {
    void addHorgaszat(Horgaszat horgaszat);
    Collection<Horgaszat> getAllHorgaszat();
    Horgaszat GetHorgaszatById(String id);
    void updateHorgaszat(Horgaszat horgaszat);
    void removeHorgaszat(Horgaszat horgaszat);
    //Collection<Horgaszat> readAllHorgaszatHely(String horgaszatHely);
    //double atlagHalDarab();
    //Map<Horgaszat,Double> atlagHalDarabHelyenként();
}
