public class Persona {
    String nombre;
    String poblacion;
    int Edad;

    public Persona() {
        this.nombre = "Anónimo";
        this.poblacion = "Desconocido";
        this.Edad = 0;
    }

    public Persona(String nombre, String poblacion, int Edad) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.Edad = Edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return this.poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getEdad() {
        return this.Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String toString() {
        return "Persona{nombre='" + this.nombre + "', poblacion='" + this.poblacion + "', Edad=" + this.Edad + "}";
    }
}
