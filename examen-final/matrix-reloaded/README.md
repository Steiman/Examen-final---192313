# Requerimiento 2: Asignar Anomalía
# Descripción: Permitir asignar una anomalía específica a un agente.
# Tareas:
# Crear un método asignarAnomalia(Anomaly anomalia) en la clase Agent.
# Añadir un atributo anomaliasAsignadas (lista de objetos Anomaly) a la clase Agent.
# Mostrar las anomalías asignadas al agente.

# Para cumplir con el requerimiento, lo que hice fue modificar las clases Agente y Anomalia, y luego ajustar los gestores correspondientes. Primero, agrege un atributo anomaliasAsignadas en la clase Agente, el cual es una lista donde se almacenan las anomalias asignadas a cada agente. Luego, cree un metodo asignarAnomalia en la clase Agente para agregar las anomalias a esa lista.

# En el AgenteManager, agrege un metodo llamado asignarAnomalia que permite seleccionar una anomalía de la lista de anomalias registradas y asignarla a un agente especifico. Para esto, tambien modifique el constructor de AgenteManager y AnomaliaManager para que reciban la lista de anomalias y poder trabajar con ella de manera compartida entre ambas clases.

# Finalmente, en el Main, asegure que los gestores recibieran correctamente la lista de anomalias al inicializarlos, y luego ofreci la opcion de asignar anomalias a los agentes desde el menu.