// This java file provides the code for the attributes for items in the inventory database. These
// attributes can be created and modified in the database.

package com.example.inventory;

public class Item {
    private long itemId;
    private String itemTitle;
    private String itemQuantity;
    private String itemQuantityUnits;
    private boolean expanded;

    public Item(long id, String username, String title, String quantity, String quantityUnits) {
        this.itemId = id;
        this.itemTitle = title;
        this.itemQuantity = quantity;
        this.itemQuantityUnits = quantityUnits;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public long getId() {
        return itemId;
    }
    public void setId(int id) {
        this.itemId = id;
    }

    public String getTitle() {
        return itemTitle;
    }
    public void setTitle(String title) {
        this.itemTitle = title;
    }

    public String getQuantity() {
        return itemQuantity;
    }
    public void setQuantity(String quantity) {
        this.itemQuantity = quantity;
    }

    public String getQuantityUnits() {
        return itemQuantityUnits;
    }
    public void setQuantityUnits(String quantityUnits) {
        this.itemQuantityUnits = quantityUnits;
    }
}