package insat.bigdata;

import com.opencsv.CSVParser;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

import org.apache.hadoop.io.Text;

public class CategoryFraudTokenizeMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text categoryKey = new Text();

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

    
        CSVParser parser = new CSVParser();
        String[] fields = parser.parseLine(value.toString());

        // Ignorer la ligne d'en-tête et les lignes mal formatées
        if (fields != null && fields.length >= 23 && !fields[1].equals("trans_date_trans_time")) {
            if (fields[22].equals("1")) {
                String category = fields[4];
                categoryKey.set(category);
                context.write(categoryKey, one);
            }
        }


}

}
