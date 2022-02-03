package com.example.audiopodcast;

import java.util.List;

public class ParentModelClass {
    String title;
    List<ChildModelClass> childModelClassList;

    public ParentModelClass(String title) {
        this.title = title;
    }

    public ParentModelClass(String title, List<ChildModelClass> childModelClassList) {
        this.title = title;
        this.childModelClassList = childModelClassList;
    }
}
