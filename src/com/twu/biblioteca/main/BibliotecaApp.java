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
        LibrarySection bookLibrarySection =
                new LibrarySection(bookList, new ArrayList<Item>(), new HashMap<String, String>());
        ArrayList<Item> movieList = new ArrayList<>();
        movieList.add(new Movie("Harry", 2001, "yap", "3"));
        movieList.add(new Movie("Dave", 2005, "blah", "unrated"));
        LibrarySection movieLibrarySection =
                new LibrarySection(movieList, new ArrayList<Item>(), new HashMap<String, String>());
        ConfirmationHandler confirmationHandler = new ConfirmationHandler(view);
        User loggedInUser = new User();

        ArrayList<User> registeredUser = new ArrayList<>();
        registeredUser.add(new User("111-1111", "asd", "Ram", "ram@mail.com", "9999",
                new ArrayList<Book>(), UserRoles.ADMIN_ROLE));
        registeredUser.add(new User("111-1112", "asd", "Sham", "Shyaam@mail.com", "9999",
                new ArrayList<Book>(), UserRoles.NORMAL_USER));
        registeredUser.add(new User("111-1113", "asd", "kaam", "kaam@mail.com", "9999",
                new ArrayList<Book>(), UserRoles.NORMAL_USER));
        InputView inputView = new InputView(bufferedReader);
        User nullUser = new User("", "", "", "", "", null, UserRoles.NULL_USER);
        UserDatabase userDatabase = new UserDatabase(registeredUser, nullUser);
        LibrarianMenuView librarianMenuView = new LibrarianMenuView(inputView);
        NullUserView nullUserView = new NullUserView("");
        LoginView loginView = new LoginView(inputView, userDatabase);
        UserMenuView userMenuView = new UserMenuView(inputView);
        WelcomeView welcomeView = new WelcomeView(loginView);
        LogOutView logOutView = new LogOutView(userDatabase);
        HashMap<String, IView> operationHashMap = new HashMap<>();
        operationHashMap.put("list books", new ListAvailableItemsView(bookLibrarySection));
        operationHashMap.put("list movies", new ListAvailableItemsView(movieLibrarySection));
        operationHashMap.put("checkout book",
                new CheckOutView(bookLibrarySection, inputView, "CheckOut Book Successful", "CheckOut Unsuccessful"));
        operationHashMap.put("checkout movie",
                new CheckOutView(movieLibrarySection, inputView, "CheckOut Movie Successful", "CheckOut Unsuccessful"));
        operationHashMap.put("return book",
                new ReturnItemView(bookLibrarySection, inputView, "Return Book Successful", "CheckOut Unsuccessful"));
        operationHashMap.put("return movie",
                new ReturnItemView(movieLibrarySection, inputView, "Return Movie Successful", "CheckOut Unsuccessful"));
        operationHashMap.put("my profile", new ListUserDetails("User Details : "));
        operationHashMap.put("logout", logOutView);
        operationHashMap.put("quit", new QuitView());
        operationHashMap.put(" ", new InvalidOperationView());

        HashMap<String, IView> adminOperationMap = new HashMap<>();
        adminOperationMap.put("list checkedout books", new ListUnavailableItemsView(bookLibrarySection, "CheckedOut Books"));
        adminOperationMap.put("list checkedout movies", new ListUnavailableItemsView(movieLibrarySection, "CheckedOut Movies"));

        Controller controller = new Controller(librarianMenuView, loginView, nullUserView, userMenuView,
                welcomeView, operationHashMap, adminOperationMap, loggedInUser);

        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(view, loggedInUser, controller);
        bibliotecaApplication.start();
    }
}
