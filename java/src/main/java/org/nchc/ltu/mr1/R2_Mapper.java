package org.nchc.ltu.mr1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;

import java.io.IOException;


public  class R2_Mapper extends Mapper<Object, Text, Text, IntWritable>{
    private final static IntWritable i_val = new IntWritable();
    private Text word = new Text();
    private static Logger logger = Logger.getLogger(R2_Mapper.class);
    @Override
    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {

      logger.info("input sentence " + value.toString());
      String[] str_array= value.toString().split(",");
      String v_count = str_array[3].trim().split("@")[1];
      word.set(str_array[0].trim() + "," + str_array[1].trim() + "," + str_array[2].trim());
      
      i_val.set(Integer.parseInt(v_count));
      context.write(word, i_val);
    }
  }
