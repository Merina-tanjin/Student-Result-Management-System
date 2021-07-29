3
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Formatter;

class Main {
  public static void main(String[] args) throws IOException {

   
    System.out.println("              Student Result Information");

    Scanner input = new Scanner(System.in);
    String id, pass;
    System.out.print("Enter your user id: ");
    id = input.nextLine();
    System.out.println("Your user id is: " + id);
    System.out.print("Enter your user Passward:");
    pass = input.nextLine();

    if (pass.equals("123")) {
      System.out.println("   ");
      System.out.println("                 WELCOME       ");

      System.out.print("How much time u want to go inside Base System :");
      int nm = input.nextInt();

      for (int j = 0; j < nm; j++) {
        System.out.println("   ");
        System.out.println("1.Add Student");
        System.out.println("2.View Student List");
        System.out.println("3.End ");

        Scanner value = new Scanner(System.in);
        int num;
        System.out.println("Enter your Choice: ");
        num = value.nextInt();
        switch (num) {
        case 1:
          System.out.println("\n::::ADD Student:::\n");
          Scanner digit = new Scanner(System.in);
          int number;
          System.out.print("How many Students info you want to add:");
          number = digit.nextInt();

          String Name;
          String ID;
          String Course;
          Double MidMarks;
          Double FinalMarks;
          Double TotalMarks;

          try {

            
            FileOutputStream fout = new FileOutputStream("Student.txt", true);
            Scanner sc = new Scanner(System.in);
            for (int i = 1; i <= number; i++) {
              System.out.println("Enter name : ");
              Name = sc.next() + " ";
              System.out.println("Enter ID : ");
              ID = sc.next() + " ";
              System.out.println("Enter Course name : ");
              sc.nextLine();
              Course = sc.next() + " ";
              System.out.println("Enter MidMarks : ");
              sc.nextLine();
              MidMarks = sc.nextDouble();
              String md = Double.toString(MidMarks) + " ";
              System.out.println("Enter FinalMarks : ");
              FinalMarks = sc.nextDouble();
              String fm = Double.toString(FinalMarks) + " ";
              System.out.println("Enter TotalMarks : ");
              TotalMarks = sc.nextDouble();
              String tm = Double.toString(TotalMarks) + " " + "\n";
              System.out.print("\n");
              byte b[] = Name.getBytes();
              fout.write(b);
              byte c[] = ID.getBytes();
              fout.write(c);
              byte d[] = Course.getBytes();
              fout.write(d);
              byte e[] = md.getBytes();
              fout.write(e);
              byte f[] = fm.getBytes();
              fout.write(f);
              byte g[] = tm.getBytes();
              fout.write(g);

            }
            fout.close();
            System.out.println("Done!!");
          } catch (FileNotFoundException e) {
            System.out.println(e);
          }

          break;
        case 2:
          System.out.println("\n::::Showing Student List::::\n");
          try {
            File Fi = new File("Student.txt");
            Scanner s = new Scanner(Fi);
            while (s.hasNext()) {
              String name = s.next();
              String idd = s.next();
              String Cos = s.next();
              String MM = s.next();
              String FM = s.next();
              String TM = s.next();
              System.out.print("Name :" + name + " ID :" + idd + " Course :" + Cos + " MidMarks :" + MM
                  + " FinalMarks :" + FM + " TotalMarks :" + TM + "\n");

            }
          } catch (FileNotFoundException e) {
            System.out.println(e);

          }

          break;
        case 3:

          System.out.println("BYE BYE");

          break;

        }

      }
    }

    else {
      System.out.println("Ops Sorry:Wrong info");
    }
  }
}

class Student extends Person {
  protected String Name;
  protected String ID;
  protected String Course;
  private double MidMarks;
  private double FinalMarks;
  private double TotalMarks;

  @Override
  public void setName(String Name) {
    this.Name = Name;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public void setCourse(String Course) {
    this.Course = Course;
  }

  @Override
  public String getName() {
    return Name;
  }

  public String getID() {
    return ID;
  }

  public String getCourse() {
    return Course;
  }

  public void setMidMarks(double MidMarks) {
    this.MidMarks = MidMarks ;
  }

  public void setFinalMarks(double FinalMarks) {
    this.FinalMarks = FinalMarks ;
  }

  public void setTotalMarks(double TotalMarks) {
    this.TotalMarks = MidMarks + FinalMarks;
  }

  public double getMidMarks() {
    return MidMarks;
  }

  public double getFinalMarks() {
    return FinalMarks;
  }

  public double getTotalMarks() {
    return TotalMarks;
  }
}

class Person extends User{ 
  
  private String name;
 

  Person() {
  }

  public Person(String name) {
    super();
    this.name = name;
    
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
  
  abstract  class User{
   
   abstract void setName(String name);
  abstract String getName();
  }

  
