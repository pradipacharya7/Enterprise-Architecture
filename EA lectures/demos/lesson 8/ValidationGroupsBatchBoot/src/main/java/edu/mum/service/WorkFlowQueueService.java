package edu.mum.service;

import java.util.List;

import edu.mum.domain.Member;
import edu.mum.domain.workflow.WorkFlowQueue;
import edu.mum.domain.workflow.WorkFlowType;
 
public interface WorkFlowQueueService {

	public void save(WorkFlowQueue workFlowQueue);
	public void update(WorkFlowQueue workFlowQueue);
	public List<WorkFlowQueue> findAll();
 
	public WorkFlowQueue findOne(Long id);

	public WorkFlowQueue findByMember(Member member) ;

}
