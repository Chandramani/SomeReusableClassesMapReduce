package util;

public class Attribute {
	private String name;
	private int ordinal = -1;
	private boolean id;
	private String dataType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrdinal() {
		return ordinal;
	}
	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}
	public boolean isId() {
		return id;
	}
	public void setId(boolean id) {
		this.id = id;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	public boolean isCategorical() {
		return dataType.equals("categorical");
	}

	public boolean isInteger() {
		return dataType.equals("int");
	}

	public boolean isDouble() {
		return dataType.equals("double");
	}

	public boolean isText() {
		return dataType.equals("text");
	}
}
