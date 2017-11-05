final class Person {
    private String name;
    private String lastName;

    public Person(String name, String last) {
        this.name = name;
        this.lastName = last;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String toString() {
        return this.getName() + " " + this.getLastName();
    }
}