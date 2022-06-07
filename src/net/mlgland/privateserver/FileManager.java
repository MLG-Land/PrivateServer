package net.mlgland.privateserver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.bukkit.ChatColor;
import org.json.JSONObject;

public class FileManager {
    public static void createPermissionsDatabaseFile() {
        // basically we're going to create a json file that will store the
        // permissions for each player
        // this will be used to check if a player has permission to join the
        // server
        // if they don't have permission, they will be kicked
        // if they do have permission, they will be allowed to join
        // this will be used to check if a player has permission to join the
        // server

        // first we must check if the file exists
        File file = new File("plugins/PrivateServer/permissions.json");
        // save the file
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // now we will use filewriter to write to the file
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("{}");
            writer.close();
            System.out.println(ChatColor.GREEN + "[PrivateServer] [Log] Permissions database file has been created");
        } catch (IOException e) {
            // TODO: handle exception
            System.out
                    .println(ChatColor.RED + "[PrivateServer] [Error] Permissions database file has not been created");
            e.printStackTrace();
        }
    }

    public static void updateDatabase(String uuid, Boolean permission) {
        // first we will get the file contents and parse the json
        // we will add the player to the json file
        // we will then save the file

        // read the contents of the file
        String contents = "";
        try {
            File file = new File("plugins/PrivateServer/permissions.json");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                // separate each line with \n
                contents.concat(line + "\n");
            }
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println(ChatColor.RED + "[PrivateServer] [Error] Permissions database file could not be read");
            e.printStackTrace();
        }
        // parse the json
        JSONObject json = new JSONObject(contents);
        // add the player to the json
        json.put(uuid, permission);
        // convert the json to a string
        String jsonString = json.toString();
        // save the file
        try {
            File file = new File("plugins/PrivateServer/permissions.json");
            FileWriter writer = new FileWriter(file);
            writer.write(jsonString);
            writer.close();
            System.out.println(ChatColor.GREEN + "[PrivateServer] [Log] Permissions database file has been updated");
        } catch (IOException e) {
            System.out
                    .println(ChatColor.RED + "[PrivateServer] [Error] Permissions database file has not been updated");
            e.printStackTrace();
        }
    }
}
