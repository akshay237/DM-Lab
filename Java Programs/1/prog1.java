import java.util.*;
import java.io.*;
class record
{
	int index,age,attr;
	String name,pclass;
}
class prog1
{
	static record[] rc = new record[10];
	public static void main(String args[]) throws IOException,FileNotFoundException
	{
		BufferedReader csv = new BufferedReader(new FileReader(new File("data.csv")));
		String str = csv.readLine();
		int i=0,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		System.out.println("DataSet");
		while(str != null)
		{
			rc[i]=new record();
			String[] data = str.split(",");
			rc[i].index=Integer.parseInt(data[0]);
			rc[i].age=Integer.parseInt(data[1]);
			rc[i].attr=Integer.parseInt(data[2]);
			rc[i].name=data[3];
			rc[i].pclass=data[4];
			if(rc[i].attr > max)
				max=rc[i].attr;
			if(rc[i].attr < min)
				min=rc[i].attr;
			System.out.println(rc[i].index+" "+rc[i].age+" "+rc[i].attr+" "+rc[i].name+" "+rc[i].pclass);
			str=csv.readLine();
			i++;
		}
		int avg=0;
		for(int j=0;j<i;j++)
			avg+=rc[j].attr;
		avg /= i;
		System.out.println("Maximun Value :"+max);
		System.out.println("Minimum value :"+min);
		System.out.println("Average Value :"+avg);
		int mean = (min+max)/2;
		int mid1 = (min+mean)/2;
		int mid2 = (max+mean)/2;
		int sample[] = new int[4];
		for(int j=0;j<i;j++)
		{
			System.out.println(rc[j].index+" "+rc[j].age+" "+rc[j].attr+" "+rc[j].name+" "+rc[j].pclass);
			if(rc[j].attr>=min && rc[j].attr < mid1)
				sample[0]=rc[j].attr;
			if(rc[j].attr>=mid1 && rc[j].attr < mean)
				sample[1]=rc[j].attr;
			if(rc[j].attr>=mean && rc[j].attr < mid2)
				sample[2]=rc[j].attr;			
			if(rc[j].attr>=mid2 && rc[j].attr < max)
				sample[3]=rc[j].attr;
		}
		System.out.println("["+min+"-"+mid1+") - "+sample[0]);
		System.out.println("["+mid1+"-"+mean+") - "+sample[1]);
		System.out.println("["+mean+"-"+mid2+") - "+sample[2]);
		System.out.println("["+mid2+"-"+max+") - "+sample[3]);
	}
}
