/*******
* Name: Geovanny Pantoja
* date: 26 March 2026
* purpose of the class: Generic interface for entity serialization/deserialization, used by ContactSerializer.
* demonstrates polymorphism and inversion of control with generic types.
*/
package edu.pantoja.rolodex.storage;

public interface EntitySerializer<T> {
    String serialize(T entity);
    T deserialize(String data);

}
