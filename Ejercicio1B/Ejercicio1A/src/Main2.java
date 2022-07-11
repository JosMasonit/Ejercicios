import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Path ruta = Path.of("src","ficheroPersonas.txt");

        List<String> listString = Files.readAllLines(ruta);
        List<Persona> personicas = listString.stream().map(linea -> {
            String[] separada = new String[3];
            separada = linea.split(":");
            if(separada[0].equals("")){
                separada[0]="Desconocido";
            }
            if(separada[1].equals("")){
                separada[1]="Desconocido";
            }
            Optional<String> edadOp;
            if(separada.length < 3){
                edadOp = Optional.ofNullable(null);
            }else{
                edadOp = Optional.ofNullable(separada[2]);
            }
            String nombre = separada[0];
            String poblacion = separada[1];
            String edadString = edadOp.orElse("0");
            int edad = Integer.parseInt(edadString);

            Persona p = new Persona(nombre, poblacion, edad);
            return p;
        }).collect(Collectors.toList());

        personicas.stream().filter(p -> p.getEdad() < 25 && p.getEdad() !=0)
                .forEach(p -> System.out.println("Nombre:"+p.getNombre()
                        +". Poblacion:"+p.getPoblacion()+". Edad:"+p.getEdad()));

    }
}
