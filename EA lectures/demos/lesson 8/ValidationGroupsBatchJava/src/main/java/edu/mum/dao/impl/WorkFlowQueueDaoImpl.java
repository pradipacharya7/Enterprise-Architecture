package edu.mum.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.WorkFlowQueueDao;
import edu.mum.domain.Member;
import edu.mum.domain.workflow.WorkFlowQueue;
import edu.mum.domain.workflow.WorkFlowType;


@SuppressWarnings("unchecked")
@Repository
public class WorkFlowQueueDaoImpl extends GenericDaoImpl<WorkFlowQueue> implements WorkFlowQueueDao {

	public WorkFlowQueueDaoImpl() {
		super.setDaoType(WorkFlowQueue.class );
		}

	public WorkFlowQueue findByMember(Member member) {
		

		Query query = entityManager.createQuery("select wfq from WorkFlowQueue wfq  where wfq.member =:member" );
		return (WorkFlowQueue) query.setParameter("member", member).getSingleResult();
		
	};

 }