

package util;

import java.util.ArrayList;
import java.util.List;

public class FeatureCount  {
	private int ordinal;
	private String type;
	private List<BinCount> counts = new ArrayList<BinCount>();
	private double laplaceProb;
	
	public FeatureCount( int ordinal, String type) {
		super();
		this.ordinal = ordinal;
		this.type = type;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	

	public List<BinCount> getCounts() {
		return counts;
	}

	public void setCounts(List<BinCount> counts) {
		this.counts = counts;
	}

	public void addBinCount(BinCount binCount) {
		boolean added = false;
		for (BinCount thisBinCount : counts) {
			if (thisBinCount.getBin().equals(binCount.getBin())){
				thisBinCount.addCount(binCount.getCount());
				added = true;
			}
		}
		
		if (!added){
			counts.add(binCount);
		}
	}
	
	public void normalize(int total) {
		for (BinCount binCount : counts) {
			binCount.normalize(total);
		}
		laplaceProb = 1.0 / (1 + total);
	}	
	
	public double getProb(String bin) {
		double prob = laplaceProb;
		for (BinCount binCount : counts) {
			if (binCount.getBin().equals(bin)) {
				prob = binCount.getProb();
				break;
			}
		}		
		return prob;
	}
}
