package classes;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Tarefa extends Compromisso {
    private Date dataFinal;
    private LocalTime horarioInicial;
    private LocalTime horarioFinal;
    private String prioridade;

    public Tarefa(String titulo, String descricao, Date data, LocalTime horarioInicial, Date dataFinal, LocalTime horarioFinal, String prioridade) {
        super(titulo, descricao, data, horarioInicial);
        this.dataFinal = dataFinal;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.prioridade = prioridade;
    }

    public Tarefa() {
        super("", "", null, null);
        // Initialize with default values
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public LocalTime getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(LocalTime horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(LocalTime horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
    
   public String toShortString() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    return String.format(
        "<html>Tarefa: %s<br>Descrição: %s<br>Início: %s %s<br>Fim: %s %s<br>Prioridade: %s</html>",
        getTitulo(),
        getDescricao(),
        dateFormat.format(getData()), // Data formatada: dd/MM/yyyy
        getHorario() != null ? getHorario().format(timeFormatter) : "N/A", // Hora formatada: HH:mm
        dataFinal != null ? dateFormat.format(dataFinal) : "N/A", // Data final formatada
        horarioFinal != null ? horarioFinal.format(timeFormatter) : "N/A", // Hora final formatada
        prioridade
    );
}
}
