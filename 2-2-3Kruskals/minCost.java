package Kruskals;

public class minCost {
	Edge[] edge;
	Edge[] minE;
	int size;
	
	
	// 최소 비용 신장 트리
		//신장트리 모든 정점을 연결하는 서브트리
		//G가 n -> size 개의 저엄을 가질 때, G의 신장트리는 n개의 정점과 n-1개의 간선 간선도? 구성 

		//신장트리의 비용 = 신장트리의 간선들의 가중치의 합 int cost; for()-연결한는 점을 확인 {cost+=weight[][];} 이중에 최소를 선택
		//갈망법, 몇개의 판단기준 -> 뭐야   => 최상의 결정
		//
	public minCost(Edge[] edge2){
		this.edge = edge2;
	}
		void weightedunion() {
			
		}

		void collapsingfind() {

		}

		void kruskal() {
	
			sort();
			//간선들을 비용이 증가하는 순서로 정렬한다
			 
			System.out.println("xx");
			//이미 T에 있는 간선들과 함께 사이클을 형성하지 않으면 
			
			//적은 비용을 가지는 간선들부터 차례로 T에 추가한다.
			//n개의 정점을 가지는 연결그래프에서는 정확히 n-1개의 간산이 선택된다.
		}
		void connected(){
		
		}
		void sort(){
			//이거 하려면 엣지가 있어야 한다.  
				int size = this.edge.length;
				for(int i=size-1; i>0; i--){
					for(int j=0;j<i;j++){
						if(this.edge[j].get_weight()>this.edge[j+1].get_weight()){
							swap(j,j+1);
						}
					}
				}
			
		}
		private void swap(int j, int i) {
			// TODO Auto-generated method stub
			Edge tmp = this.edge[j];
			this.edge[j] = this.edge[i];
			this.edge[i] = tmp;
			
		}
}
