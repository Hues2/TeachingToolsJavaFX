package com.example.teachingtoolsjavafx.controllers;

import com.example.teachingtoolsjavafx.bars.Bar;
import java.util.ArrayList;

// This class handles the logic for the 2nd tab
public class SecondTabController {

    private final ArrayList<Bar[]> listOfLists;

    SecondTabController(ArrayList<Bar[]> listOfLists){
        this.listOfLists = listOfLists;
    }

    // This method gets the list to be printed out on the second tab
    public String getList(int counter){
        StringBuilder list = new StringBuilder("\nStep " + counter + ":");
        list.append("\n[");
        for (Bar bar : listOfLists.get(counter)) {
            list.append(" ").append(bar.getSize()).append(",");
        }
        list.append("]\n");
        return list.toString();
    }
}
