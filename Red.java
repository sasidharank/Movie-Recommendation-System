import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Red extends Reducer<Text, Text, Text, Text> {
String lin=null;
Text tt=new Text();
	public void reduce(Text _key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		// process values
		for (Text val : values) {
lin=val.toString();
tt.set(lin);
		}
		context.write(_key, tt);
	}

}
