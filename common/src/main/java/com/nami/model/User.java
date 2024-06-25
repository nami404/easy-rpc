package com.nami.model;

import java.io.Serializable;

/**
 * @author nami404
 * * @date 2024/6/25 16:19
 */
public class User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
