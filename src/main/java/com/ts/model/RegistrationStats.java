package com.ts.model;

public class RegistrationStats {
	
	private int month;
    private long count;

    public RegistrationStats(int month, long count) {
        this.month = month;
        this.count = count;
    }

	public RegistrationStats(Integer month2, Long count2) {
		// TODO Auto-generated constructor stub
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
    
    

}
