package com.innovaturelabs.training.contacts.view;

import com.innovaturelabs.training.contacts.json.Json;
import java.util.Date;


public class ItemListView {

    private final int itemId;
    private final String name;
    private final String description;
    private final String type;
    private final byte status;
    @Json.DateTimeFormat
    private final Date createDate;
    @Json.DateTimeFormat
    private final Date updateDate;

    public ItemListView(int itemId, String name, String description, String type, byte status, Date createDate, Date updateDate) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public byte getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }
    
}
