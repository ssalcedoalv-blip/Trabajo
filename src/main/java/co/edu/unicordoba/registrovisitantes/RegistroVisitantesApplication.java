package co.edu.unicordoba.registrovisitantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta anotación activa el contenedor de Spring: a partir de aquí,
// Spring es quien decide cuándo crear los objetos (beans), no nosotros con "new".
@SpringBootApplication
public class RegistroVisitantesApplication {

    // "main" es, por definición, un método STATIC: la JVM lo ejecuta
    // sin que exista todavía ningún objeto de esta clase.
    public static void main(String[] args) {
        SpringApplication.run(RegistroVisitantesApplication.class, args);
    }

}
