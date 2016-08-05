package com.vdlm.meila.client;

import java.io.Serializable;

public class MeilaUser implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private String age_range;
    private String avatar;
    // private Integer collect_count;
    // private Integer comment_count;
    private Integer fans_count;
    // private Integer follows_count;
    private Integer gender;
    private Integer level;
    private String level_img;
    private String nickname;
    private Integer skin_type;
    private String slug;
    private String type_icon;

    private MeilaUserClub club = new MeilaUserClub();

    // 代表是否关注
    private int sns_status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge_range() {
        return age_range;
    }

    public void setAge_range(String age_range) {
        this.age_range = age_range;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    // public Integer getCollect_count() {
    // return collect_count;
    // }
    //
    // public void setCollect_count(Integer collect_count) {
    // this.collect_count = collect_count;
    // }
    //
    // public Integer getComment_count() {
    // return comment_count;
    // }
    //
    // public void setComment_count(Integer comment_count) {
    // this.comment_count = comment_count;
    // }
    //
    // public Integer getFans_count() {
    // return fans_count;
    // }
    //
    // public void setFans_count(Integer fans_count) {
    // this.fans_count = fans_count;
    // }
    //
    // public Integer getFollows_count() {
    // return follows_count;
    // }
    //
    // public void setFollows_count(Integer follows_count) {
    // this.follows_count = follows_count;
    // }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevel_img() {
        return level_img;
    }

    public void setLevel_img(String level_img) {
        this.level_img = level_img;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSkin_type() {
        return skin_type;
    }

    public void setSkin_type(Integer skin_type) {
        this.skin_type = skin_type;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getType_icon() {
        return type_icon;
    }

    public void setType_icon(String type_icon) {
        this.type_icon = type_icon;
    }

    public MeilaUserClub getClub() {
        return club;
    }

    public void setClub(MeilaUserClub club) {
        this.club = club;
    }

    public int getSns_status() {
        return sns_status;
    }

    public void setSns_status(int sns_status) {
        this.sns_status = sns_status;
    }

	public Integer getFans_count() {
		return fans_count;
	}

	public void setFans_count(Integer fans_count) {
		this.fans_count = fans_count;
	}

}
