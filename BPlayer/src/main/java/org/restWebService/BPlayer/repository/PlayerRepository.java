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

	@Query("select p from Team t join t.listPlayer p where t.id = ?1 group by p")
	public List<Player> findPlayersByIdTeam(Long idTeam);

	@Query("select p from Player p where p.organization.id in (select t.organization.id from Team t where t.id = ?1) and p.id not in (select pa from Team ta join ta.listPlayer pa where ta.id = ?1)")
	public List<Player> findListPlayerToAddTeam(Long idTeam);

}
