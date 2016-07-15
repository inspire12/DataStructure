

public class hashing implements Map {

	private Entry[] entries;
	private int size, used;
	private float loadFactor =(float) 0.75;
	private Entry NIL = new Entry(null,null);;
	private int collins = 0;

	public static int countAccess =0;
	
	public hashing(int capacity,float loadFactor) {
		// TODO Auto-generated constructor stub
		entries= new Entry[capacity];
		this.loadFactor= loadFactor;
	
	}
	private void incAceess(){
		hashing.countAccess++;
	}
	public hashing(String a){
		
	}
	public int howManyCollins(){
		return this.collins;
	}
	public hashing(int capacity) {
		// TODO Auto-generated method stub
		this(capacity,0.75F);
	}
	public hashing() {
		// TODO Auto-generated constructor stub
		this(101);
	}
	public String get(String key) {
		// TODO Auto-generated method stub
		incAceess();
		int h = hash(key);
		for(int i=0; i<entries.length;i++){
			int j=nextProbe(h, i);
			Entry entry = entries[j];
			if(entry==null)break;
			if(entry==NIL)continue;
			if(entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return null; //없어
	}
	private void printCollins(int h){
		System.out.print("->"+h);
	}
	private void printISO(String iso){
		System.out.printf("\n%d"+ ". "+iso,this.size+1 );
	}
	public void put(String key) {
		// TODO Auto-generated method stub
		//RETURN oldValue
	
		if(used>loadFactor*entries.length){
			rehash();
		}
		int h = hash(key); 
		//int d = hash2(key);
		//printISO((String) key);
		
		for(int i=0; i<entries.length;i++,++collins){
			
			int j = nextProbe(h, i);
			//printCollins(j);
			Entry entry = entries[j];
			incAceess();
			if(entry==null){
				entries[j]=new Entry(key);
				++size;
				++used;
				break;
			}else{
				String a =entries[j].getValue().toString();
				String b =key.toString();
				if(a.equals(b)){
				entries[j]._element._count++;
				++size;
				break;
				}
				
			}
		}
		//entries[hash(key)]=new Entry();
		++size;
	
	}
	
	
	public void printCollins(){
	
		System.out.println("\n"+collins +" 충돌함");
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
			int h =hash(entry.getKey().get_element());
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
	private int hash(String key){  
		if(key==null)throw new IllegalArgumentException();
		return (key.hashCode()&0x7FFFFFFF)% entries.length;
	}

/*	private int hash2(Object key){
		if(key==null)throw new IllegalArgumentException();
		return 1+(key.hashCode()&0x7FFFFFFF)% (entries.length-1);
	}*/
	private int nextProbe(int h, int i){
		return (h+i)% entries.length;
	}
	/*	private int nextProbe(int h, int d,int i){
		return (h+i*d)% entries.length;
	}*/
	private void printName(){
		System.out.println("=================================");
		System.out.println("hashTable_Linear");
	}
	public void print(){
		printName();
		this.printCollins();
	}
	@Override
	public String put(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}
	public String toString(){
		String a= "";
	//+hashing.countAccess;
		int i =0;
		while(i<entries.length){
			if(entries[i]!=null){
			a+=entries[i]._element;
			}
			i++;
		}	
		return a;
	}
	@Override
	public String remove(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}

	
	

	