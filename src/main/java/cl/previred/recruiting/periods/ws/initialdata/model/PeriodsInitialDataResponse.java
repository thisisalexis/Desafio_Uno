package cl.previred.recruiting.periods.ws.initialdata.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public class PeriodsInitialDataResponse {
    private BigInteger id;
    private LocalDate fechaCreacion;
    private LocalDate fechaFin;
    private List<LocalDate> fechas;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<LocalDate> getFechas() {
        return fechas;
    }

    public void setFechas(List<LocalDate> fechas) {
        this.fechas = fechas;
    }
}
