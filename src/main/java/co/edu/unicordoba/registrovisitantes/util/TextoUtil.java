package co.edu.unicordoba.registrovisitantes.util;

// "final": esta clase no se puede heredar.
public final class TextoUtil {

    // Constructor PRIVADO: nadie puede escribir "new TextoUtil()".
    // Esta clase es solo un contenedor de métodos static, igual que Math o Integer.
    private TextoUtil() {
        throw new UnsupportedOperationException("Clase de utilidades: no se instancia");
    }

    // MÉTODO STATIC: el resultado depende SOLO del parámetro "texto",
    // no de ningún objeto. Es el mismo patrón que Math.pow(2, 10).
    public static String normalizarNombre(String texto) {
        if (texto == null || texto.isBlank()) {
            return "SIN NOMBRE";
        }
        String[] palabras = texto.trim().toLowerCase().split("\\s+");
        StringBuilder resultado = new StringBuilder();
        for (String palabra : palabras) {
            resultado.append(Character.toUpperCase(palabra.charAt(0)))
                      .append(palabra.substring(1))
                      .append(" ");
        }
        return resultado.toString().trim();
    }
}
