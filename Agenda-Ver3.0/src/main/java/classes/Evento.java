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
    @Override
    public String getTitulo() {
        // TODO Auto-generated method stub
        return super.getTitulo();
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
    @Override
    public Date getData() {
        // TODO Auto-generated method stub
        return super.getData();
    }
    public String getLocal() {
        return local;
    }
    public ArrayList<String> getConvidados() {
        return convidados;
    }
    @Override
    public void setDescricao(String descricao) {
        // TODO Auto-generated method stub
        super.setDescricao(descricao);
    }
    @Override
    public void setTitulo(String titulo) {
        // TODO Auto-generated method stub
        super.setTitulo(titulo);
    }
    public void setConvidados(ArrayList<String> convidados) {
        this.convidados = convidados;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public void setData(Date data){
        super.setData(data);
    }
    @Override
    public void setHorarioInicial(LocalTime horarioInicial) {
        // TODO Auto-generated method stub
        super.setHorarioInicial(horarioInicial);
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
