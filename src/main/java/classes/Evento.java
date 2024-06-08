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
    
    
    
}
