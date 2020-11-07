package com.grupo30.model;
import com.grupo30.enums.Plano;

import java.util.Date;
import java.util.ArrayList;

/**
* Modelo de usuário que contém todos os dados pertinentes a ele
*/
public class Usuario extends Pessoa {
	
	/**
	 * Refeiçao do usuário
	 */
	private Refeicao refeicao;
	/**
	 * Pesos do usuário
	 */
    private ArrayList<Peso> peso = new ArrayList<Peso>();
    /**
	 * Batimentos Cardíacos do usuário
	 */
    private ArrayList<BatimentoCardiaco> batimentoCardiaco = new ArrayList<BatimentoCardiaco>();
    /**
	 * Atividade do usuário
	 */
    private ArrayList<Atividade> atividade = new ArrayList<Atividade>();
    /**
	 * Plano do usuário
	 */
    private Plano plano;

	public Usuario(int codPessoa, String nome, String sobrenome, int cpf, String sexo, String email, String senha, Date dt_nascimento, Date dt_registro, Date dt_assinatura, int telefone) {
		super(codPessoa, nome, sobrenome, cpf, sexo, email, senha, dt_nascimento, dt_registro, dt_assinatura, telefone);
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}
	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}
	public ArrayList<Peso> getPeso() {
		return peso;
	}
	public void setPeso(Peso peso) {
		this.peso.add(peso);
	}
	public ArrayList<BatimentoCardiaco> getBatimentoCardiaco() {
		return batimentoCardiaco;
	}
	public void setBatimentoCardiaco(BatimentoCardiaco batimentoCardiaco) {
		this.batimentoCardiaco.add(batimentoCardiaco);
	}
	public ArrayList<Atividade> getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade.add(atividade);
	}
	
	public Plano getPlano() {
		return plano;
	}
	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
	
	
}
