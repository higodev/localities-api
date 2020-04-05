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
@Table(name="states")
public class State implements Serializable{
	private static final long serialVersionUID = 2354577893493192979L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="state_name")
	private String stateName;
	
	private String uf;
	
}
