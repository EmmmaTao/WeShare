import java.util.HashSet;
import java.util.ArrayList;

public class Item {

    /** tag of this item.*/
    private HashSet _tag;

    /** value of this item.*/
    private int _value;

    /** notes of this item.*/
    private String _notes;

    /** records of this item.*/
    private ArrayList<Request> _records;

    /** whether this item is damaged.*/
    private boolean _damaged;

    /** whether this item is available.*/
    private boolean _available;

    /** Constructor for an ITEM, taking a TAG, VALUE and NOTES.*/
    public Item(HashSet tag, int value, String notes) {
        this._tag = tag;
        this._value = value;
        this._notes = notes;
        this._damaged = false;
        this._available = false;
    }

    /** get the damage of this item.*/
    public boolean getDamage() {
        return _damaged;
    }

    /** get the tag of this item.*/
    public HashSet getTag() {
        return _tag;
    }

    /** get the value of this item.*/
    public int getValue() {
        return _value;
    }

    /** get the notes of this item.*/
    public String getNotes() {
        return _notes;
    }

    /** get the availability of this item.*/
    public boolean getAvailable() {
        return _available;
    }

    /** register that this item is damaged.*/
    public void setDamage() {
        _damaged = true;
    }

    /** change the availability of this item.*/
    public void setAvailable() {
        if (getAvailable()) {
            _available = false;
        } else {
            _available = true;
        }
    }

    /** UNFINISHED.*/
    public void damaged() {
        if (getDamage()) {
            // ahhhhhhhhhhhh
        }
    }

    /** add more records of this item.*/
    public void logRecord(Request r) {
        _records.add(r);
    }

}
