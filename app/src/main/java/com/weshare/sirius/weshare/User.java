package com.weshare.sirius.weshare;

import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;


public class User {
	public HashSet<String> tags;
	public HashSet<Item> possessions;
	public int credit;
	public String account;
	public String username;
	//map api return what kind of location data?

	public User(HashSet<String> initialTags, String name, String acct) {
		tags = initialTags;
		username = name;
		possessions = new HashSet<Item>();
		account = acct;
		credit = 0;
	}
	public void postRequest() {
		//pop window, get tags, create a HashSet of tags and so on
  		HashSet<String> tags;
  		String itemName;
  		Location location;
  		String otherInfo;
  		Request r = new Request(this, tags, itemName, location, otherInfo);
  		sendNotification(User[] nearby);
  		//post this request 
  		//only post to nearby people
	}

	//called when user decides to accept a request
	public void acceptRequest(Request r) {
		//change item to unavailable
		ArrayList<Item> match = new ArrayList<Item>();
		for (Item i : possessions) {
			if (i.getName().equals(r.getItemName())) {
				match.add(i);
			}
		}
		// ask user to a)select from matches, 
		// b)create new possession, c) select from all possessions
		if (a) {
			//show matches, prompt user to select item _i
			r.setItem(i);
			i.setAvailable(false);
		}
		else if (b) {
			//prompt user for _tag, _value, _other
			Item it = createItem(r.getItemName(), tag, value, other);
			r.setItem(it);
			i.setAvailable(false);
		}
		else {
			//show all possessions, prompt user to select item _i
			r.setItem(i);
			i.setAvailable(false);
		}

		//await borrower's confirmation
		if (confirmed) {
			r.getBorrower().holdDeposit(r.getItem().getValue() / 10);
		}
	}

	public void holdDeposit(int dep) {
		//freeze _dep amount of money from account, connect to Paypal API			
	}

	public void chat(User anon) {
		//chatting
	}

	public void completeRequest(Request r) {
		Item i = r.getItem();
		if (mouseclick on something) {
			possessions.remove(i);
			i.damaged();	
			//deduct money from borrower + report to support
		}
		else {
			//unfreeze money
			r.setComplete();
			credit++;
			tags.addAll(i.getTag()); //?
			i.logRecord(r);
		}
	}

	public void createItem(String n, HashSet<String> tag, int value, String other) {
		Item requested = new Item(n, tag, value, other);
		possessions.add(requested);
	}

	public void addTag(String t) {
		assert Arrays.asList(Item.alltags).contains(t);
		tags.add(t);
	}

	public void removeTag(String t) {
		tags.remove(t);
	}

}