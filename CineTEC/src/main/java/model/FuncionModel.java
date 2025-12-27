package model;

public class FuncionModel {
    private int idFuncion;
    private int idSala;
    private int idPelicula;
    private java.time.LocalDate fechaFuncion;
    private java.time.LocalTime horaFuncion;
    private java.math.BigDecimal precioAdulto;
    private java.math.BigDecimal precioNino;
    private java.math.BigDecimal precioEstudiante;
    private int creadoPor;


    public int getIdFuncion() { return idFuncion; }
    public void setIdFuncion(int idFuncion) { this.idFuncion = idFuncion; }
    public int getIdSala() { return idSala; }
    public void setIdSala(int idSala) { this.idSala = idSala; }
    public int getIdPelicula() { return idPelicula; }
    public void setIdPelicula(int idPelicula) { this.idPelicula = idPelicula; }
    public java.time.LocalDate getFechaFuncion() { return fechaFuncion; }
    public void setFechaFuncion(java.time.LocalDate fechaFuncion) { this.fechaFuncion = fechaFuncion; }
    public java.time.LocalTime getHoraFuncion() { return horaFuncion; }
    public void setHoraFuncion(java.time.LocalTime horaFuncion) { this.horaFuncion = horaFuncion; }
    public java.math.BigDecimal getPrecioAdulto() { return precioAdulto; }
    public void setPrecioAdulto(java.math.BigDecimal precioAdulto) { this.precioAdulto = precioAdulto; }
    public java.math.BigDecimal getPrecioNino() { return precioNino; }
    public void setPrecioNino(java.math.BigDecimal precioNino) { this.precioNino = precioNino; }
    public java.math.BigDecimal getPrecioEstudiante() { return precioEstudiante; }
    public void setPrecioEstudiante(java.math.BigDecimal precioEstudiante) { this.precioEstudiante = precioEstudiante; }
    public int getCreadoPor() { return creadoPor; }
    public void setCreadoPor(int creadoPor) { this.creadoPor = creadoPor; }
}