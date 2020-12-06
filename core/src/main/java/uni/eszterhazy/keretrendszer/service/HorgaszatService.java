package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.exception.HorgaszatAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.HorgaszatNotFound;
import uni.eszterhazy.keretrendszer.model.Fogas;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
import uni.eszterhazy.keretrendszer.model.Sor;


import java.time.LocalDate;
import java.util.Collection;

public interface HorgaszatService {
    void addHorgaszat(Horgaszat horgaszat) throws HorgaszatAlreadyAdded;
    Collection<Horgaszat> getAllHorgaszat();
    Horgaszat getHorgaszatById(String id) throws HorgaszatNotFound;
    void updateHorgaszat(Horgaszat horgaszat);
    void deleteHorgaszat(Horgaszat horgaszat) throws HorgaszatNotFound;
    void addFogas(Fogas fogas, String horgaszatId) throws HorgaszatNotFound;
    void deleteFogas(int id, String horgaszatId) throws HorgaszatNotFound;
    void addSor(Sor sor);
    Collection<Horgaszat> findAllBetweenKetDatum(LocalDate start, LocalDate end);
}
