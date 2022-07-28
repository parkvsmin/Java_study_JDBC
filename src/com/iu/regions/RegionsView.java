package com.iu.regions;

import java.util.ArrayList;

public class RegionsView {
	
	public void view(ArrayList<RegionsDTO> ar) {
		System.out.println("REGION_ID\t REGION_NAME");
		System.out.println("-------------------------------");
		for(RegionsDTO regionsDTO:ar) {
			System.out.print(regionsDTO.getRegion_id()+"\t\t ");
			System.out.println(regionsDTO.getRegion_name());
			System.out.println("-------------------------------");
		}
		
	}
	
	//view
	public void view(RegionsDTO regionsDTO) {
		System.out.println("REGION_ID\t REGION_NAME");
		System.out.println("-------------------------------");
		System.out.print(regionsDTO.getRegion_id()+"\t\t ");
		System.out.println(regionsDTO.getRegion_name());
		System.out.println("-------------------------------");
	}

}