# Generador

Proyecto de marshalling y unmarshalling de personas.

Partes de este proyecto:

1. Crear una clase base **Persona** y un generador de personas aleatorias como lista de **Persona**.
2. Crear un **marshaller** que exporte la lista de personas a XML o JSON.
3. Crear un **unmarshaller** que importe o cargue la lista de personas desde XML o JSON a objeto Java (lista de
   personas).

Para crear el proyecto desde cero, en una terminal escribimos (todo junto en una línea):

```bash
mvn archetype:generate 
    -DgroupId=com.iesvdc.acceso 
    -DartifactId=generador 
    -DarchetypeArtifactId=maven-archetype-quickstart 
    -DinteractiveMode=false
```

Esto crea una carpeta con el nombre **generador** (recuerda el parámetro *-DartifactId=generador*).

## Clases modelo

Llamamos **modelo de datos**, a la forma, al esqueleto que me sirve para manejar la información de un tipo determinado
de manera estructurada.

La clase *Persona*:

```java
class Persona {
   private String nombre;
   private String apellido;
   private String email;
   private LocalDate fdn;
   private List<Direccion> direcciones;
}
```

La clase *Direccion*:

```java
class Direccion {
   private String calle;
   private int numero;
   private Localidad localidad;
}
```

La clase *Localidad*:

```java
class Localidad {
   // private String municipio;
   private String poblacion;
   private int cp;
   private String provincia;
}
```

