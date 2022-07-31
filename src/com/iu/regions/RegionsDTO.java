package com.iu.regions;

public class RegionsDTO {
	//멤번변수 접근지정자 : private
	//Getter/setter
	//기본생성자 필수
	//멤버변수명은 Table의 컬럼명과 동일하게 선언
	private Integer region_id;
	private String region_name;
	
	public int getRegionId() {
		return region_id;
	}
	
	public void setRegionId(int regionId) {
		this.region_id = regionId;
	}
	
	public String getRegionName() {
		return region_name;
	}
	
	public void setRegionName(String regionName) {
		this.region_name = regionName;
	}
}