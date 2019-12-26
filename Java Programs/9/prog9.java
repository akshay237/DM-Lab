import java.util.*;
import java.io.*;
class record{
	double x=0,y=0;
}
class prog9{
 public static record calCentroid(ArrayList<record> bl)
 {
	record a = new record();
	double c=0,d=0;
	for(record r:bl)
	{
		c += r.x;
		d += r.y;
	}
	a.x = c / bl.size();
	a.y = d / bl.size();
	return a;
 }
 public static double dist(double p,double q,double r,double s)
 {
	double res=0;
	res=Math.pow((p-r),2) + Math.pow((q-s),2);
	return Math.sqrt(res);
 }
 public static void main(String args[]) throws IOException,FileNotFoundException
 {
	BufferedReader csv = new BufferedReader(new FileReader(new File("movieData.csv")));
	String str = csv.readLine();
	ArrayList<record> temp=new ArrayList<>();
	while(str != null)
	{
		String[] data = str.split(",");
		record rc = new record();
		rc.x = Double.parseDouble(data[1]);
		rc.y = Double.parseDouble(data[2]);
		temp.add(rc);
		str = csv.readLine();
	}
	ArrayList<record> centroid=new ArrayList<>();
	ArrayList<record> c1=new ArrayList<>();
	ArrayList<record> c2=new ArrayList<>();
	ArrayList<record> c3=new ArrayList<>();
	centroid.add(temp.get(0));
	centroid.add(temp.get(3));
	centroid.add(temp.get(6));
	for(int i=0;i<100;i++)
	{
		c1.clear();c2.clear();c3.clear();
		for(record r:temp)
		{
			ArrayList<Double> t=new ArrayList<>();
			Double p = dist(r.x,r.y,(centroid.get(0)).x,(centroid.get(0)).y);
			Double q = dist(r.x,r.y,(centroid.get(1)).x,(centroid.get(1)).y);
			Double s = dist(r.x,r.y,(centroid.get(2)).x,(centroid.get(2)).y);
			t.add(p);
			t.add(q);
			t.add(s);
			double res=Collections.min(t);
			if(res==p)
				c1.add(r);
			if(res==q)
				c2.add(r);
			if(res==s)
				c3.add(r);
		}
		centroid.clear();
		centroid.add(calCentroid(c1));
		centroid.add(calCentroid(c2));
		centroid.add(calCentroid(c3));
	}
	System.out.println("1-Cluster");
	for(record r:c1)
		System.out.println(r.x + " " + r.y);
	System.out.println("2-Cluster");
	for(record r:c2)
		System.out.println(r.x + " " + r.y);
	System.out.println("3-Cluster");	
	for(record r:c3)
		System.out.println(r.x + " " + r.y);
	for(int i=0;i<3;i++)
		System.out.println("Centroid of cluster "+i+ " is :" + centroid.get(i).x + " " + centroid.get(i).y);
 }
}
