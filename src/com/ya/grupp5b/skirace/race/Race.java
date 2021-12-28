package com.ya.grupp5b.skirace.race;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.ya.grupp5b.skirace.skier.Skier;

public class Race {

	private LocalTime raceStart;
	private List<Skier> skierList;
	

	
	
	public Race() {
		super();
		skierList = new ArrayList<Skier>();	
		
	}
	
	public LocalTime getRaceStart() {
		return raceStart;
	}

	public void setRaceStart(LocalTime raceStart) {
		this.raceStart = raceStart;
	}

	public List<Skier> getSkierList() {
		return skierList;
	}

	public void setSkierList(Skier skier) {
		this.skierList.add(skier);
	}	
	

}
