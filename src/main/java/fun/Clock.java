package fun;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

/**
 * Created by senyuanwang on 15/7/28.
 */
public interface Clock {

    public default void stamp(String tag, Runnable func) {
        Instant start = Instant.now();
        try {
            func.run();
        } finally {
            Instant end = Instant.now();
            Duration took = Duration.between(start, end);
            System.out.println("It takes [" + took.getNano() + "] nono seconds to process [" + tag + "]");
        }
    }
}
