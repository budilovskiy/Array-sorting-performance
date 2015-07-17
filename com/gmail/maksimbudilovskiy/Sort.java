package com.gmail.maksimbudilovskiy;

abstract public class Sort {
	protected long timeout;
	
	public long getTimeout() {
		return timeout;
	}
		
	abstract public int[] sorting(int[] array);
}
