import java.util.Comparator;



public class Entry implements Comparator<Entry>{
	char _key;
	int _freq=0;
	
	public char add(char input){
			
		this._key=input;
		return input;
	}

	

	
	public char get_key() {
		return _key;
	}




	public void set_key(char _key) {
		this._key = _key;
	}




	public int getFreq() {
		return _freq;
	}




	public void setFreq(int freq) {
		this._freq = freq;
	}




	@Override
	public int compare(Entry o1, Entry o2) {
		// TODO Auto-generated method stub
		if(o1.getFreq()<o2.getFreq()){
			return -1;
		}if(o1.getFreq()<o2.getFreq()){
			return 1;
		}
		return 0;
	}

	
}
