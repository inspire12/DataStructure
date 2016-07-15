package prob01;

//인접 리스트에 가중치 를 추가하자
public class Graph_Weighted {
	int size;
		List[] a; //adjacencylist
	
	public Graph_Weighted(String[] args){
		size = args.length;
		a= new List[size];
		for (int i=0; i<size ; i++){
			a[i] = new List(args[i]);
		}
	}
	public void add(String v, String w){
		a[index(v)].add(index(w));
		a[index(w)].add(index(v));
	}
	public String toString(){
		return null;
	}
	private int index(String v){
		//값과 해당 
		for (int i =0;i<size; i++){
			if(a[i].vertex.equals(v)){
				return i;
			}
		}
		return a.length;
	}
	
	private class List{
		String vertex; 
		Node edges;  
		List(String vertex){ 
			this.vertex = vertex;
		}
		public void add(int j){ 
			edges = new Node(j,edges);
		}
		public String toString(){
			StringBuffer buf = new StringBuffer(vertex);
			
			if(edges !=null){
				buf.append(":");
			}
			for(Node p=edges; p!=null; p =p.next){
				buf.append(Graph_Weighted.this.a[p.to].vertex);
			}
			return buf+"";
		}
	}
	private class Node{  //리스트 , 노드는 연결점 로 쓰인다. vertex는 요소(node에 담길)
		int to; Node next;
		Node(int to,Node next){
			this.to = to; this.next = next;
		}
	}
	public void findShortestPaths() {
		// TODO Auto-generated method stub
		
	}
}

