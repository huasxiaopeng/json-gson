package com.example.springboot.doamin;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
public class Item {
    @JsonView(Views.Public.class)
    public int id;

    @JsonView(Views.Public.class)
    public String itemName;

    @JsonView(Views.Internal.class)
    public String ownerName;

    public Item(int id, String itemName, String ownerName) {
        this.id = id;
        this.itemName = itemName;
        this.ownerName = ownerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
