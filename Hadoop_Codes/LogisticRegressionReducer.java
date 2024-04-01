import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class LogisticRegressionReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {

    @Override
    protected void reduce(Text key, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {

        // Placeholder for aggregating weights logic
        double sumWeights = 0.0;
        int count = 0;

        // Aggregate weights from all mappers
        for (DoubleWritable value : values) {
            sumWeights += value.get();
            count++;
        }

        // Compute the average weight (or perform any other aggregation logic)
        double averageWeight = sumWeights / count;

        // Output the final result
        context.write(key, new DoubleWritable(averageWeight));
    }
}
