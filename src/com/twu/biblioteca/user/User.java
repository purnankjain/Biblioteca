package com.twu.biblioteca.user;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.view.IView;

import java.util.ArrayList;

public class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private ArrayList<Book> checkedOutBooks;
    private ArrayList<Movie> checkedOutMovies;
    private UserRoles role;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber,
                ArrayList<Book> checkedOutBooks, ArrayList<Movie> checkedOutMovies, UserRoles role) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.checkedOutBooks = checkedOutBooks;
        this.checkedOutMovies = checkedOutMovies;
        this.role = role;
    }

    public User() {
        role = UserRoles.NULL_USER;
    }

    public boolean hasCredentials(String thatId, String thatPassword) {
        return (libraryNumber.equals(thatId) && password.equals(thatPassword));
    }

    public IView menuView(Controller controller) {
        return controller.menuView(this);
    }

    public IView nextViewOnInvalidSelection(Controller controller) {
        return controller.nextViewOnInvalidSelection();
    }

    public void addBookToUserBookList(Book book) {
        checkedOutBooks.add(book);
    }

    public void addMovieToMovieList(Movie movie) {
        checkedOutMovies.add(movie);
    }
    
    public ArrayList<Book> getAllBooks() {
        return checkedOutBooks;
    }

    public boolean hasBook(Book book) {
        for(Book thisBook : checkedOutBooks) {
            if(thisBook.equals(book)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMovie(Movie movie) {
        for(Movie thisMovie : checkedOutMovies) {
            if(thisMovie.equals(movie)) {
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
        return !(checkedOutBooks != null ? !checkedOutBooks.equals(user.checkedOutBooks) : user.checkedOutBooks != null);

    }

    @Override
    public int hashCode() {
        int result = libraryNumber != null ? libraryNumber.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (checkedOutBooks != null ? checkedOutBooks.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + " " + email + " " + phoneNumber;
    }

    public void removeFromUserBookList(Book book) {
        checkedOutBooks.remove(book);
    }

    public void removeMovieFromMovieList(Movie movie) {
        checkedOutMovies.remove(movie);
    }
}
