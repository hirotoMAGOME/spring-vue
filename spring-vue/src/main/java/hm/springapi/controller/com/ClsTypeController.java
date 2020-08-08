package hm.springapi.controller.com;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import hm.springapi.domain.ClsType;
import hm.springapi.service.common.ClsTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClsTypeController {

    private final ClsTypeService clsTypeService;

    @GetMapping("/api/common/cls-type")
    public ResponseEntity<ClsTypeResponse> findByDomainCdOrderByClsTypeKey() {
        List<ClsType> clstype = clsTypeService.findByDomainCdOrderByClsTypeKey();
        ClsTypeResponse clsTypeResponse = ClsTypeResponse.builder()
                .clstypes(clstype)
                .build();

        return new ResponseEntity<>(clsTypeResponse, HttpStatus.OK);
    }
    
    
}