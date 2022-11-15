package dev.patricksilva.animalcontroller.view.model;

public class AnimalModelResponse {
    private Integer id;
    private Integer own;
    private String name;
    private Integer age;
    private String breed;
    private Boolean alive;

    // #region
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwn() {
        return own;
    }

    public void setOwn(Integer own) {
        this.own = own;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    // #endregion

}
