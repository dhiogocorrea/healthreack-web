package com.grupo30.model;
import java.util.Date;
/**
* Modelo de Peso que contém código, valor e data de inserção
* Armazena os pesos inseridos pelo usuário
*/
public class Peso {

	/**
	 * O código do peso
	 */
    private int codPeso;
    /**
     * O valor do peso em kg
     */
    private Double valor;
    /**
     * A data em que foi realizada a pesagem
     */
    private Date dtPesagem;
    
    public Peso() {}

    public Peso(int codPeso, Double valor, Date dtPesagem) {
        this.codPeso = codPeso;
        this.valor = valor;
        this.dtPesagem = dtPesagem;
    }
    
    public Peso(Double valor, Date dtPesagem) {
        this.valor = valor;
        this.dtPesagem = dtPesagem;
    }

    public int getCodPeso() {
        return codPeso;
    }

    public void setCodPeso(int codPeso) {
        this.codPeso = codPeso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDtPesagem() {
        return dtPesagem;
    }

    public void setDtPesagem(Date dtPesagem) {
        this.dtPesagem = dtPesagem;
    }
}
