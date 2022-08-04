package com.br.rocha.entity.loja.olinda;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CLIENTE_OLINDA")
public class Cliente implements Serializable {

	@Id
	@Column(name = "ID")
	private Integer id;
	private String nome;
	private static final long serialVersionUID = 1L;
}
