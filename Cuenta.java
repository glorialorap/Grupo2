public class Cuenta {

    private int Numero_Cuenta;
    private String Nombre_Cliente;
    private double Saldo;
    private String Dirrecion;

    //! Atributos agregados:
    private String Nombre_Banco;
    private String Correo_Electronico;
    private int Edad;
    
    //constructor vacio
    public Cuenta() {
    }

    public Cuenta(int numero_Cuenta, String nombre_Cliente, double saldo, String dirrecion, String nombre_Banco,
            String correo_Electronico, int edad) {
        Numero_Cuenta = numero_Cuenta;
        Nombre_Cliente = nombre_Cliente;
        Saldo = saldo;
        Dirrecion = dirrecion;
        Nombre_Banco = nombre_Banco;
        Correo_Electronico = correo_Electronico;
        Edad = edad;
    }

    public int getNumero_Cuenta() {
        return Numero_Cuenta;
    }

    public void setNumero_Cuenta(int numero_Cuenta) {
        Numero_Cuenta = numero_Cuenta;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String nombre_Cliente) {
        Nombre_Cliente = nombre_Cliente;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    public String getDirrecion() {
        return Dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        Dirrecion = dirrecion;
    }

    public String getNombre_Banco() {
        return Nombre_Banco;
    }

    public void setNombre_Banco(String nombre_Banco) {
        Nombre_Banco = nombre_Banco;
    }

    public String getCorreo_Electronico() {
        return Correo_Electronico;
    }

    public void setCorreo_Electronico(String correo_Electronico) {
        Correo_Electronico = correo_Electronico;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    

}