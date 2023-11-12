package de.peaqe.javabedrocksynchronization.handler;

import de.peaqe.MongoAPI;
import de.peaqe.javabedrocksynchronization.handler.data.PlayerData;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * *
 * {@code @author:} peaqe
 * {@code @class:} DataHandler
 * *
 * Information's:
 * {@code @type:} Java-Class
 * {@code @date:} 12.11.2023 | 20:30 Uhr
 * *
 */

public class DataHandler {

    private final MongoAPI mongoAPI;
    private final String collectionName = "collection_jbs";

    public DataHandler() {
        this.mongoAPI = new MongoAPI(
                "username",
                "password",
                "database");
    }

    public void loadToDatabase(PlayerData playerData) {

        var search = this.mongoAPI.findDocument(
                this.collectionName,
                "javaUniqueID",
                playerData.getJavaUniqueID(),
                PlayerData.class
        );

        if (search == null) {
            this.mongoAPI.insertDocument(
                    this.collectionName,
                    playerData,
                    PlayerData.class
            );
            System.out.println("Player: " + playerData.getJavaName() + " registered!");
            return;
        }

        this.mongoAPI.updateDocument(
                this.collectionName,
                "javaUniqueID",
                playerData.getJavaUniqueID(),
                playerData,
                PlayerData.class
        );
        System.out.println("Player: " + playerData.getJavaName() + " updated!");

    }

    @Nullable
    public PlayerData loadJavaFromDatabase(UUID javaUniqueID) {
        return this.mongoAPI.findDocument(
                this.collectionName,
                "javaUniqueID",
                javaUniqueID.toString(),
                PlayerData.class
        );
    }

    @Nullable
    public PlayerData loadBedrockFromDatabase(UUID bedrockUniqueID) {
        return this.mongoAPI.findDocument(
                this.collectionName,
                "bedrockUniqueID",
                bedrockUniqueID.toString(),
                PlayerData.class
        );
    }

}
