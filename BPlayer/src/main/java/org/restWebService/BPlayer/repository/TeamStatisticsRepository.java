package org.restWebService.BPlayer.repository;

import javax.transaction.Transactional;

import org.restWebService.BPlayer.domain.TeamStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface TeamStatisticsRepository extends JpaRepository<TeamStatistics, Long> {

}
