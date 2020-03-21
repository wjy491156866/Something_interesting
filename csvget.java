package csvtest;

import java.io.BufferedReader;
import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

public class csvget{

	public static void main(String[] args) {
		System.out.println("###################################################################");
		int id1 = 24;
		double time1 = 7200;
    	System.out.println("Hello World!");
    	int timeindex1 = (int)time1;
    	//String fileName = "F:\\AGI\\test\\" + ID + ".csv";
    	//String fileNameedge = "C:\\Users\\HASEE\\Desktop\\locationfile\\cloud\\cloud Fixed Position.csv";
    	//String fileNameedge = "C:\\\\Users\\\\HASEE\\\\Desktop\\\\locationfile\\\\edge_devices\\mist Fixed Position.csv";
    	String fileNameedge = "C:\\Users\\HASEE\\Desktop\\locationfile\\edge_datacenter\\edge Fixed Position.csv";
    	   
    	   
    	long startTime1=System.currentTimeMillis();
    	int count1= Getlocationtimenum(fileNameedge,id1,(int)timeindex1);
    	System.out.println("The node num:"+count1);
    	long endTime1=System.currentTimeMillis(); 
    	System.out.println("第一次耗时： " + (endTime1-startTime1));
    	System.out.println("###################################################################");
    	   
    	   
    	//List<Map<String,List<String>>> locationinfo =Getlocationtime(fileNameedge);
    	//List<Map<String,List<String>>> locationinfo = csvread.Getlocationtime(fileNameedge);
    	long startTime2=System.currentTimeMillis();
    	csvread.locationinfo = csvread.Getlocationtime(fileNameedge);
    	csvposread.printpos(id1, timeindex1);
    	long endTime2=System.currentTimeMillis(); 
    	System.out.println("第二次耗时： " +(endTime2-startTime2));
    	System.out.println("###################################################################");
    	
    	long startTime5=System.currentTimeMillis();
    	csvposread.printpos(id1, timeindex1);
    	long endTime5=System.currentTimeMillis(); 
    	System.out.println("第二+一次耗时： " +(endTime5-startTime5));
    	System.out.println("###################################################################");
    	
    	int id2 = 20;
		double time2 = 6554;
		System.out.println("Hello World!");
		int timeindex2 = (int)time2;
    	   
		long startTime3=System.currentTimeMillis();
		int count2= Getlocationtimenum(fileNameedge,id2,(int)timeindex2);
	    System.out.println("The node num:"+count2);
	    long endTime3=System.currentTimeMillis(); 
	    System.out.println("第三次耗时： " + (endTime3-startTime3));
	    System.out.println("###################################################################");
			
			
    	long startTime4=System.currentTimeMillis();
    	csvposread.printpos(id2, timeindex2);
    	long endTime4=System.currentTimeMillis(); 
    	System.out.println("第四次耗时： " + (endTime4-startTime4));
    	System.out.println("###################################################################");
    	   
    	   /*
    	   String i1 = "";
	       String i2 = "";
	       String i3 = "";
    	   if (csvread.locationinfo.size() !=0) {
    		   
    		   //System.out.println(locationinfo);
    		   if(!(csvread.locationinfo.get(1).isEmpty())) {
    			   int timenum = csvread.locationinfo.get(1).get("1").size();
    			   System.out.println("The time num:" + (timenum-2));
    			   
    			   i1 = csvread.locationinfo.get(id-1).get("2").get(timeindex+1);
        		   i2 = csvread.locationinfo.get(id-1).get("3").get(timeindex+1);
        		   i3 = csvread.locationinfo.get(id-1).get("4").get(timeindex+1);
    		   }
    		   else {
    			   System.out.println("map is null");
    		   }
 	   
    		   System.out.println("The node ID: "+ id);
    		   System.out.println("The time: "+ timeindex);

    		   double xpos = Double.parseDouble(i1);
    		   double ypos = Double.parseDouble(i2);
    		   double zpos = Double.parseDouble(i3);
    		   System.out.println("The location is: "+xpos + "," + ypos + "," + zpos);   
    		   int size = csvread.locationinfo.size();	   
    		   System.out.println("List The node num:"+size);
    	   }
    	   else {
    		   System.out.println("List is null");
    	   }
    	   */
    	}
	/*
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
	*/
	
	
	
	
	public static int Getlocationtimenum(String fileName, int id, int time){
		int count=0,count1=0,count2=0;  //出去标题和第0秒
        String i1 = "";
        String i2 = "";
        String i3 = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));//换成你的文件名
            String line = null;
            while((line = reader.readLine()) != null){
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                if (item[0].equals("\"Time (EpSec)\"")){ //统计节点数量
                	count1++;
                }
                if (count1 == 1) {
                	if(!(item[0].equals("\"Time (EpSec)\"")) && !(item[0].equals(""))) {
                		count++;
                	}
                }
            }
            System.out.println("The time num:" + (count-1));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }  
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));//换成你的文件名
            String line = null;
            while((line = reader.readLine()) != null){
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                if (item[0].equals("\"Time (EpSec)\"")){ // 这个2就是第二种情况根据仿真时间对应的东西
                	count2++;
                }
                if (count2 == id) {
                	if(!(item[0].equals("\"Time (EpSec)\"")) && !(item[0].equals(""))) {
                		if((int)Double.parseDouble(item[0])== time) {
                			i1 = item[1];
                			i2 = item[2];
                			i3 = item[3];
                			System.out.println("The node ID: "+ count2);
                			System.out.println("The time: "+ time);
                			break;
                		}
                	}
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        double xpos = Double.parseDouble(i1);
        double ypos = Double.parseDouble(i2);
        double zpos = Double.parseDouble(i3);
        System.out.println("The location is: "+xpos + "," + ypos + "," + zpos);
        return count1;
	}
}