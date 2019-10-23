#include <iostream>
#include <vector>
#include <algorithm>
#include <boost/filesystem.hpp>
#include <boost/regex.hpp>
#include "string"

using std::cout;
using std::endl;
namespace fs = boost::filesystem;

int it(fs::path p){
    int classCounter = 0;  

    for (const fs::directory_entry& x : fs::recursive_directory_iterator(p)){
        if(fs::extension(x.path().string()) == ".java"  && fs::is_regular_file(x.path())){
            ++classCounter;
            std::cout << "    " << x.path() << '\n';
        }
        
    }
    return classCounter;
}

int main(int argc, char* argv[])
{

  if (argc < 2)
  {
    cout << "Usage: ./javaList path\n";
    return 1;
  }

  fs::path p (argv[1]);

  try
  {
    int classCounter = it(p);
    cout << "Java fájlok száma: " << classCounter << std::endl;
      
  }

  catch (const fs::filesystem_error& ex)
  {
    cout << ex.what() << '\n';
  }

  return 0;
}