package edu.mum.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.MemberDao;
import edu.mum.domain.Address;
import edu.mum.domain.Member;


@SuppressWarnings("unchecked")
@Repository
public class MemberDaoImpl extends GenericDaoImpl<Member> implements MemberDao {

	public MemberDaoImpl() {
		super.setDaoType(Member.class );
		}

	public Member findByMemberNumber(Integer number) {
	     
		Query query = entityManager.createQuery("select m from MEMBER m  where m.memberNumber =:number");
		return (Member) query.setParameter("number", number).getSingleResult();
			     

	}

	//  - Using JPQL checks the address FK for Member[a.memberId]  using memberId declared in Address
	// memberId needs to reflect the name of the FK in Address Table in DB
/*	public Member findByAddress(Address address) {
		
		Query query = entityManager.createQuery("select m from MEMBER m  where m.id =:memberId");
		return (Member) query.setParameter("memberId", address.getMemberId()).getSingleResult();

	}
*/	
	// NATIVE SQL - checks the address FK for Member[a.memberId] directly instead of using the memberId stored in Address
	// BECUSE reflecting the FK in the OO model COULD BE CONSIDERED BAD PRACTICE!!! 
	public Member findByAddressNative(Long addressId) {
		
		Query query = entityManager.createNativeQuery("SELECT m.* FROM " +
				" MEMBR m, Address a where m.member_id = a.memberId and a.id = ?", Member.class);

			Member member = (Member) query.setParameter(1,addressId).getSingleResult();
			return member;

	}
	
 }