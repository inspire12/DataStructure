package hashing;

public class Entry {
	Object _value =null;
	Object _key = null;
	
	public Entry(){
	}
	
	public Entry(Object key,Object value){
		this._key=key;
		this._value=value;
	}
	
	public Object getKey(){
		return this._key;
	}
	public Object getValue(){
		return this._value;
	}
	public void setValue(Object value){
		this._value=value;
	}
}
