package hm.springapi.controller.com;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import hm.springapi.dao.entity.ClsType;

@Getter
@Builder
public class ClsTypeResponse {

    private List<ClsType> clstypes;
}