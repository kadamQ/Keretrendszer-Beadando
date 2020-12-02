package uni.eszterhazy.keretrendszer.dao.mongo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import uni.eszterhazy.keretrendszer.model.Horgaszat;

import java.io.IOException;

public class HorgaszatAdapter {
    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public static Horgaszat dbObjectToHorgaszat(DBObject horgaszat){
        try {
            Horgaszat obj = mapper.readValue(horgaszat.toString(),Horgaszat.class);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    public static DBObject horgaszatToDBObject(Horgaszat horgaszat){
        String horgaszatString= "";
        try {
            horgaszatString = mapper.writeValueAsString(horgaszat);
            BasicDBObject obj = mapper.readValue(horgaszatString, BasicDBObject.class);
            return obj;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BasicDBObject();
    }
}