#include<iostream> 
#include<string> 
using namespace std; 

class Person {
    public:
        string *name;
        int age;

    Person(string name, int age) {
        this->name = new string(name);
        this->age = age;
    }

    ~Person() {
        cout << "Destructor!\n";
        delete name;
    }

    Person(const Person &p) {
        cout << "Copy constructor.\n";
        name = new string(*p.name);
        age = p.age;
    }

    void changeNameAndAge(string name, int age) {
        *(this->name) = name;
        this->age = age;
    }

    void introduce() {
        cout <<"Hey I am "<< *name <<" and I am "<<age<< " years old."<<endl;
    }

    Person& operator = (Person && p) {
        cout << "Move constructor.\n";
        swap(name, p.name);
        return *this;
    }

    Person dark (Person && p) {
        name = nullptr;
        *this = move(p);
        cout << "Move assignment\n";
    }
};

int main() {
    Person anakin("Anakin", 8);
    anakin.introduce();

    Person duplicateAnakin = anakin;
    duplicateAnakin.introduce();

    anakin.changeNameAndAge("Darth Vader", 24);
    anakin.introduce();
    duplicateAnakin.introduce(); 

    return 0;
}