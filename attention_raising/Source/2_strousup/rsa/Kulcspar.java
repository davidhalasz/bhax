public class Kulcspar {

static class KulcsPar{

  java.math.BigInteger d, e, m;

  public KulcsPar(){
      
      int meretBitekben = 700 * (int) (java.lang.Math.log((double) 10) 
        / java.lang.Math.log((double) 2));

      java.math.BigInteger p = new java.math.BigInteger(meretBitekben, 100, new java.util.Random());

      java.math.BigInteger q = new java.math.BigInteger(meretBitekben, 100, new java.util.Random());

      m = p.multiply(q);

      java.math.BigInteger z = p.subtract(java.math.BigInteger.ONE).multiply(q.subtract(java.math.BigInteger.ONE));

      do {
        do {
            d = new java.math.BigInteger(meretBitekben, new java.util.Random());
          } while (d.equals(java.math.BigInteger.ONE));
        } while (!z.gcd(d).equals(java.math.BigInteger.ONE));
        
      e = d.modInverse(z);
    }
  }

public static void main(String[] args){

    KulcsPar jSzereplo = new KulcsPar();

    String tisztaSzoveg = "Hello, titkosított szöveg!";
    
    byte[] buffer = tisztaSzoveg.getBytes();
    java.math.BigInteger[] titkos = new java.math.BigInteger[buffer.length];

    for(int i = 0; i < titkos.length; i++)
      {
        titkos[i] = new java.math.BigInteger(new byte[]{buffer[i]});
        titkos[i] = titkos[i].modPow(jSzereplo.e, jSzereplo.m);
      }

    for(int i = 0; i < titkos.length; i++)
      {
        titkos[i] = titkos[i].modPow(jSzereplo.d, jSzereplo.m);
        buffer[i] = titkos[i].byteValue();
      }
    System.out.println(new String(buffer));
    }
  }
