package com.mitocode.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class IngressDetailPK implements Serializable {
	/**
	 * La serialización es un algoritmo de llevar un 
	 * tipo de dato a otro tipo de dato a traves de un trafico de red
	 * Tenemos un tipo de clase convertirlo a una de BD
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_ingress")
	private Ingress idIngress;
	
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product idProduct;
}
