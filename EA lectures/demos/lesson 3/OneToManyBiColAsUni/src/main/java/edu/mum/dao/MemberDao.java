package edu.mum.dao;

import edu.mum.domain.Address;
import edu.mum.domain.Member;

public interface MemberDao extends GenericDao<Member> {
      
	public Member findByMemberNumber(Integer number);
	
	public Member findByAddressNative(Long addressId);
}
