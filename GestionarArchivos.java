import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionarArchivos {

    public void crearArchivo(String fileName, Cuenta cuenta,int id) {
        System.out.println("=== Escribiendo en el archivo " + fileName + " ===");
        // Crea un nuevo archivo o se busca si ya existe
        File file = new File(fileName);

        if (buscarRepetidos(fileName,id)) {
            // Try para cualquier excepcion que nosotros tengamos
            try {
                // Usamos FileWriter en modo append (true) para agregar contenido al final del
                // archivo
                // Esta informacion se encuentra en Oracle
                FileWriter fileWriter = new FileWriter(file, true);
                // Escribe el metodo toString de la clase
                fileWriter.write(cuenta.toString() + System.lineSeparator());
                // Cerramos para hacer cualquier modificacion al archivo (en caso de
                // necesitarlo)
                fileWriter.close();
                System.out.println("=== El contenido de la cuenta se escribió correctamente en el archivo ===");
            } catch (IOException e) {
                System.out.println("=== Excepción al escribir en el archivo: " + e);
            }
        } else {
            System.out.println("Numero de cuenta repetido");
        }

    }

    public void buscarArchivo(String fileName, int id) {
        System.out.println("=== Leyendo el archivo " + fileName + " ===");
        // Busca el archivo por decirlo asi y se crea un objeto
        File file = new File(fileName);
        // El try para cualquier excepcion que tengamos
        try (Scanner sc = new Scanner(file)) {
            // Pregunta si tiene siguinete
            while (sc.hasNextLine()) {
                // Creamos una variable que contenga la informacion de una linea en el archivo
                String data = sc.nextLine();
                // Creamos array para guardar cualquier informacion en este caso el numero de
                // cuenta
                // Y el .split es un regex que nos omite por decirlo asi el guion que esta en el
                // archivo
                String[] parts = data.split("-");
                // Guarda la indormacion que tiene la convierte a entero y no guarda el guion
                int accountNumber = Integer.parseInt(parts[0]);
                String clientName = parts[1];
                double accountBalance = Double.parseDouble(parts[2]);
                String address = parts[3];
                String bankName = parts[4];
                String email = parts[5];
                int age = Integer.parseInt(parts[6]);

                // Pregunta si el numero de cuanta que cogimos del archivo es igual al que le
                // enviamos como parametro
                if (accountNumber == id) {
                    // Si entra entonces nos imprime la informacion guardada en la linea
                    System.out.println("Numero de cuenta: " + accountNumber + ", Nombre: " + clientName + ", Saldo: "
                            + accountBalance + ", Direccion: " + address + ", Nombre del banco: " + bankName
                            + ", Correo: " + email + ", Edad: " + age);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(" === Hubo un error al abrir el archivo: " + e.getMessage());
        }
    }

    public void leerArchivo(String fileName) {
        System.out.println("=== Leyendo el archivo " + fileName + " ===");
        // Busca el archivo por decirlo asi y se crea un objeto
        File file = new File(fileName);
        // El try para cualquier excepcion que tengamos
        try (Scanner sc = new Scanner(file)) {
            // Pregunta si tiene siguinete
            while (sc.hasNextLine()) {
                // Creamos una variable que contenga la informacion de una linea en el archivo
                String data = sc.nextLine();
                String[] parts = data.split("-");
                // Guarda la indormacion que tiene la convierte a entero y no guarda el guion
                int accountNumber = Integer.parseInt(parts[0]);
                String clientName = parts[1];
                double accountBalance = Double.parseDouble(parts[2]);
                String address = parts[3];
                String bankName = parts[4];
                String email = parts[5];
                int age = Integer.parseInt(parts[6]);
                System.out.println("Numero de cuenta: " + accountNumber + ", Nombre: " + clientName + ", Saldo: "
                        + accountBalance + ", Direccion: " + address + ", Nombre del banco: " + bankName + ", Correo: "
                        + email + ", Edad: " + age);
            }
        } catch (FileNotFoundException e) {
            System.out.println(" === Hubo un error al abrir el archivo: " + e.getMessage());
        }
    }

    public void modificarArchivo(String fileName, int accountNumber, String name, int age, String email,
            String address) {
        // Busca el archivo por decirlo asi y se crea un objeto
        File file = new File(fileName);
        // Creo un ArrayList como auxiliar para guardar informacion
        List<String> allNewData = new ArrayList<>();

        // Leer el archivo y almacenar su contenido en memoria
        try (Scanner sc = new Scanner(file)) {
            // Creamos una variable booleana
            boolean found = false;
            // Se recorre el archivo
            while (sc.hasNextLine()) {
                // Creamos una variable para guardar la informacion
                String data = sc.nextLine();
                // Creamos un array para que nos guarde algunas partes sin coger el guion (ese
                // guion es del to string)
                String[] parts = data.split("-");

                // Variables que guardan partes del archivo, se cogen los datos que quiera de
                // cada linea
                int thisAccountNumber = Integer.parseInt(parts[0]);
                double accountBalance = Double.parseDouble(parts[2]);
                String accountName = parts[4];
                // Creo una variable para guarda la informacion con cierto formato
                String stringData;
                // Pregunta si el numero de cuanta del archivo es igual al numero de cuenta
                // recibido como paramtro
                if (thisAccountNumber == accountNumber) {
                    // Modifico la linea segun el caso necesitado, asi la necesite yo
                    stringData = thisAccountNumber + "-" + name + "-" + accountBalance + "-" + address + "-"
                            + accountName + "-" + email + "-" + age;
                    // Guardamos la informacion en el ArrayList
                    allNewData.add(stringData);
                    // Declaramos como true para utilizar despues
                    found = true;
                } else {
                    // Sino es igual entonces la linea que estamos tomando del archivo la enviamos
                    // igual
                    allNewData.add(data);
                }
            }
            // Si la variable found es diferente de true entonces nos saca ese mensaje
            if (!found) {
                System.out.println("No se encontró el número de cuenta digitado");
            }
        } catch (FileNotFoundException e) {
            System.out.println("=== Hubo un error al abrir el archivo: " + e.getMessage());
            return;
        }
        /*
         * Ya sabemos que el true en el append es para que se agregue informacion
         * Pero en este caso utilizamos false para sobreescribir en el archivo, depronto
         * esta no es una forma
         * muy eficiente de pasar datos cuando son en cantidades masivas, pero por el
         * momento fue lo unico que se
         * me ocurrio
         */
        try (FileWriter fileWriter = new FileWriter(file, false)) { // 'false' para sobrescribir el archivo
            for (String line : allNewData) {
                // Aca se agrega y el System.lineSeparator(), espara que salte de linea
                fileWriter.write(line + System.lineSeparator());
            }
            //System.out.println("=== El archivo se modificó correctamente ===");
        } catch (IOException e) {
            System.out.println("=== Hubo un error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void borrarArchivo(String fileName) {

        System.out.println("=== Borrando el archivo " + fileName + " ===");
        // Se busca el archivo por decirlo asi o se crea sino existe
        File file = new File(fileName);
        // Nos retorna true o false y dependiende de eso nos muestra un mensaje
        if (file.delete()) {
            System.out.println("=== El archivo se borro correctamente ===");
        } else {
            System.out.println("=== No se pudo borrar el archivo ===");
        }
    }

    public boolean buscarRepetidos(String fileName, int accountNumber) {

        File file = new File(fileName);

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {

                // Creamos una variable para guardar la informacion
                String data = sc.nextLine();
                // Creamos un array para que nos guarde algunas partes sin coger el guion (ese
                // guion es del to string)
                String[] parts = data.split("-");
                // Variables que guardan partes del archivo, se cogen los datos que quiera de
                // cada linea
                int thisAccountNumber = Integer.parseInt(parts[0]);

                if (thisAccountNumber == accountNumber) {
                    // Si retorna false entonces fue que encontro alguno repetido
                    return false;
                }

            }
        } catch (FileNotFoundException e) {
            //System.out.println("=== Hubo un error al abrir el archivo: " + e.getMessage());
        }
        return true;
    }

}
