package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class Validador {

    // regex para correos
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    // regex para contraseñas. no se si todo esto lleva java doc o q pedo, ahi le buscamos
    private static final String PASS_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&_\\-])[A-Za-z\\d@$!%*?&_\\-]{8,}$";

    public static boolean esEmailValido(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    public static boolean esUsuarioValido(String usuario) {
        // No null y sin espacio   s
        return usuario != null && !usuario.contains(" ") && !usuario.trim().isEmpty();
    }

    public static boolean esPasswordSegura(String password) {
        return Pattern.compile(PASS_REGEX).matcher(password).matches();
    }

    public static boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) return false;
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 16;
    }
}