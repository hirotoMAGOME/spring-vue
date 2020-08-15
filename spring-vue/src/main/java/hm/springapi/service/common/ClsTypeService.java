package hm.springapi.service.common;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.domain.ClsType;
import hm.springapi.domain.ClsTypeRepository;

//import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClsTypeService {

    private final ClsTypeRepository clsTypeRepository;

//    TODO NULLÇÃÇ∆Ç´Ç…ëSåüçıÇ…ÇµÇΩÇ¢
    public List<ClsType> findByDomainCdIn(List<String> ClsTypeKey) {
        return clsTypeRepository.findByDomainCdIn(ClsTypeKey);
    }
    
//    public String createBudgetCategory(BudgetCategory budgetCategory) {
//    	//TODO DBÇÃNOW()ÇégÇ¡ÇΩï˚Ç™Ç¢Ç¢ÅH
//    	LocalDateTime now = LocalDateTime.now();
//    	
//    	java.lang.System.out.println("bbbbbbbbb1");
//    	java.lang.System.out.println(budgetCategory.getName());
//    	java.lang.System.out.println("aaaaaaaaaa1");
//    	
//    	
//    	budgetCategory.setUserId((long)1);
//    	budgetCategory.setName("test2");
//    	budgetCategory.setBudgetCategoryType(true);
//    	
//    	budgetCategory.setCreatedAt(java.sql.Date.valueOf("2020-01-02"));
//    	budgetCategory.setUpdatedAt(java.sql.Date.valueOf("2020-01-02"));
//    	
//    	java.lang.System.out.println("bbbbbbbbb1");
//    	java.lang.System.out.println(budgetCategory.getName());
//    	java.lang.System.out.println("aaaaaaaaaa1");
//    	
//    	budgetCategoryRepository.save(budgetCategory);
//    	
//    	return "success!!";
//    }
}