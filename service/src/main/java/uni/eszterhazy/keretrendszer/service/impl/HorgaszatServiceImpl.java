package uni.eszterhazy.keretrendszer.service.impl;

import org.apache.log4j.Logger;
import uni.eszterhazy.keretrendszer.dao.HorgaszatDAO;
import uni.eszterhazy.keretrendszer.exception.HorgaszatNotFound;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
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
    public Horgaszat getHorgaszatById(String id) {
        try {
            Horgaszat horgaszat = dao.readHorgaszat(id);
            return dao.readHorgaszat(id);
        } catch (HorgaszatNotFound horgaszatNotFound) {
            horgaszatNotFound.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateHorgaszat(Horgaszat horgaszat) {

    }
    @Override
    public void removeHorgaszat(Horgaszat horgaszat) {

    }
}
