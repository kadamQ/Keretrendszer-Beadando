package uni.eszterhazy.keretrendszer.dao.mongo;

import com.mongodb.*;
import uni.eszterhazy.keretrendszer.dao.HorgaszatDAO;
import uni.eszterhazy.keretrendszer.exception.HorgaszatAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.HorgaszatNotFound;
import uni.eszterhazy.keretrendszer.model.Fogas;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
import uni.eszterhazy.keretrendszer.model.Sor;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;

public class HorgaszatDAOMongo implements HorgaszatDAO{
    private MongoClient client;
    private DB db;
    private DBCollection collection;

    public HorgaszatDAOMongo(String uri, String database, String collection) throws UnknownHostException {
        this.client = new MongoClient(new MongoClientURI(uri));
        this.db = client.getDB(database);
        this.collection = db.getCollection(collection);
    }

    public void createHorgaszat(Horgaszat horgaszat) throws HorgaszatAlreadyAdded {
        try {
            readHorgaszat(horgaszat.getId());
        } catch (HorgaszatNotFound dolgozoNotFound) {
            collection.insert(HorgaszatAdapter.horgaszatToDBObject(horgaszat));
            return;
        }
        throw new HorgaszatAlreadyAdded(horgaszat.getId());
    }

    public Collection<Horgaszat> readAllHorgaszat() {
        DBCursor cursor = collection.find(new BasicDBObject(), new BasicDBObject().append("_id",0));
        Collection<Horgaszat> result = new ArrayList<>();
        cursor.forEach(o->{
            result.add(HorgaszatAdapter.dbObjectToHorgaszat(o));
        });
        return result ;
    }

    public Horgaszat readHorgaszat(String id) throws HorgaszatNotFound {
        DBCursor cursor = collection.find(new BasicDBObject().append("id",id), new BasicDBObject().append("_id",0));
        if(cursor.length()==0){
            throw new HorgaszatNotFound(id);
        }
        return HorgaszatAdapter.dbObjectToHorgaszat(cursor.one());
    }

    public void updateHorgaszat(Horgaszat horgaszat) {

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
}