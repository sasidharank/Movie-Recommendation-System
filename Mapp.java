import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapp extends Mapper<LongWritable, Text, Text, Text> {

	public void map(LongWritable ikey, Text ivalue, Context context) throws IOException, InterruptedException {
try {
		
//	String line[]=ivalue.toString().split(" ");
//		System.out.println(line);
//		context.write(new Text(line[0]), new Text(line[1]) );
	Text t=new Text();
	Text tt=new Text();
	String line=ivalue.toString();
	StringTokenizer st=new StringTokenizer(line, " ");
	while(st.hasMoreTokens()) {
	t.set(st.nextToken());
	tt.set(st.nextToken());
		context.write(t, tt);
	}
	
}catch(Exception e) {
	System.out.println(e);
}
	}

}
