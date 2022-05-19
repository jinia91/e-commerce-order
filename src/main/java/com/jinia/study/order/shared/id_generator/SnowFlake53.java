package com.jinia.study.order.shared.id_generator;

public class SnowFlake53 implements IdGenerator {
	private static final int MAX_BIT_SIZE = 53;
	private static final long BASE_TIMESTAMP = 1652981464342L; // 2022.05.20 : 02:31
	private static final int TIMESTAMP_BIT_SIZE = 41;
	private static final int TIMESTAMP_SHIFT = MAX_BIT_SIZE - TIMESTAMP_BIT_SIZE;

	private final int serverId;
	private final int serverIdShift;
	private final int serialNumberMask;

	private long lastTimestamp;
	private int serialNumber;

	public SnowFlake53(int serverId, int serverIdBitSize) {
		this.serverId = serverId;
		this.serverIdShift = MAX_BIT_SIZE - TIMESTAMP_BIT_SIZE - serverIdBitSize;
		int serialNumberBitSize = MAX_BIT_SIZE - TIMESTAMP_BIT_SIZE - serverIdBitSize;
		this.serialNumberMask = (int) Math.pow(2, serialNumberBitSize) - 1;
		this.lastTimestamp = System.currentTimeMillis();
		this.serialNumber = 0;
	}

	@Override
	public synchronized Long generate() {
		long timestamp = System.currentTimeMillis();

		if (timestamp < lastTimestamp) {
			throw new IdGeneratorTimestampException();
		}

		if (lastTimestamp == timestamp) {
			serialNumber = (serialNumber + 1) & serialNumberMask;

			if (serialNumber == 0) {
				timestamp = waitNextTimestamp(lastTimestamp);
			}
		} else {
			serialNumber = 0;
		}

		lastTimestamp = timestamp;

		return ((timestamp - BASE_TIMESTAMP) << TIMESTAMP_SHIFT)
				| serverId << serverIdShift
				| serialNumber;
	}

	private long waitNextTimestamp(long lastTimestamp) {
		long current = System.currentTimeMillis();

		while (lastTimestamp >= current) {
			current = System.currentTimeMillis();
		}

		return lastTimestamp + 1;
	}
}
