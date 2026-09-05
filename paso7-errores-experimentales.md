# Paso 7 — Errores experimentales (NO dejar en el proyecto final)

Estos dos fragmentos existen solo para que tomes la captura que pide el
informe. Se pegan, se prueban, se toma la evidencia (pantallazo) y se
**eliminan** antes de entregar.

---

## Error A: inyectar un `@Autowired` en un campo `static`

Pégalo dentro de `VisitanteController` (junto a los demás métodos):

```java
@Autowired
private static VisitanteService roto; // MAL: Spring no inyecta en campos static

@GetMapping("/roto")
public String probarRoto() {
    return "roto es null: " + (roto == null);
}
```

No olvides el import arriba del archivo:
```java
import org.springframework.beans.factory.annotation.Autowired;
```

**Qué pasa:** el proyecto compila y arranca sin problema. Al pedir
`GET /api/visitantes/roto` la respuesta es `true` (o sea, `roto` quedó en
`null`). Además, en la consola donde corre `./mvnw spring-boot:run` vas a
ver una advertencia parecida a:

```
Autowired annotation is not supported on static fields: private static ... VisitanteService roto
```

Es un error **silencioso**: nada te avisa mientras programas, solo se nota
en tiempo de ejecución.

---

## Error B: usar `this` dentro de un método `static`

Pégalo dentro de `Visitante.java` (junto a los demás métodos):

```java
public static String saludoRoto() {
    return "Hola " + this.nombre; // no compila
}
```

**Qué pasa:** el proyecto **ni siquiera compila**. Verás un error como:

```
java: non-static variable this cannot be referenced from a static context
```

Este es un error de **compilación**: el compilador te detiene antes de
que puedas ejecutar nada.

---

## Para el informe

Después de tomar las capturas de ambos errores, **borra los dos
fragmentos** (el campo `roto`, el endpoint `/roto`, el import de
`Autowired`, y el método `saludoRoto`) para que el proyecto quede limpio
y compilando en la versión que subes a GitHub.
