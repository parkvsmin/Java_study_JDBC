package com.iu.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class RegionsDAO {
	
	//2. Regions에서 하나의 결과(row)
	public RegionsDTO getDetail(int region_id)throws Exception{
		RegionsDTO regionsDTO=null;
		//1. DB 연결
		Connection con  = DBConnector.getConnection();
		
		//2. SQL문 작성
		String sql="SELECT * FROM REGIONS WHERE REGION_ID=?";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 값 세팅
		// WHERE NUM BETEEN ?(1) AND ?(2);
		st.setInt(1, region_id);
		
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			regionsDTO = new RegionsDTO();
			int rId= rs.getInt(1);
			regionsDTO.setRegion_id(rId);
			regionsDTO.setRegion_name(rs.getString(2));
			
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
		return regionsDTO;
		
	}
	
	
	//1. Regions 의 모든 데이터 가져오기
	public ArrayList<RegionsDTO> getList() throws Exception {
		ArrayList<RegionsDTO> ar = new ArrayList();
		//1.DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query 문 작성
		String sql="SELECT * FROM REGIONS";
		
		//3. Query 문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. 
		
		//5. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			RegionsDTO regionsDTO = new RegionsDTO();
			regionsDTO.setRegion_id(rs.getInt("Region_id"));
			regionsDTO.setRegion_name(rs.getString("Region_name"));
			ar.add(regionsDTO);
		}
		//6. 자원 해제
		DBConnector.disConnect(rs, st, con);
		return ar;
	}

}