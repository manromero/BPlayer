package org.restWebService.BPlayer.repository;

import javax.transaction.Transactional;

import org.restWebService.BPlayer.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
