package com.example.myapplication;

public class GroupMember {
    String groupMember;
    String admin;

    public GroupMember(String groupMember, String admin) {
        this.groupMember = groupMember;
        this.admin = admin;
    }

    public String getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(String groupMember) {
        this.groupMember = groupMember;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
