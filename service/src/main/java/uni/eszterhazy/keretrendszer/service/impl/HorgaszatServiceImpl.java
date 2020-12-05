package uni.eszterhazy.keretrendszer.service.impl;

import org.apache.log4j.Logger;
import uni.eszterhazy.keretrendszer.dao.HorgaszatDAO;
import uni.eszterhazy.keretrendszer.exception.HorgaszatNotFound;
import uni.eszterhazy.keretrendszer.model.Fogas;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
import uni.eszterhazy.keretrendszer.model.Sor;
import uni.eszterhazy.keretrendszer.service.HorgaszatService;
import uni.eszterhazy.keretrendszer.exception.HorgaszatAlreadyAdded;

import java.util.Collection;
public class HorgaszatServiceImpl implements HorgaszatService {
    Logger logger = Logger.getLogger(this.getClass());
    private HorgaszatDAO dao;

    public HorgaszatServiceImpl(HorgaszatDAO dao) {
        this.dao = dao;
    }
    @Override
    public void addHorgaszat(Horgaszat horgaszat) throws HorgaszatAlreadyAdded {
        dao.createHorgaszat(horgaszat);
    }
    @Override
    public Collection<Horgaszat> getAllHorgaszat() {
        Collection<Horgaszat> result = dao.readAllHorgaszat();
        logger.warn("Az adatbazisban "+result.size()+" horgaszat van felveve");
        return result;
    }
    @Override
    public Horgaszat getHorgaszatById(String id) throws HorgaszatNotFound {
            return dao.readHorgaszat(id);
    }

    @Override
    public void updateHorgaszat(Horgaszat horgaszat) {

    }
    @Override
    public void deleteHorgaszat(Horgaszat horgaszat) {
        dao.deleteHorgaszat(horgaszat);
    }
    @Override
    public void addFogas(Fogas fogas, String horgaszatId){
        dao.addFogas(fogas, horgaszatId);
    }

    @Override
    public void deleteFogas(int id, String horgaszatId){
        dao.deleteFogas(id,horgaszatId);
    }

    @Override
    public void addSor(Sor sor) {
        dao.addSor(sor);
    }
}
