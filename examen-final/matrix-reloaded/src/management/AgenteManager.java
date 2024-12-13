package management;

import entities.Agente;
import entities.Anomalia;
import java.util.ArrayList;
import utils.ConsoleUtils;

public class AgenteManager {
    private ArrayList<Agente> agentes;
    private ArrayList<Anomalia> anomalias;

    // Constructor actualizado para aceptar la lista de anomalías
    public AgenteManager(ArrayList<Anomalia> anomalias) {
        this.agentes = new ArrayList<>();
        this.anomalias = anomalias;
    }

    public void registrarAgente() {
        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente: ");
        ConsoleUtils.limpiarBuffer();

        String nombre = ConsoleUtils.leerTexto("Ingrese el nombre del agente: ");
        String habilidad = ConsoleUtils.leerTexto("Ingrese la habilidad especial del agente: ");

        Agente nuevoAgente = new Agente(id, nombre, habilidad);
        agentes.add(nuevoAgente);
        System.out.println("Agente registrado con éxito.");
    }

    public void asignarAnomalia(Agente agente) {
        if (anomalias.isEmpty()) {
            System.out.println("No hay anomalías registradas para asignar.");
            return;
        }
        System.out.println("Seleccione una anomalía para asignar al agente:");

        // Mostrar anomalías
        for (int i = 0; i < anomalias.size(); i++) {
            System.out.println((i + 1) + ". " + anomalias.get(i));
        }

        int opcion = ConsoleUtils.leerEntero("Seleccione la anomalía a asignar: ");
        if (opcion < 1 || opcion > anomalias.size()) {
            System.out.println("Opción no válida.");
            return;
        }

        Anomalia anomaliaSeleccionada = anomalias.get(opcion - 1);
        agente.asignarAnomalia(anomaliaSeleccionada);
        System.out.println("Anomalía asignada a " + agente.getNombre() + ".");
    }

    public void mostrarAgentes() {
        if (agentes.isEmpty()) {
            System.out.println("No hay agentes registrados.");
            return;
        }
        System.out.println("=== Lista de Agentes ===");
        for (Agente agente : agentes) {
            System.out.println(agente);
        }
    }

    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Agentes ===");
            System.out.println("1. Registrar Agente");
            System.out.println("2. Mostrar Agentes");
            System.out.println("3. Asignar Anomalía a Agente");
            System.out.println("4. Salir");
            int opcion = ConsoleUtils.leerEntero("Seleccione una opción: ");
            ConsoleUtils.limpiarBuffer();

            switch (opcion) {
                case 1 -> registrarAgente();
                case 2 -> mostrarAgentes();
                case 3 -> {
                    // Solicitar seleccionar un agente
                    mostrarAgentes();
                    int idAgente = ConsoleUtils.leerEntero("Ingrese el ID del agente para asignar anomalía: ");
                    Agente agenteSeleccionado = null;
                    for (Agente agente : agentes) {
                        if (agente.getId() == idAgente) {
                            agenteSeleccionado = agente;
                            break;
                        }
                    }
                    if (agenteSeleccionado != null) {
                        asignarAnomalia(agenteSeleccionado);
                    } else {
                        System.out.println("Agente no encontrado.");
                    }
                }
                case 4 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}

