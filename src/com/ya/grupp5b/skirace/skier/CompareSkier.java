package com.ya.grupp5b.skirace.skier;

import java.util.Comparator;

public class CompareSkier implements Comparator<Skier>{

	@Override
	public int compare(Skier skier1, Skier skier2) {
		
        if (skier1.getGoalTime().getHour() < skier2.getGoalTime().getHour() && 
        	skier1.getGoalTime().getMinute() < skier2.getGoalTime().getMinute() && 
        	skier1.getGoalTime().getSecond() < skier2.getGoalTime().getSecond()&&
        	skier1.getGoalTime().getNano() < skier2.getGoalTime().getNano()) {        	
            return -1;
           
        } else if  (skier1.getGoalTime().getHour() > skier2.getGoalTime().getHour() && 
        			skier1.getGoalTime().getMinute() > skier2.getGoalTime().getMinute() && 
        			skier1.getGoalTime().getSecond() > skier2.getGoalTime().getSecond()&&
        			skier1.getGoalTime().getNano() > skier2.getGoalTime().getNano()) {
            return 1;
        } else {
            return 0;
        }
		
	}

}
