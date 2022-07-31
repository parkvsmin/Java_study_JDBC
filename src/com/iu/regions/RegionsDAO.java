package com.iu.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class RegionsDAO {
	// 1. regions 테이블의 모든 데이터 가져오기
	public ArrayList<RegionsDTO> getList() throws Exception {
		ArrayList<RegionsDTO> arr = new ArrayList<>();
		// 1. DB 연결
		Connection con = DBConnector.getConnection();
		// 2. query문 작성
		String sql = "SELECT * FROM regions"; // 세미콜론 자동으로 해줌
		// 3. query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. sql문 안에 ?가 있을경우 세팅
		// 5. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			RegionsDTO dto = new RegionsDTO();
			dto.setRegionId(rs.getInt("REGION_ID"));
			dto.setRegionName(rs.getString("REGION_NAME"));
			arr.add(dto);
		}
		// 6. 자원 해제
		DBConnector.disConnect(rs, st, con);
		return arr;
	}
	
	// 2. regions에서 하나의 결과(row)
	public RegionsDTO getDetail(int region_id) throws Exception {
		RegionsDTO dto = new RegionsDTO();
		Connection con = DBConnector.getConnection();
//		String sql = "SELECT * FROM regions WHERE region_id = "+region_id; 위험한 방법
		String sql = "SELECT * FROM regions WHERE region_id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, region_id); // index는 대개 0부터 시작하나 오라클은 1부터 시작 인덱스 순서는 무조건 앞에서부터
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			dto.setRegionId(rs.getInt(1));
			dto.setRegionName(rs.getString(2));
		}
		DBConnector.disConnect(rs, st, con);
		return dto;
	}
	
	public int setRegion(RegionsDTO dto) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO REGIONS VALUES (?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getRegionId());
		st.setString(2, dto.getRegionName());
		int row = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return row;
	}
}