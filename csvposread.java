package csvtest;

public class csvposread {
	
	public static void printpos(int id, int timeindex){
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
	}
	
}