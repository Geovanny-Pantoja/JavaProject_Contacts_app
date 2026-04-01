/*******************
 * Name: Geovanny Pantoja 
 * Date: 31 March 2026  
 * Description: DAO making connection to data base to execute CRUD against datbase
 */
package edu.pantoja.rolodex.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;

import edu.pantoja.rolodex.model.Address;
import edu.pantoja.rolodex.model.BusinessContact;
import edu.pantoja.rolodex.model.Contact;
import edu.pantoja.rolodex.model.FamilyContact;
import edu.pantoja.rolodex.model.FriendContact;

public class SQLiteContactDAO implements ContactDAO {

    private static final String DB_NAME = "rolodex.db";

    public SQLiteContactDAO() {
        createTable();
    }

    private Connection getConnection() {
        return SQLiteDataBase.connect(DB_NAME);
    }

    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS contacts (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " fName VARCHAR(40) NOT NULL,\n"
                + " lName VARCHAR(40) NOT NULL,\n"
                + " email VARCHAR(50),\n"
                + " cellNumber VARCHAR(20),\n"
                + " street VARCHAR(100),\n"
                + " city VARCHAR(50),\n"
                + " state VARCHAR(20),\n"
                + " zipCode VARCHAR(10),\n"
                + " companyName VARCHAR(100),\n"
                + " jobTitle VARCHAR(50),\n"
                + " workPhone VARCHAR(10),\n"
                + " birthday VARCHAR(20),\n"
                + " relationship VARCHAR(20),\n"
                + " howWeMet VARCHAR(100),\n"
                + " type VARCHAR(20) NOT NULL\n"
                + ");";
        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(Contact contact) {
        String sql = "INSERT INTO contacts(fName, lName, email, cellNumber, street, city, state, "
                + " zipCode, companyName, jobTitle, workPhone, birthday, relationship,  howWeMet, type) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contact.getfName());
            pstmt.setString(2, contact.getlName());
            pstmt.setString(3, contact.getEmail());
            pstmt.setString(4, contact.getCellNumber());
            pstmt.setString(5, contact.getAddress().getStreet());
            pstmt.setString(6, contact.getAddress().getCity());
            pstmt.setString(7, contact.getAddress().getState());
            pstmt.setString(8, contact.getAddress().getZipCode());
            String companyName = null;
            String jobTitle = null;
            String workPhone = null;
            String relationship = null;
            String birthday = null;
            String howWeMet = null;

            switch (contact.getType()) {
                case "BUSINESS":
                    BusinessContact bc = (BusinessContact) contact;
                    companyName = bc.getCompanyName();
                    jobTitle = bc.getJobTitle();
                    workPhone = bc.getWorkPhone();
                    break;
                case "FAMILY":
                    FamilyContact fc = (FamilyContact) contact;
                    birthday = fc.getBirthday();
                    relationship = fc.getRelationship();
                    break;
                case "FRIEND":
                    FriendContact frc = (FriendContact) contact;
                    howWeMet = frc.getHowWeMet();
                    break;
                default:
                    break;
            }
            pstmt.setString(9, companyName);
            pstmt.setString(10, jobTitle);
            pstmt.setString(11, workPhone);
            pstmt.setString(12, birthday);
            pstmt.setString(13, relationship);
            pstmt.setString(14, howWeMet);
            pstmt.setString(15, contact.getType());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Contact contact) {
        String sql = "UPDATE contacts SET fName = ?, lName = ?, email = ?, cellNumber = ?, street = ?, city = ?, state = ?, "
                + " zipCode = ?, companyName = ?, jobTitle = ?, workPhone = ?, birthday = ?, relationship = ?,  howWeMet = ? "
                + "WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contact.getfName());
            pstmt.setString(2, contact.getlName());
            pstmt.setString(3, contact.getEmail());
            pstmt.setString(4, contact.getCellNumber());
            pstmt.setString(5, contact.getAddress().getStreet());
            pstmt.setString(6, contact.getAddress().getCity());
            pstmt.setString(7, contact.getAddress().getState());
            pstmt.setString(8, contact.getAddress().getZipCode());
            String companyName = null;
            String jobTitle = null;
            String workPhone = null;
            String relationship = null;
            String birthday = null;
            String howWeMet = null;

            switch (contact.getType()) {
                case "BUSINESS":
                    BusinessContact bc = (BusinessContact) contact;
                    companyName = bc.getCompanyName();
                    jobTitle = bc.getJobTitle();
                    workPhone = bc.getWorkPhone();
                    break;
                case "FAMILY":
                    FamilyContact fc = (FamilyContact) contact;
                    birthday = fc.getBirthday();
                    relationship = fc.getRelationship();

                    break;
                case "FRIEND":
                    FriendContact frc = (FriendContact) contact;
                    howWeMet = frc.getHowWeMet();
                    break;
                default:
                    break;
            }
            pstmt.setString(9, companyName);
            pstmt.setString(10, jobTitle);
            pstmt.setString(11, workPhone);
            pstmt.setString(12, birthday);
            pstmt.setString(13, relationship);
            pstmt.setString(14, howWeMet);
            pstmt.setInt(15, contact.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Contact findById(int id) {
        String sql = "SELECT * FROM contacts WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                // shared field
                int contactId = rs.getInt("id");
                String fName = rs.getString("fName");
                String lName = rs.getString("lName");
                String email = rs.getString("email");
                String cellNumber = rs.getString("cellNumber");

                Address address = new Address(
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zipCode"));

                String type = rs.getString("type");

                switch (type) {
                    case "BUSINESS":
                        return new BusinessContact(
                                contactId, fName, lName, email, cellNumber, address,
                                rs.getString("companyName"),
                                rs.getString("jobTitle"),
                                rs.getString("workPhone"));
                    case "FAMILY":
                        return new FamilyContact(
                                contactId, fName, lName, email, cellNumber, address,
                                rs.getString("birthday"),
                                rs.getString("relationship")

                        );
                    case "FRIEND":
                        return new FriendContact(
                                contactId, fName, lName, email, cellNumber, address,
                                rs.getString("howWeMet"));
                    default:
                        return null;
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> contacts = new java.util.ArrayList<>();
        String sql = "SELECT * FROM contacts";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                var rs = pstmt.executeQuery()) {
            while (rs.next()) {
                // shared field
                int contactId = rs.getInt("id");
                String fName = rs.getString("fName");
                String lName = rs.getString("lName");
                String email = rs.getString("email");
                String cellNumber = rs.getString("cellNumber");

                Address address = new Address(
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zipCode"));

                String type = rs.getString("type");

                switch (type) {
                    case "BUSINESS":
                        contacts.add(new BusinessContact(
                                contactId, fName, lName, email, cellNumber, address,
                                rs.getString("companyName"),
                                rs.getString("jobTitle"),
                                rs.getString("workPhone")));
                        break;
                    case "FAMILY":
                        contacts.add(new FamilyContact(
                                contactId, fName, lName, email, cellNumber, address,
                                rs.getString("birthday"),
                                rs.getString("relationship")

                        ));
                        break;
                    case "FRIEND":
                        contacts.add(new FriendContact(
                                contactId, fName, lName, email, cellNumber, address,
                                rs.getString("howWeMet")));
                        break;
                    default:
                        break;
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contacts;
    }

    @Override
    public List<Contact> findByType(String type) {
        List<Contact> contacts = new java.util.ArrayList<>();
        String sql = "SELECT * FROM contacts WHERE type = ? collate nocase";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // shared field
                int contactId = rs.getInt("id");
                String fName = rs.getString("fName");
                String lName = rs.getString("lName");
                String email = rs.getString("email");
                String cellNumber = rs.getString("cellNumber");

                Address address = new Address(
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zipCode"));

                switch (type) {
                    case "BUSINESS":
                        contacts.add(new BusinessContact(
                                contactId, fName, lName, email, cellNumber, address,
                                rs.getString("companyName"),
                                rs.getString("jobTitle"),
                                rs.getString("workPhone")));
                        break;
                    case "FAMILY":
                        contacts.add(new FamilyContact(
                                contactId, fName, lName, email, cellNumber, address,
                                rs.getString("birthday"),
                                rs.getString("relationship")

                        ));
                        break;
                    case "FRIEND":
                        contacts.add(new FriendContact(
                                contactId, fName, lName, email, cellNumber, address,
                                rs.getString("howWeMet")));
                        break;
                    default:
                        break;
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contacts;
    }
}
