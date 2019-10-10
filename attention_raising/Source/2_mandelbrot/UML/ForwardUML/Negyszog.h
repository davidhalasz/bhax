
#ifndef NEGYSZOG_H
#define NEGYSZOG_H

#include string

/**
  * class Negyszog
  * 
  */

class Negyszog
{
public:

  // Constructors/Destructors
  //  


  /**
   * Empty Constructor
   */
  Negyszog ();

  /**
   * Empty Destructor
   */
  virtual ~Negyszog ();

  // Static Public attributes
  //  

  // Public attributes
  //  

  int a;
  int b;
  int c;
  int d;
  int kerulet;
  int terulet;

  // Public attribute accessor methods
  //  


  // Public attribute accessor methods
  //  


  /**
   * Set the value of a
   * @param new_var the new value of a
   */
  void setA (int new_var)   {
      a = new_var;
  }

  /**
   * Get the value of a
   * @return the value of a
   */
  int getA ()   {
    return a;
  }

  /**
   * Set the value of b
   * @param new_var the new value of b
   */
  void setB (int new_var)   {
      b = new_var;
  }

  /**
   * Get the value of b
   * @return the value of b
   */
  int getB ()   {
    return b;
  }

  /**
   * Set the value of c
   * @param new_var the new value of c
   */
  void setC (int new_var)   {
      c = new_var;
  }

  /**
   * Get the value of c
   * @return the value of c
   */
  int getC ()   {
    return c;
  }

  /**
   * Set the value of d
   * @param new_var the new value of d
   */
  void setD (int new_var)   {
      d = new_var;
  }

  /**
   * Get the value of d
   * @return the value of d
   */
  int getD ()   {
    return d;
  }

  /**
   * Set the value of kerulet
   * @param new_var the new value of kerulet
   */
  void setKerulet (int new_var)   {
      kerulet = new_var;
  }

  /**
   * Get the value of kerulet
   * @return the value of kerulet
   */
  int getKerulet ()   {
    return kerulet;
  }

  /**
   * Set the value of terulet
   * @param new_var the new value of terulet
   */
  void setTerulet (int new_var)   {
      terulet = new_var;
  }

  /**
   * Get the value of terulet
   * @return the value of terulet
   */
  int getTerulet ()   {
    return terulet;
  }


  /**
   * @param  a_oldal
   * @param  b_oldal
   * @param  c_oldal
   * @param  d_oldal
   */
   Negyszog (int a_oldal, int b_oldal, int c_oldal, int d_oldal)
  {
  }

protected:

  // Static Protected attributes
  //  

  // Protected attributes
  //  

public:


  // Protected attribute accessor methods
  //  

protected:

public:


  // Protected attribute accessor methods
  //  

protected:


private:

  // Static Private attributes
  //  

  // Private attributes
  //  

public:


  // Private attribute accessor methods
  //  

private:

public:


  // Private attribute accessor methods
  //  

private:


  void initAttributes () ;

};

#endif // NEGYSZOG_H
