package csvtest;

import java.io.BufferedReader;
import java.io.FileReader;

public class csvrownum {

	public static void main(String[] args) {
    	   
    	   int id = 1;
    	   String ID = Integer.toString(id);
    	   
    	   System.out.println("Hello World!");
    	   
    	   //String fileName = "F:\\AGI\\test\\" + ID + ".csv";
    	   String fileNameedge = "D:\\Others\\eclipse\\Workspace\\PureEdgeSim_2.2.4\\PureEdgeSim\\settings\\locationflie\\edge_devices\\edge" + ID + ".csv";
    	   int count= Getlocationtimenum(fileNameedge);

    	   System.out.println(count);

       }
	
	public static int Getlocationtimenum(String fileName){
      int count=0;  //不除比标题
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            while((reader.readLine()) != null){
            	count++;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
	}
}
