import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class francisco_lab13 
{
	ArrayList<Integer> data = new ArrayList<Integer>();
	Stream<Integer> datastream = data.stream();
	
	public static void main(String[] args)
	{
		

	}
	
	public void readData(String filename) 
	{
		try 
		{
			
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String inn;
			while((inn = input.readLine()) != null) 
			{
				data.add(Integer.parseInt(inn));
			}
			
			input.close();
		} 
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);	
		}
	}
	
	public long getTotalCount() {
		return datastream.count();
	}
	
	public long getOddCount() {
		return datastream.filter(i -> i % 2 == 1).count();
	}
	
	public long getEvenCount() {
		return datastream.filter(i -> i % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return datastream.distinct().filter(i -> i > 5).count();
	}
	
	public Integer[] getResult1() {
		Object[] objarr = datastream.filter(i -> i % 2 == 0).filter(i -> i > 5).filter(i -> i < 50).sorted().toArray();
		Integer[] intarr = Arrays.copyOf(objarr, objarr.length, Integer[].class);
		return intarr;
	}
	
	public Integer[] getResult2() {
		Object[] objarr = datastream.limit(50).map(i -> i * i * 3).toArray();
		Integer[] intarr = Arrays.copyOf(objarr, objarr.length, Integer[].class);
		return intarr;
	}
	
	public Integer[] getResult3() {
		Object[] objarr = datastream.filter(i -> i % 2 == 1).map(i -> i*2).sorted().skip(20).distinct().toArray();
		Integer[] intarr = Arrays.copyOf(objarr, objarr.length, Integer[].class);
		return intarr;	}
}
