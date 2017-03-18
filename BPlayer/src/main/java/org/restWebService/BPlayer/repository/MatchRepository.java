package org.restWebService.BPlayer.repository;

import javax.transaction.Transactional;

import org.restWebService.BPlayer.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface MatchRepository extends JpaRepository<Match, Long> {

}
