package com.example.di.fouliex.workingwithdagger;

/**
 * Created by 212361198 on 2/10/17.
 */
class StarbuckTeaDrink implements Drink {
    Teabag teabag;

    public StarbuckTeaDrink(Teabag teabag) {
        this.teabag = teabag;
    }

    @Override
    public String getFlavor() {
        return teabag.getFlavor();
    }
}
