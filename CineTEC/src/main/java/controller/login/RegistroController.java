package controller.login;

import dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.UsuarioModel;
import utils.EncripHash;
import utils.Validador;

import java.sql.Date;
import java.time.LocalDate;

public class RegistroController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtEmail;
    @FXML private PasswordField txtPassword;
    @FXML private PasswordField txtConfirmPassword;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private Label lblGoToLogin;

    private UsuarioDAO usuarioDAO;

    public RegistroController() {
        usuarioDAO = new UsuarioDAO();
    }

    @FXML
    public void initialize() {


        lblGoToLogin.setOnMouseClicked(event -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));

                Stage stage = (Stage) lblGoToLogin.getScene().getWindow();

                Scene scene = new Scene(root);
                stage.setScene(scene);

                stage.sizeToScene();
                stage.centerOnScreen();
                stage.setTitle("CineTec - Login");
            }catch (Exception e) { e.printStackTrace(); }
        });

        dpFechaNacimiento.setEditable(false);

        
    }

    @FXML
    private void handleRegister() {
        String nombre = txtNombre.getText();
        String email = txtEmail.getText();
        String pass = txtPassword.getText();
        String confirmPass = txtConfirmPassword.getText();
        LocalDate fechaNac = dpFechaNacimiento.getValue();

        // 1. Validaciones básicas
        if (nombre.isEmpty() || email.isEmpty() || pass.isEmpty() || fechaNac == null) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
            return;
        }

        // 2. Validación de Contraseñas coinciden
        if (!pass.equals(confirmPass)) {
            mostrarAlerta("Error", "Las contraseñas no coinciden.");
            return;
        }

        // 3. Validación de Usuario (Sin espacios)
        if (!Validador.esUsuarioValido(nombre)) {
            mostrarAlerta("Error", "El usuario no debe tener espacios en blanco.");
            return;
        }

        // 4. Validación de Email
        if (!Validador.esEmailValido(email)) {
            mostrarAlerta("Error", "Formato de correo inválido.");
            return;
        }

        // 5. Validación de Edad (> 16)
        if (!Validador.esMayorDeEdad(fechaNac)) {
            mostrarAlerta("Error", "Debes tener al menos 16 años para registrarte.");
            return;
        }

        // 6. Validación de Contraseña Segura
        if (!Validador.esPasswordSegura(pass)) {
            mostrarAlerta("Error", "La contraseña debe tener al menos 8 caracteres, una letra y un número.");
            return;
        }

        // 7. Verificar si el correo ya existe en BD
        if (usuarioDAO.existeEmail(email)) {
            mostrarAlerta("Error", "Este correo ya está registrado.");
            return;
        }

        // --- CREACIÓN DEL MODELO ---
        UsuarioModel nuevoUsuario = new UsuarioModel();
        nuevoUsuario.setNombreUsuario(nombre);
        nuevoUsuario.setEmailUsuario(email);
        nuevoUsuario.setFechaNacimiento(Date.valueOf(fechaNac));
        nuevoUsuario.setPasswordUsuario(EncripHash.sha256(pass));

        // --- GUARDAR EN BD ---
        if (usuarioDAO.registrarUsuario(nuevoUsuario)) {
            mostrarAlerta("Éxito", "Usuario registrado correctamente.");
            // Aquí deberías redirigir al Login automáticamente
        } else {
            mostrarAlerta("Error", "Hubo un problema al conectar con la base de datos.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(titulo.equals("Error") ? Alert.AlertType.ERROR : Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}