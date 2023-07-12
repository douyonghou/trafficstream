package com.litb.vela.utils;


import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.common.typeutils.TypeSerializer;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;
import org.apache.flink.streaming.connectors.kafka.KafkaDeserializationSchema;
import org.apache.flink.util.Collector;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;

/**
 * Author: dougonghou
 * Date: 2023/7/11 15:49
 */
public class TrafficChannel implements DeserializationSchema<String> {

    @Override
    public String deserialize(byte[] message) throws IOException {
        System.out.println(message.toString());
        return message.toString();
    }

    @Override
    public boolean isEndOfStream(String nextElement) {
        if(nextElement.isEmpty())
            return false;
        return true;
    }

    @Override
    public TypeInformation<String> getProducedType() {

        return null;
    }
}
