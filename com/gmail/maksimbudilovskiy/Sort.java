package com.gmail.maksimbudilovskiy;

public abstract class Sort {
	protected long timeout;
	
	public long getTimeout() {
		return timeout;
	}
		
	public int[] sorting(int[] array) {
		timeout = 0;
		return array;
	}
}
