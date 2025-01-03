package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SaleDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSaleDetail;
	
	@ManyToOne
	@JoinColumn(name = "id_sale")
	private Sale sale;
	
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;
	
	@Column(nullable = false)
	private short quantity;
	
	@Column(columnDefinition = "decimal(5,2)", nullable = false)
	private double salePrcie;
	
	@Column(columnDefinition = "decimal(5,2)", nullable = false)
	private double discount;

	/**
	 * @return the idSaleDetail
	 */
	public Integer getIdSaleDetail() {
		return idSaleDetail;
	}

	/**
	 * @param idSaleDetail the idSaleDetail to set
	 */
	public void setIdSaleDetail(Integer idSaleDetail) {
		this.idSaleDetail = idSaleDetail;
	}

	/**
	 * @return the sale
	 */
	public Sale getSale() {
		return sale;
	}

	/**
	 * @param sale the sale to set
	 */
	public void setSale(Sale sale) {
		this.sale = sale;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
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
	 * @return the salePrcie
	 */
	public double getSalePrcie() {
		return salePrcie;
	}

	/**
	 * @param salePrcie the salePrcie to set
	 */
	public void setSalePrcie(double salePrcie) {
		this.salePrcie = salePrcie;
	}

	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
	
}
