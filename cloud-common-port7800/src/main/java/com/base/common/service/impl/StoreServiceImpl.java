package com.base.common.service.impl;

import com.base.common.dao.StoreMapper;
import com.base.common.service.StoreService;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PPmaster
 * @since 2021/5/12 23:04
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Resource
    StoreMapper storeMapper;

    @Override
    public List getAllStoreList() {
        return storeMapper.getAllStoreList();
    }

}
