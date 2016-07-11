package com.webshop.model;

public enum UserProfileType
{
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    String userProfileType;

    private UserProfileType(String userProfileType)
    {
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType()
    {
        return userProfileType;
    }

    public void setUserProfileType(String userProfileType)
    {
        this.userProfileType = userProfileType;
    }
}
