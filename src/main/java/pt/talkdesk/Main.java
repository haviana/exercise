package pt.talkdesk;

import java.util.ArrayList;

import pt.talkdesk.call.Caller;
import pt.talkdesk.call.Calls;
import pt.talkdesk.utils.FileProcessor;


/***
 * Main method it needs the filename
 */
public class Main {
	public static void main(String[] args) {
		String filename = args[0];

		FileProcessor fileProcess = new FileProcessor(filename);

		Calls calls = new Calls(new ArrayList<>(fileProcess.createListOfCallers()));

		float sum = 0;
		float time = 0;
		for (Caller call : calls.getCalls()) {
			time = call.getCallerTimer();
			if (time < 5) {
				sum = sum + (time * 0.05f);

			} else {
				sum = sum + ((5) * 0.05f);
				sum = sum + ((time - 5) * 0.02f);
			}
		}
		
		System.out.println("Sum: " + sum);
	}
}
