package org.nchc.ltu.mr1;

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


public class R1_WC  extends Configured implements Tool {

    public static void main( String[] args ) throws Exception{
//    	String[] argv = {"/tmp/mr_test/input","/tmp/mr_test/result1"};
    	String[] argv = {"D:\\waue\\dataSet\\testinput","D:\\waue\\dataSet\\testoutput"};
    	args = argv;

        System.exit(go(args));
        

    }
    
	public static int go(String[] args) throws Exception{
        String[] otherArgs = new GenericOptionsParser(args).getRemainingArgs();
        
        if (otherArgs.length < 2) {
                System.err.println("Usage: WC <input> <output> ");
                System.exit(2);
        }
		int res = ToolRunner.run(new R1_WC(), args);
		return res;
	}
	
	@Override
	public int run (String[]args) throws Exception{
		// TODO Auto-generated method stub
    	Configuration conf = new Configuration();

        // delete output dir
    	OperatingFiles ofs = new OperatingFiles();
    	ofs.deleteFile(args[1]);
    	
        conf.set("mapred.textoutputformat.separator", "@");
        Job job = Job.getInstance(conf, "R1_WC");
        job.setJarByClass(R1_WC.class);
        job.setMapperClass(R1_Mapper.class);
        job.setCombinerClass(R1_Reducer.class);
        job.setReducerClass(R1_Reducer.class);
        
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        return (job.waitForCompletion(true) ? 0 : 1);
	}
}
