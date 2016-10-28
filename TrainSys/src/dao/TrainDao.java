package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.TrainInfo;

public class TrainDao extends BaseDao {
	public List<TrainInfo> getAllTrain() {
		String sql="select * from train_info";
		ResultSet rs=null;
		List<TrainInfo> list = new ArrayList<TrainInfo>();
		
		try {
			rs=getResultSet(sql, null);
			while(rs.next()){
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean delTrain(String[] trainId){
		return false;
	}
	public TrainInfo findTrain(String no){
		return null;
	}
}
