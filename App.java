
public class App {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(5, "juan", 8888888, 
        "50b", "bancolombia", "gmail.com", 18);
        GestionarArchivos gestionar = new GestionarArchivos();
        String nombre = "pepita";
        gestionar.crearArchivo(nombre, cuenta);
        gestionar.leerArchivo(nombre);
        gestionar.borrarArchivo(nombre);


    }
}
