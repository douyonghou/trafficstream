package com.litb.vela;

import com.litb.vela.utils.KafkaSourceWatermark;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.log4j.Logger;

/**
 * Author: dougonghou
 * Date: 2023/7/11 15:09
 */
public class VelaMain {
    public static final Logger log = Logger.getLogger(VelaMain.class);

    public static void main(String[] args) {
        try {
            StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

            KafkaSource<String> kafkaSource = KafkaSource
                    .<String>builder()
                    .setBootstrapServers("node2:9092")
                    .setTopics("traffic-channel")
                    .setGroupId("traffic-channels")
                    .setStartingOffsets(OffsetsInitializer.earliest())
                    .setValueOnlyDeserializer(new SimpleStringSchema())
                    // 每 10 秒检查一次新分区
                    .setProperty("partition.discovery.interval.ms","10000")
//                    .setDeserializer(KafkaRecordDeserializationSchema.valueOnly(StringDeserializer.class))
                    .build();
//            DataStreamSource<String> stringDataStreamSource = env.fromSource(kafkaSource, WatermarkStrategy.noWatermarks(), "KafkaSource");
            DataStreamSource<String> stringDataStreamSource = env.fromSource(kafkaSource, (WatermarkStrategy)new KafkaSourceWatermark(), "KafkaSource");
            stringDataStreamSource.print();
            stringDataStreamSource.map(x -> {
                return x;
            });


            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
