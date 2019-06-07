package com.dxc.examples.springbootwebjpathymeleaf.catalog.airline;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "airline")
@Data
public class Airline implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1712844815774403272L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50, unique = true)
	private String name;
	
	@Column(nullable = false)
	private Boolean status;
	
	@Column(nullable = false)
	private Date createdate;
	
	@Column(nullable = false)
	private Date updatedate;
	
	protected Airline() {}
	
	public Airline( String name ) {
		this.name = name;
		this.status = true;
		this.createdate = new Date();
		this.updatedate = new Date();
	}

	
}
