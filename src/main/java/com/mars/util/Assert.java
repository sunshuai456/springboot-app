package com.mars.util;

import com.mars.entity.Base;
import org.springframework.lang.Nullable;

public class Assert extends org.springframework.util.Assert {

    public static void notNull(@Nullable Base entity, String message) {
        if (entity == null || entity.getDeleteTime() != null) {
            throw new IllegalArgumentException(message);
        }
    }

}
