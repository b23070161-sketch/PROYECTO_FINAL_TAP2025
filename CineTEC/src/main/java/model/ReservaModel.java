package model;

public class ReservaModel {
    private int idReserva;
    private int idUsuario;
    private int idFuncion;
    private int idAsiento;
    private java.time.LocalDateTime creadaEn;


    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public int getIdFuncion() { return idFuncion; }
    public void setIdFuncion(int idFuncion) { this.idFuncion = idFuncion; }
    public int getIdAsiento() { return idAsiento; }
    public void setIdAsiento(int idAsiento) { this.idAsiento = idAsiento; }
    public java.time.LocalDateTime getCreadaEn() { return creadaEn; }
    public void setCreadaEn(java.time.LocalDateTime creadaEn) { this.creadaEn = creadaEn; }
}
