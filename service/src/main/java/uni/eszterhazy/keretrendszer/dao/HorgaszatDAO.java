package uni.eszterhazy.keretrendszer.dao;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
import uni.eszterhazy.keretrendszer.exception.HorgaszatAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.HorgaszatNotFound;

import java.util.Collection;

public interface HorgaszatDAO {
    void createHorgaszat(Horgaszat horgaszat) throws HorgaszatAlreadyAdded;
    Collection<Horgaszat> readAllHorgaszat();
    Horgaszat readHorgaszat(String id) throws HorgaszatNotFound;
    void updateHorgaszat(Horgaszat horgaszat);
    void deleteHorgaszat(Horgaszat horgaszat);
}
