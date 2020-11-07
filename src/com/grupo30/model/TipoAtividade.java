package com.grupo30.model;
/**
* Modelo de Tipo de Atividade que contém código, tipo e calorias gastas
* Armazena os tipos de atividade que o usuário utiliza
*/
public class TipoAtividade {

	/**
	 * Código de atividade
	 */
    private int codTipoAtividade;
    /**
     * Tipo de atividade
     */
    private String tipoAtividade;
    /**
     * Calorias gastas por hora pela atividade
     */
    private int caloriasGastasHora;

    public TipoAtividade(int codTipoAtividade, String tipoAtividade, int caloriasGastasHora) {
        this.codTipoAtividade = codTipoAtividade;
        this.tipoAtividade = tipoAtividade;
        this.caloriasGastasHora = caloriasGastasHora;
    }

    public int getCodTipoAtividade() {
        return codTipoAtividade;
    }

    public void setCodTipoAtividade(int codTipoAtividade) {
        this.codTipoAtividade = codTipoAtividade;
    }

    public String getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(String tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public int getCaloriasGastasHora() {
        return caloriasGastasHora;
    }

    public void setCaloriasGastasHora(int caloriasGastasHora) {
        this.caloriasGastasHora = caloriasGastasHora;
    }

}
