package cn.edu.zucc.pojo;

import java.io.Serializable;

public class TbRoleEntity implements Serializable {

    private Integer roleId;
    private String roleName;

    public Integer getId() {
        return roleId;
    }

    public void setId(Integer id) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return roleName;
    }

    public void setRolename(String rolename) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "TbRoleEntity{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
