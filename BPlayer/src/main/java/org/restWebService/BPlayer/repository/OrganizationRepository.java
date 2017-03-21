package org.restWebService.BPlayer.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.restWebService.BPlayer.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	@Query("select o from Organization o join o.administrators a where a.id=?1 group by o")
	public List<Organization> findAdministratedByBUserId(long id);

}
