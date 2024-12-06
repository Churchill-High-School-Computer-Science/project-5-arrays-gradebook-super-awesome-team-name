

public class Gradebook {

    String[] labels = { "First", "Last", "Test1", "Test2", "Quiz1", "Quiz2", "Homework1", "Homework2", "Homework3",
            "Homework4", "Homework5", "Homework6", "Homework7", "Homework8", "Homework9", "Homework10" };

    String[][] book;

    public Gradebook(String[][] b) {
        if (b.length > 0 && b[0].length == 16) {
            book = b;
        }

        else {
            System.out.println("Gradebook is not the right size. Ensure that formatting is correct.");
            book = new String[1][16];
        }
    }

    public boolean changeGrade(String lastName, String assnName, String newGrade) {
        int assnIndex = 0;
        for(int x = 0; x < labels.length; x++)
        {
            if(assnName.equals(labels[x]))
            {
                assnIndex = x;
            }
        }
        for(int x = 0; x < book.length; x++)
        {
            if(book[x][1].equals(lastName))
            {
                book[x][assnIndex] = newGrade;
                return true;
            }
        }
        return false;
    }

    public double findAssignmentAverage(String assnName) {
        double average = 0;
        int assnIndex = 0;
        
        for(int x = 0; x < labels.length; x++)
        {
            if(labels[x].equals(assnName))
            {
                assnIndex = x;
            }
        }
        for(int z = 0; z < book.length; z++)
        {
            assnIndex++;
            average += Double.valueOf(book[z][assnIndex]);
        }
        average /= assnIndex;
        return average;
    }

    public double findStudentAverage(String lastName) {
        double average = 0;
        int personIndex = 0;
        for(int x = 0; x < book.length; x++)
        {
            if(book[x][1].equals(lastName))
            {
                for(int y = 2; y < book[x].length; y++)
                {   
                    personIndex = book[x].length-2;
                    average += Double.valueOf(book[x][y]);
                }
            }
        }
        average /= personIndex;
        return average;
    }

    public void printStudentInfo(String lastName) {
        for(int x = 0; x < book.length; x++){
            if(book[x][1].equals(lastName))
            {
                for(int y = 2; y < book[x].length; y++)
                {   
                    System.out.println(book[x][y]);

                }
            }
        }
    }

}
