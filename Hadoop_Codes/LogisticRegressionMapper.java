import java.io.IOException;
import java.util.Arrays;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class LogisticRegressionMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Parse the input record
        String[] fields = value.toString().split(",");
        double[] features = Arrays.stream(fields, 0, fields.length - 1)
                .mapToDouble(Double::parseDouble)
                .toArray();
        int label = Integer.parseInt(fields[fields.length - 1]);

        // Compute logistic regression model parameters (gradient descent)
        double[] weights = computeGradientDescent(features, label);

        // Emit key-value pairs: key is a unique identifier, value is each weight in the weights array
        for (double weight : weights) {
            context.write(new Text("model"), new DoubleWritable(weight));
        }
    }

    private double[] computeGradientDescent(double[] features, int label) {
        // Placeholder for gradient descent logic (implement based on logistic regression algorithm)
        // This is a simple example and does not include the actual gradient descent logic
        double[] weights = new double[features.length];
        // Perform gradient descent computations...
        return weights;
    }
}
