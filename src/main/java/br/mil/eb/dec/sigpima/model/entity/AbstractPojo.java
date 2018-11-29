package br.mil.eb.dec.sigpima.model.entity;

import java.io.Serializable;

/**
 * Classe abstrata para Pojos
 * 
 * @author Marcos Vinicius
 * 
 */
public abstract class AbstractPojo extends Object implements Serializable, Cloneable {

	private static final long serialVersionUID = 5219817439116791888L;
	
	public static final String NAME_SCHEMA = "sigpima";
	public static final String NAME_SCHEMA_CORP = "corp";
	public static final String NAME_SCHEMA_ACESSO = "acesso";
	
	// ----------------------- VARIAVEIS STATICAS VALORES DEFINIDOS NO BANCO DE DADOS DESENVOLVIMENTO.
	public static final Long TIPO_REQUISICAO_CONTRATO=3L;
	public static final Long APLICACAO_REQUISICAO_CONTRATO=6L;
	public static final Long FINALIDADE_PRO_LICITAR_CONTRATO=37L;
	public static final Long FINALIDADE_PRO_ADITIVO_CONTRATO=38L;
	public static final Long NATUREZA_339039=6L;
	

	public abstract Long getCodigo();
	public abstract void setCodigo(Long pCodigo);
	
	private String ultimoMetodo;
		
	public String getUltimoMetodo() {
		return ultimoMetodo;
	}
	public void setUltimoMetodo(String ultimoMetodo) {
		this.ultimoMetodo = ultimoMetodo;
	}
	
	
	/**
	 * Metodo que sobrescreve o metodo equals da classe Object
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj != null && obj instanceof AbstractPojo) {

			AbstractPojo pojo = (AbstractPojo) obj;

			if (pojo.getCodigo() != null && getCodigo() != null) {
				return getCodigo().equals(pojo.getCodigo());
			}
		}

		return false;
	}

	/**
	 * Metodo que sobrescreve o metodo hashCode da classe Object
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + (getCodigo() == null ? 0 : getCodigo().hashCode());
		return result;
	}

	/**
	 * Metodo que sobrescreve o metodo clone da classe Object
	 */
	@Override
	public Object clone() {
		
		Object clone = null;
		
		try {
			
			clone = super.clone();
			
		} catch (CloneNotSupportedException e) {
		} catch (Exception e) {
		}
		
		return clone;
	}

	/**
	 * Metodo que sobrescreve o metodo toString da classe Object
	 */
	@Override
	public String toString() {

		/**
		 * retira a parte comum a todos as classes
		 */
		String desc = super.toString().substring(21);

		try {

			return "pk: " + getCodigo().toString() + ", " + desc;
		}
		catch (Exception e) {
			return desc;
		}
	}
	
	public String trucarString(int pTamanho, String pTxt) {
		String txtRetorno = "";
		if (pTxt != null) {
			if (pTxt.length() > pTamanho) {
				txtRetorno = pTxt.substring(0, pTamanho) + "...";
			} else {
				txtRetorno = pTxt;
			}
		}
		return txtRetorno;
	}
	
}
