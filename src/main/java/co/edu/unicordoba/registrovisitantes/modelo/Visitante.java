package co.edu.unicordoba.registrovisitantes.modelo;

import co.edu.unicordoba.registrovisitantes.util.TextoUtil;

public class Visitante {

    // ---------- ESTADO DE INSTANCIA ----------
    // Cada objeto Visitante guarda SU PROPIA copia de id, nombre y edad.
    private final int id;
    private final String nombre;
    private final int edad;

    // ---------- ESTADO DE CLASE (static) ----------
    // Existe UNA sola vez y se comparte entre TODOS los objetos Visitante.
    private static int totalCreados;

    // Constante de clase: static + final => única, compartida y de solo lectura.
    public static final int EDAD_MINIMA = 18;

    // Bloque static: corre UNA sola vez, al cargar la clase,
    // incluso antes de que exista el primer "new Visitante(...)".
    static {
        totalCreados = 0;
    }

    public Visitante(String nombre, int edad) {
        totalCreados++;                  // SIN "this": pertenece a la CLASE
        this.id = totalCreados;          // CON "this": pertenece a ESTE objeto
        this.nombre = TextoUtil.normalizarNombre(nombre);
        this.edad = edad;
    }

    // ---------- MÉTODO DE INSTANCIA ----------
    // Necesita this.edad, es decir, depende del estado de UN objeto concreto.
    public boolean esMayorDeEdad() {
        return this.edad >= EDAD_MINIMA;
    }

    // ---------- MÉTODO DE CLASE (static) ----------
    // No usa "this": solo expone el valor compartido "totalCreados".
    // Se invoca como Visitante.getTotalCreados(), sin necesitar ningún objeto.
    public static int getTotalCreados() {
        return totalCreados;
    }

    // Getters de instancia (Spring los usa para convertir el objeto a JSON)
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
