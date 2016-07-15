package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {


public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      
   
	FileReader fileReader = new FileReader(""+"hw02");
	BufferedReader reader = new BufferedReader(fileReader);
	String tmp = null;
	tmp = reader.readLine();
	Graph_Weight graph_weight = new Graph_Weight(Integer.parseInt(tmp));
	
      //
      for(int i=0; i<graph_weight.size; i++){
         tmp = reader.readLine();
         graph_weight.set_vertices(tmp, i);
      }
      
      tmp=reader.readLine();
      while( tmp!=null){
    	//띄어쓰기를 중심으로 
    	 String to = tmp.split(" ")[0];
    	 String from = tmp.split(" ")[1];
    	 String weight = tmp.split(" ")[2];
    	 
    	 graph_weight.add(to, from, Integer.parseInt(weight));
         tmp=reader.readLine();
      }
      
      graph_weight.Dijkstra();
      graph_weight.print();
      }
}
