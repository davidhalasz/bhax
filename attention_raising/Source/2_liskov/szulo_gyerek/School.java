class Teacher {

    protected String tName;
    
    public void setName(String name) {
        tName = name;
    }
}

class Student extends Teacher {

    public String getName() {
        return tName;
    }
}
    
class School {
    public static void main (String args[]) {

        Teacher t = new Student();
        t.setName("Tanár");
        
        Student s = new Student();
        s.setName("Diák");
        
        System.out.println(s.getName() + " " + t.getName());
    }
}