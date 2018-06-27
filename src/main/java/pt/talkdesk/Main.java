package pt.talkdesk;

import java.util.ArrayList;

import pt.talkdesk.call.Caller;
import pt.talkdesk.call.Calls;
import pt.talkdesk.utils.FileProcessor;

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
				System.out.println("entrou <5");
				sum = sum + (time * 0.05f);
				System.out.println(sum);

			} else {
				System.out.println("entrou >5");
				sum = sum + ((5) * 0.05f);
				sum = sum + ((time - 5) * 0.02f);
				System.out.println(sum);
			}
			System.out.println(call.getCallFrom());
			System.out.println(call.getCallTo());
		}
		
		System.out.println("Sum: " + sum);
	}
}
