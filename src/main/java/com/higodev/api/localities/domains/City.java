package com.higodev.api.localities.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cities")
public class City implements Serializable{
	private static final long serialVersionUID = 3453106001277351581L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 100, nullable = false)
	private String city;
	
	@Column(length = 30, nullable = false)
	private String ibge;
	
	@Column(length = 2)
	private String uf;
	
	@Column(name = "state_id")
	private long stateId;

}
