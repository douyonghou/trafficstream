package com.litb.vela.utils;

import com.litb.vela.pojos.TrackerPojo;
import org.apache.flink.api.common.eventtime.*;

/**
 * Author: dougonghou
 * Date: 2023/7/12 17:54
 */
public class KafkaSourceWatermark implements WatermarkGenerator<String> {
    private final long maxOutOfOrderness = 3500; // 3.5 秒
    private long currentMaxTimestamp;
    @Override
    public void onEvent(String event, long eventTimestamp, WatermarkOutput output) {
        currentMaxTimestamp = Math.max(currentMaxTimestamp, eventTimestamp);


    }

    @Override
    public void onPeriodicEmit(WatermarkOutput output) {
        output.emitWatermark(new Watermark(currentMaxTimestamp - maxOutOfOrderness - 1));

    }
}
