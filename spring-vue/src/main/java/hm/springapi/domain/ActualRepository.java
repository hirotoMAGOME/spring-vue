package hm.springapi.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActualRepository extends JpaRepository<Actual, Long> {
}