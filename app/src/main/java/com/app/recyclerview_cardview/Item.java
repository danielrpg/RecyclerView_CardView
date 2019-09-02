package com.app.recyclerview_cardview;

public class Item {
    private int imageResource;
    private String textView;
    private String textView2;

    public Item(int imageResource, String text, String text2) {
        this.imageResource = imageResource;
        this.textView = text;
        this.textView2 = text2;
    }

    public void changeText1(String text) {
        textView = text;
    }

    public int getImageResource() {
        return this.imageResource;
    }

    public String getTextView() {
        return this.textView;
    }

    public String getTextView2() {
        return this.textView2;
    }
}
