package classes;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Evento extends Compromisso {
    private String local;
    private ArrayList<String> convidados;

    public Evento(String titulo, String descricao, Date data, LocalTime horario, String local, ArrayList<String> convidados) {
        super(titulo, descricao, data, horario);
        this.local = local;
        this.convidados = convidados;
    }

    public Evento() {
        super("", "", null, null);
        // Initialize with default values
        this.convidados = new ArrayList<>();
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public ArrayList<String> getConvidados() {
        return convidados;
    }

    public void setConvidados(ArrayList<String> convidados) {
        this.convidados = convidados;
    }

    @Override
    public String toShortString() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Formato de data dd/MM/yyyy
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm"); // Formato de hora HH:mm
    return String.format(
        "<html>Evento: %s<br>Descrição: %s<br>Data: %s<br>Hora: %s<br>Local: %s</html>",
        getTitulo(),
        getDescricao(),
        dateFormat.format(getData()), // Usando o SimpleDateFormat
        getHorario() != null ? getHorario().format(timeFormatter) : "N/A", // Usando o DateTimeFormatter
        local
    );
}

    
}
