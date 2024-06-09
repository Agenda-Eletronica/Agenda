/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gutav
 */
public class Evento extends Compromisso{
    private String local;
    private ArrayList<String> convidados = new ArrayList<String>();
    
    
    public Evento(String titulo, String descricao, Date data, LocalTime horario, String local, ArrayList convidados) {
        super(titulo, descricao, data, horario);
        this.local = local;
        this.convidados = convidados;
    }


    public Evento() {
        //TODO Auto-generated constructor stub
    }
    public String toShortString() {
        return String.format(
            "Evento: %s | Descrição: %s | Data: %s | Hora: %s | Local: %s | Convidados: %d",
            getTitulo(),
            getDescricao(),
            getData(),
            getHorario(),
            local,
            convidados.size()
        );
    }

    public String toLongString() {
        return String.format(
            "Evento: %s\nDescrição: %s\nData: %s\nHora: %s\nLocal: %s\nConvidados: %s",
            getTitulo(),
            getDescricao(),
            getData(),
            getHorario(),
            local,
            String.join(", ", convidados)
        );
    }

    
    
}
