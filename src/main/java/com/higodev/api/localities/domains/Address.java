package com.higodev.api.localities.domains;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.higodev.api.localities.utils.viacep.ViaCepDto;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "adresses")
@ToString(onlyExplicitlyIncluded = true)
public class Address implements Serializable {
	private static final long serialVersionUID = 8845448952917323517L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 10)
	private String postalCode;

	@Column(length = 150)
	private String address;

	@Column(length = 250)
	private String complement;

	@Column(length = 100)
	private String neighborhood;

	@Column(length = 100)
	private String city;

	@Column(length = 2)
	private String uf;

	@Column(length = 50)
	private String ibge;

	@Column(name = "date_register")
	private LocalDateTime dateRegister = LocalDateTime.now();

	public Address(ViaCepDto viaCepDto) {
		this.postalCode = viaCepDto.getCep();
		this.address = viaCepDto.getLogradouro();
		this.complement = viaCepDto.getComplemento();
		this.neighborhood = viaCepDto.getBairro();
		this.city = viaCepDto.getLocalidade();
		this.uf = viaCepDto.getUf();
		this.ibge = viaCepDto.getIbge();
	}
}
