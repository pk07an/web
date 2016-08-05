package com.vdlm.meila.client;

import java.util.Date;
import java.util.List;

/**
 * 社区返回的围观讨论详细信息
 * @author yongqi@meila.com
 */
public class MeilaWareDiscussDetail {

    private String slug;
    private String content;
    private Boolean has_more_replies;
    private Integer reply_count;
    private String reply_to;
    private Date create_time;
    private Date update_time;
    
    private MeilaUser user;
    private List<MeilaWareDiscussDetail> replies;
    private List<MeilaWareDiscussImg> imgs;
    
    
    public Date getUpdate_time() {
        return update_time;
    }
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
    public Boolean getHas_more_replies() {
        return has_more_replies;
    }
    public void setHas_more_replies(Boolean has_more_replies) {
        this.has_more_replies = has_more_replies;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getReply_count() {
        return reply_count;
    }
    public void setReply_count(Integer reply_count) {
        this.reply_count = reply_count;
    }
    public Date getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public String getReply_to() {
        return reply_to;
    }
    public void setReply_to(String reply_to) {
        this.reply_to = reply_to;
    }
    public MeilaUser getUser() {
        return user;
    }
    public void setUser(MeilaUser user) {
        this.user = user;
    }
    public List<MeilaWareDiscussDetail> getReplies() {
        return replies;
    }
    public void setReplies(List<MeilaWareDiscussDetail> replies) {
        this.replies = replies;
    }
    public List<MeilaWareDiscussImg> getImgs() {
        return imgs;
    }
    public void setImgs(List<MeilaWareDiscussImg> imgs) {
        this.imgs = imgs;
    }
}
