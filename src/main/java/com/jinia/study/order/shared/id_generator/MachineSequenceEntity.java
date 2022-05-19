package com.jinia.study.order.shared.id_generator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "machine_sequence")
public class MachineSequenceEntity {
	@Id
	Integer sequence;
}

