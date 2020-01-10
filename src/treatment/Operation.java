package treatment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Newspaper;

public class Operation 
{
	public ArrayList<Newspaper> lists;
	
	public Operation()
	{
		lists=new ArrayList<Newspaper>();
	}
	
	public  Newspaper getLine(String s)
	{
		try
		{
			String[] data = s.split(":", 7);
			Newspaper newspaper = new Newspaper();
			System.out.println("Id = "+data[0]); 
			newspaper.setId(Integer.parseInt(data[0]));
			System.out.println("Name = "+data[1]);
			newspaper.setName(data[1]);
			System.out.println("Country "+data[2]);
			newspaper.setCountry(data[2]);
			System.out.println("Date = "+data[3]);
			newspaper.setDate(data[3]);
			System.out.println("Title = "+data[4]);
			newspaper.setTitle(data[4]);
			System.out.println("Author = "+data[5]);
			newspaper.setAuthor(data[5]);
			System.out.println("Content = "+data[6]);
			newspaper.setContent(data[6]);
			return newspaper;
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Error : "+ex.getMessage());
			return null;
		}
		catch(Exception ex)
		{
			System.out.println("Error : "+ex.getMessage());
			return null;
		}
	}
	
	public  void collectData(String url)
	{
		try
		{
			File file = new File(url);   
			BufferedReader br = new BufferedReader(new FileReader(file));   
			String st; 
			while ((st = br.readLine()) != null)
			{
			    //System.out.println(st);
			    this.lists.add(getLine(st));
			}
		}
		catch(IOException ex)
		{
			System.out.println("Error : "+ex.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println("Error : "+ex.getMessage());
		}
	}
	
	public static void main(String args[])
	{
		Operation o=new Operation();
		o.collectData("C:/Users/lenovo/workspace/Newspaper-analysis/src/treatment/journal.txt");
		for(int i=0 ; i<o.lists.size() ; i++)
		{
			System.out.println(o.lists.get(i).toString());
		}
	}
}