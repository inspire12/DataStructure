package main;

public class Graph_Weight {
	int size;
	public String[] vertices;
	Node_weight[] a;
	boolean visited[];
	int dist[];
	int prev[];

	public Graph_Weight(String[] args){
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new Node_weight[size];
		
		for(int i=0; i<size; i++){
			a[i] = new Node_weight();
		}
		
		for(int i=0; i<size; i++){
			a[i].setValue(vertices[i]);
		}
		visited = new boolean[size];
		dist = new int[size];
	}
	
	public Graph_Weight(int size2){
	//숫자 만ㅋ큼 간선을 만들어야한다.
		size =  size2;
		vertices = new String[size2];
		a = new Node_weight[size2];
		for(int i=0; i<size2; i++){
			a[i] = new Node_weight();
		}
		visited = new boolean[size2];
		dist = new int[size2];
		for(int i=0; i<size2; i++){
			dist[i] = 9999;
		}
		prev = new int[size2];
	}
	public void set_vertices(String s, int i){
		this.vertices[i] = s;
	}
	
	public void add(String v, String w, int weight){
		Node_weight tmp1 = new Node_weight(w);
		Node_weight tmp2 = new Node_weight(v);
		int i = index(v), j = index(w);
		
		tmp1.setNext(a[i]);
		tmp1.set_weight(weight);
		a[i] = tmp1;
		tmp2.setNext(a[j]);
		tmp2.set_weight(weight);
		a[j] = tmp2;
		
		
	}
	private int index(String v){
		for(int i=0; i<size; i++)
			if(vertices[i].equals(v)) {
				return i;
			}
		return a.length;
	}
	
	public void Dijkstra(){
		this.dist[0] = 0;
		while(!all_visited()){
			int min = 9999;
			int min_index = 0;
			for(int i=0; i<this.size; i++){
				if((min > this.dist[i]) && !this.visited[i]){
					min = this.dist[i];
					min_index = i;
				}
			}
			this.visited[min_index] = true;
			
			for(Node_weight no=this.a[min_index]; no.getNext()!=null; no=no.getNext()){
			//
				int j = this.index(no.getValue());
				int length = this.dist[min_index]+no.get_weight();
				
				if(length<dist[j]){
					dist[j] = length;
					prev[j] = min_index;
				}
			}
		}
	}
	public boolean all_visited(){
		boolean x = true;
		for(int i=0; i<this.size; i++){
			x = x&&this.visited[i];
		}
		return x;
	}
	public void print() {
		
		for(int i=0; i<this.size; i++){
			System.out.print(this.vertices[i]+" 거리 : "+this.dist[i]+" / ");
			this.printPath(i);
		}
	}
	public void printPath(int i){
		System.out.print(this.vertices[i]);
		while(i != 0){
			i = this.prev[i];
			System.out.print("<-"+this.vertices[i]);
		}
		System.out.println();
	}
	public String toString(){
		return (this.vertices+" 거리 : "+this.dist+"/ ");
	}
	
}
