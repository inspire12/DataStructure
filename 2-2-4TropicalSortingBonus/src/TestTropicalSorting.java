import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class TestTropicalSorting {
	//유향 그래프  //위상정렬 
	//그래프를 만들고  솔팅, 스택사용해서 프린트
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		String readLine = null;
		String path = TestTropicalSorting.class.getResource("").getPath();
		FileReader fileReader = new FileReader(path+"hw04_bonus");
		BufferedReader reader = new BufferedReader(fileReader);
		
		readLine = reader.readLine();
		
		//행렬 생성
		Graph_pro04 graph_weight = new Graph_pro04(Integer.parseInt(readLine));
		
	     
	      for(int i=0; i<graph_weight.size; i++){
	         readLine = reader.readLine();
	         String vertex = readLine.split(" ")[0];
	    	 int grade = readLine.split(" ")[1].charAt(0);
	         graph_weight.vertices[i]=vertex;
	         graph_weight.a[i].setVertex(vertex);
	         
	         graph_weight.a[i].setGrade(grade);
	         
	      }
	      
	      readLine=reader.readLine();
	      while( readLine!=null){
	    	//띄어쓰기를 중심으로 
	    	 String to = readLine.split(" ")[0];
	    	 String from = readLine.split(" ")[1];
	    	
	    	 graph_weight.add(to, from);
	         readLine=reader.readLine();
	      }
	      graph_weight.topSorting();
	      
	      System.out.println("");
	}
	
}
