package com.weshare.sirius.weshare;

import java.util.HashSet;

public class Request{

  public User borrower;
  public User provider;
  public HashSet<String> tags;
  public String itemName;
  /** public String otherInfo; */
  public int status;
  public Item obj;
  /** public Location location; */


  Request(User borrower, HashSet<String> tags, String itemName) {
   /** Location location; String otherInfo = null){ */
      this.borrower = borrower;
    this.tags = tags;
    this.itemName = itemName;
    /** this.location = location; */
    /** this.otherInfo = otherInfo; */
    this.status = -1;
  }

  /**Location getLocation(){
    return location;
  } */

  boolean isComplete(){
    return status > 0;
  }

  void setComplete(){
    status = 1;
  }

  void processRequest(User provider){
    this.provider = provider;
    status = 0;
  }

  void setItem(Item obj){
    this.obj = obj;
  }

  Item getItem(){
    assert(obj != null);
    return obj;
  }

  User getBorrower() {
    return borrower;
  }

  String getItemName() {
    return itemName;
  }

  /** void toString(){
    String verb = "";
    if(status < 1){
      verb = " wants "
    } else if(status = 0){
      verb = " is borrowing ";
    } else{
      verb = " borrowed "
    }
    return from + verb + obj.toString();
  } */

}
