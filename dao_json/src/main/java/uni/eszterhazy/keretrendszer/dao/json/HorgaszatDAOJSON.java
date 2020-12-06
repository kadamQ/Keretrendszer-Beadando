package uni.eszterhazy.keretrendszer.dao.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import uni.eszterhazy.keretrendszer.dao.HorgaszatDAO;
import uni.eszterhazy.keretrendszer.exception.*;
import uni.eszterhazy.keretrendszer.model.Fogas;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
import uni.eszterhazy.keretrendszer.model.Sor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class HorgaszatDAOJSON implements HorgaszatDAO {
    File jsonFile;
    ObjectMapper mapper;

    public HorgaszatDAOJSON(String jsonFilePath) throws IOException {
        jsonFile = new File(jsonFilePath);
        if(!jsonFile.exists()){
            jsonFile.createNewFile();
            FileWriter writer = new FileWriter(jsonFile);
            writer.write("[]");
            writer.flush();
            writer.close();
        }
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

    }

    public void createHorgaszat(Horgaszat horgaszat) throws HorgaszatAlreadyAdded {
        Collection<Horgaszat> horgaszatok = readAllHorgaszat();

        Horgaszat result = null;
        try {
            result = readHorgaszat(horgaszat.getId());
        } catch (HorgaszatNotFound horgaszatNotFound) {
            horgaszatok.add(horgaszat);
            try {
                mapper.writeValue(jsonFile, horgaszatok);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new HorgaszatAlreadyAdded(horgaszat.getId());
    }

    public Collection<Horgaszat> readAllHorgaszat() {
        Collection<Horgaszat> horgaszatok = new ArrayList<Horgaszat>();
        TypeReference type = new TypeReference<ArrayList<Horgaszat>>() {};
        try {
            horgaszatok = mapper.readValue(jsonFile, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return horgaszatok;
    }

    public Horgaszat readHorgaszat(String id) throws HorgaszatNotFound {
        Collection<Horgaszat> horgaszatok = readAllHorgaszat();
        for(Horgaszat h: horgaszatok){
            if(h.getId().equalsIgnoreCase(id)){
                return h;
            }
        }
        throw new HorgaszatNotFound(id);
    }

    @Override
    public void updateHorgaszat(String id, String horgaszatHely, LocalDate horgaszatDatum, int horgaszDarab, int halDarab, Collection<Fogas> fogasok, Sor sor) throws HorgaszatNotFound, HorgaszatHelyNemlehetUres, HorgaszatDatumNemLehetAJovoben, HorgaszDarabNemLehetKisebbMint1, HalDarabNemLehetKisebbMint0 {

    }

    public void deleteHorgaszat(Horgaszat horgaszat) {

    }

    public void addFogas(Fogas fogas, String id) {

    }

    public void deleteFogas(int id, String horgaszatId) {

    }

    @Override
    public void addSor(Sor sor) {

    }

    @Override
    public Collection<Horgaszat> findAllBetweenKetDatum(LocalDate start, LocalDate end) {
        return null;
    }
}
