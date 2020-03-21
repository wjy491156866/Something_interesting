package csvtest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class csvread {
	public static List<Map<String,List<String>>> locationinfo;
	
	public static List<Map<String,List<String>>> Getlocationtime(String fileName){	  
		  List<Map<String,List<String>>> data = new ArrayList<>();	//全部数据
		  Map<String,List<String>> map = new HashMap<>();	//记录每一块数据
		  List<String> list1 = new ArrayList<>();	//第一列
		  List<String> list2 = new ArrayList<>();	//第二列
		  List<String> list3 = new ArrayList<>();	//第三列
		  List<String> list4 = new ArrayList<>();	//第四列
		  try {
			  BufferedReader reader = new BufferedReader(new FileReader(fileName));//换成你的文件名
		      String line = null;
		      while((line = reader.readLine()) != null){
		    	  String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
		    	  if (!(item[0].equals(""))){
		    		  list1.add(item[0]);
		    		  list2.add(item[1]);
		    		  list3.add(item[2]);
		    		  list4.add(item[3]);
		    	  }
		    	  else {
		        	  map.put("1",list1);
		        	  map.put("2",list2);
		        	  map.put("3",list3);
		        	  map.put("4",list4);
		        	  data.add(map);
		        	  list1 = new ArrayList<>();
		        	  list2 = new ArrayList<>();
		        	  list3 = new ArrayList<>();
		        	  list4 = new ArrayList<>();
		        	  map = new HashMap<>();
		          }
		      }
		      reader.close();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  return data;
	}
	
}