package com.java.language.annotation;

import java.lang.annotation.Documented;

/**
 * Created by titan-developer on 2/21/15.
 */

@Documented
@interface ClassPreamble {

    String author();

    String date();

    int currentRevision() default 1;

    String lastModified() default "N/A";

    String lastModifiedBy() default "N/A";

    // Note use of array
    String[] reviewers();
}
