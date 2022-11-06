package dev.patricksilva.peoplecontroller.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PeopleModelRequest {

    @NotBlank(message = "The name must contain non-blank characters")
    @NotEmpty(message = "The name must be filled")
    @Size(min = 2, message = "The name must be at least 2 characters")
    private String name;

    @NotBlank(message = "The name must contain non-blank characters")
    @NotEmpty(message = "The name must be filled")
    private String lastname;

    // #region Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    // #endregion
}
