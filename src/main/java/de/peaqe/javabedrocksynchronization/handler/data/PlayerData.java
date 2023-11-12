package de.peaqe.javabedrocksynchronization.handler.data;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bukkit.Location;

/**
 * *
 * {@code @author:} peaqe
 * {@code @class:} PlayerData
 * *
 * Information's:
 * {@code @type:} Java-Class
 * {@code @date:} 12.11.2023 | 20:33 Uhr
 * *
 */

@SuppressWarnings(value = {"unused", "LombokGetterMayBeUsed"})
public class PlayerData {

    @BsonProperty("javaName")
    private String javaName;

    @BsonProperty("javaUniqueID")
    private String javaUniqueID;

    @BsonProperty("bedrockName")
    private String bedrockName;

    @BsonProperty("bedrockUniqueID")
    private String bedrockUniqueID;

    @BsonProperty("inventory")
    private String inventory;

    @BsonProperty("xp")
    private int xp;

    @BsonProperty("location")
    private Location location;

    @BsonProperty("health")
    private double health;

    @BsonProperty("food")
    private int food;

    public PlayerData(String javaName, String javaUniqueID, String bedrockName, String bedrockUniqueID, String inventory, int xp, Location location, double health, int food) {
        this.javaName = javaName;
        this.javaUniqueID = javaUniqueID;
        this.bedrockName = bedrockName;
        this.bedrockUniqueID = bedrockUniqueID;
        this.inventory = inventory;
        this.xp = xp;
        this.location = location;
        this.health = health;
        this.food = food;
    }

    public PlayerData() {}

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public String getJavaUniqueID() {
        return javaUniqueID;
    }

    public void setJavaUniqueID(String javaUniqueID) {
        this.javaUniqueID = javaUniqueID;
    }

    public String getBedrockName() {
        return bedrockName;
    }

    public void setBedrockName(String bedrockName) {
        this.bedrockName = bedrockName;
    }

    public String getBedrockUniqueID() {
        return bedrockUniqueID;
    }

    public void setBedrockUniqueID(String bedrockUniqueID) {
        this.bedrockUniqueID = bedrockUniqueID;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
