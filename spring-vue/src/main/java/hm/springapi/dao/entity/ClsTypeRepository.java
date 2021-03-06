package hm.springapi.dao.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClsTypeRepository extends JpaRepository<ClsType, Long> {
	public List<ClsType> findByDomainCdIn(List<String> ClsTypeKey);
}