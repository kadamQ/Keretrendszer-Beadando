package uni.eszterhazy.keretrendszer.dao;
import uni.eszterhazy.keretrendszer.exception.*;
import uni.eszterhazy.keretrendszer.model.Fogas;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
import uni.eszterhazy.keretrendszer.model.Sor;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

public interface HorgaszatDAO {
    void createHorgaszat(Horgaszat horgaszat) throws HorgaszatAlreadyAdded;
    Collection<Horgaszat> readAllHorgaszat();
    Horgaszat readHorgaszat(String id) throws HorgaszatNotFound;
    void updateHorgaszat(String id, String horgaszatHely, LocalDate horgaszatDatum, int horgaszDarab, int halDarab, Collection<Fogas> fogasok, Sor sor) throws HorgaszatNotFound, HorgaszatHelyNemlehetUres, HorgaszatDatumNemLehetAJovoben, HorgaszDarabNemLehetKisebbMint1, HalDarabNemLehetKisebbMint0;
    void deleteHorgaszat(Horgaszat horgaszat) throws HorgaszatNotFound;
    void addFogas(Fogas fogas, String id) throws HorgaszatNotFound;
    void deleteFogas(int id, String horgaszatId) throws HorgaszatNotFound;
    void addSor(Sor sor);
    Collection<Horgaszat> findAllBetweenKetDatum(LocalDate start, LocalDate end);
    }
