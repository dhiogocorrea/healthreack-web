package com.grupo30.model;
import com.grupo30.enums.Plano;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
* Modelo de usuário que contém todos os dados pertinentes a ele
*/
public class Usuario extends Pessoa {
	
	/**
	 * O código do usuario
	 */
    private int codUsuario;
	/**
	 * Refeiçao do usuário
	 */
	private List<Refeicao> refeicao;
	/**
	 * Pesos do usuário
	 */
    private List<Peso> peso = new ArrayList<Peso>();
    /**
	 * Batimentos Cardíacos do usuário
	 */
    private List<BatimentoCardiaco> batimentoCardiaco = new ArrayList<BatimentoCardiaco>();
    /**
	 * Atividade do usuário
	 */
    private List<Atividade> atividade = new ArrayList<Atividade>();
    /**
   	 * Atividade do usuário
   	 */
       private List<Alimento> alimento = new ArrayList<Alimento>();
    /**
	 * Plano do usuário
	 */
    private Plano plano;
    
    public Usuario( ) {}

	public Usuario(int codUsuario, String nome, String sobrenome, String cpf, String sexo, String email, String senha, Date dt_nascimento, Date dt_registro, Date dt_assinatura, int telefone, Plano plano) {
		super(codUsuario, nome, sobrenome, cpf, sexo, email, senha, dt_nascimento, dt_registro, dt_assinatura, telefone);
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public List<Refeicao> getRefeicao() {
		return refeicao;
	}
	public void setRefeicao(List<Refeicao> refeicao) {
		this.refeicao = refeicao;
	}
	public List<Peso> getPeso() {
		return peso;
	}
	public void setPeso(List<Peso> peso) {
		this.peso = peso;
	}
	public List<BatimentoCardiaco> getBatimentoCardiaco() {
		return batimentoCardiaco;
	}
	public void setBatimentoCardiaco(List<BatimentoCardiaco> batimentoCardiaco) {
		this.batimentoCardiaco = batimentoCardiaco;
	}
	public List<Atividade> getAtividade() {
		return atividade;
	}
	public void setAtividade(List<Atividade> atividade) {
		this.atividade = atividade;
	}
	public List<Alimento> getAlimento() {
		return alimento;
	}
	public void setAlimento(List<Alimento> alimento) {
		this.alimento = alimento;
	}
	public Plano getPlano() {
		return plano;
	}
	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
	
	
}
