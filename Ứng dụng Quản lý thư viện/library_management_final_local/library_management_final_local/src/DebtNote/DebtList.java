
package DebtNote;


public class DebtList {
    
    

    private int id,debt;
    private String name;

    public DebtList (int id, String name, int debt) {
        this.id = id;
        this.name = name;
        this.debt = debt;
    }
    
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    
    public int getDebt() {
        return debt;
    }
   
}
    
    

    

