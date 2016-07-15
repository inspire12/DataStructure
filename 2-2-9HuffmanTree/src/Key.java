
public class Key {
	String _element;
	int _count;
	public Key(){
		this._count=0;
	}
	public Key(String element){
		this._element=element;
		this._count=1;
	}
	public Key(String element,int count){
		this._element=element;
		this._count=count;
	}
	public String get_element() {
		return _element;
	}
	public void set_element(String _element) {
		this._element = _element;
	}
	public int get_count() {
		return _count;
	}
	public void set_count(int _count) {
		this._count = _count;
	}
	public String toString(){
		return this._element +" : "+this._count +"\n";
	}
}
