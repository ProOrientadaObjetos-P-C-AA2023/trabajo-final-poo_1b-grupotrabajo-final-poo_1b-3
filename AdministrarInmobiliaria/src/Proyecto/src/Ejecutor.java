import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Inmobiliaria{
    private Casa casa;
    private Departamento departamento;

    public Inmobiliaria() {
    }

    public Inmobiliaria(Casa casa, Departamento departamento) {
        this.casa = casa;
        this.departamento = departamento;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Casa getCasa() {
        return casa;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
class Propietario implements Serializable {
    private String nombres;
    private String apellidos;
    private String identificacion;

    public Propietario(String nombres, String apellidos, String identificacion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }
}

class Barrio implements Serializable {
    private String nombre;
    private String referencia;

    public Barrio(String nombre, String referencia) {
        this.nombre = nombre;
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getReferencia() {
        return referencia;
    }
}

class Ciudad implements Serializable {
    private String nombre;
    private String provincia;

    public Ciudad(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }
}

class Constructora implements Serializable {
    private String nombre;
    private String empresaId;

    public Constructora(String nombre, String empresaId) {
        this.nombre = nombre;
        this.empresaId = empresaId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmpresaId() {
        return empresaId;
    }
}

class Casa implements Serializable {
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double metrosCuadrados;
    private Barrio barrio;
    private Ciudad ciudad;
    private int numeroCuartos;
    private Constructora constructora;
    private double costoFinal;

    public Casa(Propietario propietario, double precioMetroCuadrado, double metrosCuadrados, Barrio barrio, Ciudad ciudad, int numeroCuartos, Constructora constructora) {
        this.propietario = propietario;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.metrosCuadrados = metrosCuadrados;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.numeroCuartos = numeroCuartos;
        this.constructora = constructora;
        this.costoFinal = metrosCuadrados * precioMetroCuadrado;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public double getPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public int getNumeroCuartos() {
        return numeroCuartos;
    }

    public Constructora getConstructora() {
        return constructora;
    }

    public double getCostoFinal() {
        return costoFinal;
    }
}

class Departamento implements Serializable {
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double metrosCuadrados;
    private double valorAlicuotaMensual;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private String nombreEdificio;
    private String ubicacionDepartamento;
    private Constructora constructora;

    public Departamento(Propietario propietario, double precioMetroCuadrado, double metrosCuadrados, double valorAlicuotaMensual, Barrio barrio, Ciudad ciudad, String nombreEdificio, String ubicacionDepartamento, Constructora constructora) {
        this.propietario = propietario;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.metrosCuadrados = metrosCuadrados;
        this.valorAlicuotaMensual = valorAlicuotaMensual;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.nombreEdificio = nombreEdificio;
        this.ubicacionDepartamento = ubicacionDepartamento;
        this.constructora = constructora;
        this.costoFinal = (metrosCuadrados * precioMetroCuadrado) + (valorAlicuotaMensual * 12);
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public double getPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public double getValorAlicuotaMensual() {
        return valorAlicuotaMensual;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public String getUbicacionDepartamento() {
        return ubicacionDepartamento;
    }

    public Constructora getConstructora() {
        return constructora;
    }
}

public class Ejecutor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Casa> listaCasas = new ArrayList<>();
        List<Departamento> listaDepartamentos = new ArrayList<>();

        cargarCasasDesdeArchivo(listaCasas);
        cargarDepartamentosDesdeArchivo(listaDepartamentos);

        boolean salir = false;
        while (!salir) {
            System.out.println("Bienvenido al sistema de gestión inmobiliaria");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar una casa");
            System.out.println("2. Agregar un departamento");
            System.out.println("3. Mostrar lista de casas");
            System.out.println("4. Mostrar lista de departamentos");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarCasa(scanner, listaCasas);
                    break;
                case 2:
                    agregarDepartamento(scanner, listaDepartamentos);
                    break;
                case 3:
                    mostrarListaCasas(listaCasas);
                    break;
                case 4:
                    mostrarListaDepartamentos(listaDepartamentos);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }

        guardarCasasEnArchivo(listaCasas);
        guardarDepartamentosEnArchivo(listaDepartamentos);

        scanner.close();
    }

    private static void cargarCasasDesdeArchivo(List<Casa> listaCasas) {
        try {
            FileInputStream fileInputStream = new FileInputStream("casas.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listaCasas.addAll((ArrayList<Casa>) objectInputStream.readObject());
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el archivo de casas.");
        }
    }

    private static void cargarDepartamentosDesdeArchivo(List<Departamento> listaDepartamentos) {
        try {
            FileInputStream fileInputStream = new FileInputStream("departamentos.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listaDepartamentos.addAll((ArrayList<Departamento>) objectInputStream.readObject());
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el archivo de departamentos.");
        }
    }

    private static void guardarCasasEnArchivo(List<Casa> listaCasas) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("casas.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listaCasas);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo de casas.");
        }
    }

    private static void guardarDepartamentosEnArchivo(List<Departamento> listaDepartamentos) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("departamentos.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listaDepartamentos);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo de departamentos.");
        }
    }

    private static void agregarCasa(Scanner scanner, List<Casa> listaCasas) {
        System.out.println("Ingrese los datos de la casa:");
        System.out.print("Nombre del propietario: ");
        String nombres = scanner.nextLine();
        System.out.print("Apellidos del propietario: ");
        String apellidos = scanner.nextLine();
        System.out.print("Identificación del propietario: ");
        String identificacion = scanner.nextLine();
        System.out.print("Precio por metro cuadrado: ");
        double precioMetroCuadrado = scanner.nextDouble();
        System.out.print("Metros cuadrados: ");
        double metrosCuadrados = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nombre del barrio: ");
        String nombreBarrio = scanner.nextLine();
        System.out.print("Referencia del barrio: ");
        String referenciaBarrio = scanner.nextLine();
        System.out.print("Nombre de la ciudad: ");
        String nombreCiudad = scanner.nextLine();
        System.out.print("Provincia de la ciudad: ");
        String provinciaCiudad = scanner.nextLine();
        System.out.print("Número de cuartos: ");
        int numeroCuartos = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre de la constructora: ");
        String nombreConstructora = scanner.nextLine();
        System.out.print("ID de la empresa constructora: ");
        String idEmpresaConstructora = scanner.nextLine();

        Propietario propietario = new Propietario(nombres, apellidos, identificacion);
        Barrio barrio = new Barrio(nombreBarrio, referenciaBarrio);
        Ciudad ciudad = new Ciudad(nombreCiudad, provinciaCiudad);
        Constructora constructora = new Constructora(nombreConstructora, idEmpresaConstructora);

        Casa casa = new Casa(propietario, precioMetroCuadrado, metrosCuadrados, barrio, ciudad, numeroCuartos, constructora);
        listaCasas.add(casa);

        System.out.println("La casa ha sido agregada exitosamente.");
    }

    private static void agregarDepartamento(Scanner scanner, List<Departamento> listaDepartamentos) {
        System.out.println("Ingrese los datos del departamento:");
        System.out.print("Nombre del propietario: ");
        String nombres = scanner.nextLine();
        System.out.print("Apellidos del propietario: ");
        String apellidos = scanner.nextLine();
        System.out.print("Identificación del propietario: ");
        String identificacion = scanner.nextLine();
        System.out.print("Precio por metro cuadrado: ");
        double precioMetroCuadrado = scanner.nextDouble();
        System.out.print("Metros cuadrados: ");
        double metrosCuadrados = scanner.nextDouble();
        System.out.print("Valor de la alicuota mensual: ");
        double valorAlicuotaMensual = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nombre del barrio: ");
        String nombreBarrio = scanner.nextLine();
        System.out.print("Referencia del barrio: ");
        String referenciaBarrio = scanner.nextLine();
        System.out.print("Nombre de la ciudad: ");
        String nombreCiudad = scanner.nextLine();
        System.out.print("Provincia de la ciudad: ");
        String provinciaCiudad = scanner.nextLine();
        System.out.print("Nombre del edificio: ");
        String nombreEdificio = scanner.nextLine();
        System.out.print("Ubicación del departamento: ");
        String ubicacionDepartamento = scanner.nextLine();
        System.out.print("Nombre de la constructora: ");
        String nombreConstructora = scanner.nextLine();
        System.out.print("ID de la empresa constructora: ");
        String idEmpresaConstructora = scanner.nextLine();

        Propietario propietario = new Propietario(nombres, apellidos, identificacion);
        Barrio barrio = new Barrio(nombreBarrio, referenciaBarrio);
        Ciudad ciudad = new Ciudad(nombreCiudad, provinciaCiudad);
        Constructora constructora = new Constructora(nombreConstructora, idEmpresaConstructora);

        Departamento departamento = new Departamento(propietario, precioMetroCuadrado, metrosCuadrados, valorAlicuotaMensual, barrio, ciudad, nombreEdificio, ubicacionDepartamento, constructora);
        listaDepartamentos.add(departamento);

        System.out.println("El departamento ha sido agregado exitosamente.");
    }

    private static void mostrarListaCasas(List<Casa> listaCasas) {
        System.out.println("Lista de casas:");
        for (Casa casa : listaCasas) {
            System.out.println("Propietario: " + casa.getPropietario().getNombres() + " " + casa.getPropietario().getApellidos());
            System.out.println("Precio por metro cuadrado: " + casa.getPrecioMetroCuadrado());
            System.out.println("Metros cuadrados: " + casa.getMetrosCuadrados());
            System.out.println("Barrio: " + casa.getBarrio().getNombre());
            System.out.println("Ciudad: " + casa.getCiudad().getNombre());
            System.out.println("Número de cuartos: " + casa.getNumeroCuartos());
            System.out.println("Constructora: " + casa.getConstructora().getNombre());
            System.out.println("Costo final: " + casa.getCostoFinal());
            System.out.println("\n");
        }
    }

    private static void mostrarListaDepartamentos(List<Departamento> listaDepartamentos) {
        System.out.println("Lista de departamentos:");
        for (Departamento departamento : listaDepartamentos) {
            System.out.println("Propietario: " + departamento.getPropietario().getNombres() + " " + departamento.getPropietario().getApellidos());
            System.out.println("Precio por metro cuadrado: " + departamento.getPrecioMetroCuadrado());
            System.out.println("Metros cuadrados: " + departamento.getMetrosCuadrados());
            System.out.println("Valor de la alicuota mensual: " + departamento.getValorAlicuotaMensual());
            System.out.println("Barrio: " + departamento.getBarrio().getNombre());
            System.out.println("Ciudad: " + departamento.getCiudad().getNombre());
            System.out.println("Nombre del edificio: " + departamento.getNombreEdificio());
            System.out.println("Ubicación del departamento: " + departamento.getUbicacionDepartamento());
            System.out.println("Constructora: " + departamento.getConstructora().getNombre());
            System.out.println("Costo final: " + departamento.getCostoFinal());
            System.out.println("\n");
        }
    }
}
