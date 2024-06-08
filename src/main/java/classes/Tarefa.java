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
    private Date DataFinal;
    private LocalTime horarioFinal;
    
    public Tarefa(String titulo, String descricao, Date data, LocalTime horarioInicial, Date dataFinal, LocalTime horarioFinal, String prioridade) {
        super(titulo, descricao, data, horarioInicial);
        this.DataFinal = dataFinal;
        this.horarioFinal = horarioFinal;
        this.prioridade = prioridade;
    }
    
}
