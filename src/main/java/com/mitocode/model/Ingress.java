package com.mitocode.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ingress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIngress;
	
	@ManyToOne
	@JoinColumn(name = "id_provider")
	private Provider provider;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private UserData user;
	
	@Column(nullable = false)
	private LocalDateTime datetime;
	
	@Column(columnDefinition = "decimal(5,2)", nullable = false)
	private double total;
	
	@Column(columnDefinition = "decimal(5,2)", nullable = false)
	private double tax;
	
	@Column(length = 10,nullable = false)
	private String serial;
	
	@Column(nullable = false)
	private boolean enabled;

	/**
	 * @return the idIngress
	 */
	public Integer getIdIngress() {
		return idIngress;
	}

	/**
	 * @param idIngress the idIngress to set
	 */
	public void setIdIngress(Integer idIngress) {
		this.idIngress = idIngress;
	}

	/**
	 * @return the provider
	 */
	public Provider getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	/**
	 * @return the user
	 */
	public UserData getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserData user) {
		this.user = user;
	}

	/**
	 * @return the datetime
	 */
	public LocalDateTime getDatetime() {
		return datetime;
	}

	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the tax
	 */
	public double getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(double tax) {
		this.tax = tax;
	}

	/**
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * @param serial the serial to set
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
