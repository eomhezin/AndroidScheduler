package com.example.androidscheduler;

import java.util.ArrayList;
import java.util.List;

import android.R.string;
import android.os.Parcel;
import android.os.Parcelable;

public class ClassInfo implements Parcelable{
	
	public String name;
	public List<String> day;		// day - number ex) mon - 2, mon - 3
	public ArrayList<Integer> number;
	public String detail;
	
	public ClassInfo(String name, String day,
			Integer number, String detail) {
		
		this.name = name;
		if(day == null){
			this.day = new ArrayList();
		}
		this.day.add(day);
		if(number == null){
			this.number = new ArrayList();
		}
		this.number.add(number);
		this.detail = detail;
	}
	
	public ClassInfo(Parcel src){
		
		name = src.readString();
		
		if(day == null){
			day = new ArrayList();
		}
		src.readStringList(day);
		
		if(number == null){
			number = new ArrayList<Integer>();
		}
		number = (ArrayList<Integer>)src.readSerializable();
		
		detail = src.readString();
	}
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

		@Override
		public Object createFromParcel(Parcel source) {
			return new ClassInfo(source);
		}

		@Override
		public Object[] newArray(int size) {
			return new ClassInfo[size];
		}
		
	};
	
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeList(day);
		dest.writeSerializable(number);
		dest.writeString(detail);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getDay() {
		return (ArrayList<String>) day;
	}

	public void setDay(ArrayList<String> day) {
		this.day = day;
	}

	public ArrayList<Integer> getNumber() {
		return number;
	}

	public void setNumber(ArrayList<Integer> number) {
		this.number = number;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
