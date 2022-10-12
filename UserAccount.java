package com.example.lab5.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The type User account.
 */
public class UserAccount {

   /**
    * The constant GENDER_MALE.
    */
   public static final String GENDER_MALE = "M";
   /**
    * The constant GENDER_FEMALE.
    */
   public static final String GENDER_FEMALE = "F";

   private String userName;
   private String gender;
   private String password;

   private List<String> roles;

   /**
    * Instantiates a new User account.
    */
   public UserAccount() {

   }

   /**
    * Instantiates a new User account.
    *
    * @param userName the user name
    * @param password the password
    * @param gender   the gender
    * @param roles    the roles
    */
   public UserAccount(String userName, String password, String gender, String... roles) {
      this.userName = userName;
      this.password = password;
      this.gender = gender;

      this.roles = new ArrayList<String>();
      if (roles != null) {
         for (String r : roles) {
            this.roles.add(r);
         }
      }
   }

   /**
    * Gets user name.
    *
    * @return the user name
    */
   public String getUserName() {
      return userName;
   }

   /**
    * Sets user name.
    *
    * @param userName the user name
    */
   public void setUserName(String userName) {
      this.userName = userName;
   }

   /**
    * Gets gender.
    *
    * @return the gender
    */
   public String getGender() {
      return gender;
   }

   /**
    * Sets gender.
    *
    * @param gender the gender
    */
   public void setGender(String gender) {
      this.gender = gender;
   }

   /**
    * Gets password.
    *
    * @return the password
    */
   public String getPassword() {
      return password;
   }

   /**
    * Sets password.
    *
    * @param password the password
    */
   public void setPassword(String password) {
      this.password = password;
   }

   /**
    * Gets roles.
    *
    * @return the roles
    */
   public List<String> getRoles() {
      return roles;
   }

   /**
    * Sets roles.
    *
    * @param roles the roles
    */
   public void setRoles(List<String> roles) {
      this.roles = roles;
   }
}