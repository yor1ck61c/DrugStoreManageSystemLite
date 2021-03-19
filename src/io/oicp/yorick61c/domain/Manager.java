package io.oicp.yorick61c.domain;

public class Manager {
    private String managerName;
    private String password;

    public Manager() {
    }

    public Manager(String managerName, String password) {
        this.managerName = managerName;
        this.password = password;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (!managerName.equals(manager.managerName)) return false;
        return password.equals(manager.password);
    }

    @Override
    public int hashCode() {
        int result = managerName.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerName='" + managerName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
