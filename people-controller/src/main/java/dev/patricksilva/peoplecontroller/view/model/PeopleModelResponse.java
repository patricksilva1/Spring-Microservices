package dev.patricksilva.peoplecontroller.view.model;

public class PeopleModelResponse {
    private String id;
    private String name;
    private String lastname;

    // #region Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
