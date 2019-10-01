#include<iostream>
#include <string>

class Teacher {
    
    public:
        
        std::string t_name;

        Teacher(std::string name) {
            t_name = name;
        }

        std::string teachName(){
            return t_name;
        }
};
    
class Student : public Teacher {
    public:
        Student(std::string s_name): Teacher(s_name) {
            t_name = s_name;
        }

        std::string getName(){
            return t_name;
        }
};

int main (int argc, char **argv) {
    std::string stName = "Thomas";

    Teacher* t = new student(stName);
    Student* s = new Student(stName);
    
    std::cout << s->getName() << t->getName() << std::endl;
}