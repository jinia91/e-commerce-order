package com.jinia.study.order.shared.id_generator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "server_sequence_id")
public class ServerIdEntity {
	@Id
	Integer id;
}

