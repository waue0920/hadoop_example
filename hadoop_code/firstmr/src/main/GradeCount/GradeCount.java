package GradeCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class GradeCount extends Configured implements Tool {

    public static void main(String[] args) throws Exception {

        String[] argv = {"./MRdata/score", "./output/score_output/"};
        args = argv;

        System.exit(go(args));


    }

    public static int go(String[] args) throws Exception {
        String[] otherArgs = new GenericOptionsParser(args).getRemainingArgs();

        if (otherArgs.length < 2) {
            System.err.println("Usage: GradeCount <input> <output> ");
            System.exit(2);
        }
        int res = ToolRunner.run(new GradeCount(), args);
        return res;
    }

    @Override
    public int run(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Configuration conf = new Configuration();

        // delete output dir
        hdfs.FileUtil ofs = new hdfs.FileUtil();
        ofs.deleteFile(args[1], conf);

        conf.set("mapred.textoutputformat.separator", ",");
        Job job = Job.getInstance(conf, "grade_count");
        job.setJarByClass(GradeCount.class);
        job.setMapperClass(R1_Mapper.class);

        job.setReducerClass(R1_Reducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        return (job.waitForCompletion(true) ? 0 : 1);
    }
}
