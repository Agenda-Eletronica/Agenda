/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author gutav
 */
public class Tarefa extends Compromisso {
    private String prioridade;
    private Date dataFinal;
    private LocalTime horarioFinal;
    private static Tarefa instancia = null;
    

    private Tarefa() {

    }

    public static Tarefa getInstancia() {
        if (instancia == null) {
            instancia = new Tarefa();
        }
        return instancia;
    }
    
    public Tarefa(String titulo, String descricao, Date data, LocalTime horarioInicial, Date dataFinal, LocalTime horarioFinal, String prioridade) {
        super(titulo, descricao, data, horarioInicial);
        this.dataFinal = dataFinal;
        this.horarioFinal = horarioFinal;
        this.prioridade = prioridade;
    }




    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
    public Date getDataFinal() {
        return dataFinal;
    }
    public void setHorarioFinal(LocalTime horarioFinal) {
        this.horarioFinal = horarioFinal;
    }
    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
    

    public String getPrioridade() {
        return prioridade;
    }

    

    @Override
    public String getDescricao() {

        return super.getDescricao();
    }
    @Override
    public LocalTime getHorario() {

        return super.getHorario();
    }

    public String toShortString() {
        return String.format(
            "Tarefa: %s | Descrição: %s | Início: %s %s | Fim: %s %s | Prioridade: %s",
            getTitulo(),
            getDescricao(),
            getData(),
            getHorario(),
            dataFinal,
            horarioFinal,
            prioridade
        );
    }

    public String toLongString() {
        return String.format(
            "Tarefa: %s\nDescrição: %s\nData Inicial: %s\nHora Inicial: %s\nData Final: %s\nHora Final: %s\nPrioridade: %s",
            getTitulo(),
            getDescricao(),
            getData(),
            getHorario(),
            dataFinal,
            horarioFinal,
            prioridade
        );
    }

}
