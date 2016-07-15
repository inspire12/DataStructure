package main;




 class Node { // 리스트 , 노드는 연결점 로 쓰인다. vertex는 요소(node에 담길)
		String vertex;
		int weight;
		Node next;

		Node(String vertex,int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		
		public Node() {
			this.vertex = null;
			this.weight = 0;
			this.next = null;
		}

		public Node(String vertex) {
			this.vertex = vertex;
		}

		public Node next() {
			return this.next;
		}
		public void setVertex(String v) {
			this.vertex = v;
		}

		public void setNext(Node n) {
			this.next = n;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		// 연결확인
		public Boolean isNext() {
			return this.next != null;
		}
	}