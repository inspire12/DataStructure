package hashing;

public class hashTable_double implements Map{
	private Entry[] entries;
	private int size, used;
	private float loadFactor;
	private Entry NIL = new Entry(null,null);;
	private int collins = 0;
	
	public hashTable_double(int capacity,float loadFactor) {
		// TODO Auto-generated constructor stub
		entries= new Entry[capacity];
		this.loadFactor= loadFactor;
	
	}
	
	public hashTable_double(int capacity) {
		// TODO Auto-generated method stub
		this(capacity,0.5F);  //적재율 50퍼
	}
	
	public Object get(Object key) {
		// TODO Auto-generated method stub
		int h = hash(key); int d = hash2(key);
		printISO((String)key);
		for(int i=0; i<entries.length;i++){
			int j=nextProbe(h,d, i);
			printCollins(j);
			Entry entry = entries[j];
			if(entry==null)break;
			if(entry==NIL)continue;
			if(entry.getKey().equals(key)) return entry.getValue();
		}
		return null; //없어
	}
	private void printCollins(int h){
		System.out.print("->"+h);
	}
	private void printISO(String iso){
		System.out.printf("\n%d"+ ". "+iso,this.size+1 );
	}
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		//RETURN oldValue
		if(used>loadFactor*entries.length) rehash();
		int h = hash(key);int d= hash2(key);
		printISO((String) key);
	
		for(int i=0; i<entries.length;i++,++collins){
			
			int j = nextProbe(h,d, i);
			printCollins(j);
			Entry entry = entries[j];
			if(entry==null){
				entries[j]=new Entry(key,value);
				++size;
				++used;
				
				return null;
			}
		}
		entries[hash(key)]=new Entry(key,value);
		++size;
		return value;
	}
	public void printCollins(){
	
		System.out.println("\n"+collins +" 충돌함");
	}
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		int h = hash(key);
		
		for(int i=0;i<entries.length;i++){
			int j =nextProbe(h, i);
			Entry entry= entries[j];
			if(entry==null)break;
			if(entry==NIL)continue;
			if(entry.getKey().equals(key)){
				Object oldValue = entry.getValue();
				entries[j]=NIL;
				--size;
				return oldValue;
			}
		}
		
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	private void rehash(){
		Entry[] oldEntries = this.entries;
		entries= new Entry[2*oldEntries.length+1];
		for(int k=0; k<oldEntries.length;k++){
			Entry entry = oldEntries[k];
			if(entry==null||entry==NIL)continue;
			int h =hash(entry.getKey());
			for(int i =0; i<entries.length;i++){
				int j = nextProbe(h, i);
				
				if(entries[j]==null){
					entries[j]=entry;
					break;
				}
			}
		}
		used=size;
	}
	private int hash(Object key){  
		if(key==null)throw new IllegalArgumentException();
		return (key.hashCode()&0x7FFFFFFF)% entries.length;
	}
	private int hash2(Object key){
		if(key==null)throw new IllegalArgumentException();
		return 1+(key.hashCode()&0x7FFFFFFF)% (entries.length-1);
	}
	private int nextProbe(int h, int i){
		return (h+i*i)% entries.length;
	}
	private int nextProbe(int h, int d,int i){
		return (h+i*d)% entries.length;
	}
	private void printName(){
		System.out.println("=================================");
		System.out.println("hashTable_Double");
	}
	public void print(){
		printName();
		this.put("AT", new Country("Austria","German",32378,8139299));
		this.put("BE", new Country("Belgium","Dutch",11800,10182034));
		this.put("DE", new Country("Germany","German",137800,82087361));
		this.put("DK", new Country("Denmark","Danish",16639,5356845));
		this.put("ES", new Country("Spain","Spanish",194880,39167744));
		this.put("FR", new Country("France","French",211200,58978172));
		this.put("IT", new Country("Italy","Italian",116300,56735130));
		this.put("LU", new Country("Luxembourg","French",998,429080));
		this.put("SE", new Country("Sweden","Portuguese",35672,9918040));
		this.printCollins();
	}
}
