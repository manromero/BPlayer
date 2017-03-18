package org.restWebService.BPlayer.repository;

import javax.transaction.Transactional;

import org.restWebService.BPlayer.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface TeamRepository extends JpaRepository<Team, Long> {

}
