package Kruskals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestGraph_pro01 {

	// static int numberOfEdge=0;
	   
@SuppressWarnings("resource")
public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
    String path = TestGraph_pro01.class.getResource("").getPath();
	FileReader fileReader = new FileReader(path+"hw02");
	BufferedReader reader = new BufferedReader(fileReader);
	String tmp = null;
	tmp = reader.readLine();
	
	//행렬 생성
	Graph_pro01 graph_weight = new Graph_pro01(Integer.parseInt(tmp));
	
     
      for(int i=0; i<graph_weight.size; i++){
         tmp = reader.readLine();
         graph_weight.vertices[i]=tmp;
      }
      
      tmp=reader.readLine();
      while( tmp!=null){
    	//띄어쓰기를 중심으로 
    	 
    	 String to = tmp.split(" ")[0];
    	 String from = tmp.split(" ")[1];
    	 String weight = tmp.split(" ")[2];
    //	 numberOfEdge++;
    	 graph_weight.add(to, from, Integer.parseInt(weight));
         tmp=reader.readLine();
      }
      
     graph_weight.DFS();
     graph_weight.kruskal();
     
      }
}
