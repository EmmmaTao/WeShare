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
  public Location location;


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

  User getProvider() { return provider; }

  HashSet<String> getTags() {
      return tags;
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
    r1.location = new Location("");
    r1.location.setLatitude(37.871612);
    r1.location.setLongitude(-122.262820);
    //vlsb northwest

    HashSet<String> tags2 = new HashSet<String>();
    tags2.add("Stationeries");
    Request r2 = new Request(User.allusers.get(1),tags2, "printing paper");
    r2.location = new Location("");
    r2.location.setLatitude(37.871218);
    r2.location.setLongitude(-122.258904);
    //37.871218, -122.258904 wheeler

    HashSet<String> tags3 = new HashSet<String>();
    tags3.add("Textbooks");
    Request r3 = new Request(User.allusers.get(2),tags3, "a java reference");
    r3.location = new Location("");
    r3.location.setLatitude(37.873465);
    r3.location.setLongitude(-122.257780);
      // lat 37.873465, long -122.257780 (evans)


    Request r4 = new Request(User.allusers.get(3),tags1, "iphone charger");
    r4.location = new Location("");
    r4.location.setLatitude(37.870373);
    r4.location.setLongitude(-122.260495);
    //37.870373, -122.260495 dwinelle
      //0.002163, 0.000373

    Request r5 = new Request(User.allusers.get(5), tags2, "bluebook");
    r5.location = new Location("");
    r5.location.setLatitude(37.875617);
    r5.location.setLongitude(-122.258584);
    //37.875617, -122.258584 soda
      //0.003, 0.002284

      // current location is = 37.872536, -122.260868 (moffitt)

    allRequests.add(r1);
    allRequests.add(r2);
    allRequests.add(r3);
    allRequests.add(r4);
    allRequests.add(r5);
  }


}

