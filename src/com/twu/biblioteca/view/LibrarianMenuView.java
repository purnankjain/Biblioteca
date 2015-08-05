package com.twu.biblioteca.view;

import com.twu.biblioteca.IUser;
import com.twu.biblioteca.operations.*;
import com.twu.biblioteca.parser.Parser;

public class LibrarianMenuView implements IView{

    InputView inputView;
    ListView listView;
    CheckOutView checkOutView;
    ReturnView returnView;
    InvalidOperationView invalidOperationView;
    Parser parser;

    public LibrarianMenuView(InputView inputView, ListView listView, CheckOutView checkOutView,
                             ReturnView returnView, InvalidOperationView invalidOperationView, Parser parser) {
        this.inputView = inputView;
        this.listView = listView;
        this.checkOutView = checkOutView;
        this.returnView = returnView;
        this.invalidOperationView = invalidOperationView;
        this.parser = parser;
    }

    @Override
    public IView renderView(IUser user) {
        printLibrarianMenu();
        String input = inputView.readInput();
        Operation operation = parser.selectOperation(input);
        return operation.nextView(this);
    }

    private void printLibrarianMenu() {
        System.out.println("=======================");
        System.out.println("List Books");
        System.out.println("List Movies");
        System.out.println("CheckOut Book");
        System.out.println("CheckOut Movie");
        System.out.println("Return Book");
        System.out.println("Return Movie");
        System.out.println("=======================");
        System.out.println("Enter Choice : ");

    }

    public IView nextView(ListOperation listOperation) {
        return listView;
    }

    public IView nextView(CheckOutOperation checkOutOperation) {
        return checkOutView;
    }

    public IView nextView(ReturnItemOperation returnItemOperation) {
        return returnView;
    }

    public IView nextView(InvalidOperation invalidOperation) {
        return invalidOperationView;
    }

}
