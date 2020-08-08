package hm.springapi.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClsTypeRepository extends JpaRepository<ClsType, Long> {
	public List<ClsType> findByDomainCdOrderByClsTypeKey(String name);
}