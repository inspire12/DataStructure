package prob01;

//리스트를 이용해서 구현하기
public class TestGraph_pro01 {
	public static void main(String[] args) {

		Graph_pro01 g = new Graph_pro01(new String[] { "SE", "UK", "DE", "FR",
				"CZ", "CH", "AT", "IT" });

		System.out.println(g); // 초기 그래프 정보 출력

		System.out.println("깊이 우선 탬색의 결과입니다.");
		g.add("SE", "UK"); // Edge 추가
		g.add("SE", "DE");
		g.add("UK", "FR");
		g.add("DE", "FR");
		g.add("DE", "IT");
		g.add("DE", "CZ");
		g.add("CH", "FR");
		g.add("CH", "IT");
		g.add("CH", "AT");
		
		g.DFS();

	}

}
