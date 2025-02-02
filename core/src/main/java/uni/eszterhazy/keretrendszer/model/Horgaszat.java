package uni.eszterhazy.keretrendszer.model;

import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import uni.eszterhazy.keretrendszer.exception.HalDarabNemLehetKisebbMint0;
import uni.eszterhazy.keretrendszer.exception.HorgaszDarabNemLehetKisebbMint1;
import uni.eszterhazy.keretrendszer.exception.HorgaszatDatumNemLehetAJovoben;
import uni.eszterhazy.keretrendszer.exception.HorgaszatHelyNemlehetUres;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.UUID;

public class Horgaszat {
    private String id;
    private String horgaszatHely;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate horgaszatDatum;
    private int horgaszDarab;
    private int halDarab;
    private Collection<Fogas> fogasok;
    private Sor sor;

    Logger logger = Logger.getLogger(this.getClass());

    public Horgaszat(){
        this.id = UUID.randomUUID().toString();
        logger.warn("uj horgaszat lett letrehozva a "+this.id+"azonositoval!");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHorgaszatHely() {
        return horgaszatHely;
    }

    public void setHorgaszatHely(String horgaszatHely) throws HorgaszatHelyNemlehetUres {
        if(horgaszatHely.trim().length()==0){
            throw new HorgaszatHelyNemlehetUres();
        }
        this.horgaszatHely = horgaszatHely;
    }

    public LocalDate getHorgaszatDatum() {
        return horgaszatDatum;
    }

    public void setHorgaszatDatum(@DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate horgaszatDatum) throws HorgaszatDatumNemLehetAJovoben {
        if(horgaszatDatum.isAfter(LocalDate.now())){
            throw new HorgaszatDatumNemLehetAJovoben("A dátum nem lehet későbbi a mai dátumnál: "+LocalDate.now().toString()+"!");
        }
        this.horgaszatDatum = horgaszatDatum;
    }

    public int getHorgaszDarab() {
        return horgaszDarab;
    }

    public void setHorgaszDarab(int horgaszDarab) throws HorgaszDarabNemLehetKisebbMint1 {
        if(horgaszDarab < 1){
            throw new HorgaszDarabNemLehetKisebbMint1();
        }
        this.horgaszDarab = horgaszDarab;
    }

    public int getHalDarab() {
        return halDarab;
    }

    public void setHalDarab(int halDarab) throws HalDarabNemLehetKisebbMint0 {
        if(halDarab < 0){
            throw new HalDarabNemLehetKisebbMint0();
        }
        this.halDarab = halDarab;
    }

    public Collection<Fogas> getFogasok() {
        return fogasok;
    }

    public void setFogasok(Collection<Fogas> fogasok) {
        this.fogasok = fogasok;
    }

    public Sor getSor() {
        return sor;
    }

    public void setSor(Sor sor) {
        this.sor = sor;
    }

    @Override
    public String toString() {
        return "Horgaszat{" +
                "id='" + id + '\'' +
                ", horgaszatHely='" + horgaszatHely + '\'' +
                ", horgaszatDatum=" + horgaszatDatum +
                ", horgaszDarab=" + horgaszDarab +
                ", halDarab=" + halDarab +
                ", fogasok=" + fogasok +
                ", sor=" + sor +
                '}';
    }
}
