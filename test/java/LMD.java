import org.apache.flink.api.common.eventtime.NoWatermarksGenerator;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;

import java.util.concurrent.Callable;
import java.util.function.DoubleToIntFunction;

/**
 * Author: dougonghou
 * Date: 2023/7/12 18:03
 */
public class LMD {
    static <T> WatermarkStrategy<T> noWatermarks() {
        return (ctx) -> new NoWatermarksGenerator<>();
    }

    public static void main(String[] args) {
    }
}
