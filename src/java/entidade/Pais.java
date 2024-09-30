package entidade;

/**
 * Classe que representa a entidade País.
 */
public class Pais {
    private int id;
    private String nome;
    private String sigla;
    private long populacao; 
    private String continente;  

    // Construtor
    public Pais() {
        nome = "";
        sigla = "";
        populacao = 0;
        continente = "";
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }
}
