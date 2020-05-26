package com.jabanto.spring.SpringMVc.Model;

public class Role {

    private int id;
    private int idUser;
    private int roleAdmin;
    private int roleDevelop;
    private int roleCtld;
    private int roleGltd;
    private int roleBilling;
    private int roleRegistry;
    private int rolePurchaseRead;
    private int rolePurchaseWrite;
    private int roleSaleWrite;
    private int roleSql;

    public Role(int id, int idUser, int roleAdmin, int roleDevelop, int roleCtld, int roleGltd, int roleBilling, int roleRegistry, int rolePurchaseRead, int rolePurchaseWrite, int roleSaleWrite, int roleSql) {

        this.id = id;
        this.idUser = idUser;
        this.roleAdmin = roleAdmin;
        this.roleDevelop = roleDevelop;
        this.roleCtld = roleCtld;
        this.roleGltd = roleGltd;
        this.roleBilling = roleBilling;
        this.roleRegistry = roleRegistry;
        this.rolePurchaseRead = rolePurchaseRead;
        this.rolePurchaseWrite = rolePurchaseWrite;
        this.roleSaleWrite = roleSaleWrite;
        this.roleSql = roleSql;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getRoleAdmin() {
        return roleAdmin;
    }

    public void setRoleAdmin(int roleAdmin) {
        this.roleAdmin = roleAdmin;
    }

    public int getRoleDevelop() {
        return roleDevelop;
    }

    public void setRoleDevelop(int roleDevelop) {
        this.roleDevelop = roleDevelop;
    }

    public int getRoleCtld() {
        return roleCtld;
    }

    public void setRoleCtld(int roleCtld) {
        this.roleCtld = roleCtld;
    }

    public int getRoleGltd() {
        return roleGltd;
    }

    public void setRoleGltd(int roleGltd) {
        this.roleGltd = roleGltd;
    }

    public int getRoleBilling() {
        return roleBilling;
    }

    public void setRoleBilling(int roleBilling) {
        this.roleBilling = roleBilling;
    }

    public int getRoleRegistry() {
        return roleRegistry;
    }

    public void setRoleRegistry(int roleRegistry) {
        this.roleRegistry = roleRegistry;
    }

    public int getRolePurchaseRead() {
        return rolePurchaseRead;
    }

    public void setRolePurchaseRead(int rolePurchaseRead) {
        this.rolePurchaseRead = rolePurchaseRead;
    }

    public int getRolePurchaseWrite() {
        return rolePurchaseWrite;
    }

    public void setRolePurchaseWrite(int rolePurchaseWrite) {
        this.rolePurchaseWrite = rolePurchaseWrite;
    }

    public int getRoleSaleWrite() {
        return roleSaleWrite;
    }

    public void setRoleSaleWrite(int roleSaleWrite) {
        this.roleSaleWrite = roleSaleWrite;
    }

    public int getRoleSql() {
        return roleSql;
    }

    public void setRoleSql(int roleSql) {
        this.roleSql = roleSql;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", roleAdmin=" + roleAdmin +
                ", roleDevelop=" + roleDevelop +
                ", roleCtld=" + roleCtld +
                ", roleGltd=" + roleGltd +
                ", roleBilling=" + roleBilling +
                ", roleRegistry=" + roleRegistry +
                ", rolePurchaseRead=" + rolePurchaseRead +
                ", rolePurchaseWrite=" + rolePurchaseWrite +
                ", roleSaleWrite=" + roleSaleWrite +
                ", roleSql=" + roleSql +
                '}';
    }
}
