import java.util.*;
import java.io.*;
class DataPoint{
	boolean readValue,predictedValue;
	DataPoint(boolean r,boolean p)
	{
		readValue=r;
		predictedValue=p;
	}
}
class prog10
{
	public static ArrayList<DataPoint> getInput(String file)
	{
	  ArrayList<DataPoint> al = new ArrayList<>();
	  try{
		BufferedReader csv = new BufferedReader(new FileReader(new File(file)));
		String str = csv.readLine();
		boolean r,p;
		while(str != null)
		{
			String[] data = str.split(",");
			if(data[0].equals("T"))
				r=true;
			else
				r=false;
			if(data[1].equals("T"))
				p=true;
			else
				p=false;
			DataPoint d = new DataPoint(r,p);
			al.add(d);
			str=csv.readLine();
		}
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();
	  }
	  return al;
	}
	public static void main(String args[]) throws FileNotFoundException,IOException
	{
		ArrayList<DataPoint> data=getInput("input10.csv");
		double tp=0,fp=0,tn=0,fn=0;
		double w1=2,w2=1,w3=1,w4=2;
		for(DataPoint d: data)
		{
			if(d.readValue && d.predictedValue)
 				tp++;
			if(!d.readValue && d.predictedValue)
 				fp++;
			if(!d.readValue && !d.predictedValue)
 				tn++;
			if(d.readValue && !d.predictedValue)
 				fn++;
		}
		System.out.println("Confusion Matrix:");
		System.out.println(tp+" "+fn);
		System.out.println(fp+" "+tn);
		double sensitivity=tp/(tp+fn);
		double specifity=tn/(fp+tn);
		double precision=tp/(tp+fp);
		double recall=tp/(tp+fn);
		double weighted=(w1*tp+w4*tn)/(w1*tp+w2*fn+w3*fp+w4*tn);
		System.out.println("Sensitivity:"+sensitivity);
		System.out.println("Specifity:"+specifity);
		System.out.println("Precision:"+precision);
		System.out.println("Recall:"+recall);
		System.out.println("Weighted Accuracy:"+weighted);
	}
}
