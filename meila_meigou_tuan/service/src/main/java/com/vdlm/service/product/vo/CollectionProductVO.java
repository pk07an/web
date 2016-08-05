package com.vdlm.service.product.vo;

import java.io.Serializable;
import java.util.Date;

public class CollectionProductVO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String productId;
    private Date collectionAt;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getCollectionAt() {
        return collectionAt;
    }

    public void setCollectionAt(Date collectionAt) {
        this.collectionAt = collectionAt;
    }

}
