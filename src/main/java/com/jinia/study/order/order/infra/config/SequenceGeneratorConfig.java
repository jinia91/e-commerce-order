package com.jinia.study.order.order.infra.config;


import com.jinia.study.order.shared.id_generator.IdGenerator;
import com.jinia.study.order.shared.id_generator.JdbcMachineSequenceAllocator;
import com.jinia.study.order.shared.id_generator.MachineSequenceAllocator;
import com.jinia.study.order.shared.id_generator.SnowFlake53;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SequenceGeneratorConfig {

	private static final int MACHINE_SEQUENCE_BIT_SIZE = 7;

	@Bean
	public MachineSequenceAllocator machineSequenceAllocator() {
		return new JdbcMachineSequenceAllocator(MACHINE_SEQUENCE_BIT_SIZE);
	}

	@Bean
	public IdGenerator sequenceGenerator(MachineSequenceAllocator allocator) {
		int machineSequence = allocator.allocate();
		return new SnowFlake53(machineSequence, MACHINE_SEQUENCE_BIT_SIZE);
	}
}
