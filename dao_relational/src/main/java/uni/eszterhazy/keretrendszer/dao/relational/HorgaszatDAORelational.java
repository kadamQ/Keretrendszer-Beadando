package uni.eszterhazy.keretrendszer.dao.relational;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import uni.eszterhazy.keretrendszer.dao.HorgaszatDAO;
import uni.eszterhazy.keretrendszer.exception.HorgaszatAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.HorgaszatNotFound;
import uni.eszterhazy.keretrendszer.model.Fogas;
import uni.eszterhazy.keretrendszer.model.Horgaszat;
import uni.eszterhazy.keretrendszer.model.Sor;

import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class HorgaszatDAORelational implements HorgaszatDAO {
    private static SessionFactory factory;

    public HorgaszatDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void createHorgaszat(Horgaszat horgaszat) throws HorgaszatAlreadyAdded {
        try {
            readHorgaszat(horgaszat.getId());
        } catch (HorgaszatNotFound horgaszatNotFound) {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            Sor sor = horgaszat.getSor();
            sor.setHorgaszat(horgaszat);
            session.save(horgaszat);
            tx.commit();
            session.close();
            return;
        }
        throw new HorgaszatAlreadyAdded(horgaszat.getId());
    }

    @Override
    public Collection<Horgaszat> readAllHorgaszat() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Collection<Horgaszat> result = session.createQuery("FROM Horgaszat ORDER BY horgaszatDatum DESC").list();
        transaction.commit();
        session.close();
        return result;
    }

    @Override
    public Horgaszat readHorgaszat(String id) throws HorgaszatNotFound {
        Horgaszat horgaszat;
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        if (session.get(Horgaszat.class, id) == null) {
            session.close();
            throw new HorgaszatNotFound(id);
        } else {
            horgaszat = session.get(Horgaszat.class, id);
            transaction.commit();
            session.close();
            return horgaszat;
        }
    }

    @Override
    public void updateHorgaszat(Horgaszat horgaszat) {

    }

    @Override
    public void addFogas(Fogas fogas, String id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Horgaszat horgaszat = session.get(Horgaszat.class, id);
        List<Fogas> fogasok = (List<Fogas>) horgaszat.getFogasok();
        fogasok.add(fogas);
        horgaszat.setFogasok(fogasok);
        session.save(horgaszat);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteFogas(int id, String horgaszatId) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Fogas fogas = session.get(Fogas.class, id);
        Horgaszat horgaszat = session.get(Horgaszat.class, horgaszatId);
        List<Fogas> fogasok = (List<Fogas>) horgaszat.getFogasok();
        fogasok.remove(fogas);
        session.delete(fogas);
        transaction.commit();
        session.close();
    }

    @Override
    public void addSor(Sor sor) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(sor);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteHorgaszat(Horgaszat horgaszat) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(horgaszat);
        tx.commit();
        session.close();
    }

    @Override
    public Collection<Horgaszat> findAllBetweenKetDatum(LocalDate start, LocalDate end) {
        List<Horgaszat> result;
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        result = session.createQuery(
                "FROM Horgaszat AS horgaszat WHERE horgaszat.horgaszatDatum BETWEEN :start AND :end"
        ).setParameter("start", start)
                .setParameter("end", end)
                .list();
        transaction.commit();
        session.close();
        return result;
    }
}

