package kruskals;

public class kruskal {
	private int[] _set;
	private Edge[] _e;
	private int cost;
	private min m;
	private Edge[] kk;
	int numberOfEdge;
	
	public kruskal(int size, int sizeV){
		this._e = new Edge[size];
		this._set = new int[sizeV];
		this.cost = 0;
		kk = new Edge[size];
		numberOfEdge = 0;
		
		for(int i=0; i<size; i++){
			this._e[i] = new Edge();
			kk[i] = new Edge();
		}
		for(int i=0; i<sizeV; i++)
			this._set[i] = -1;
		m = new min(size);
	}
	public int collapsingfind(int index){
		
		while(_set[index]!=-1){
			index = _set[index];
		}
		return index;
	}
	public void weightedunion(int i, int j){
		if(i<j)
			_set[j] = i;
		else
			_set[i] = j;
	}
	public void kruskal(){
		m.sort();
		
		while((numberOfEdge<this._set.length-1)&&(!m.isFull())){
			Edge tmpE = m.get_Edge();
			if(this.collapsingfind(this.VertexToIndex(tmpE.get_head())) != this.collapsingfind(this.VertexToIndex(tmpE.get_tail()))){
				kk[numberOfEdge++] = tmpE;
				this.weightedunion(this.VertexToIndex(tmpE.get_head()), this.VertexToIndex(tmpE.get_tail()));
				cost = cost+tmpE.get_length();
				
			}
			
		}
	}
	public String toString(){
		String tmp ="";
		for(int i=0; i<numberOfEdge; i++){
			tmp = tmp+"["+kk[i].get_head()+" "+kk[i].get_tail()+"],";
		}
		return tmp;
	}
	
	
	public int VertexToIndex(String vertex){
		char v = vertex.charAt(0);
		int index=0;
		for(char c='a'; c<'z'; c++){
			if(c ==v) 
				break;
			else
				index++;
		}
		return index;
	}
	public int[] get_set() {
		return _set;
	}

	public Edge[] get_e() {
		return _e;
	}

	public void set_e(Edge[] e) {
		this._e = e;
		m.set_e(e);
	}
	public int getcost(){
		return this.cost;
	}
	
	
	
}
