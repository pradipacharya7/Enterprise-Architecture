package edu.mum.dao;

import edu.mum.domain.Member;
import edu.mum.domain.workflow.WorkFlowQueue;
import edu.mum.domain.workflow.WorkFlowType;

public interface WorkFlowQueueDao extends GenericDao<WorkFlowQueue> {
      
	public WorkFlowQueue findByMember(Member member) ;
	
}
