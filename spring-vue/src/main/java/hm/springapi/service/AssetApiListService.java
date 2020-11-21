package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.dao.entity.AssetApiList;
import hm.springapi.dao.entity.AssetApiListRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetApiListService {

    private final AssetApiListRepository assetApiList;

    public List<AssetApiList> findAll() {
        return assetApiList.findAll();
    }
}