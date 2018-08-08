package GradeCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;

import java.io.IOException;


public class R1_Mapper extends Mapper<Object, Text, Text, IntWritable> {
    private IntWritable score = new IntWritable(0);
    private Text id = new Text();
    private static Logger logger = Logger.getLogger(R1_Mapper.class);

    String[] val_arr;
    String str;

    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // value.toString() = xxx,A38C074,kevin850821@gmail.com,3,50.00%
        logger.info("input sentence " + value.toString());
        str = value.toString();

        val_arr = str.split(",");
        if (val_arr.length != 5) {
            System.err.println("skip: " + str);
        } else {
            id.set(val_arr[1].toUpperCase() + "_" + val_arr[0]);
            score.set(Integer.parseInt(val_arr[3]));
            context.write(id, score);
        }


    }
}
