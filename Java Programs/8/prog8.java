import java.util.*;
import java.io.*;
class prog8
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);		
		double mean_x=0,mean_y=0,cov_xy=0,var_x=0,m=-1000,c=-1000;
		double x[]= {1,2,3,4,5,6,7,8};
		double y[]= {9,10,11,12,13,14,15,16};
		for(int i=0;i<x.length;i++)
		{
			mean_x += x[i];
			mean_y += y[i];
		}
		mean_x /= x.length;
		mean_y /= y.length;
		for(int i=0;i<x.length;i++)
		{
			var_x += Math.pow(x[i]-mean_x,2);
			cov_xy += (x[i]-mean_x)*(y[i]-mean_y);
		}
		var_x /= x.length;
		cov_xy /= x.length;
		m=cov_xy/var_x;
		c=mean_y - m*mean_x;
		System.out.println("Enter value of x");
		double x_val = s.nextDouble();
		System.out.println("Equation is y = "+m+"x"+"+"+c );
		double res = x_val*m+c;
  		System.out.println("Result is: "+res);		
	}
}
