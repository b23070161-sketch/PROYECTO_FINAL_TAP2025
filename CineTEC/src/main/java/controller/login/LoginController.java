package controller.login;

import dao.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.UsuarioModel;
import utils.EncripHash;

import java.io.IOException;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnLogin;
    @FXML private Label lblGoToRegister;

    private UsuarioDAO usuarioDAO;

    public LoginController() {
        usuarioDAO = new UsuarioDAO();
    }

    @FXML
    public void initialize() {
        lblGoToRegister.setOnMouseClicked(event -> {
            try {
                // Ir al registro
                Parent root = FXMLLoader.load(getClass().getResource("/view/Registro_Usuario.fxml"));
                Stage stage = (Stage) lblGoToRegister.getScene().getWindow();

                Scene  scene = new Scene(root);
                stage.setScene(scene);

                stage.sizeToScene();
                stage.centerOnScreen();

                stage.setTitle("CineTec - Registro");


            } catch (IOException e) { e.printStackTrace(); }
        });
    }

    @FXML
    private void handleLoginButtonClick(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        if (usuario.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Error", "Por favor ingresa tus credenciales.");
            return;
        }

        // 1. Encriptar contraseña para comparar
        String passHash = EncripHash.sha256(password);

        // 2. VERIFICAR SI ES ADMIN
        if (usuarioDAO.esAdmin(usuario, passHash)) {
            System.out.println("INICIASTE SESIÓN COMO ADMINISTRADOR");

            // --- LÓGICA ESPECÍFICA PARA ABRIR ADMIN MAXIMIZADO ---
            try {
                // Asegúrate que el nombre del archivo sea EXACTAMENTE el que tienes en tu carpeta view
                // Puede ser "/view/Admin_Main.fxml" o "/view/Menu_Admin.fxml" (revisa tu carpeta)
                Parent root = FXMLLoader.load(getClass().getResource("/view/Admin_Main.fxml"));

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);

                // ESTO ES IMPORTANTE PARA EL ADMIN:
                stage.setTitle("CineTEC - Panel de Administración");
                stage.centerOnScreen();
                stage.setMaximized(true); // <--- ¡Pantalla completa!
                stage.setResizable(true); // <--- Permitir que cambie de tamaño
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                mostrarAlerta("Error", "No se encontró la vista de Admin: /view/Admin_Main.fxml");
            }
            return; // Detenemos la ejecución aquí para que no siga al código de usuario
        }

        // 3. VERIFICAR SI ES USUARIO NORMAL (CLIENTE)
        UsuarioModel userLogueado = usuarioDAO.loginUsuario(usuario, passHash);

        if (userLogueado != null) {
            System.out.println("✅ BIENVENIDO USUARIO: " + userLogueado.getNombreUsuario());

            // Lógica para Cliente (Cartelera)
            // Aquí usamos abrirPantalla normal porque la cartelera tiene su tamaño definido
            abrirPantalla(event, "/view/Cliente_Cartelera.fxml");
        } else {
            mostrarAlerta("Error", "Su usuario o contraseña son incorrectos.");
        }
    }

    private void abrirPantalla(ActionEvent event, String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "no se pudo cargar la vista" + fxmlPath);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}