
public class Key {
	int element;
	int arrayNumber;
	public Key(){
		
	}
	public Key(int a){
		this.arrayNumber=a;
	}
	public Key(int e,int a){
		this.element=e;
		this.arrayNumber=a;
	}
	public int getElement() {
		return element;
	}
	public void setElement(int element) {
		this.element = element;
	}
	public int getArrayNumber() {
		return arrayNumber;
	}
	public void setArrayNumber(int arrayNumber) {
		this.arrayNumber = arrayNumber;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.element+", "+this.arrayNumber+"번째 배열에서 온 정렬  ";
	}
}
