package csvtest;

import java.io.BufferedReader;
import java.io.FileReader;




public class csvread {
	

	public static void main(String[] args) {
    	   
    	   int id = 16;
    	   String ID = Integer.toString(id);
    	   
    	   System.out.println("Hello World!");
    	   
    	   String fileName = "F:\\AGI\\" + ID + ".csv";
    	   
           String i1 = "";
           String i2 = "";
           String i3 = "";
           try {
               BufferedReader reader = new BufferedReader(new FileReader(fileName));//换成你的文件名
               reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
               String line = null;
               while((line = reader.readLine()) != null){
                   String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分

                   if (item[0].equals("8")){ // 这个2就是第二种情况根据仿真时间对应的东西
                       i1 = item[1];
                       i2 = item[2];
                       i3 = item[3];
                       break;
                   }
               }
               reader.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
       
           System.out.println(i1 + " " + i2 + " " + i3);
           
           double xpos = Double.parseDouble(i1);
           double ypos = Double.parseDouble(i2);
           double zpos = Double.parseDouble(i3);
           System.out.println(xpos + " " + ypos + " " + zpos);
      
           

       }

   }
