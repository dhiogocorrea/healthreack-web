package com.grupo30.model;
import java.util.Date;
/**
* Modelo de Pessoa que contém dados pessoais
*/
public abstract class Pessoa {

	/**
	 * O código da pessoa
	 */
	private int codPessoa;
	/**
	 * Nome da pessoa
	 */
	private String nome;
	/**
	 * Sobrenome da pessoa
	 */
	private String sobrenome;
	/**
	 * CPF da pessoa
	 */
	private String cpf;
	/**
	 * Sexo da pessoa
	 */
	private String sexo;
	/**
	 * Endereço de email da pessoa
	 */
	private String email;
	/**
	 * Senha de cadastro da pessoa
	 */
	private String senha;
	/**
	 * Data de nascimento da pessoa
	 */
	private Date dtNascimento;
	/**
	 * Data de registro da pessoa
	 */
	private Date dtRegistro;
	/**
	 * Data de assinatura de plano da pessoa
	 */
	private Date dtAssinatura;
	/**
	 * Número de telefone da pessoa
	 */
	private int numeroTelefone;

	public Pessoa(int codPessoa, String nome, String sobrenome, String cpf, String sexo, String email, String senha, Date dtNascimento, Date dtRegistro, Date dtAssinatura, int numeroTelefone) {
		this.codPessoa = codPessoa;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.email = email;
		this.senha = senha;
		this.dtNascimento = dtNascimento;
		this.dtRegistro = dtRegistro;
		this.dtAssinatura = dtAssinatura;
		this.numeroTelefone = numeroTelefone;
	}

	public Pessoa(){}

	public int getCodPessoa() {
		return codPessoa;
	}

	 
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Date getDtRegistro() {
		return dtRegistro;
	}

	public void setDtRegistro(Date dtRegistro) {
		this.dtRegistro = dtRegistro;
	}

	public Date getDtAssinatura() {
		return dtAssinatura;
	}

	public void setDtAssinatura(Date dtAssinatura) {
		this.dtAssinatura = dtAssinatura;
	}

	public int getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
 
	
	
	 

}



