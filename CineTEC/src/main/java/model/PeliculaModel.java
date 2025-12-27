package model;

public class PeliculaModel {
    private int idPelicula;
    private String tituloPelicula;
    private String descripcionPelicula;
    private String directorPelicula;
    private String productoraPelicula;
    private java.time.LocalDate fechaLanzamiento;
    private java.time.LocalDate fechaSalida;
    private String clasificacion;
    private Integer duracion;
    private String portada;
    private boolean activa = true;
    private int creadoPor;

    public int getIdPelicula() { return idPelicula; }
    public void setIdPelicula(int idPelicula) { this.idPelicula = idPelicula; }
    public String getTituloPelicula() { return tituloPelicula; }
    public void setTituloPelicula(String tituloPelicula) { this.tituloPelicula = tituloPelicula; }
    public String getDescripcionPelicula() { return descripcionPelicula; }
    public void setDescripcionPelicula(String descripcionPelicula) { this.descripcionPelicula = descripcionPelicula; }
    public String getDirectorPelicula() { return directorPelicula; }
    public void setDirectorPelicula(String directorPelicula) { this.directorPelicula = directorPelicula; }
    public String getProductoraPelicula() { return productoraPelicula; }
    public void setProductoraPelicula(String productoraPelicula) { this.productoraPelicula = productoraPelicula; }
    public java.time.LocalDate getFechaLanzamiento() { return fechaLanzamiento; }
    public void setFechaLanzamiento(java.time.LocalDate fechaLanzamiento) { this.fechaLanzamiento = fechaLanzamiento; }
    public java.time.LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(java.time.LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }
    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }
    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }
    public String getPortada() { return portada; }
    public void setPortada(String portada) { this.portada = portada; }
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
    public int getCreadoPor() { return creadoPor; }
    public void setCreadoPor(int creadoPor) { this.creadoPor = creadoPor; }
}
