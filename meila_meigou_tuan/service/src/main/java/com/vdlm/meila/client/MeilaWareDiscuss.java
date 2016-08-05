package com.vdlm.meila.client;

import java.util.List;

/**
 * 社区返回的围观讨论
 * @author yongqi@meila.com
 */
public class MeilaWareDiscuss {

    private Integer count;
    
    private List<MeilaWareDiscussDetail> discusses;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<MeilaWareDiscussDetail> getDiscusses() {
        return discusses;
    }

    public void setDiscusses(List<MeilaWareDiscussDetail> discusses) {
        this.discusses = discusses;
    }
}
