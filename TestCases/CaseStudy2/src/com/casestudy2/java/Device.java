package com.casestudy2.java;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Device {
	String deviceName;
	boolean status;
	LocalDateTime onTime;
	LocalDateTime offTime;
	
	
	
	
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public LocalDateTime getOnTime() {
		return onTime;
	}
	public void setOnTime(LocalDateTime onTime) {
		this.onTime = onTime;
	}
	public LocalDateTime getOffTime() {
		return offTime;
	}
	public void setOffTime(LocalDateTime offTime) {
		this.offTime = offTime;
	}
	public Device(String device)
	{	
		this.deviceName=device;
		this.status=false;
		this.onTime=null;
		this.offTime=null;
	}
	public boolean onDevice()
	{
		this.status=true;
		this.onTime=LocalDateTime.now();
		return this.status;
	}
	public boolean offDevice()
	{
		this.status=false;
		this.offTime=LocalDateTime.now();
		return this.status;
	}
	public int deviceOnTime()
	{
		long time=this.onTime.until(this.offTime,ChronoUnit.MINUTES);
				return (int) time;
	}
	
}
