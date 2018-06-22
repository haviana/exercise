package pt.talkdesk.call;

import java.util.Date;

public class Caller {

	Date timeStart =null;
	Date timeFinish =null;
	long callFrom =-1;
	public long getCallFrom() {
		return callFrom;
	}
	public void setCallFrom(long callFrom) {
		this.callFrom = callFrom;
	}
	long callTo =-1;
	
	public Caller(Date timeStart, Date timeFinish, long callFrom, long callTo) {
		this.timeFinish=timeFinish;
		this.timeStart=timeStart;
		this.callFrom=callFrom;
		this.callTo=callTo;
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
	public long getCallTo() {
		return callTo;
	}
	public void setCallTo(long callTo) {
		this.callTo = callTo;
	}
}
