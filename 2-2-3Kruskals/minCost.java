package Kruskals;

public class minCost {
	Edge[] edge;
	Edge[] minE;
	int size;
	
	
	// �ּ� ��� ���� Ʈ��
		//����Ʈ�� ��� ������ �����ϴ� ����Ʈ��
		//G�� n -> size ���� ������ ���� ��, G�� ����Ʈ���� n���� ������ n-1���� ���� ������? ���� 

		//����Ʈ���� ��� = ����Ʈ���� �������� ����ġ�� �� int cost; for()-�����Ѵ� ���� Ȯ�� {cost+=weight[][];} ���߿� �ּҸ� ����
		//������, ��� �Ǵܱ��� -> ����   => �ֻ��� ����
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
			//�������� ����� �����ϴ� ������ �����Ѵ�
			 
			System.out.println("xx");
			//�̹� T�� �ִ� ������� �Բ� ����Ŭ�� �������� ������ 
			
			//���� ����� ������ ��������� ���ʷ� T�� �߰��Ѵ�.
			//n���� ������ ������ ����׷��������� ��Ȯ�� n-1���� ������ ���õȴ�.
		}
		void connected(){
		
		}
		void sort(){
			//�̰� �Ϸ��� ������ �־�� �Ѵ�.  
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
