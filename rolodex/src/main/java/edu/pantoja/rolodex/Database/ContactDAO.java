/**********
 * Name: Geovanny Pantoja
 * Date: 31 March 2026
 * Description: DAO interface to ensure proper methods are called 
 */
package edu.pantoja.rolodex.Database;

import java.util.List;

import edu.pantoja.rolodex.model.Contact;

public interface ContactDAO {

    void insert(Contact contact);
    void update(Contact contact);
    void delete(int id);
    Contact findById(int id);
    List<Contact> findAll();
    List<Contact> findByType(String type);

}
