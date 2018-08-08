package wordCount;

/**
 * Making your WordCount job configurable from the command line
 */


import hdfs.FileDelete;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.Map;

public class WordCountwithTool extends Configured implements Tool {
    @Override
    public int run(String[] args) throws Exception {

        if (args.length != 2) {
            System.err.println("Invalid Command");
            System.err.println("Usage: <input path> <output path>");
            return -1;
        }

        Configuration conf = getConf();

        Job job = Job.getInstance(conf);
        // option 1:
        //showConfig(conf);
        job.setJobName("wordCountWithTool");
        job.setJarByClass(WordCountwithTool.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducerWithMin.class);

        Path inputFilePath = new Path(args[0]);
        Path outputFilePath = new Path(args[1]);
        FileInputFormat.addInputPath(job, inputFilePath);
        FileOutputFormat.setOutputPath(job, outputFilePath);
        // option 2: delete
        FileDelete fsd = new FileDelete();
        fsd.deleteFile(outputFilePath, conf);


        return job.waitForCompletion(true) ? 0 : 1;
    }

    private void showConfig(Configuration conf) {

        for (Map.Entry<String, String> entry : conf) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        // assign argument
        String[] argc = {"MRdata/wordcount", "output/wc_tool"};
        args = argc;

        // fix Error :
        // java.io.IOException: HADOOP_HOME or hadoop.home.dir are not set
        System.setProperty("hadoop.home.dir", "/opt/hadoop");

        // run code
        int exitCode = ToolRunner.run(new WordCountwithTool(), args);
        System.exit(exitCode);
    }
}



