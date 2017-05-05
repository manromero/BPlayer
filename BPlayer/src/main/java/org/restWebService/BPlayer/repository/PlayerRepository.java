package org.restWebService.BPlayer.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.restWebService.BPlayer.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Query("select p from Player p where p.organization.id = ?1")
	public List<Player> findPlayersByIdOrganization(Long idOrganization);

}
