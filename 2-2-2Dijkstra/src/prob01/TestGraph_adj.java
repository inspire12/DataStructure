package prob01;

import java.io.IOException;

public class TestGraph_adj {
	public static void main(String[] args) throws IOException{
		
		Graph_Weighted g = new Graph_Weighted(args);//이미 생성자에서 InputStream으로 값을 저장ㅇ해서 만들어짐
		 System.out.println("충발점을 입력하세요."); 
		 
		 g.findShortestPaths();
		 	
	}
}
