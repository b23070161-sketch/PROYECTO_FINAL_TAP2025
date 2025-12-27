package dao;

import db.DatabaseConnection;
import model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO() {
        conn = DatabaseConnection.getInstance().getConnection();
    }

    /*
    =====================================================================
                                    REGISTRO
    =====================================================================
     */

    public boolean registrarUsuario(UsuarioModel usuario) {
        String sql = "INSERT INTO usuarios (email_usuario, nombre_usuario, fecha_nacimiento, password_usuario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getEmailUsuario());
            pstmt.setString(2, usuario.getNombreUsuario());
            pstmt.setDate(3, usuario.getFechaNacimiento()); // usa date
            pstmt.setString(4, usuario.getPasswordUsuario());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeEmail(String email) {
        String sql = "SELECT id_usuario FROM usuarios WHERE email_usuario = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
    ===================================================================================
                                        LOGIN
    ===================================================================================
     */

    // Logue como  usaurio
    public UsuarioModel loginUsuario(String identificador, String passwordHash) {
        // Lee el usuario o el correo
        String sql = "SELECT * FROM usuarios WHERE (email_usuario = ? OR nombre_usuario = ?) AND password_usuario = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, identificador);
            pstmt.setString(2, identificador);
            pstmt.setString(3, passwordHash);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new UsuarioModel(
                        rs.getInt("id_usuario"),
                        rs.getString("email_usuario"),
                        rs.getString("nombre_usuario"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("password_usuario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    =========================================================================================
            VERIFICA SI EL USUARIO ES DE TIPO ADMIN, RETORNA UNN BOOLEAN POR RESPUESTA
            TRUE SI ES QUE EXISTE EL ADMIN.
    =========================================================================================
     */
    public boolean esAdmin(String username, String passwordHash) {
        String sql = "SELECT id_admin FROM admins WHERE username = ? AND password_admin = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, passwordHash);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}