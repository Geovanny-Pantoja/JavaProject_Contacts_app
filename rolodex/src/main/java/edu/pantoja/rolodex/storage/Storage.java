/*******
* Name: Geovanny Pantoja
* date: 26 March 2026
* purpose of the class: Generic persistence interface for saving and loading entities.
*/
package edu.pantoja.rolodex.storage;

import java.util.List;

public interface Storage<T> {
    
    void saveData(List<T> entities);    
    List<T> loadData();

}
