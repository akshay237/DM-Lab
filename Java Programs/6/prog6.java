import java.util.*;
import java.io.*;
class comp
{
	double a;
	String b;
	int x,y,z;
	public comp(double p,String q,int r,int s,int t)
	{
		a=p;b=q;x=r;y=s;z=t;
	}
}
class prog6
{
	public static void main(String args[]) throws FileNotFoundException,IOException
	{
		Scanner s = new Scanner(System.in);		
		BufferedReader csv = new BufferedReader(new FileReader(new File("input6.csv")));
		String str = csv.readLine();
		int a[] = new int[3];
		int b[] = new int[3];
		System.out.println("Enter x,y,z to classify in class Small,Medium,Large shirts:");
		a[0]=s.nextInt();
		a[1]=s.nextInt();
		a[2]=s.nextInt();
		System.out.println("Enter the nearest neighbour");
		int k = s.nextInt();
		ArrayList<comp> al=new ArrayList<>();
		while(str != null)
		{
			String[] data = str.split(",");
			for(int i=0;i<3;i++)
				b[i]=Integer.parseInt(data[i]);
			int sum=(a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]) + (a[2]-b[2])*(a[2]-b[2]);
			double res = Math.sqrt(sum);
			comp c = new comp(res,data[3],b[0],b[1],b[2]);
			al.add(c);
			str=csv.readLine();
		}
		Collections.sort(al,new Comparator<comp>(){
		@Override public int compare(comp p1,comp p2)
		{
			if(p1.a == p2.a)
				return 0;
			else if(p1.a > p2.a)
				return 1;
			else
				return -1;
		}
		});
		int x[] = new int[3];
		System.out.println(k + " nearest neighbour are:");
		for(comp cp:al)
		{
			if(k==0)
				break;
			System.out.println(cp.x+" "+cp.y+" "+cp.z+" "+cp.b);
			k--;
			String c = cp.b;
			if(c.equals("S"))
				x[0]++;
			else if(c.equals("M"))
				x[1]++;
			else
				x[2]++;
		}
		char res;
		int r = Math.max(x[0],Math.max(x[1],x[2]));
		if(x[0] == r)
			res='S';
		else if(x[1] == r)
			res='M';
		else
			res='L';
		System.out.println("Classifier for"+a[0]+" "+a[1]+" "+a[2]+" is : " +res);
	}
}

