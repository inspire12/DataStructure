package prob01;


public class Graph_pro01 {//���� ����� ����� �׷���
	int size;
	String[] vertices;
	boolean[][] a;
	
	public Graph_pro01(String[] args){  //������ �ϴ� ������ ������ ���� ���� ��� ũ�⸦ 2�����迭�� ������ �Ѵ�.
		
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0 , size);
		a = new boolean[size][size];
	}
	
	public void add(String v, String w){ //�߰��Ҷ�
		int i = index(v);
		int j = index(w);
		a[i][j] = a[j][i] = true;
	}
	
	public String toString(){ //��º�
		if(size==0){
			return "{}";
		}
		StringBuffer buf = new StringBuffer("{"+ vertex(0));
		for(int i=1; i<size; i++){
			buf.append(","+ vertex(i));
		}
		return buf + "}";
	}
	
		
	
	private int index(String v){
		for(int i =0; i<size; i++){
			if(vertices[i].equals(v)){
				return i;
			}
		}
		return a.length;
	}
	
	private String vertex(int i){
		StringBuffer buf = new StringBuffer(vertices[i]+":"); //StringBuffer ���ο� ��ü�� �������� �ʰ� �̾��
		for(int j =0; j<size;j++){
			if(a[i][j]){
				buf.append(vertices[j]);  //buf.append�� ����
			}
		}
			return buf+"";
	}
	
	public void DFS(){ //������ �̿��ؼ�
		ArrayList<String> list = new ArrayList<String>();
		boolean[] visited = new boolean[size]; //����Ǿ��ִ´� �ƴ���
		
		//������ �ֱ�
		int tmp=0; 
		list.push(vertices[tmp]); //��
		visited[tmp]=true;
		System.out.print("{");
		while(!list.isEmpty()){  //
		
			//����ϴ� ����Ȯ��
			for(int i=0; i<size; i++){
				String stmp = (String) list.peek();
				if(stmp.equals(vertices[i])){ 
					tmp=i;   //�ش��ϴ� ���̷� �������ش�.
					break;
				}
			}
			if(!list.isEmpty()){
				System.out.print("->");
			}		
			System.out.print(list.pop() );
			
			//�ִ� ����Ȯ�� 
			for(int i=0; i<size; i++){	
				if(a[tmp][i]&&  !visited[i]){
					visited[i]=true;   //�ߺ� �ݹ����� �ʵ���
					list.push(vertices[i]);
				}
			}
		}
		System.out.println("}");
	}

}
