import entities.Anomalia;
import java.util.ArrayList;
import management.*;
import utils.ConsoleUtils;

public class Main {
    public static void main(String[] args) {
        // Crear lista de anomalías
        ArrayList<Anomalia> listaAnomalias = new ArrayList<>();

        // Crear los gestores con la lista de anomalías
        AnomaliaManager anomaliaManager = new AnomaliaManager(listaAnomalias);
        AgenteManager agenteManager = new AgenteManager(listaAnomalias);

        System.out.println("Bienvenido a Matrix Reloaded: Salvando la Humanidad");
        System.out.println("Elige una píldora para continuar:");
        System.out.println("1. Píldora Roja: Agentes de la Resistencia");
        System.out.println("2. Píldora Azul: Control de Anomalías");

        int opcion = ConsoleUtils.leerEntero("Selecciona una opción (1 o 2): ");

        if (opcion == 1) {
            agenteManager.mostrarMenu();
        } else if (opcion == 2) {
            anomaliaManager.mostrarMenu();
        } else {
            System.out.println("Opción no válida. Adiós.");
        }
    }
}



