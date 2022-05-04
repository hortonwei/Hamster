package com.horton.util;

import com.twitter.snowflake.sequence.IdGenerator;
import com.twitter.snowflake.support.ElasticIdGeneratorFactory;
import com.twitter.snowflake.worker.SimpleWorkerIdAssigner;
import com.twitter.snowflake.worker.WorkerIdAssigner;

import java.util.concurrent.TimeUnit;

public class IdWorker {

    private final static ElasticIdGeneratorFactory factory = new ElasticIdGeneratorFactory();
    private final static WorkerIdAssigner workerIdAssigner = new SimpleWorkerIdAssigner(1L);
    private static final IdGenerator idGenerator;

    static {
        factory.setTimeUnit(TimeUnit.MILLISECONDS);
        factory.setTimeBits(41);
        factory.setWorkerBits(10);
        factory.setSeqBits(12);
        factory.setEpochTimestamp(1649684524717000L);
        idGenerator = factory.create(workerIdAssigner);
    }

    public static long genId() {
        return idGenerator.nextId();
    }
}
