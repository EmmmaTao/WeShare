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
	public static ArrayList<User> allusers = new ArrayList<User>();

	public static void initdummyusers() {
		HashSet<String> dummytags = new HashSet<String>();
		dummytags.add("Electronics");
		User user1 = new User(dummytags, "user1", "12345");
		User user2 = new User(dummytags, "user2", "23451");
		User user3 = new User(dummytags, "user3", "34512");
		User user4 = new User(dummytags, "user4", "45123");
		User user5 = new User(dummytags, "user5", "51234");
		allusers.add(user1);
		allusers.add(user2);
		allusers.add(user3);
		allusers.add(user4);
		allusers.add(user5);
	}

	public User(HashSet<String> initialTags, String name, String acct) {
		tags = initialTags;
		username = name;
		possessions = new HashSet<Item>();
		account = acct;
		credit = 0;
		allusers.add(this);
	}
	public void postRequest() {
		//pop window, get tags, create a HashSet of tags and so on
  		HashSet<String> tags = null;
  		String itemName = "";
  		//Location location;
  		String otherInfo;
  		Request r = new Request(this, tags, itemName);
  		//fetch nearby users in nearby[]
        User[] nearby = new User[3];
  		sendNotification(nearby);
  		//post this request 
  		//only post to nearby people
	}

	public void sendNotification(User[] near) {

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
		// ask user to 1)select from matches,
		// 2)create new possession, 3) select from all possessions
        int options = 1;
		if (options == 1) {
			//show matches, prompt user to select item _i
            Item i = new Item("",null,0,"");
			r.setItem(i);
			i.setAvailable();
		}
		else if (options == 2) {
			//prompt user for _tag, _value, _other
            HashSet<String> tag = null;
            int value = 0;
            String other = "";
			Item it = createItem(r.getItemName(), tag, value, other);
			r.setItem(it);
			it.setAvailable();
		}
		else {
			//show all possessions, prompt user to select item _i
            Item i = new Item("",null,0,"");
			r.setItem(i);
			i.setAvailable();
		}

		//await borrower's confirmation
        boolean confirmed = false;
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
		//prompt user to comfirm completion in mouseclick
		boolean mouseclick = false;
		if (mouseclick) {
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

	public Item createItem(String n, HashSet<String> tag, int value, String other) {
		Item requested = new Item(n, tag, value, other);
		possessions.add(requested);
		return requested;
	}

	public void addTag(String t) {
		assert Arrays.asList(Item.alltags).contains(t);
		tags.add(t);
	}

	public void removeTag(String t) {
		tags.remove(t);
	}

}