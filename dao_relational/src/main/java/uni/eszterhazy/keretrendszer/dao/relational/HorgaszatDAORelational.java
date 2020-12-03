package uni.eszterhazy.keretrendszer.dao.relational;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import uni.eszterhazy.keretrendszer.dao.HorgaszatDAO;
import uni.eszterhazy.keretrendszer.model.Horgaszat;

import java.util.Collection;

public class HorgaszatDAORelational implements HorgaszatDAO {
    private static SessionFactory factory;

    public HorgaszatDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void createHorgaszat(Horgaszat horgaszat) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(horgaszat);
        tx.commit();
        session.close();
    }

    @Override
    public Collection<Horgaszat> readAllHorgaszat() {
        Session session = factory.openSession();
        Collection<Horgaszat> result = session.createQuery("FROM Horgaszat").list();
        return result;
    }

    @Override
    public Horgaszat readHorgaszat(String id) {
        Session session= factory.openSession();
        Horgaszat result = session.get(Horgaszat.class, id);
        return result;
    }

    @Override
    public void updateHorgaszat(Horgaszat horgaszat) {

    }

    @Override
    public void deleteHorgaszat(Horgaszat horgaszat) {

    }
}

