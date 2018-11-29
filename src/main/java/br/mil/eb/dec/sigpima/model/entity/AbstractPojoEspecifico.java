package br.mil.eb.dec.sigpima.model.entity;

import java.sql.Timestamp;

/**
 * Classe abstrata para Pojos
 * 
 * @author aristides.neto
 * 
 */
public abstract class AbstractPojoEspecifico extends AbstractPojo {


	private static final long serialVersionUID = -558156798176473838L;
	
	
	public abstract Timestamp getDataHoraRegistro();
	public abstract void setDataHoraRegistro(Timestamp pDataHoraRegistro);
	
	
}
