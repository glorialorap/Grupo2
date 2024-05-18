public class Cuenta {

    private int numeroCuenta=-1;
    private String nombreCliente;
    private double saldo;
    private String direccion;
    //! Atributos agregados:
    private String nombreBanco;
    private String correoElectronico;
    private int edad;
    private int numeroArchivos;
    
    //constructor vacio
    public Cuenta() {
    }

    public Cuenta(int numeroCuenta, String nombreCliente, double saldo, String direccion, String nombreBanco,
            String correoElectronico, int edad) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.saldo = saldo;
        this.direccion = direccion;
        this.nombreBanco = nombreBanco;
        this.correoElectronico = correoElectronico;
        this.edad = edad;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumeroArchivos() {
        return numeroArchivos;
    }

    public void setNumeroArchivos(int numeroArchivos) {
        this.numeroArchivos = numeroArchivos;
    }

    public String toString() {
        return  numeroCuenta +"-"+ nombreCliente  +"-"+ saldo +"-"+ direccion +"-"+ nombreBanco +"-"+ 
                correoElectronico+"-"+ edad ;
    }

}