package externalSort;

public class Element {
	private int index;
	private int value;
	
	public Element(){
		index = 0;
		value = 0;
	}
	public Element(int i, int v){
		index = i;
		value = v;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
