

package util;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;


public class TextInt implements WritableComparable<TextInt>{
	private Text first;
	private IntWritable second;
	
	public TextInt() {
		first = new Text();
		second =  new IntWritable();
	}
	
	public void set(String first, int second) {
		this.first.set(first);
		this.second.set(second);
	}
	
	public Text getFirst() {
		return first;
	}
	public void setFirst(Text first) {
		this.first = first;
	}
	public IntWritable getSecond() {
		return second;
	}
	public void setSecond(IntWritable second) {
		this.second = second;
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		first.readFields(in);
		second.readFields(in);
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		first.write(out);
		second.write(out);
		
	}
	@Override
	public int compareTo(TextInt other) {
		int cmp = first.compareTo(other.getFirst());
		if (0 == cmp) {
			cmp = second.compareTo(other.getSecond());
		}
		return cmp;
	}
	
	public int baseCompareTo(TextInt other) {
		int cmp = first.compareTo(other.getFirst());
		return cmp;
	}

	public int hashCode() {
		return first.hashCode() * 163 + second.hashCode();
	}
	
	public int baseHashCode() {
		return Math.abs(first.hashCode());
	}

	public boolean equals(Object obj) {
		boolean isEqual =  false;
		if (obj instanceof TextInt) {
			TextInt other = (TextInt)obj;
			isEqual = first.equals(other.first) && second.equals(other.second);
		}
		
		return isEqual;
	}
	
	public String toString() {
		return first.toString() + ":" + second.get();
	}


}
