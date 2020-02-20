import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
public class randomnum {
    public static void main(String []args) {
        int edgeDevicesNum = 100, getDevicesCount=20;
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
		    //System.out.println(count);
		    for(int i=0; i<result.length; i++){
			      System.out.println(result[i]);
		    }
    }
}
