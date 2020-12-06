package uni.eszterhazy.keretrendszer.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Datum {
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate start;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate end;

    public Datum() {
    }

    public Datum(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
