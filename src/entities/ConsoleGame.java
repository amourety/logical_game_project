package entities;

class ConsoleGame {
    /* public static void main(String[] args) {
        try {
            File f = new File("C:\\Users\\Guzel\\Desktop\\logical_game_project\\project\\project\\src\\data\\music.wav");
            URI path = f.toURI();
            DataReader dataReader = DataReaderFactory.getProduct();
            MediaPlayer mediaPlayer = MediaPlayer.getInstance();
            mediaPlayer.setTrack(dataReader.read(path));
            mediaPlayer.play();
        }
        catch (DataReaderException ex){
            getErrorInfo(ex, "Ошибка в DataReader");
        }
        Scanner sc = new Scanner(System.in);
        Timer timer = new Timer();
        Player p = new Player("Vadim");
        Randomizer r = new Randomizer();
        Unit[] units = {
                new Unit("BLACK", "#000000", 1), //CORRECT UNITS
                new Unit("BLUE", "#0000ff", 1),
                new Unit("GREEN", "#008000", 1),
                new Unit("YELLOW", "#ffff00", 1),
                new Unit("RED", "#ff0000", 1),

                new Unit("BLUE", "#000000", 0), //WRONG BLACK UNITS
                new Unit("GREEN", "#000000", 0),
                new Unit("YELLOW", "#000000", 0),
                new Unit("RED", "#000000", 0),

                new Unit("BLACK", "#0000ff", 0),//WRONG BLUE UNITS
                new Unit("GREEN", "#0000ff", 0),
                new Unit("YELLOW", "#0000ff", 0),
                new Unit("RED", "#0000ff", 0),

                new Unit("BLACK", "#008000", 0),//WRONG GREEN UNITS
                new Unit("BLUE", "#008000", 0),
                new Unit("YELLOW", "#008000", 0),
                new Unit("RED", "#008000", 0),

                new Unit("BLACK", "#ffff00", 0),//WRONG YELLOW UNITS
                new Unit("BLUE", "#ffff00", 0),
                new Unit("GREEN", "#ffff00", 0),
                new Unit("RED", "#ffff00", 0),

                new Unit("BLACK", "#ff0000", 0),//WRONG RED UNITS
                new Unit("BLUE", "#ff0000", 0),
                new Unit("GREEN", "#ff0000", 0),
                new Unit("YELLOW", "#ff0000", 0)};
        Thread thread = new Thread();
        int count = 10;
        thread.start();
        while(count > 0){
            try{
                Unit correctUnit = r.random(units);
                System.out.println(correctUnit.getColorName() + "(" + correctUnit.getRgb() + ")");
                String s = sc.nextLine();
                if ((s.equals("YES") && correctUnit.getPure() == 1) || (s.equals("NO") && correctUnit.getPure() == 0)) {
                    p.addScore();
                } else {
                    System.out.println("WRONG");
                }
                count--;
            }
            catch(Exception ex){
                getErrorInfo(ex,"ОШИБКА");
            }
        }
        System.out.println("YOUR SCORE:" + p.getScore());

    }
    public static void getErrorInfo(Exception ex, String msg) {
        System.out.print(msg);
        System.err.println(ex.getMessage());
        System.exit(1);
    }
*/
}
