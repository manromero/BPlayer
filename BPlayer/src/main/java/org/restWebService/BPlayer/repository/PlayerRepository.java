package org.restWebService.BPlayer.repository;

import javax.transaction.Transactional;

import org.restWebService.BPlayer.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
