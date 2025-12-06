package model;

public class AsientoModel {
    private int idAsiento;
    private int idSala;
    private String fila;
    private String codigo;

    public AsientoModel(int idAsiento, int idSala, String fila, String codigo) {
        this.idAsiento = idAsiento;
        this.idSala = idSala;
        this.fila = fila;
        this.codigo = codigo;
    }

    public int getIdAsiento() { return idAsiento; }
    public void setIdAsiento(int idAsiento) { this.idAsiento = idAsiento; }
    public int getIdSala() { return idSala; }
    public void setIdSala(int idSala) { this.idSala = idSala; }
    public String getFila() { return fila; }
    public void setFila(String fila) { this.fila = fila; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
}