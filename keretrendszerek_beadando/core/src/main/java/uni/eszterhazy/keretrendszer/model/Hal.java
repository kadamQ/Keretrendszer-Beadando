package uni.eszterhazy.keretrendszer.model;

public class Hal {
    private int id;
    private String nev;

    public Hal() {
    }

    public Hal(String nev) {
        this.nev = nev;
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
}
