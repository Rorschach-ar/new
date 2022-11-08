package com.innovaturelabs.training.contacts.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ItemForm {

    @Size(max = 30)
    @NotBlank
    private String name;
    @Size(max = 30)
    private String description;
    @Size(max = 30)
    private String type;
   

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
