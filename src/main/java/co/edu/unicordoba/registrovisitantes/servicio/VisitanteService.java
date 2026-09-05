package co.edu.unicordoba.registrovisitantes.servicio;

import co.edu.unicordoba.registrovisitantes.modelo.Visitante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// @Service le dice a Spring: "crea UNA sola instancia (bean) de esta clase
// y guárdala en el contenedor". Por defecto, todo bean de Spring es SINGLETON.
@Service
public class VisitanteService {

    // Atributo de INSTANCIA del bean. Como el bean es único (singleton),
    // en la práctica esta lista termina siendo compartida por toda la aplicación,
    // aunque NO es un atributo static de la clase.
    private final List<Visitante> registrados = new ArrayList<>();

    public Visitante registrar(String nombre, int edad) {
        Visitante v = new Visitante(nombre, edad); // aquí SÍ usamos "new"
        registrados.add(v);
        return v;
    }

    public List<Visitante> listar() {
        return List.copyOf(registrados); // copia inmutable
    }

    // Cuántos objetos quedaron GUARDADOS en este servicio (instancia)
    public int contarRegistrados() {
        return registrados.size();
    }

    // Cuántos objetos Visitante se han CREADO en total con "new" en toda la
    // aplicación, se hayan guardado o no. Viene del atributo static de Visitante.
    public int contarCreadosEnLaClase() {
        return Visitante.getTotalCreados();
    }
}
