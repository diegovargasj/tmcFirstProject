package sec.project.domain;

public class Admin extends User {
    
    public Admin() {
        super("admin", "admin@admin.com", "adminPassword");
        this.privilege = 1;
    }
}
