package pt.talkdesk.call;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Calls {
	List<Caller> calls = null;
	HashMap<String, Long> timeCalls=null;
	
	public Calls(List<Caller> calls) {
		this.calls=calls;
		timeCalls = new HashMap<String,Long>();
		setCallsTime();
		removeMaxTime();
	}

	public List<Caller> getCalls() {
		return calls;
	}

	public void setCalls(List<Caller> calls) {
		this.calls = calls;
	}

	
	public void removeMaxTime()
	{
		float maxTime=0f;
		String caller=null;
		for (Caller call:calls) {
			long time =timeCalls.get(call.getCallFrom());
			if (maxTime<time)
			{
				maxTime=time;
				caller = call.getCallFrom();
			}
		}
		List<Caller> aux = new ArrayList<Caller>();
		for (Caller call:calls) {
			if (!(call.getCallFrom().equals(caller))) {
				aux.add(call);
			}
		}
		calls =aux;
	}
	
	public void setCallsTime() {
		for (Caller call:calls)
		{
			if(timeCalls.get(call.getCallFrom()) ==null)
			{
				timeCalls.put(call.getCallFrom(),call.getCallerTimer());
			}else
			{
				timeCalls.put(call.getCallFrom(), call.getCallerTimer()+timeCalls.get(call.getCallFrom()));	
			}
			
		}
	}
	
	
}
