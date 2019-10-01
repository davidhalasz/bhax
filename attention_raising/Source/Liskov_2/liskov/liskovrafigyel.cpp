#include <iostream>

// ez a T az LSP-ben
class Madar {

};

// ez a két osztály alkotja a "P programot" az LPS-ben
class Program {
public:
     void fgv ( Madar &madar ) {
         
    }
};

// itt jönnek az LSP-s S osztályok
class RepuloMadar : public Madar {
public:
     virtual void repul() = 0;
};

class Sas : public RepuloMadar
{
    void repul() override {
        std::cout << "A sas repül.\n";
    }
};

class Pingvin : public Madar
{};

int main ( int argc, char **argv )
{
    Program program;

     Sas sas;
     program.fgv (sas);

     Pingvin pingvin;
     //program.fgv ( pingvin );

    return 0;
}
