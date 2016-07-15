package prob02;

//s
public class TestGraph_pro02 {
	public static void main(String[] args){
		
		Graph_pro02 g = new Graph_pro02(new String[]{"SE", "UK", "DE", "FR", 
	            "CZ", "CH", "AT", "IT"});
		 System.out.println(g);
		 g.add("SE", "UK"); //Edge 추가 
		 g.add("SE", "DE");
		 g.add("UK", "FR");
		 g.add("DE", "FR");
		 g.add("DE", "IT");
		 g.add("DE", "CZ");		
		 g.add("CH", "FR");
		 g.add("CH", "IT");
		 g.add("CH", "AT");

		 System.out.println("깊이우선탐색 입니다.");
			g.DFS();
			
	}
}
