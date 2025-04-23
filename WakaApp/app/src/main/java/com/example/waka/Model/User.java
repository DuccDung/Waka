package com.example.waka.Model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("fullName")
    private String fullName;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("gender")
    private int gender;

    @SerializedName("address")
    private String address;

    @SerializedName("resetPassword")
    private int resetPassword;

    @SerializedName("accountActive")
    private boolean accountActive;

    @SerializedName("socialAccount")
    private boolean socialAccount;

    @SerializedName("id")
    private String id;

    @SerializedName("userName")
    private String userName;

    @SerializedName("normalizedUserName")
    private String normalizedUserName;

    @SerializedName("email")
    private String email;

    @SerializedName("normalizedEmail")
    private String normalizedEmail;

    @SerializedName("emailConfirmed")
    private boolean emailConfirmed;

    @SerializedName("passwordHash")
    private String passwordHash;

    @SerializedName("securityStamp")
    private String securityStamp;

    @SerializedName("concurrencyStamp")
    private String concurrencyStamp;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    @SerializedName("phoneNumberConfirmed")
    private boolean phoneNumberConfirmed;

    @SerializedName("twoFactorEnabled")
    private boolean twoFactorEnabled;

    @SerializedName("lockoutEnd")
    private String lockoutEnd;

    @SerializedName("lockoutEnabled")
    private boolean lockoutEnabled;

    @SerializedName("accessFailedCount")
    private int accessFailedCount;

    // Getter and Setter Methods for each field

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(int resetPassword) {
        this.resetPassword = resetPassword;
    }

    public boolean isAccountActive() {
        return accountActive;
    }

    public void setAccountActive(boolean accountActive) {
        this.accountActive = accountActive;
    }

    public boolean isSocialAccount() {
        return socialAccount;
    }

    public void setSocialAccount(boolean socialAccount) {
        this.socialAccount = socialAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNormalizedUserName() {
        return normalizedUserName;
    }

    public void setNormalizedUserName(String normalizedUserName) {
        this.normalizedUserName = normalizedUserName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNormalizedEmail() {
        return normalizedEmail;
    }

    public void setNormalizedEmail(String normalizedEmail) {
        this.normalizedEmail = normalizedEmail;
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSecurityStamp() {
        return securityStamp;
    }

    public void setSecurityStamp(String securityStamp) {
        this.securityStamp = securityStamp;
    }

    public String getConcurrencyStamp() {
        return concurrencyStamp;
    }

    public void setConcurrencyStamp(String concurrencyStamp) {
        this.concurrencyStamp = concurrencyStamp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPhoneNumberConfirmed() {
        return phoneNumberConfirmed;
    }

    public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
        this.phoneNumberConfirmed = phoneNumberConfirmed;
    }

    public boolean isTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public String getLockoutEnd() {
        return lockoutEnd;
    }

    public void setLockoutEnd(String lockoutEnd) {
        this.lockoutEnd = lockoutEnd;
    }

    public boolean isLockoutEnabled() {
        return lockoutEnabled;
    }

    public void setLockoutEnabled(boolean lockoutEnabled) {
        this.lockoutEnabled = lockoutEnabled;
    }

    public int getAccessFailedCount() {
        return accessFailedCount;
    }

    public void setAccessFailedCount(int accessFailedCount) {
        this.accessFailedCount = accessFailedCount;
    }
}

