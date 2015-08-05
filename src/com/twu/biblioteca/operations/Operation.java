package com.twu.biblioteca.operations;


import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LibrarianMenuView;
import com.twu.biblioteca.view.View;

public interface Operation {
    void execute(View view);
    IView nextView(LibrarianMenuView librarianMenuView);
}
