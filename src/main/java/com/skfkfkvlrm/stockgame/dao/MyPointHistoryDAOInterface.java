package com.skfkfkvlrm.stockgame.dao;

import java.util.List;
import java.util.Map;

public interface MyPointHistoryDAOInterface {
	public List<Map<String, Object>> getMyPointHistoryList(String studentId);
}
