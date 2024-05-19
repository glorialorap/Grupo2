import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionarArchivos gestionA = new GestionarArchivos();
        boolean menu = true;
        try {
            while (menu) {
                System.out.println("\n--- BIENVENIDO AL PROGRAMA ---");
                System.out.println("        1. Crear cuenta         ");
                System.out.println("       2. Buscar cuenta         ");
                System.out.println("       3. Mostrar cuenta        ");
                System.out.println("      4. Modificar cuenta       ");
                System.out.println("       5. Borrar cuenta         ");
                System.out.println("            6. Salir            ");
                System.out.println("---------------------------------");
                System.out.print("Seleccione una opción: ");
                int opc = sc.nextInt();
                sc.nextLine();

                switch (opc) {
                    case 1:
                        System.out.println("=== Agregar archivo ===");
                        System.out.print("Ingrese el nombre del archivo: ");
                        String fileNameA = sc.nextLine();
                        System.out.print("Número de cuenta: ");
                        int accountNumberA = sc.nextInt();
                        System.out.print("Nombre del cliente: ");
                        sc.nextLine();
                        String customerNameA = sc.nextLine();
                        System.out.print("Saldo de la cuenta: ");
                        double accountBalanceA = sc.nextDouble();
                        System.out.print("Dirección: ");
                        sc.nextLine();
                        String addressA = sc.nextLine();
                        System.out.print("Nombre del banco: ");
                        String bankNameA = sc.nextLine();

                        // Validación de correo
                        String emailA;
                        while (true) {
                            System.out.print("Ingrese el correo electrónico: ");
                            emailA = sc.nextLine();
                            // Regex para validar correo electrónico
                            Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
                            Matcher matcher = pattern.matcher(emailA);
                            if (matcher.matches()) {
                                break;
                            } else {
                                System.out.println("Correo electrónico no válido. Intente nuevamente.");
                            }
                        }

                        // Validación de dad
                        int ageA;
                        while (true) {
                            System.out.print("Ingrese la edad: ");
                            ageA = sc.nextInt();
                            sc.nextLine(); // Consume el salto de línea
                            if (ageA >= 18) {
                                break;
                            } else {
                                System.out.println(
                                        "No se puede crear una cuenta. La edad debe ser mayor o igual a 18 años.");
                            }
                        }
                        Cuenta cuenta = new Cuenta(accountNumberA, customerNameA, accountBalanceA, addressA, bankNameA,
                                emailA, ageA);
                        gestionA.crearArchivo(fileNameA, cuenta, accountNumberA);
                        break;

                    case 2:
                        System.out.println("=== Buscar cuenta ===");
                        System.out.print("Ingrese el nombre del archivo: ");
                        String searchFile = sc.nextLine();
                        System.out.print("Ingrese el número de cuenta: ");
                        int searchNumber = sc.nextInt();
                        gestionA.buscarArchivo(searchFile, searchNumber);
                        break;

                    case 3:
                        System.out.println("=== Información de cuenta === ");
                        System.out.print("Ingrese el nombre del archivo que desea ver: ");
                        String showFile = sc.nextLine();
                        gestionA.leerArchivo(showFile);
                        break;

                    case 4:
                        System.out.println("=== Modificar cuenta === ");
                        System.out.print("Nombre del archivo: ");
                        String fileNameE = sc.nextLine();
                        System.out.print("Número de cuenta a modificar: ");
                        int accountNumberE = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nuevo nombre del cliente: ");
                        String newName = sc.nextLine();

                        int newAge;
                        while (true) {
                            System.out.print("Nueva edad: ");
                            newAge = sc.nextInt();
                            sc.nextLine(); // Consume el salto de línea
                            if (newAge >= 18) {
                                break;
                            } else {
                                System.out.println(
                                        "No se puede modificar la cuenta. La edad debe ser mayor o igual a 18 años.");
                            }
                        }

                        // Validación de correo electrónico
                        String newEmail;
                        while (true) {
                            System.out.print("Nuevo correo electrónico: ");
                            newEmail = sc.nextLine();
                            // Regex para validar correo electrónico
                            Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
                            Matcher matcher = pattern.matcher(newEmail);
                            if (matcher.matches()) {
                                break;
                            } else {
                                System.out.println("Correo electrónico no válido. Intente nuevamente.");
                            }
                        }
                        System.out.print("Nueva dirección: ");
                        String newAddress = sc.nextLine();

                        gestionA.modificarArchivo(fileNameE, accountNumberE, newName, newAge, newEmail, newAddress);
                        break;

                    case 5:
                        System.out.println("=== Eliminar cuenta ===");
                        System.out.print("Ingrese el nombre del archivo que desea eliminar: ");
                        String deleteFile = sc.nextLine();

                        gestionA.borrarArchivo(deleteFile);
                        break;

                    case 6:
                        menu = false;
                        System.out.println("Salida del programa");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
        }
        sc.close();
    }
}
