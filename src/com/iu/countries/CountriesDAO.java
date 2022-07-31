package com.iu.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class CountriesDAO {
	
	//setCountry
	
	public void getList() throws Exception {	
		ArrayList<CountriesDTO> arr = new ArrayList<>();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM countries";
	}
	//getDetail : countries_id
	public CountriesDTO getDetail(String country_id)throws Exception{
		
		CountriesDTO countriesDTO= new CountriesDTO();
		
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL 작성
		String sql ="SELECT * FROM COUNTRIES WHERE COUNTRY_ID=?";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 갑 세팅
		st.setString(1, country_id);
		
		//5. 최종 전송 및 결과처리
		ResultSet rs = st.executeQuery();
		
		
		if(rs.next()) {
			countriesDTO = new CountriesDTO();
			countriesDTO.setCountry_id(rs.getString("country_id"));
			countriesDTO.setCountry_name(rs.getString("country_name"));
			countriesDTO.setRegion_id(rs.getInt("region_id"));
		}
				
		DBConnector.disConnect(rs, st, con);
		
		return countriesDTO;
	}
	
	
	public ArrayList<CountriesDTO> getList(String search) throws Exception {
		ArrayList<CountriesDTO> ar = new ArrayList();
		
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL 작성
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_NAME LIKE '%'||?||'%'";
		
		//3. 미리보내기
		PreparedStatement st = con.prepareStatement(sql);
		
		// ? 았으면 값 세팅
		st.setString(1, "%"+search+"%");
		
		//4. 최종전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			CountriesDTO countriesDTO = new CountriesDTO();
			countriesDTO.setCountry_id(rs.getString("country_id"));
			countriesDTO.setCountry_name(rs.getString("country_name"));
			countriesDTO.setRegion_id(rs.getInt("region_id"));
			ar.add(countriesDTO);
			
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
		
	}

}