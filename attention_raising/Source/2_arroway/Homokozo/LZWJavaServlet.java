import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class LZWJavaServlet extends HttpServlet{

    public LZWJavaServlet() {
        gyoker = new Csomopont('/');
        fa = gyoker;
    }

    public void operator(char b) {
        if (b == '0') {
            if (fa.nullasGyermek() == null) {
                Csomopont uj = new Csomopont('0');
                fa.ujNullasGyermek(uj);
                fa = gyoker;
            }
            else {
                fa = fa.nullasGyermek ();
            }
        } else {
            if (fa.egyesGyermek() == null) {
                Csomopont uj = new Csomopont('1');
                fa.ujEgyesGyermek (uj);
                fa = gyoker;
            }
            else {
                fa = fa.egyesGyermek();
            }
        }
    }

    public void kiir() {
        melyseg = 0;
        kiir (gyoker);
    }


    public StringBuffer kimenet = new StringBuffer();

    class Csomopont {
        public Csomopont (char betu) {
            this.betu = betu;
            balNulla= null;
            jobbEgy = null;
        };

        public Csomopont nullasGyermek() {
            return balNulla;
        }

        public Csomopont egyesGyermek() {
            return jobbEgy;
        }

        public void ujNullasGyermek (Csomopont gy) {
            balNulla = gy;
        }

        public void ujEgyesGyermek (Csomopont gy) {
            jobbEgy = gy;
        }

        public char getBetu() {
            return betu;
        }

        private char betu;
        private Csomopont balNulla = null;
        private Csomopont jobbEgy = null;
    };

    private Csomopont fa = null;
    private int melyseg, atlagosszeg, atlagdb;
    private double szorasosszeg;
    
    public void kiir (Csomopont elem) {
        if (elem != null) {
            ++melyseg;
            kiir (elem.egyesGyermek());
            for (int i = 0; i < melyseg; ++i) {
                kimenet.append("---");
            }
            kimenet.append(elem.getBetu() + "(" + (melyseg - 1) + ")\n");
            kiir (elem.nullasGyermek());
            --melyseg;
        }
    }

   
    protected Csomopont gyoker;
    protected int maxMelyseg;
    protected double atlag, szoras;

    public int getMelyseg() {
        melyseg = maxMelyseg = 0;
        rmelyseg (gyoker);
        return maxMelyseg - 1;
    }

    public double getAtlag() {
        melyseg = atlagosszeg = atlagdb = 0;
        ratlag (gyoker);
        atlag = ((double) atlagosszeg) / atlagdb;
        return atlag;
    }

    public double getSzoras() {
        atlag = getAtlag ();
        szorasosszeg = 0.0;
        melyseg = atlagdb = 0;

        rszoras (gyoker);

        if (atlagdb - 1 > 0) {
            szoras = Math.sqrt (szorasosszeg / (atlagdb - 1));
        } else {
            szoras = Math.sqrt (szorasosszeg);
        }
        return szoras;
    }

    public void rmelyseg (Csomopont elem) {
        if (elem != null) {
            ++melyseg;
            if (melyseg > maxMelyseg) {
                maxMelyseg = melyseg;
            }
            rmelyseg (elem.egyesGyermek ());
            rmelyseg (elem.nullasGyermek ());
            --melyseg;
        }
    }

    public void ratlag (Csomopont elem) {
        if (elem != null) {
            ++melyseg;
            ratlag (elem.egyesGyermek ());
            ratlag (elem.nullasGyermek ());
            --melyseg;
            if (elem.egyesGyermek () == null && elem.nullasGyermek () == null) {
                ++atlagdb;
                atlagosszeg += melyseg;
            }
        }
    }

    public void rszoras (Csomopont elem) {
        if (elem != null) {
            ++melyseg;
            rszoras (elem.egyesGyermek ());
            rszoras (elem.nullasGyermek ());
            --melyseg;
            if (elem.egyesGyermek () == null && elem.nullasGyermek () == null) {
                ++atlagdb;
                szorasosszeg += ((melyseg - atlag) * (melyseg - atlag));
            }
        }
    }



    public void CreateStringBuffer(String bemenet) {

        for(int i = 0; i < bemenet.length(); ++i){
            int c = bemenet.charAt(i);
            if(c == 0x0a){
                break;
            }
        }
        boolean kommentben = false;
            
            
        for(int i = 0; i < bemenet.length(); ++i)
        {
            int c = bemenet.charAt(i);
     
            if (c == 0x3e) {			// > karakter
                    kommentben = true;
                    continue;
                }
    
            if (c == 0x0a) {			// újsor
                kommentben = false;
                continue;
            }
    
            if (kommentben) {
                continue;
            }
    
            if (c == 0x4e) // N betű
            {
                continue;
            }

                for (int j = 0; j < 8; ++i)
                {
                    if ((c & 0x80) == 128) {
                        operator('1');
                    } else {
                        operator('0');
                    }
                    c <<= 1;
                }

            }

            kiir();

            kimenet.append("depth = " + getMelyseg() + "\n");
            kimenet.append("mean = " + getAtlag() + "\n");
            kimenet.append("var = " + getSzoras() + "\n");
    }

            public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            // Set response content type
            response.setContentType("text/html");
            
          if(request.getParameter("bemenet") == null){
              return;
          }
          else
            CreateStringBuffer(request.getParameter("bemenet"));
          
          PrintWriter out = response.getWriter();
          String title = "LZWBinFa Java Servlet";
          String docType =
               "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
               
          out.println(docType +
               "<html>\n" +
                  "<head><title>" + title + "</title></head>\n" +
                  "<body>\n" +
                     "<h1 align = \"center\">" + title + "</h1>\n" + 
                       kimenet + 
                  "</body>" +
               "</html>"
            );
        }
};
