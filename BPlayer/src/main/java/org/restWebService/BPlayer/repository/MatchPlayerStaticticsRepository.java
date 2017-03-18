package org.restWebService.BPlayer.repository;

import javax.transaction.Transactional;

import org.restWebService.BPlayer.domain.MatchPlayerStatictics;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface MatchPlayerStaticticsRepository extends JpaRepository<MatchPlayerStatictics, Long> {

}
