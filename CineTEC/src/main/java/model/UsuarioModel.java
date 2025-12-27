package model;

import java.time.LocalDate;
import java.sql.Date;

public class UsuarioModel {
    private int idUsuario;
    private String emailUsuario;
    private String nombreUsuario;
    private Date fechaNacimiento;
    private String passwordUsuario;

    public UsuarioModel() {}

    public UsuarioModel(int idUsuario, String emailUsuario, String nombreUsuario, Date fechaNacimiento, String passwordUsuario) {
        this.idUsuario = idUsuario;
        this.emailUsuario = emailUsuario;
        this.nombreUsuario = nombreUsuario;
        this.fechaNacimiento = fechaNacimiento;
        this.passwordUsuario = passwordUsuario;
    }

    // getters y setters
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getEmailUsuario() { return emailUsuario; }
    public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getPasswordUsuario() { return passwordUsuario; }
    public void setPasswordUsuario(String passwordUsuario) { this.passwordUsuario = passwordUsuario; }
}
