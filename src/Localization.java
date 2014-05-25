import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;




public class Localization {
	
	
	int sampleid=0; 
	//String ssid = null; 
	String bssid= null;
	int rssi;
	static int i=1;
	//static int i=0;
	
	
	//static String filename = "/home/swifferayubu/c1.csv";
	static String filename = "c1.csv";
	static String testfile = "test.csv";
	static String testfile2 = "test2.csv";
	
	
	static final int columnID_AP = 2;
	static final int columnID_endofCSV = 3;
	
	
	public static void main(String args[]) throws FileNotFoundException {
		
		float [] data_test = {-14, -100, -40, - 59, -74};
		
		float [] hst;
		
	
		//Get scanner instance
		Scanner scanner = new Scanner(new File(filename));
		String data = "";
		//Set the delimiter used in file
		scanner.useDelimiter(",");

			
		Scanner s = null;

		ArrayList list_ap ;
		
		//		s.useDelimiter(",");
	//	s.useDelimiter(",\\s*");
		
		try{
			s = new Scanner((Readable) new BufferedReader(new FileReader(testfile2)));
			//s.useDelimiter(",");
			//s.useDelimiter(",\\s*\n*");
			s.useDelimiter(",|\n\n|\n"); // ski
		
			/* get list of all AP's */
			//list_ap = fetchAP(s);
			list_ap = fetchAP_sample(s);
			
			System.out.println("List of AP " + list_ap);
			
			
			/*create histogram for a specific AP */
			//create_histogram((String) list_ap.get(0));
			
			
				

		}finally{
			if(s != null) s.close();
			
		}
		
		
	/*	hst=createHistogram(data_test) ; 
		
		for(int i=0; i<hst.length; i++){
		//	System.out.println("i: "+i, "freg:"+hst[i] );
		
				
		}
	
		
		
		
		//Get all tokens and store them in some data structure
		//I am just printing them
		while (scanner.hasNext()) 
		{
		    data = scanner.next();
*/	/*		if((i % 9) ==0 )
				System.out.println(data + "|" + i);
			
			i ++;
		*/
		    
		/*    if (i == 0)
               // emp.setId(Integer.parseInt(data));
            else if (i == 1)
                //emp.setName(data);
            else if (i == 2)
                //emp.setRole(data);
            else if (i == 3)
                //emp.setSalary(data);
            else
            	   System.out.println("invalid data::" + data);
            i++; 
		  */  
		    
	//	}
		
		//Do not forget to close the scanner  
		//scanner.close();
   
	
		
		
	
	}


	/* 
	 * Fetch AP from a list in csv file, only the first sample
	 * */
	public static ArrayList fetchAP_sample(Scanner s){
		String data1=null;
		ArrayList list_ap = new ArrayList();

    	/*skip he first line, header */
    s.nextLine();
		//	System.out.println(s.nextLine());
    	
    	
    	do{
    	//	System.out.println("......");
    		/*find only AP from first samples */
    		if(s.findInLine("1") != null){
    		
    				/* get AP name */
    			for(int j=1; j<columnID_AP; j++ ){
    				data1=s.next(); 
    				list_ap.add(data1);
    			}
    		//	System.out.println("AP: "+data1); //Apple
    			
    		}	
    		
    		
    		/*advance to the next line */
		    s.nextLine();
    		//System.out.println("nextline: " + s.nextLine());
			//System.out.println("hasnextline?: "+s.hasNextLine());
			
		
    	}while(s.hasNextLine()==true);
    	
    	
    	
    	  	
    	
//		while(s.hasNextLine())
	//		{
		/*	  System.out.println("line id:" +i);
			  data1=s.findInLine("1");
			  System.out.println(data1); //Apple
			
			for(int j=1; j<columnID_AP; j++ ){
				data1=s.next(); 
							
			}
			System.out.println(data1); //Apple
			
			while((data1 == null) && (s.hasNextLine()== true) )
			{
				s.nextLine();
				System.out.println(data1);
				
				data1 = s.findInLine(" 1");
				System.out.println(data1);
				
				
			}
			*/
			
			/*find next occurance of 1st sample */
		//data1=	s.nextLine();
		//System.out.println(s.next());
	//		System.out.println(s.next());
			
			
		//  System.out.println(data1); 
			
		//	data1=s.findInLine("1");
			  
		//	  System.out.println(data1); //Apple
				
		/*		for(int j=0; j<columnID_AP; j++ ){
					data1=s.next(); 
								
				}
				System.out.println(data1); //Apple
					
			*/
			
		//	System.out.println(data1); //1
			/*get AP column */
		//	data1=s.next(); 
		//	System.out.println(data1); //Apple
			
		//	data1=s.next(); 
		//	System.out.println(data1); //2
			
	//		data1=s.next();
		//	System.out.println(data1); //next row //2
			
		//	data1=s.next();
			
		//	System.out.println(data1);
			
			
			  //data1 = s.next();
				//System.out.println(data1);
				
				//if(i==columnID_endofCSV ) i=0;
		
				//if(i==columnID_AP ){
				//if(i==(columnID_AP-1) ){
					//list_ap.add(data1);
				//}	
				
							
		//		i++;
		//	}
		
    	return list_ap;
    	
    	
    }

	
	
	
	
    public static ArrayList fetchAP(Scanner s){
		String data1=null;
		ArrayList list_ap = new ArrayList();

    	
    	s.nextLine();
		while(s.hasNext())
			{
			 //  System.out.println("id:" +i);
				data1 = s.next();
				//System.out.println(data1);
				
				if(i==columnID_endofCSV ) i=0;
		
				if(i==columnID_AP ){
				//if(i==(columnID_AP-1) ){
				//	System.out.println(data1);
					list_ap.add(data1);
				}	
				
							
				i++;
			}
				
    	return list_ap;
    	
    	
    }
    
	public static void create_histogram (String ap) throws FileNotFoundException{
		Scanner s = new Scanner((Readable) new BufferedReader(new FileReader(testfile2)));
		String sample=null;
	
		try{
			
			/* search through file for given AP*/
			System.out.println(" AP  " + ap );
			sample=s.findInLine(ap); 
			System.out.println("string :" + sample );
			/* save the RSSI values */
			
			/*count the amount of times */
				
	
			
		}finally{
			if(s != null) s.close();
			
			
		}
		
		
	}

    
    
	/* filter data
	 * Remove beginning of the data. in case of noise  */
    public float [] filterdata(float [] sampledata){
        int sampleToRemove=10;
    	int sample_length = sampledata.length;
    	float [] filtered_data= new float[sample_length-sampleToRemove];	
    	
    	/*copy the the last N data from input */
    	
    	
    	
    	return filtered_data;
    	
    }

	
	/* get the average for a given random Process */
	public float calculatMean(float [] data){
		int data_length = data.length;
		float avg=0;
		
		/* sum total*/
		for(int i=0; i<data_length; i++)
		{
			avg += data[i];
			
		}
		
		/* normalize */
		avg= avg/data_length;
		
		return avg;
	}
	
	
	public static float [] createHistogram(float []data){
		
		/*(-100)-(-90), (-90)-(-80)...... (-10)-0*/
		
		
/*		float [] histogram = null;
		int bin =0;
		float max=0,min=0;
		int data_size= data.length;
		int range;
	*/
		float [] histogram = new float[10];
		int bin =10;
		float max=0,min=0;
		int data_size= data.length;
		int range;
		 float value=0;
		
		/* get the minimum value */ 
		min=calculateMin(data);
		
		/* get the maximum value */ 
		max= calculateMax(data);
		
		/* determine  bin */
		bin = 10;
		
		range =  (int) (max-min);
	 for(int i=0; i< data_size; i++){
		value = data[i];
		
		 if((value == -100) || (value ==-90))
			histogram[0]++;
		else if((value >90) || (value ==-80))
				histogram[1]++;
		else if((value > -80) || (value ==-70))
			histogram[2]++;
		else if((value > -70) || (value == -60))
			histogram[3]++;
		else if((value > -60) || (value ==-50))
			histogram[4]++;
		else if((value > -50) || (value ==-40))
			histogram[5]++;
		else if((value > -40) || (value ==-30))
			histogram[6]++;
		else if((value  > -30) || (value ==-20))
			histogram[7]++;
		else if((value > -20) || (value ==-10))
			histogram[8]++;
		else if((value > -10) || (value ==0))
			histogram[9]++;
		
		
		
	 }

		return histogram;
		
	}
	
	public float [] createPMF(float []data){
		float [] pmf = null;
		
		
		return pmf;
	}


	public static float calculateMax(float [] data){
		 float maxValue = data[0];  
		  for(int i=1;i < data.length;i++){  
		    if(data[i] > maxValue){  
		      maxValue = data[i];  
		    }  
		  }  
		  return maxValue;  
		
		
		
	}
	
	
	
	
	
	public static float calculateMin(float [] data){

	float minValue = data[0];  
	  for(int i=1;i<data.length;i++){  
	    if(data[i] < minValue){  
	      minValue = data[i];  
	    }  
	  }  
	  return minValue;  
	}
	
}