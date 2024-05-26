package com.mycompany.agenda;

public class Horario {
    private int hora;
    private int minuto;

    public  Horario (int hora, int minuto){
        this.hora = hora;
        this.minuto = minuto;
    }
    public void setHora(int hora){
        this.hora = hora;
    }
    public void setMinuto(int minuto){
        this.minuto = minuto;
    }
    public int getHora(){
        return hora;
    }
    public int getMinuto(){
        return minuto;
    }
    public String toString(){
        return hora+":"+minuto;
    }
}
