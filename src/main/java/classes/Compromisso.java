package classes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Compromisso {
    private String titulo;
    private String descricao;
    private Date data;
    private LocalTime horario;
    

    public Compromisso (String titulo, String descricao, Date data, LocalTime horario){
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.horario = horario;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getDescricao(){
        return descricao;
    }
    
    public String toString(){
        return ":::::" + this.titulo + ":::::\n"
        +"Descrição: " + this.descricao +"\n"
        +"Data: " + this.data + "\n"
        +"Horario: " + this.horario +"\n";
    }
}
