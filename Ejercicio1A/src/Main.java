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
            String[] separada1 = new String[3];
            String[] separada2 = linea.split("\\:");
            for(int i=0; i<separada2.length; i++){
                System.out.println(separada2[i]);
                if(separada2[i].equals("")){
                    separada2[i]="Desconocido";
                }
                separada1[i] = separada2[i];
            }
            String nombre = separada1[0];
            String poblacion = separada1[1];
            Optional<String> edadOp = Optional.ofNullable(separada1[2]);
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
