package com.mfx.blog.dto;

/**
 * 日志表的action字段
 *
 * @author mfx
 * @date 2017/3/4
 */
public enum LogActions {

    DEFAULT_OPER("默认常规操作"),
    BACK_LOGIN("后台登录"),
    FRONT_LOGIN("前台登录"),
    LOGOUT("退出登录"),
    USER_REGISTER("用户注册"),
    MOD_PWD("修改密码"),
    MOD_INFO("修改个人信息"),
    PUBLISH_ARTICLE("发表文章"),
    AUDIT_ARTICLE("审核文章"),
    DEL_ARTICLE("删除文章"),
    ADD_ARTICLE_COMMENT("评论文章"),
    DEL_ARTICLE_COMMENT("删除文章评论"),
    ADD_ARTICLE_CATEGORY("增加文章分类"),
    ADD_ARTICLE_TAG("增加文章标签"),
    DEL_PAGE("删除页面"),
    SYS_BACKUP("系统备份"),
    SYS_SETTING("保存系统设置"),
    INIT_SITE("初始化站点"),
    VISIT_SITE("访问站点"),
    ADD_LINK("增加友链"),
    MOD_LINK("修改友链"),
    DEL_LINK("删除友链"),
    ADD_MILESTONE("记录历程"),
    MOD_MILESTONE("修改历程"),
    DEL_MILESTONE("删除历程"),
    ADD_AWARD("添加赞赏记录"),
    ARTICLE_LIKE_DISLIKE("支持或反对文章"),
    DELETE_LOG("删除日志"),
    ADD_FEEDBACK("添加反馈");

    private String action;

    LogActions(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
