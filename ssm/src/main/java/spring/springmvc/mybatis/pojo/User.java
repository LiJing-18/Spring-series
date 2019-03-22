package spring.springmvc.mybatis.pojo;

/**
 * 用户表
 */
public class User {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户性别
     */
    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + "]";
	}
    
}