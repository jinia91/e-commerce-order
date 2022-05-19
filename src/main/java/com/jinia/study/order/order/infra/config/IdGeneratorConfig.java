package com.jinia.study.order.order.infra.config;


import com.jinia.study.order.shared.id_generator.IdGenerator;
import com.jinia.study.order.shared.id_generator.JdbcServerIdAllocator;
import com.jinia.study.order.shared.id_generator.ServerIdAllocator;
import com.jinia.study.order.shared.id_generator.SnowFlake53;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdGeneratorConfig {

	private static final int MACHINE_SEQUENCE_BIT_SIZE = 7;

	@Bean
	public ServerIdAllocator machineSequenceAllocator() {
		return new JdbcServerIdAllocator(MACHINE_SEQUENCE_BIT_SIZE);
	}

	@Bean
	public IdGenerator sequenceGenerator(ServerIdAllocator allocator) {
		int machineSequence = allocator.allocate();
		return new SnowFlake53(machineSequence, MACHINE_SEQUENCE_BIT_SIZE);
	}
}
