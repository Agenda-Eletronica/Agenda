package com.mycompany.agenda;

public class Compromisso {
    private String titulo;
    private String descricao;
    private Data data;
    private Horario hora;
    private Usuario participante;

    public Compromisso (String titulo, String descricao, Data data, Horario hora, Usuario participante){
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.participante = participante;
        this.hora = hora;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setData(Data data){
        this.data = data;
    }
    public void setHora(Horario hora){
        this.hora = hora;
    }
    public void setParticipante(Usuario participante){
        this.participante = participante;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getDescricao(){
        return descricao;
    }
    public Data getData(){
        return data;
    }
    public Horario getHora(){
        return hora;
    }
    public Usuario getParticipante(){
        return participante;
    }
    public String toString(){
        return ":::::" + titulo + ":::::\n"
        +"Descrição: " + descricao +"\n"
        +"Data: " + data + "\n"
        +"Horario: " + hora +"\n";
    }
}
