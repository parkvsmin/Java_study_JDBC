package com.iu.regions;

import java.util.ArrayList;

public class RegionsView {
	
	public void view(ArrayList<RegionsDTO> arr) { // 여러개
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i).getRegionId() + ", " + arr.get(i).getRegionName());
		}
	}
	
	public void view(RegionsDTO dto) {
		System.out.println(dto.getRegionId() + ", " + dto.getRegionName());
	}
}