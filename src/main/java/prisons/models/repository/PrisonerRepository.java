package prisons.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prisons.models.entity.PrisonerEntity;

@Repository
public interface PrisonerRepository extends JpaRepository<PrisonerEntity, Long>{

}
