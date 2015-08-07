package com.twu.biblioteca.user;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LoginView;

import java.util.ArrayList;

public class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private ArrayList<Book> books;
    private UserRoles role;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber,
                ArrayList<Book> books, UserRoles role) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.books = books;
        this.role = role;
    }

    public User() {
        role = UserRoles.NULL_USER;
    }

    public boolean hasCredentials(String thatId, String thatPassword) {
        return (libraryNumber.equals(thatId) && password.equals(thatPassword));
    }

    public IView nextViewAfterLogin(Controller controller) {
        return controller.nextViewAfterLogin(this);
    }

    public IView nextViewOnInvalidSelection(Controller controller) {
        return controller.nextViewOnInvalidSelection(this);
    }

    public IView nextViewAfterLogin(LoginView loginView) {
        return null;
    }

    public void addBookToUserBookList(Book book) {
        books.add(book);
    }
    
    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public boolean hasBook(Book book) {
        for(Book thisBook : books) {
            if(thisBook.equals(book)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasRole(UserRoles thatRole) {
        return role.equals(thatRole);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (libraryNumber != null ? !libraryNumber.equals(user.libraryNumber) : user.libraryNumber != null)
            return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        return !(books != null ? !books.equals(user.books) : user.books != null);

    }

    @Override
    public int hashCode() {
        int result = libraryNumber != null ? libraryNumber.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + email + " " + phoneNumber;
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}
