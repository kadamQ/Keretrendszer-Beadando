package uni.eszterhazy.keretrendszer.dao;
import uni.eszterhazy.keretrendszer.model.Fogas;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
import uni.eszterhazy.keretrendszer.exception.HorgaszatAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.HorgaszatNotFound;
import uni.eszterhazy.keretrendszer.model.Sor;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

public interface HorgaszatDAO {
    void createHorgaszat(Horgaszat horgaszat) throws HorgaszatAlreadyAdded;
    Collection<Horgaszat> readAllHorgaszat();
    Horgaszat readHorgaszat(String id) throws HorgaszatNotFound;
    void updateHorgaszat(Horgaszat horgaszat);
    void deleteHorgaszat(Horgaszat horgaszat);
    void addFogas(Fogas fogas, String id);
    void deleteFogas(int id, String horgaszatId);
    void addSor(Sor sor);
    Collection<Horgaszat> findAllBetweenKetDatum(LocalDate start, LocalDate end);
    }
