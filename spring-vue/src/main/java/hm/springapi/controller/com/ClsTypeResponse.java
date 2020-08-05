package hm.springapi.controller.com;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.ClsType;

import java.util.List;

@Getter
@Builder
public class ClsTypeResponse {

    private List<ClsType> clstypes;
}