package org.restWebService.BPlayer.repository;

import javax.transaction.Transactional;

import org.restWebService.BPlayer.domain.BUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface BUserRepository extends JpaRepository<BUser, Long> {

	@Query("select u from BUser u where u.username = ?1")
	public BUser findByUsername(String username);
	
}
