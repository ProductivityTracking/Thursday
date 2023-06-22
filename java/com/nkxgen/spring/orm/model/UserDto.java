package com.nkxgen.spring.orm.model;

import java.util.Date;

public class UserDto {
    private int userId;
    private String userDisplayName;
    private String userPassword;
    private Date userCreationDate;
    private String userEmployeeId;
    private String userStatus;
    private Date userLastUpdatedDate;
    private Role userRole;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getUserCreationDate() {
        return userCreationDate;
    }

    public void setUserCreationDate(Date userCreationDate) {
        this.userCreationDate = userCreationDate;
    }

    public String getUserEmployeeId() {
        return userEmployeeId;
    }

    public void setUserEmployeeId(String userEmployeeId) {
        this.userEmployeeId = userEmployeeId;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserLastUpdatedDate() {
        return userLastUpdatedDate;
    }

    public void setUserLastUpdatedDate(Date userLastUpdatedDate) {
        this.userLastUpdatedDate = userLastUpdatedDate;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public static UserDto fromEntity(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserDisplayName(user.getUserDisplayName());
        userDto.setUserPassword(user.getUserPassword());
        userDto.setUserCreationDate(user.getUserCreationDate());
        userDto.setUserEmployeeId(user.getUserEmployeeId());
        userDto.setUserStatus(user.getUserStatus());
        userDto.setUserLastUpdatedDate(user.getUserLastUpdatedDate());
        userDto.setUserRole(user.getUserRole());
        return userDto;
    }
}
