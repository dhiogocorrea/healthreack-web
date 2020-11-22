package com.grupo30.model;

import java.util.Date;

/**
* Modelo de Alimento que contém código, nome, quantidade consumida e quantidade de calorias
*/
public class Alimento {

	/**
	 * O código do alimento
	 */
    private int codAlimento;
    /**
     * O nome do alimento
     */
    private String nome;
    /**
     * A quantidade consumida
     */
    private Double qtConsumida;
    /**
     * A quantidade de calorias consumidas
     */
    private int qtCalorias;
    /**
     * A data em que foi consumido o alimento
     */
    private Date dtConsumida;
    
    public Alimento() {}

    public Alimento(int codAlimento, String nome, Double qtConsumida, int qtCalorias, Date dtConsumida) {
        this.codAlimento = codAlimento;
        this.nome = nome;
        this.qtConsumida = qtConsumida;
        this.qtCalorias = qtCalorias;
        this.dtConsumida = dtConsumida;
    }
    
    public Alimento(String nome, Double qtConsumida, int qtCalorias, Date dtConsumida) {
        this.nome = nome;
        this.qtConsumida = qtConsumida;
        this.qtCalorias = qtCalorias;
        this.dtConsumida = dtConsumida;
    }

    public int getCodAlimento() {
        return codAlimento;
    }

    public void setCodAlimento(int codAlimento) {
        this.codAlimento = codAlimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getQtConsumida() {
        return qtConsumida;
    }

    public void setQtConsumida(Double qtConsumida) {
        this.qtConsumida = qtConsumida;
    }

    public int getQtCalorias() {
        return qtCalorias;
    }

    public void setQtCalorias(int qtCalorias) {
        this.qtCalorias = qtCalorias;
    }
    
    public Date getDtConsumida() {
        return dtConsumida;
    }

    public void setDtConsumida(Date dtConsumida) {
        this.dtConsumida = dtConsumida;
    }

	@Override
	public String toString() {
		return "Alimento [codAlimento=" + codAlimento + ", nome=" + nome + ", qtConsumida=" + qtConsumida
				+ ", qtCalorias=" + qtCalorias + ", dtConsumida=" + dtConsumida + "]";
	}
}
