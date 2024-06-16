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
    private static Evento instancia = null;


    private Evento() {
    }

    public static Evento getInstancia() {
        if (instancia == null) {
            instancia = new Evento();
        }
        return instancia;
    }
    
    
    @SuppressWarnings("unchecked")
    public Evento(String titulo, String descricao, Date data, LocalTime horario, String local, @SuppressWarnings("rawtypes") ArrayList convidados) {
        super(titulo, descricao, data, horario);
        this.local = local;
        this.convidados = convidados;
    }
    @Override
    public String getTitulo() {

        return super.getTitulo();
    }
    @Override
    public String getDescricao() {

        return super.getDescricao();
    }
    @Override
    public LocalTime getHorario() {

        return super.getHorario();
    }
    @Override
    public Date getData() {

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

        super.setDescricao(descricao);
    }
    @Override
    public void setTitulo(String titulo) {

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

        super.setHorarioInicial(horarioInicial);
    }




    
    
}
