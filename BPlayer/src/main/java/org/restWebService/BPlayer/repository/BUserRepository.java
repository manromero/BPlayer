package org.restWebService.BPlayer.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.restWebService.BPlayer.domain.BUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface BUserRepository extends JpaRepository<BUser, Long> {

	@Query("select u from BUser u where u.username = ?1")
	public BUser findByUsername(String username);

	@Query("select u from BUser u where u.username = ?1 and u.password=?2")
	public BUser findByUsernameAndPassword(String username, String password);

	@Query("select a from Organization o join o.administrators a where o.id = ?1 group by a")
	public List<BUser> finAdministratorsByIdOrganization(Long idOrganization);

	@Query("select b from BUser b where b.id not in (select a.id from Organization o join o.administrators a where o.id = ?1)")
	public List<BUser> findListBUserToBeAdministrator(Long idOrganization);
	
}
