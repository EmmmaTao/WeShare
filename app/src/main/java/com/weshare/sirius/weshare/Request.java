package com.weshare.sirius.weshare;
import android.location.Location;

import java.util.ArrayList;
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
    allRequests.add(this);
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

  static ArrayList<Request> allRequests = new ArrayList<>();


  static void initializeAllRequest(){
    HashSet<String> tags1 = new HashSet<String>();
    tags1.add("Electronics");
    Request r1 = new Request(User.allusers.get(0),tags1, "ear phone");
    HashSet<String> tags2 = new HashSet<String>();
    tags2.add("Stationeries");
    Request r2 = new Request(User.allusers.get(1),tags2, "printing paper");
    HashSet<String> tags3 = new HashSet<String>();
    tags3.add("Textbooks");
    Request r3 = new Request(User.allusers.get(2),tags3, "a java reference");
    Request r4 = new Request(User.allusers.get(3),tags1, "iphone charger");
    Request r5 = new Request(User.allusers.get(5), tags2, "bluebook");
    allRequests.add(r1);
    allRequests.add(r2);
    allRequests.add(r3);
    allRequests.add(r4);
    allRequests.add(r5);
  }


}

