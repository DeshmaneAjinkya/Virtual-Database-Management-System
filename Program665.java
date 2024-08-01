import java.util.*;

class Employee
{
    public int EID;
    public String Ename;
    public String EAddress;
    public int ESalary;

    private static int Counter;

    static
    {
        Counter = 0;
    }

    public Employee(String B, String C, int D)
    {
        this.EID = ++Counter;
        this.Ename = B;
        this.EAddress = C;
        this.ESalary = D;
    }

    void DisplayInfo()
    {
        System.out.println(EID+"\t"+Ename+"\t\t"+EAddress+"\t\t"+ESalary);
    }
}

class MarvellousDBMS
{
    public LinkedList <Employee> lobj;

    public MarvellousDBMS()
    {
        System.out.println("Maverick DBMS started succesfully...");
        lobj = new LinkedList<Employee>();
    }

    protected void finalize()
    {
        System.out.println("Deallocating All Resources Of DBMS");
        lobj = null;
    }

    //Insert into Employee values(1, "Sagar", "Pune", 11000);
    public void InsertIntoTable(String Name, String Address, int Salary)
    {
        Employee eobj = new Employee(Name, Address, Salary);
        lobj.add(eobj);
    }

    //Select * from employee;
    public void SelectStar()
    {
        System.out.println("Data From The Employee Database:");
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("EID\tEName\t\t\tEAddress\t\tESalary");
        System.out.println("------------------------------------------------------------------------");
        for(Employee eRef: lobj)
        {
            eRef.DisplayInfo();
        }
    }

    //Select * from Employee where EID = 3;
    public void SelectSpecific(int ID)
    {
        System.out.println("\nInformation Of Employe Whose EID Is: "+ID);

        for(Employee eRef: lobj)
        {
            if(eRef.EID == ID)
            {
                eRef.DisplayInfo();
                break;
            }
        }
    }

    //Select * from Employee where EName = "Sagar"
    public void SelectSpecific(String Name)
    {
        System.out.println("\nInformation Of Employe Whose Name Is: "+Name);

        for(Employee eRef: lobj)
        {
            if(Name.equals(eRef.Ename))
            {
                eRef.DisplayInfo();
                break;
            }
        }
    }

    //Delete from Employee where EID = 3;
    public void DeleteFrom(int ID)
    {
        int index = 0;
        boolean bFlag = false;

        for(Employee eRef: lobj)
        {
            if(eRef.EID == ID)
            {
                bFlag = true;
                break;
            }
            index++;
        }

        if(bFlag == false)
        {
            System.out.println("Unable To Delte The Element From Database As Given EID Is Not Present");
        }
        else
        {
            lobj.remove(index);
        }

    }

    //Delete from Employee where Ename = "Sagar";
    public void DeleteFrom(String Name)
    {
        int index = 0;
        boolean bFlag = false;

        for(Employee eRef: lobj)
        {
            if(Name.equals(eRef.Ename))
            {
                bFlag = true;
                break;
            }
            index++;
        }

        if(bFlag == false)
        {
            System.out.println("Unable To Delte The Element From Database As Given EID Is Not Present");
        }
        else
        {
            lobj.remove(index);
        }

    }

    //Select Sum(ESalary) from Employee
    public void AggregateSum()
    {
        int iSum = 0;

        for(Employee eRef: lobj)
        {
            iSum = iSum + eRef.ESalary;
        }

        System.out.println("Summation Of Salary: "+iSum);
    }

    //Select Max(ESalary) from Employee
    public void AggregateMax()
    {
        int iMax = 0;

        for(Employee eRef: lobj)
        {
            if(eRef.ESalary > iMax)
            {
                iMax = eRef.ESalary;
            }
        }

        System.out.println("Maximum Salary Is: "+iMax);
    }

    //Select Max(ESalary) from Employee
    public void AggregateMin()
    {
        Employee temp = lobj.get(0);

        int iMin = temp.ESalary;

        for(Employee eRef: lobj)
        {
            if(eRef.ESalary < iMin)
            {
                iMin = eRef.ESalary;
            }
        }

        System.out.println("Minimum Salary Is: "+iMin);
    }

    //Select Max(ESalary) from Employee
    public void AggregateAvg()
    {
        int iSum = 0;

        for(Employee eRef: lobj)
        {
            iSum = iSum + eRef.ESalary;
        }

        System.out.println("Average Salary Is: "+(iSum/lobj.size()));
    }

    //Select Max(ESalary) from Employee
    public void AggregateCount()
    {
        System.out.println("Number Of Employees: "+lobj.size());
    }
}

class Program665
{
    public static void main(String Arg[])
    {
        System.out.println("-------- Maverick Database Management System --------");

        Scanner sobj = new Scanner(System.in);
        MarvellousDBMS mobj = new MarvellousDBMS();

        int iOption = 0, Salary = 0, EID = 0;
        String Name, Address;

        Employee eobj = null;

        while(true)
        {
            System.out.println("--------------------------------------------------------");
            System.out.println("Please Select Your Choice Based On Your Requirement:");
            System.out.println("--------------------------------------------------------");

            System.out.println("1 : Insert New Record Into The Table");
            System.out.println("2 : Display All Records");
            System.out.println("3 : Display All Records Having Specific Employee ID(EID)");
            System.out.println("4 : Display All Records Having Specific Employee Name");
            System.out.println("5 : Delete The Records Based On Employee ID(EID)");
            System.out.println("6 : Delete The Records Based On Employee Name");
            System.out.println("7 : Display Sum Of All Salary");
            System.out.println("8 : Display Average Of All Salary");
            System.out.println("9 : Display Minimum Of All Salary");
            System.out.println("10 : Display Maximum Of All Salary");
            System.out.println("11 :Display Count");
            System.out.println("12 :Display Help");
            System.out.println("13 :Display About");
            System.out.println("14 :Terminate DBMS");
            System.out.println("--------------------------------------------------------");

            iOption = sobj.nextInt();

            switch(iOption)
            {
                case 1:
                    //1 : Insert New Record Into The Table
                    System.out.println("Please Enter The Information Of Employee:");

                    System.out.println("Please Enter Employee Name:");
                    sobj.nextLine();
                    Name = sobj.nextLine();

                    System.out.println("Please Enter Employee Address:");
                    Address = sobj.nextLine();

                    System.out.println("Please Enter Employee Salary:");
                    Salary = sobj.nextInt();

                    mobj.InsertIntoTable(Name, Address, Salary);
                break;

                case 2:
                    //2 : Display All Records
                    mobj.SelectStar();
                break;

                case 3:
                    //3 : Display All Records Having Specific Employee ID(EID)
                    System.out.println("Please Enter The Employee ID (EID) Whose Information That You Want To Display:");
                    sobj.nextLine();
                    EID = sobj.nextInt();

                    mobj.SelectSpecific(EID);
                break;

                case 4:
                    //4 : Display All Records Having Specific Employee Name
                    System.out.println("Please Enter The Employee Name Whose Information That You Want To Display:");
                    sobj.nextLine();
                    Name = sobj.nextLine();

                    mobj.SelectSpecific(Name);
                break;

                case 5:
                    //5 : Delete The Records Based On Employee ID(EID)hn76
                    System.out.println("Please Enter The Employee ID (EID) Whose Information That You Want To Delete:");
                    sobj.nextLine();
                    EID = sobj.nextInt();

                    mobj.DeleteFrom(EID);
                break;

                case 6:
                    //6 : Delete The Records Based On Employee Name
                    System.out.println("Please Enter The Employee Name Whose Information That You Want To Delete:");
                    sobj.nextLine();
                    Name = sobj.nextLine();

                    mobj.DeleteFrom(Name);
                break;

                case 7:
                    //7 : Display Sum Of All Salary
                    mobj.AggregateSum();
                break;

                case 8:
                    //8 : Display Average Of All Salary
                    mobj.AggregateAvg();
                break;

                case 9:
                    //9 : Display Minimum Of All Salary
                    mobj.AggregateMin();
                break;

                case 10:
                    //10 : Display Maximum Of All Salary
                    mobj.AggregateMax();
                break;

                case 11:
                    //11 :Display Count
                    mobj.AggregateCount();
                break;

                case 12:
                    //12 :Display Help
                    System.out.println("This project implements the DBMS for employee records");
                    System.out.println("We implement all SQL queries");
                    System.out.println("All data gets stored in Data Structures");
                    System.out.println("Complete implementation is on Primary Storage");
                break;

                case 13:
                    //13 :Display About
                    System.out.println("This project is developed by Ajinkya Deshmane");
                    System.out.println("All copyrights reserved.");
                break;

                case 14:
                    //14 :Terminate DBMS
                    System.out.println("Thankyou For Using Maverick DBMS");
                    mobj = null;

                    System.gc();
                    
                    System.exit(0);
            }
        }
    }
}