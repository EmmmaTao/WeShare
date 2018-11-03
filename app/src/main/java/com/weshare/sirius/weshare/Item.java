

public class Item {
    private Hashset _tag;
    private int _value;
    private String _notes;
    //private _records;
    private boolean _damaged;

    /** Constructor for an ITEM, taking a TAG, VALUE and NOTES.*/
    public Item(Hashset tag, int value, String notes) {
        this.tag = tag;
        this._value = value;
        this._notes = notes;
        this._damaged = false;
    }

    public boolean damage() {
        return _damaged;
    }

    public Hashset getTag() {
        return _tag;
    }

    public int getValue() {
        return _value;
    }

    public String getNotes() {
        return _notes;
    }

    public void setDamage() {
        _damaged = true;
    }

    public void damaged() {
        if (damage()) {
            // call somebody!
        }
    }

}
