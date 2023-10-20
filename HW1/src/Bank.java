import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bank {

    private Loan[] loans = new Loan[8];
    private int size;


    /**
     * addLoan - adds a new Loan to the array
     */
    public void addLoan(Loan singleLoan){
        if( singleLoan == null ){
            throw new IllegalArgumentException("Can't add null 'singleLoan'");
        }

        if( size >= loans.length ){
            loans = Arrays.copyOf(loans, loans.length*2);
        }

        loans[size] = singleLoan;
        ++size;
    }

    /**
     * remove - removes the Loan from the array and returns true if it exists, or false if it does not exist
     */
    public boolean remove(Loan singleLoan){
        if( singleLoan == null ){
            throw new IllegalArgumentException("Can't remove null 'singleLoan'");
        }

        for(int i = 0; i < size; ++i){
            if( loans[i].equals(singleLoan) ){
                // found

                --size;
                loans[i] = loans[size];
                loans[size] = null;

                return true;
            }
        }

        return false;
    }

    /**
     * find - returns all the Loans associated with a Person with the given name
     */
    public Loan[] find(String givenNameToSearch){
        if( givenNameToSearch == null ){
            throw new IllegalArgumentException("Can't search by null 'givenNameToSearch'");
        }

        List<Loan> res = new ArrayList<>();
        for(int i =0; i < size; ++i){
            if( loans[i].getPerson().getName().equals(givenNameToSearch) ){
                res.add(loans[i]);
            }
        }

        return res.toArray(new Loan[0]);
    }

    /**
     * find - same as above, with the added condition that the Loan must have a minimal amount
     */
    public Loan[] findWithMin(String name, double minAmount){
        if( name == null ){
            throw new IllegalArgumentException("Can't search by null 'name'");
        }

        List<Loan> res = new ArrayList<>();
        for(int i =0; i < size; ++i){
            if( loans[i].getPerson().getName().equals(name) &&
                    Double.compare(loans[i].getAmount(), minAmount) >= 0 ){
                res.add(loans[i]);
            }
        }

        return res.toArray(new Loan[0]);
    }

    /**
     * printInFile - prints all the Loans in the given file
     */
    public void printInFile(String fileName){
        if(fileName == null || fileName.trim().equals("") ){
            throw new IllegalArgumentException("Can't save loans to null or empty file path");
        }
        Path filePath = Paths.get(fileName);

        try {
            Files.deleteIfExists(filePath);
            Files.createFile(filePath);

            try(BufferedWriter writer = Files.newBufferedWriter(filePath)){
                for(int i =0; i < size; ++i){
                    writer.write(loans[i].toString());
                    writer.newLine();
                }
            }
        }
        catch(IOException ioEx){
            throw new IllegalStateException(ioEx);
        }

    }
}
