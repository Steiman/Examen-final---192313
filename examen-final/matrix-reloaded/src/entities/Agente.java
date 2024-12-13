package entities;

import java.util.ArrayList;

public class Agente extends Entidad {
    private String habilidadEspecial;
    private String misionAsignada;
    private ArrayList<Anomalia> anomaliasAsignadas; // Lista para anomalías asignadas

    public Agente(int id, String nombre, String habilidadEspecial) {
        super(id, nombre);
        this.habilidadEspecial = habilidadEspecial;
        this.anomaliasAsignadas = new ArrayList<>();
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public void setHabilidadEspecial(String habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }

    public void asignarMision(String mision) {
        this.misionAsignada = mision;
    }

    public void asignarAnomalia(Anomalia anomalia) {
        anomaliasAsignadas.add(anomalia); // Añadir anomalía a la lista
    }

    public ArrayList<Anomalia> getAnomaliasAsignadas() {
        return anomaliasAsignadas;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder(super.toString());
        info.append(", Habilidad Especial: ").append(habilidadEspecial);
        if (misionAsignada != null) {
            info.append(", Misión: ").append(misionAsignada);
        }
        if (!anomaliasAsignadas.isEmpty()) {
            info.append(", Anomalías Asignadas: ");
            for (Anomalia anomalia : anomaliasAsignadas) {
                info.append("\n\t- ").append(anomalia.getNombre())
                    .append(" (ID: ").append(anomalia.getId()).append(")");
            }
        }
        return info.toString();
    }
}
