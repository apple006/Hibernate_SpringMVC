package Entity;

import java.util.Date;

/**
 * 咨询评价单个json数据实体
 */
public class Expert_comment_item {

    //评论者名字
    private String author_name;
    //评论内容
    private String comment_content;
    //头像url
    private String profile;
    //评论时间
    private Date comment_time;
    //好坏程度
    private int level;

    public Expert_comment_item() {
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}