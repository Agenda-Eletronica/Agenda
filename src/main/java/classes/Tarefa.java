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
    
    public Tarefa(String titulo, String descricao, Date data, LocalTime horarioInicial, Date dataFinal, LocalTime horarioFinal, String prioridade) {
        super(titulo, descricao, data, horarioInicial);
        this.dataFinal = dataFinal;
        this.horarioFinal = horarioFinal;
        this.prioridade = prioridade;
    }

    public Tarefa() {
        //TODO Auto-generated constructor stub
    }

    public String getPrioridade() {
        return prioridade;
    }
    @Override
    public String getDescricao() {
        // TODO Auto-generated method stub
        return super.getDescricao();
    }
    @Override
    public LocalTime getHorario() {
        // TODO Auto-generated method stub
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
