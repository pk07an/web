package com.vdlm.service.product.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meila.dal.slave.dao.ProductSlaveDao;
import com.vdlm.dal.dao.MeiLaProductDao;
import com.vdlm.dal.mapper.ProductMapper;
import com.vdlm.dal.mapper.SkuMapper;
import com.vdlm.dal.model.Product;
import com.vdlm.dal.model.Sku;
import com.vdlm.service.common.BaseServiceImpl;
import com.vdlm.service.product.MeiLaProductService;
import com.vdlm.service.product.vo.ProductSkuVO;

@Service("meiLaProductService")
public class MeiLaProductServiceImpl extends BaseServiceImpl implements MeiLaProductService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MeiLaProductServiceImpl.class);
    @Autowired
    private MeiLaProductDao meiLaProductDao;
    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductSlaveDao productSlaveDao;

    @Override
    public ProductSkuVO loadById(String productId, String skuId) {

        Product product = meiLaProductDao.selectById(productId);
        if (product == null) {
            return null;
        }
        Sku sku = skuMapper.select(productId, skuId);
        if (sku == null) {
            return null;
        }
        ProductSkuVO productSkuVO = new ProductSkuVO(product);
        productSkuVO.setSku(sku);
        return productSkuVO;

    }
    
    @Override
    public void deductionSale(String productId,String skuId,Integer sale){
        int skuUpdate=skuMapper.updateSaleBySkuId(skuId,sale);
        int productUpdate=productMapper.updateSaleByProductId(productId,sale);
    }
    
    @Override
    public Product selectByProductCode(String productCode) {
        // return productMapper.selectByCode(productCode);
        return productSlaveDao.selectByCode(productCode);
    }
}
