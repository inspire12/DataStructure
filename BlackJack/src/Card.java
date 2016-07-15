
public class Card {
	int _value;
	char _shape;
	int _shuffle;
	
	public Card(){
		this._value=0;
		this._shape = '0';
		this._shuffle = 0;
	}
	public Card(int value, char shape){
		this._value=value;
		this._shape = shape;
		this._shuffle = 0;
	}
	public int get_shuffle() {
		return _shuffle;
	}

	public void set_shuffle(int _shuffle) {
		this._shuffle = _shuffle;
	}

	public void CardDelete(){
	
	}
	
	public int get_value() {
		return _value;
	}
	public void set_value(int _value) {
		this._value = _value;
	}
	public char get_shape() {
		return _shape;
	}
	public void set_shape(char _shape) {
		this._shape = _shape;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		switch (this._value) {
		case 10:
			return "("+this._shape +" , "+ 'J'+") ";
		case 11:
			return "("+this._shape +" , "+ 'Q'+") ";
		case 12:
			return "("+this._shape +" , "+ 'K'+") ";
				
		default:
			break;
		}
		return "("+this._shape +" , "+ this._value+") ";
	}
	
}
