import java.util.Arrays;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.DoubleWritable;

public class DoubleArrayWritable extends ArrayWritable {
    public DoubleArrayWritable() {
        super(DoubleWritable.class);
    }

    public DoubleArrayWritable(double[] values) {
        super(DoubleWritable.class, Arrays.stream(values).mapToObj(DoubleWritable::new).toArray(DoubleWritable[]::new));
    }
}
