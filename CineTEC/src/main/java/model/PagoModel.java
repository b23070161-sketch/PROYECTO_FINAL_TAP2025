package model;

public class PagoModel {
    private int idPago;
    private int idReserva;
    private String tipoPago;
    private String titularTarjeta;
    private String digitos4;
    private java.time.LocalDateTime fechaPago;


    public int getIdPago() { return idPago; }
    public void setIdPago(int idPago) { this.idPago = idPago; }
    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }
    public String getTipoPago() { return tipoPago; }
    public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }
    public String getTitularTarjeta() { return titularTarjeta; }
    public void setTitularTarjeta(String titularTarjeta) { this.titularTarjeta = titularTarjeta; }
    public String getDigitos4() { return digitos4; }
    public void setDigitos4(String digitos4) { this.digitos4 = digitos4; }
    public java.time.LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(java.time.LocalDateTime fechaPago) { this.fechaPago = fechaPago; }
}
