package com.weshare.sirius.weshare;
import java.util.HashSet;

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

		//only post to nearby people

	}

	public void acceptRequest(Request r) {
		//change item to unavailable
		for (Item i : possessions) {

			/** r.setItem(); */
		}
		
	}

	public void createItem(String name, HashSet<String> tag, int value, String other) {
		Item requested = new Item(name, tag, value, other);
		possessions.add(requested);
	}

	public void chat(User anon) {

	}

	/** public void completeRequest(Request r) {
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
	} */

}