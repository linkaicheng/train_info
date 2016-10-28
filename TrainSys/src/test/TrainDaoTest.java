package test;

import java.util.List;

import org.junit.Test;

import dao.TrainDao;
import entity.TrainInfo;

public class TrainDaoTest {

	@Test
	public void test() {
		TrainDao trainDao = new TrainDao();
		List<TrainInfo> list = trainDao.getAllTrain();
		System.out.println(list);
	}

}
