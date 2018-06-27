package pt.talkdesk.call;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Caller {

	Date timeStart = null;
	Date timeFinish = null;
	String callFrom = null;
	String callTo = null;

	public String getCallFrom() {
		return callFrom;
	}

	public void setCallFrom(String callFrom) {
		this.callFrom = callFrom;
	}


	public Caller(Date timeStart, Date timeFinish, String callFrom, String callTo) {
		this.timeFinish = timeFinish;
		this.timeStart = timeStart;
		this.callFrom = callFrom;
		this.callTo = callTo;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeFinish() {
		return timeFinish;
	}

	public void setTimeFinish(Date timeFinish) {
		this.timeFinish = timeFinish;
	}

	public String getCallTo() {
		return callTo;
	}

	public void setCallTo(String callTo) {
		 this.callTo = callTo;
	}

	public long getCallerTimer() {
		return TimeUnit.MILLISECONDS.toMinutes(getTimeFinish().getTime() - getTimeStart().getTime());
	}
}
