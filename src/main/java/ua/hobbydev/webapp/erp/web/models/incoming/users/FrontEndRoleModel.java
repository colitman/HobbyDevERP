/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web.models.incoming.users;

/**
 * Created by dmytro.romenskyi on 9/14/2016.
 */
public class FrontEndRoleModel {
    private String name;
    private String description;

    public FrontEndRoleModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
