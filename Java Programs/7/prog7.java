import java.util.*;
import java.io.*;
class comp
{
	double x,y,z;
}
class prog7
{
 public static void main(String args[]) throws IOException,FileNotFoundException
 {
	Scanner s = new Scanner(System.in);
	BufferedReader csv = new BufferedReader(new FileReader(new File("input7.csv")));
	String str = csv.readLine();
	double rate = 0.02;	
	double weight[] = new double[3];
	ArrayList<comp> al = new ArrayList<>();
	Random rand = new Random();
	while(str != null)
	{
		String[] data = str.split(",");
		comp c = new comp();
		c.x=Double.parseDouble(data[0]);
		c.y=Double.parseDouble(data[1]);
		c.z=Double.parseDouble(data[2]);
		al.add(c);
		str=csv.readLine();
	}
	//weight[0]=rand.nextInt(32767*2)-32767;
	//weight[1]=rand.nextInt(32767*2)-32767;
	for(int i=0;i<100;i++)
	{
		for(int j=0;j<al.size() - 1;j++)
		{
			int res=0;
			double sum=weight[0] + weight[1]*(al.get(j)).x + weight[2]*(al.get(j)).y;
			if(sum>0)
				res=1;
			double error=al.get(j).z - res;
			weight[0]+=error*rate;
			weight[1]+=(error*rate*al.get(j).x);
			weight[2]+=(error*rate*al.get(j).y);
		}
	}
	System.out.println("Enter x and y test data");
	double x = s.nextDouble();
	double y = s.nextDouble();
	double sum1 = weight[0] + weight[1]*x + weight[2]*y;
	if(sum1>0)
		System.out.println("Predicted:1");
	else
		System.out.println("Predicted:0");
	System.out.println("Final Weight[0] :" + weight[0]);
	System.out.println("Final Weight[1] :" + weight[1]);
	System.out.println("Final Weight[2] :" + weight[2]);
 }
}
