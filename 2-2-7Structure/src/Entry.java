

public class Entry {
	String _value=null;
	
	Key _element=null;
	
	
	public Entry(){
		this._element = new Key();
	}
	
	public Entry(String key){
		this._element= new Key(key,1);
		this._value=null;
		
	}
	public Entry(Key element){
		this._element = element;
	}
	public Entry(String key,String value){
		this._element= new Key(key,1);
		
		this._value=value;
	}
	
	public Key getKey(){
		return this._element;
	}
	public String getValue(){
		return this._element._element;
	}
	public void setValue(String value){
		this._value=value;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this._element+"\n";
	}
}
