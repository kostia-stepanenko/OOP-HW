public  class Loan {

    private final int id;
    private double amount;

    private final Person person;

    public Loan(int id, double amount, Person person) {
        if( id <= 0 ){
            throw new IllegalArgumentException("Negative or Zero ID detected: " + id);
        }
        if (Double.compare(amount, 0.0) < 0 ){
            throw new IllegalArgumentException("Negative amount: " + amount);
        }
        if ( person == null ){
            throw new IllegalArgumentException("Can't create Loan with null Person");
        }
        this.id = id;
        this.amount = amount;
        this.person = person;
    }

    public void increaseAmount(double valueToAdd){
        if( Double.compare(valueToAdd, 0.0) <= 0  ){
            throw new IllegalArgumentException("Can't add negative or ZERO value: " + valueToAdd);
        }

        amount += valueToAdd;
    }

    public double getAmount() {
        return amount;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "id: " + id + ", amount: " + amount + ", person: " + person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        return id == loan.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}


