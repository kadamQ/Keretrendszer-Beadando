package uni.eszterhazy.keretrendszer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

public class Hal {
    private int id;
    private String nev;
    @JsonIgnore
    private Collection<Fogas> fogasok;

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

    public Collection<Fogas> getFogasok() {
        return fogasok;
    }

    public void setFogasok(Collection<Fogas> fogasok) {
        this.fogasok = fogasok;
    }

    @Override
    public String toString() {
        return nev;
    }
}
