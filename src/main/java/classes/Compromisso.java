package classes;
import java.util.Date;
import java.time.LocalTime;


public class Compromisso {
    private String titulo;
    private String descricao;
    private Date data;
    private LocalTime horarioInicial;
    
    public Compromisso(){
        
    }
    public Compromisso (String titulo, String descricao, Date data, LocalTime horario){
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.horarioInicial = horario;
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
    public Date getData(){
        return data;
    }
    public LocalTime getHorario(){
        return horarioInicial;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public void setHorarioInicial(LocalTime horarioInicial) {
        this.horarioInicial = horarioInicial;
    }
    
}
