import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class LogisticRegressionDriver {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: LogisticRegressionDriver <inputPath> <outputPath>");
            System.exit(-1);
        }

        // Create a Hadoop job and set the main class
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Logistic Regression");

        // Set the jar file for the job
        job.setJarByClass(LogisticRegressionDriver.class);

        // Set the mapper and reducer classes
        job.setMapperClass(LogisticRegressionMapper.class);
        job.setReducerClass(LogisticRegressionReducer.class);

        // Set the output key and value classes
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

        // Set the input and output paths
        Path inputPath = new Path(args[0]);
        Path outputPath = new Path(args[1]);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        FileInputFormat.addInputPath(job, inputPath);
        FileOutputFormat.setOutputPath(job, outputPath);

        // Submit the job and wait for completion
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
