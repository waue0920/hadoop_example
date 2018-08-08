package GradeCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class R1_Reducer extends  Reducer<Text,IntWritable,Text,Text> {
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		int count = 0;
		String str = "";
		Text result = new Text();
		for (IntWritable val : values) {
			sum += val.get();
			str+=val.get()+"/";
		}
		str = sum +","+str+";";
		result.set(str);
		key.set(key.toString().replaceAll("_", ","));
		context.write(key, result);
	}
}
