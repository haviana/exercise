package pt.talkdesk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import pt.talkdesk.call.Caller;

public class Main {
	public static void main(String[] args) {
		
		File file = new File(args[0]);
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(file));
			
			
			String line=br.readLine();
			System.out.println("Reading the filename "+file.getName() +"....");
			ArrayList<Caller> calls = new ArrayList<Caller>();
			
			while(line!=null)
			{
				System.out.println(line);
				StringTokenizer sT = new StringTokenizer(line, ";");
				Date date1=new SimpleDateFormat("hh:mm:ss").parse(sT.nextToken());
				Date date2=new SimpleDateFormat("hh:mm:ss").parse(sT.nextToken());
				Caller call= new Caller(date1, date2, Long.parseLong(sT.nextToken()), Long.parseLong(sT.nextToken()));
				calls.add(call);
				line = br.readLine();
				
			}
			
			for (Caller call:calls)
			{
				System.out.println(call.getTimeFinish());
				System.out.println(call.getTimeStart());
				System.out.println(call.getCallTo());
				System.out.println(call.getCallTo());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(args[0]);
	}
}
