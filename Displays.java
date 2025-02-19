public class Displays {

    /**
     * A method that displays the ASCII art of a baby
     * and it's toy at the start of the game when the
     * user creates their baby.
     */
    public static void displayScene(){
        String scene =
        "\n"+
        "------------------------------------\n"+
        "  ,=^^=,\n"+
        " c , _,{ \n"+
        " /\\  @ )                __\n"+
        "/  ^~~^\\          <=.,__/ '}= \n"+
        "(_/ ,, ,,)          \\_ _>_/~ \n"+
        "~\\_(/-\\)'-,_,_,_,-'(_)-(_)  ";

        System.out.println(scene);
    }

    /**
     * A method that displays a simple straight line as
     * like a banner to seperate the scenes.
     * @param message a message to be displayed underneath the line/banner
     */
    public static void display(String message){
       
        System.out.println("----------------------------------------------------------------------------\n");
        System.out.println(message);
    }

    /**
     * A method that displays the ASCII art of
     * a room that is displayed during the crawling
     * challenge when the game narrates that the
     * baby looks up to a room.
     */
    public static void displayRoom(){
        String room = 
        "\t0================================================0\n"+
        "\t|-.                    (|)                     .-|\n"+
        "\t|  -.                   |                    .-  |\n"+
        "\t|    -.                |O|                 .-    |\n"+
        "\t|      .. ____________/===\\_____________ ..      |\n"+
        "\t|        :            `\\-/`  ______     :     .. |\n"+
        "\t|        :     mmmmmmm  V   |--%%--|    :   .'|| |\n"+
        "\t|        :     |  |  |      |-%%%%-|    :  |  || |\n"+
        "\t|        :     |--|--| @@@  |=_||_=|    :  I  || |\n"+
        "\t|        :     |__|__|@@@@@ |_\\__/_|    : |   || |\n"+
        "\t|        :             \\|/   ____       : |   || |\n"+
        "\t|        :;;       .'``(_)```\\__/````:  : |   || |\n"+
        "\t|        :||___   :================:'|  :  |  0+| |\n"+
        "\t|        :||===)  | |              | |  :  |   || |\n"+
        "\t|        ://``\\__|_|______________|_|__:  I   || |\n"+
        "\t|      .'/'    \' | '              | '   '.|   || |\n"+
        "\t|    .'           |                |       '.  || |\n"+
        "\t|  .'                                        ' || |\n"+
        "\t|.'                                            '. |\n"+
        "\t0=================================================0";

    System.out.println(room);
    }

    /**
     * A method that displays the ASCII art of
     * a "congrats" banner for when the user/baby
     * gets past infancy to kindergarten.
     */
    public static void displayCongrats(){
        String congrats =
        "                                                         ,jf\n"+
        "                                                        ,jf\n"+
        "   _am,    ,_am,  ,_g_oam,    _am,   _g_ag,   _am,   koewkovg   _mm_\n"+
        " ,gF  @._-gF   @--  jf   @  ,gF  @  ^ NX  #_,gF  @     jf      qK  \n"+
        " 8Y      8Y    d   j#   jF .8Y  ,d   dY     8Y   d    jf       *b,\n"+
        "jK   ,  jK   ,N   jN   jF  :K  ,Z  ,jF     jK  ,Z-  ,jfk,       dN.\n"+
        " NbpP    NbpP    dP   dFk_o8NbpP-V^dF       NbpY-V^-dF -dYo--*h,W\n"+
        "                         _gF-_@-\n"+
        "                        :8K  j8\n"+
        "                          *w*";

    System.out.println(congrats);

    }
    
}
