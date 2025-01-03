package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(IngressDetailPK.class)
public class IngressDetail {

	@Id
	private Ingress idIngress;
	@Id
	private Product idProduct;;
	
	@Column(nullable = false)
	private short quantity;
	
	@Column(columnDefinition = "decimal(5,2)", nullable = false)
	private double cost;

	/**
	 * @return the idIngress
	 */
	public Ingress getIdIngress() {
		return idIngress;
	}

	/**
	 * @param idIngress the idIngress to set
	 */
	public void setIdIngress(Ingress idIngress) {
		this.idIngress = idIngress;
	}

	/**
	 * @return the idProduct
	 */
	public Product getIdProduct() {
		return idProduct;
	}

	/**
	 * @param idProduct the idProduct to set
	 */
	public void setIdProduct(Product idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * @return the quantity
	 */
	public short getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
