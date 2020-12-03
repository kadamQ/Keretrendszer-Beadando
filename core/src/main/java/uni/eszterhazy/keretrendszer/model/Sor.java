package uni.eszterhazy.keretrendszer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Sor {
    private String id;
    @JsonIgnore
    private Horgaszat horgaszat;
    private String nev;

    private int darab;

    public Sor() {
    }

    public Sor(String nev, int darab) {
        this.nev = nev;
        this.darab = darab;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getDarab() {
        return darab;
    }

    public void setDarab(int darab) {
        this.darab = darab;
    }

    public Horgaszat getHorgaszat() {
        return horgaszat;
    }

    public void setHorgaszat(Horgaszat horgaszat) {
        this.horgaszat = horgaszat;
    }

    @Override
    public String toString() {
        return "Sor{" +
                "id='" + id + '\'' +
                ", nev='" + nev + '\'' +
                ", darab=" + darab +
                '}';
    }
}
