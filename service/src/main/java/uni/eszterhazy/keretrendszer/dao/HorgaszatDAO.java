package uni.eszterhazy.keretrendszer.dao;
import uni.eszterhazy.keretrendszer.model.Horgaszat;

import java.util.Collection;

public interface HorgaszatDAO {
    void createHorgaszat(Horgaszat horgaszat);
    Collection<Horgaszat> readAllHorgaszat();
    Horgaszat readHorgaszat();
    void updateHorgaszat(Horgaszat horgaszat);
    void deleteHorgaszat(Horgaszat horgaszat);
}
