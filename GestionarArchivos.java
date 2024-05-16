import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestionarArchivos {

    public void crearArchivo(String fileName, Cuenta cuenta) {
        System.out.println("=== Creando el archivo " + fileName + " ===");
        boolean fileCreated = false;
        File file = new File(fileName);
        try {
            fileCreated = file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(cuenta.toString());
            fileWriter.close();
            if (fileCreated) {
                System.out.println("=== El archivo se creó correctamente ===");
            } else {
                System.out.println("=== El archivo ya existe ===");
            }
        } catch (IOException e) {
            System.out.println("=== Excepción al crear el archivo: " + e);
        }
    }

    @SuppressWarnings("resource")
    public void leerArchivo(String fileName) {

        System.out.println("=== Leyendo el archivo " + fileName + " ===");
        File file = new File(fileName);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println(" === Hubo un error al abrir el archivo " + e);
        }
    }

    public void borrarArchivo(String fileName) {

        System.out.println("=== Borrando el archivo " + fileName + " ==="); 
        File file = new File(fileName); 
        if (file.delete()) { 
            System.out.println("=== El archivo se borro correctamente ==="); 
        } else { 
            System.out.println("=== No se pudo borrar el archivo ==="); 
        } 
    } 

}
