package edu.mum.domain.workflow;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.mum.domain.Member;

@Entity
@Table(name="workflowqueue")
public class WorkFlowQueue {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	// WorkFlowQueue holds Members[Bill, Pete, etc.] that participate
	// in process [Supervisor, Admin, etc.]
	@OneToOne(fetch= FetchType.EAGER)
	Member member;


/*
	 * @ElementCollection
	 * Defines a collection of instances of a basic type. 
	 * It means that the collection is not a collection of entities[@OneToMany], but
	 *  a collection of simple types (Strings, etc.)
	 * Must be specified if the collection is to be mapped by means of a collection table.
	 *
	 * There is a collection/queue per validation Target [e.g.Product].
	 * each collection contains the "parent" WorkFlowQueue ID of the admin, supervisor
	 * and the ID of the assigned validation Target
	 */
	   @ElementCollection(fetch= FetchType.EAGER)
	    private Set<Long> productQueue = new HashSet<Long>();
	    
	   @ElementCollection(fetch= FetchType.EAGER)
	    private Set<Long> memberQueue = new HashSet<Long>();
	    
	public WorkFlowQueue() {
		
	}
	public WorkFlowQueue(Member member) {
		this.member = member;
	}

    
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	public   Set<Long> getProductQueue() {
		return   productQueue;
	}
	
	public void setProductQueue(Set<Long> productQueue) {
		this.productQueue = productQueue;
	}

	public   Set<Long> getMemberQueue() {
		return   memberQueue;
	}
	
	public void setMemberQueue(Set<Long> memberQueue) {
		this.memberQueue = memberQueue;
	}
	
	@SuppressWarnings("null")
	public   Set<Long> getQueue(WorkFlowType workFlowType) {
		
		Set<Long> queue = null;
		
		switch (workFlowType) {
		
			case PRODUCT:
				queue = this.productQueue;
				break;
				
			case MEMBER:
				queue = this.memberQueue;
		}
		
		return   queue;
	}


}
