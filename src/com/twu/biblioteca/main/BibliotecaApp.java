package com.twu.biblioteca.main;

import com.twu.biblioteca.BibliotecaApplication;
import com.twu.biblioteca.ConfirmationHandler;
import com.twu.biblioteca.Controller;
import com.twu.biblioteca.LibrarySection;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserDatabase;
import com.twu.biblioteca.user.UserRoles;
import com.twu.biblioteca.view.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class BibliotecaApp {

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        View view = new View(bufferedReader);
        ArrayList<Item> bookList = new ArrayList<Item>();
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 1988);
        Book book2 = new Book("Harry Potter", "J.K Rowling", 2005);
        bookList.add(book1);
        bookList.add(book2);
        LibrarySection bookLibrarySection = new LibrarySection(bookList, new ArrayList<Item>());
        ArrayList<Item> movieList = new ArrayList<>();
        movieList.add(new Movie("Harry", 2001, "yap", "3"));
        movieList.add(new Movie("Dave", 2005, "blah", "unrated"));
        LibrarySection movieLibrarySection = new LibrarySection(movieList, new ArrayList<Item>());
        ConfirmationHandler confirmationHandler = new ConfirmationHandler(view);
        User loggedInUser = new User();

        ArrayList<User> registeredUser = new ArrayList<>();
        registeredUser.add(new User("111-1111", "asd", "Ram", "ram@mail.com", "9999", new ArrayList<Book>(), UserRoles.ADMIN_ROLE));
        registeredUser.add(new User("111-1112", "asd", "Sham", "Shyaam@mail.com", "9999", new ArrayList<Book>(), UserRoles.NORMAL_USER));
        registeredUser.add(new User("111-1113", "asd", "kaam", "kaam@mail.com", "9999", new ArrayList<Book>(), UserRoles.NORMAL_USER));
        InputView inputView = new InputView(bufferedReader);
        UserDatabase userDatabase = new UserDatabase(registeredUser);
        LibrarianMenuView librarianMenuView = new LibrarianMenuView(inputView);
        NullUserView nullUserView = new NullUserView("");
        LoginView loginView = new LoginView(inputView, userDatabase);
        UserMenuView userMenuView = new UserMenuView(inputView);
        WelcomeView welcomeView = new WelcomeView(loginView);
        HashMap<String, IView> operationHashMap = new HashMap<>();
        operationHashMap.put("List Books", new ListAvailableItemsView(bookLibrarySection));
        operationHashMap.put("List Movies", new ListAvailableItemsView(movieLibrarySection));
        operationHashMap.put("CheckOut Book", new CheckOutView(bookLibrarySection, inputView, "CheckOut Book Successful", "CheckOut Unsuccessful"));
        operationHashMap.put("CheckOut Movie", new CheckOutView(movieLibrarySection, inputView, "CheckOut Movie Successful", "CheckOut Unsuccessful"));
        operationHashMap.put("Return Book", new ReturnItemView(bookLibrarySection, inputView, "Return Book Successful", "CheckOut Unsuccessful"));
        operationHashMap.put("Return Movie", new ReturnItemView(movieLibrarySection, inputView, "Return Movie Successful", "CheckOut Unsuccessful"));
        operationHashMap.put("Quit", new QuitView());
        operationHashMap.put(" ", new InvalidOperationView());

        Controller controller = new Controller(librarianMenuView, loginView, nullUserView, userMenuView, welcomeView, operationHashMap, loggedInUser);

        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(view, loggedInUser, controller);
        bibliotecaApplication.start();
    }
}
