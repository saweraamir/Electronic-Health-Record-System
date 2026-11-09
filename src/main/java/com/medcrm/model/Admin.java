package com.medcrm.model;
import com.medcrm.repository.UserRepository;
import java.util.Scanner;

public class Admin extends User {
    private static int counter = 123;

    public Admin(String id, String name, String email, String plainPassword, String role) {
        super(id, name, email, plainPassword, role);
    }

    public User createUser(String name, String email, String role, String plainPassword) {
        if (role.equalsIgnoreCase("doctor")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your specialization: ");
            String specialization = sc.next();
            return new Doctor("Doc" + counter++, name, email, role, plainPassword, specialization);
        } else if (role.equalsIgnoreCase("patient")) {
            return new Patient("Pat" + counter++, name, email, role, plainPassword);
        } else if (role.equalsIgnoreCase("admin")) {
            return new Admin("Ad" + counter++, name, email, role, plainPassword);
        } else {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    public void assignRoles(User user, String newRole){
        user.setRole(newRole);
        System.out.println("Role updated to: " + newRole + " for user: " + user.getName());

    }
    public void deleteUser(String userId, UserRepository repository) {
        boolean deleted = repository.deleteUserById(userId);
        if (deleted) {
            System.out.println("User with ID " + userId + " deleted successfully.");
        } else {
            System.out.println("User not found or could not be deleted.");
        }
    }
}
