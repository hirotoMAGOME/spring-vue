package hm.springapi.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClsTypeRepository extends JpaRepository<ClsType, Long> {
}