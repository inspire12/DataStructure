package kruskals;

public class min {

	Edge _e[];
	int index;
	public min (int size){
		this._e  = new Edge[size];
		for(int i=0; i<size; i++)
			this._e[i] = new Edge();
		
		index = 0;
	}
	public void set_e(Edge[] e){
		this._e = e;
	}
	public void sort(){
		int size = this._e.length;
		for(int i=size-1; i>0; i--){
			for(int j=0;j<i;j++){
				if(this._e[j].get_length()>this._e[j+1].get_length()){
					swap(j,j+1);
				}
			}
		}
	}
	public Edge get_Edge(){
		if(index < this._e.length)
			return this._e[index++];
		else
			return null;
		
	}
	public boolean isFull(){
		if(index == this._e.length-1)
			return true;
		else 
			return false;
	}
	private void swap(int j, int i) {
		// TODO Auto-generated method stub
		Edge tmp = this._e[j];
		this._e[j] = this._e[i];
		this._e[i] = tmp;
		
	}
}
