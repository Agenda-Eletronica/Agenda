package com.mycompany.agenda;

public class Data {
    private int ano;
    private int mes;
    private int dia;
    

    public Data(int ano, int mes, int dia){
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    // Metodos Getters e Setters.
    public void setAno(int ano){
        this.ano = ano;
    }
    public void setMes(int mes){
        this.mes = mes;
    }
    public void setDia(int dia){
        this.dia = dia;
    }
    public int getAno(){
        return ano;
    }
    public int getMes(){
        return mes;
    }
    public int getDia(){
        return dia;
    }
    public String toString(){
        return ano+"/"+mes+"/"+dia;
    }

}
