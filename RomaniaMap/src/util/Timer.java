package util;

public class Timer {
	
	private Long init;
	private Long duration;
	
	public Timer() {
		
	}
	
	public Long start() {
		this.init = System.currentTimeMillis();
		return this.init;
	}
	
	public Long stop() {
		this.duration = System.currentTimeMillis() - this.init;
		return this.duration;
	}

	public Long getInit() {
		return init;
	}

	public Long getDuration() {
		return duration;
	}
	
	public void reset() {
		this.init = 0L;
		this.duration = 0L;
	}
}
