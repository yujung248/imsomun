package egovframework.let.shop.scheduler.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("schedulerDao")
public class SchedulerDAO extends EgovAbstractDAO {
	
	public int delSch() {
		return delete("scheduler.deleteLog");
	}
}
