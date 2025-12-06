package model;

public class AdminModel {
    private int idAdmin;
    private String username;
    private String passwordAdmin;
    private String nombreAdmin;

    public AdminModel(int idAdmin, String username, String passwordAdmin, String nombreAdmin) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.passwordAdmin = passwordAdmin;
        this.nombreAdmin = nombreAdmin;
    }

    public int getIdAdmin() { return idAdmin; }
    public void setIdAdmin(int idAdmin) { this.idAdmin = idAdmin; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPasswordAdmin() { return passwordAdmin; }
    public void setPasswordAdmin(String passwordAdmin) { this.passwordAdmin = passwordAdmin; }
    public String getNombreAdmin() { return nombreAdmin; }
    public void setNombreAdmin(String nombreAdmin) { this.nombreAdmin = nombreAdmin; }
}
