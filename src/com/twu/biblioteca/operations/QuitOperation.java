package com.twu.biblioteca.operations;


import com.twu.biblioteca.view.View;

public class QuitOperation implements Operation {

    @Override
    public void execute(View view) {
        System.exit(0);
    }

}
