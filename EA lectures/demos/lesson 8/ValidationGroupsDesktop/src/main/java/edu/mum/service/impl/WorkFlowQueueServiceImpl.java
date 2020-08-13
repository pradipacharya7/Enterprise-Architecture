package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.GenericDao;
import edu.mum.dao.WorkFlowQueueDao;
import edu.mum.domain.Member;
import edu.mum.domain.workflow.WorkFlowQueue;
import edu.mum.domain.workflow.WorkFlowType;
import edu.mum.service.WorkFlowQueueService;

@Service
@Transactional 
public class WorkFlowQueueServiceImpl implements WorkFlowQueueService {
	
	
 	@Autowired
	private WorkFlowQueueDao workFlowQueueDao;

    public void save( WorkFlowQueue workFlowQueue) {  		
    	workFlowQueueDao.save(workFlowQueue );
	}
	
	
    public void update( WorkFlowQueue workFlowQueue) {  		
    	workFlowQueueDao.update(workFlowQueue);
    	return;
	}
	
	
	public List<WorkFlowQueue> findAll() {
		return (List<WorkFlowQueue>)workFlowQueueDao.findAll();
	}

 	public WorkFlowQueue findOne(Long id) {
		return workFlowQueueDao.findOne(id);
	}

	public WorkFlowQueue findByMember(Member member) {
		return workFlowQueueDao.findByMember(member);
	};

	
 
}
