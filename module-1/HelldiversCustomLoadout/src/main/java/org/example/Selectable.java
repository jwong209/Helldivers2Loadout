package org.example;

import java.util.List;
import java.util.Random;

public interface Selectable {

// load data
    <T> void loadItemsList(String filePath, List<T> itemList); // public and abstract are implied



// select item





// find random item from list
    default <T> T selectRandomItem(List<T> itemList) {

        Random randomGenerator = null;
        int itemIndex = randomGenerator.nextInt(itemList.size());
        return itemList.get(itemIndex);

    }


}
