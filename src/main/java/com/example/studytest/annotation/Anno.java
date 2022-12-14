package com.example.studytest.annotation;


import lombok.NonNull;

import java.lang.annotation.Documented;


public class Anno {

    @CustomAnnotation
    public class AnnoParent {

    }

    public class AnnoChild extends AnnoParent {

    }
}

