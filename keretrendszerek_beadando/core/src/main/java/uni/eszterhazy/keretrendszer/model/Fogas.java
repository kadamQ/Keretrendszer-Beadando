package uni.eszterhazy.keretrendszer.model;

import java.util.UUID;

public class Fogas {
    private String id;
    private Hal hal;
    private double tomeg;
    private Horgaszbot horgaszbot;
    private Csali csali;

    public Fogas() {
        this.id = UUID.randomUUID().toString();
    }

    public Fogas(Hal hal, double tomeg, Horgaszbot horgaszbot, Csali csali) {
        this.hal = hal;
        this.tomeg = tomeg;
        this.horgaszbot = horgaszbot;
        this.csali = csali;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Hal getHal() {
        return hal;
    }

    public void setHal(Hal hal) {
        this.hal = hal;
    }

    public double getTomeg() {
        return tomeg;
    }

    public void setTomeg(double tomeg) {
        this.tomeg = tomeg;
    }

    public Horgaszbot getHorgaszbot() {
        return horgaszbot;
    }

    public void setHorgaszbot(Horgaszbot horgaszbot) {
        this.horgaszbot = horgaszbot;
    }

    public Csali getCsali() {
        return csali;
    }

    public void setCsali(Csali csali) {
        this.csali = csali;
    }
}
