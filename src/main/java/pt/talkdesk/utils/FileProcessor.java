package pt.talkdesk.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import pt.talkdesk.call.Caller;

public class FileProcessor {

	File file = null;
	BufferedReader br = null;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}

	public FileProcessor(String filename) {

		file = new File(filename);
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.println("Problems with file, maybe it does not exist");
		}
	}

	public List<Caller> createListOfCallers() {

		String line = null;
		System.out.println("Reading the filename " + file.getName() + "....");
		List<Caller> calls = new ArrayList<Caller>();
		try {
			line = br.readLine();

			while (line != null) {
				System.out.println(line);
				StringTokenizer sT = new StringTokenizer(line, ";");
				Date date1 = new SimpleDateFormat("hh:mm:ss").parse(sT.nextToken());
				Date date2 = new SimpleDateFormat("hh:mm:ss").parse(sT.nextToken());
				Caller call = new Caller(date1, date2, sT.nextToken(), sT.nextToken());
				calls.add(call);
				line = br.readLine();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return calls;

	}
}
