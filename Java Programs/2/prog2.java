import java.util.*;
import java.io.*;
class prog2
{
	ArrayList<String[]> al=new ArrayList<String[]>();
	public void loadFile(String file) throws FileNotFoundException
	{
		try{
			BufferedReader csv=new BufferedReader(new FileReader(new File(file)));
			String str = csv.readLine();
			while(str != null)
			{
				String[] data=str.split(",");
				al.add(data);
				str=csv.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void missingString(int col,String value)
	{
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		for(String[] r:al)
			if(!r[col].equalsIgnoreCase(value))
				hm.put(r[col],hm.getOrDefault(r[col],0)+1);		
		String maxValName=null;
		int maxVal=0;
		for(Map.Entry<String,Integer>m:hm.entrySet())
			if(m.getValue() > maxVal)
				maxValName=m.getKey();
		for(String[] r:al)
			if(r[col].equalsIgnoreCase(value))
				r[col]=maxValName;
	}
	public void missingInteger(int col,String value)
	{
		float avg=0;
		int count=0;
		for(String[] r:al)
		{
			if(!r[col].equalsIgnoreCase(value))
				avg+=Float.parseFloat(r[col]);
			count++;
		}
		avg /= count;
		for(String[] r:al)
			if(r[col].equalsIgnoreCase(value))
				r[col]=Integer.toString((int)avg);
	}
	public void generateFile()
	{
		try{
			FileWriter fw = new FileWriter(new File("Output2.csv"));
			for(String[] r:al)
			{
				String data=Arrays.toString(r);
				data=data.substring(1,data.length()-1);
				fw.write(data);
				fw.write('\n');
			}
			fw.close();
			System.out.println("Output File generated");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String args[]) throws FileNotFoundException,IOException
	{
		prog2 p = new prog2();
		p.loadFile("input2.csv");
		p.missingString(5,"NA");
		p.missingInteger(1,"NA");
		p.generateFile();
	}
}
	
