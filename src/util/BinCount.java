
package util;

public class BinCount {
	private String bin;
	private int count;
	private double prob;
	
	public BinCount(String bin, int count) {
		super();
		this.bin = bin;
		this.count = count;
	}
	
	public String getBin() {
		return bin;
	}
	public void setBin(String bin) {
		this.bin = bin;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void addCount(int count) {
		this.count += count;
	}
	
	public void normalize(int total) {
		prob = ((double)count ) / total;
	}

	public double getProb() {
		return prob;
	}
	
}
