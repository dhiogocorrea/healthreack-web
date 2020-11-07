package com.grupo30.model;
import java.util.Date;
/**
* Modelo de Atividade que contém código, duração e data da atividade
* Armazena todas as atividades físicas realizadas pelo usuário
*/
public class Atividade {

	/**
	 * O código da atividade
	 */
    private int codAtividade;
    /**
	 * O nome da atividade
	 */
    private String nome;
    /**
     * A duração da atividade em segundos
     */
    private int duracaoAtividade;
    /**
     * A data da atividade
     */
    private Date dtAtividade;

    public Atividade(int codAtividade, String nome, int duracaoAtividade, Date dtAtividade) {
        this.codAtividade = codAtividade;
        this.nome = nome;
        this.duracaoAtividade = duracaoAtividade;
        this.dtAtividade = dtAtividade;
    }
    
    public Atividade(String nome, int duracaoAtividade, Date dtAtividade) {
    	this.nome = nome;
        this.duracaoAtividade = duracaoAtividade;
        this.dtAtividade = dtAtividade;
    }

    public int getCodAtividade() {
        return codAtividade;
    }

    public void setCodAtividade(int codAtividade) {
        this.codAtividade = codAtividade;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }

    public int getDuracaoAtividade() {
        return duracaoAtividade;
    }

    public void setDuracaoAtividade(int duracaoAtividade) {
        this.duracaoAtividade = duracaoAtividade;
    }

    public Date getDtAtividade() {
        return dtAtividade;
    }

    public void setDtAtividade(Date dtAtividade) {
        this.dtAtividade = dtAtividade;
    }

	@Override
	public String toString() {
		return "Atividade [codAtividade=" + codAtividade + ", nome=" + nome + ", duracaoAtividade=" + duracaoAtividade
				+ ", dtAtividade=" + dtAtividade + "]";
	}
}
