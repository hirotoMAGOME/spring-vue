package hm.springapi.controller.com;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hm.springapi.domain.ClsType;
import hm.springapi.service.common.ClsTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClsTypeController {

    private final ClsTypeService clsTypeService;

    @GetMapping("/api/com/cls-type")
    @CrossOrigin
    public ResponseEntity<ClsTypeResponse> findByDomainCdOrderByClsTypeKey(@RequestParam(name = "domainCdList", required = false) String domainCdList) {
    	System.out.println(domainCdList);
        List<ClsType> clstype = clsTypeService.findByDomainCdOrderByClsTypeKey(domainCdList);
        ClsTypeResponse clsTypeResponse = ClsTypeResponse.builder()
                .clstypes(clstype)
                .build();

        return new ResponseEntity<>(clsTypeResponse, HttpStatus.OK);
    }
    
    
}