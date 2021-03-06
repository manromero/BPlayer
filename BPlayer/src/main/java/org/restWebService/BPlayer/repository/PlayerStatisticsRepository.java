package org.restWebService.BPlayer.repository;

import javax.transaction.Transactional;

import org.restWebService.BPlayer.domain.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface PlayerStatisticsRepository extends JpaRepository<PlayerStatistics, Long> {

}
