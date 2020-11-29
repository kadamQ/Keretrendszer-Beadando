package uni.eszterhazy.keretrendszer.model;

public class Sor {
    private int id;
    private String nev;
    private int darab;

    public Sor() {
    }

    public Sor(String nev, int darab) {
        this.nev = nev;
        this.darab = darab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
