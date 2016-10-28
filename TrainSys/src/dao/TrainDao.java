package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.TrainInfo;

public class TrainDao extends BaseDao {
	public List<TrainInfo> getAllTrain() {
		String sql = "select * from train_info";
		ResultSet rs = null;
		List<TrainInfo> list = new ArrayList<TrainInfo>();
		TrainInfo trainInfo = null;
		try {
			rs = getResultSet(sql, null);
			while (rs.next()) {
				trainInfo = new TrainInfo();
				trainInfo.setTrain_no(rs.getString("train_no"));
				trainInfo.setArrival_station(rs.getString("arrival_station"));
				trainInfo.setArrival_time(rs.getString("arrival_time"));
				trainInfo.setMile(rs.getInt("mile"));
				trainInfo.setRuntime(rs.getString("runtime"));
				trainInfo.setType(rs.getString("type"));
				trainInfo.setStart_station(rs.getString("start_station"));
				trainInfo.setStart_time(rs.getString("start_time"));
				list.add(trainInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAllObject(rs, null, null);
		}
		return list;
	}

	public boolean delTrain(String[] trainId) {
		// 构建所有删除用户字符串，形如(100, 101)
		String param = Arrays.toString(trainId).replace("[", "(").replace("]", ")");
		// SQL语句
		String sql = "DELETE FROM train_info WHERE train_no IN " + param;
		System.out.println(sql);
		PreparedStatement pstmt = null;
		Connection conn = null;
		boolean row = false;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			row = pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAllObject(null, pstmt, conn);
		}

		return row;
	}

	public TrainInfo findTrain(String no) {
		String sql = "select * from train_info where train_no=" + no;
		PreparedStatement pstmt = null;
		Connection conn = null;
		TrainInfo trainInfo = null;
		ResultSet rs=null;
		try {
			rs = getResultSet(sql, null);
			while (rs.next()) {
				trainInfo = new TrainInfo();
				trainInfo.setTrain_no(rs.getString("train_no"));
				trainInfo.setArrival_station(rs.getString("arrival_station"));
				trainInfo.setArrival_time(rs.getString("arrival_time"));
				trainInfo.setMile(rs.getInt("mile"));
				trainInfo.setRuntime(rs.getString("runtime"));
				trainInfo.setType(rs.getString("type"));
				trainInfo.setStart_station(rs.getString("start_station"));
				trainInfo.setStart_time(rs.getString("start_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAllObject(rs, pstmt, conn);
		}
		return trainInfo;
	}
}
