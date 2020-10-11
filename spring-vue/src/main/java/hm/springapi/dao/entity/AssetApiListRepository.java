package hm.springapi.dao.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetApiListRepository extends JpaRepository<AssetApiList, Long> {
}