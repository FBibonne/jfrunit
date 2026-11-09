package org.moditect.jfrunit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface EventSetting {
    String key();

    String value();

}
