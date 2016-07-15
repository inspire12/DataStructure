package hashing;

public interface Map {
	public Object get(Object key);
	
	public Object put(Object Key,Object value);
	
	public Object remove(Object key);
	
	public int size();
}
