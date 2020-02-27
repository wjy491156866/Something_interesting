package csvtest;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
public class randomid {
	    public static void main(String []args) {
	    	//ArrayList的用法
        List<String> list = new ArrayList<String>();
	    	System.out.println(list.size());
	    	list.add("123");
	    	System.out.println(list.size());
	    	
	    	int edgeDevicesNum = 20, getDevicesCount=12;
			
		    Set<Integer> set1=new HashSet<Integer>();
			while(true){
				set1.add((int)(Math.random()*edgeDevicesNum+1));
				if(set1.size()== getDevicesCount)
					break;
			}
			System.out.println("hi3");
			System.out.println(set1);
			int[] result = new int[set1.size()];
			Iterator<Integer> it = set1.iterator();
			int count = 0;
	        while(it.hasNext()){
	            int s = it.next();
				result[count] = s;
				count++;
			}
			int percentage[] = {21,25,35,29}; //数组定义方法
			int datacentersList =0 , edgeID=0, index=0;
			for (int i = 0; i < 4; i++) {
			
				int instancesPercentage = percentage[i];

				// Find the number of instances of this type of devices
				float devicesInstances = getDevicesCount * instancesPercentage / 100;
			
				for (int j = 0; j < devicesInstances; j++) {
					if (datacentersList > getDevicesCount || index>= getDevicesCount) {
						System.out.println(
								"ServersManager- Wrong percentages values (the sum is superior than 100%), check edge_devices.xml file !");
						break;
					}
					edgeID = result[index];
					System.out.println(edgeID);
					index++;
					datacentersList= datacentersList+1;
				}
				System.out.println("hi3------");  
				System.out.println(index);    //for循环对a++的影响
				System.out.println(datacentersList);
				System.out.println("hi3++++++");
			}
			if (datacentersList < getDevicesCount )  // if percentage of																	// < 100%
				System.out.println(
					"ServersManager- Wrong percentages values (the sum is inferior than 100%), check edge_devices.xml file !");
			// Add more devices
			int missingInstances = getDevicesCount - datacentersList;
			for (int k = 0; k < missingInstances; k++) {
				edgeID = result[index];
				index++;
				System.out.println(edgeID);
				datacentersList= datacentersList+1;
			}
			System.out.println("hi3------");
			System.out.println(index);
			System.out.println(datacentersList);
			System.out.println("hi3++++++");
			

	  }
}
