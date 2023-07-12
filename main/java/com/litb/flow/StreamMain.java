package com.litb.flow;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.log4j.Logger;

/**
 * Author: dougonghou
 * Date: 2023/7/11 15:09
 */
public class StreamMain {
    public static final Logger log = Logger.getLogger(StreamMain.class);

    public static void main(String[] args) {
        try {
            StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
            KafkaSource<String> kafkaSourcesource = KafkaSource.<String>builder()
                    .setBootstrapServers("node2:9092")
                    .setTopics("traffic-channel")
                    .setGroupId("traffic-channels")
                    .setStartingOffsets(OffsetsInitializer.earliest())
                    .setDeserializer(KafkaRecordDeserializationSchema.valueOnly(StringDeserializer.class))
                    .build();
            DataStreamSource<String> stringDataStreamSource = env.fromSource(kafkaSourcesource, WatermarkStrategy.noWatermarks(), "KafkaSource");
            stringDataStreamSource.print();
            stringDataStreamSource.map(x -> {
//                System.out.println(x);
                return x;
            });
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
