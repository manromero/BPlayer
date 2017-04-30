package org.restWebService.BPlayer.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.restWebService.BPlayer.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface TeamRepository extends JpaRepository<Team, Long> {

	@Query("select t from Team t where t.organization.id = ?1")
	public List<Team> findTeamsByIdOrganization(Long idOrganization);

}
