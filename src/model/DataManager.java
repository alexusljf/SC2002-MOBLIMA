package model;

/**
 * This class manages the data  of the application
 */
//
public class DataManager {
    /**
     * The filename for our database of moblima data
     */
    //
    private static final String FILENAME = "res/data/moblima.dat";
    /**
     * The database
     */

    private static Database database;

    /**
     *Constructor for a DataManager object
     */
    //
    private DataManager() {
    }

    /**
     *Getter for the database
     * @return
     */
    //
    public static Database getDatabase() {
        return database;
    }

    /**
     *Initialises an empty database
     */
    //
    public static void initialise() {
        database = new Database();
    }

    /**
     *This method loads the database from the file if possible. Otherwise, it initialises an empty database
     */
    //
    public static void load() {
        Object obj = Serialization.readSerializedObject(FILENAME);

        if (obj == null || !(obj instanceof Database)) {
            initialise();

            Cineplex cine1 = new Cineplex("CINELEISURE");
            // seatingArrangement(CineplexNumber)_(CinemaCode)[row][column]
            // Seat arrangements for Cineleisure
            boolean seat1_9[][] = new boolean[18][24];
            for (int row = 0; row < 18; row++) {
                for (int col = 0; col < 24; col++) {
                    if (row != 9 && row != 15) {
                        seat1_9[row][col] = true;
                    }
                }
            }
            seat1_9[0][0] = false;
            seat1_9[1][0] = false;
            for (int row = 10; row < 18; row++) {
                for (int col = 0; col < 3; col++) {
                    seat1_9[row][col] = false;
                }
            }
            boolean seat1_5[][] = new boolean[10][21];
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 21; col++) {
                    if (row != 9) {
                        seat1_5[row][col] = true;
                    }
                }
            }
            boolean seat1_4[][] = new boolean[10][21];
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 21; col++) {
                    seat1_4[row][col] = true;
                }
            }
            int[] noSeat = {2, 3, 14, 15, 16};
            for (int x : noSeat) {
                seat1_4[0][x] = false;
            }
            /**
             * Creating cinemas with respective seat classes
             */
            //
            cine1.createCinema("CLS4", seat1_4, CinemaClass.NORMAL);
            cine1.createCinema("CLS5", seat1_5, CinemaClass.NORMAL);
            cine1.createCinema("CLS9", seat1_9, CinemaClass.NORMAL);


            Cineplex cine2 = new Cineplex("JEM");
            /**
             * Seat arrangements for JEM
             */
            //
            boolean seat2_P1[][] = new boolean[5][6];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 6; col++) {
                    seat2_P1[row][col] = true;
                }
            }
            boolean seat2_P2[][] = new boolean[5][6];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 6; col++) {
                    seat2_P2[row][col] = true;
                }
            }
            seat2_P2[1][2] = false;
            seat2_P2[1][3] = false;

            boolean seat2_3[][] = new boolean[15][16];
            for (int row = 0; row < 15; row++) {
                for (int col = 0; col < 16; col++) {
                    seat2_3[row][col] = true;
                }
            }
            seat2_3[0][0] = false;
            seat2_3[0][15] = false;
            cine2.createCinema("JEMP1", seat2_P1, CinemaClass.PLATINUM_MOVIE_SUITE);
            cine2.createCinema("JEMP2", seat2_P2, CinemaClass.PLATINUM_MOVIE_SUITE);
            cine2.createCinema("JEMS3", seat2_3, CinemaClass.NORMAL);

            Cineplex cine3 = new Cineplex("AMK HUB");
            boolean seat3_10[][] = new boolean[15][16];
            for (int row = 0; row < 15; row++) {
                for (int col = 0; col < 16; col++) {
					if (row!=8){
						seat3_10[row][col] = true;
					}
                }
            }
            boolean seat3_5[][] = new boolean[11][24];
            for (int row = 0; row < 11; row++) {
                for (int col = 0; col < 24; col++) {
                    if (row != 8) {
                        seat3_5[row][col] = true;
                    }
                }
            }
            for (int col = 6; col < 18; col++) {
                seat3_5[0][col] = false;
            }

            for (int col = 0; col < 24; col++) {
                if (col <= 6 || col > 18) {
                    seat3_5[10][col] = false;
                }
            }

            cine3.createCinema("AMKS3", seat3_10, CinemaClass.NORMAL);
			cine3.createCinema("AMKS5",seat3_5,CinemaClass.NORMAL);
			cine3.createCinema("AMKS10",seat3_10,CinemaClass.NORMAL);
            /**
             * Add cineplexes after all cinemas are added into respective cineplexes
             */
            //
            database.addCineplex(cine1);
            database.addCineplex(cine2);
            database.addCineplex(cine3);

            /**
             * Initialise CinemaStaff accounts into the database
             */
            //
            CinemaStaff john = new CinemaStaff("John", "John");
			CinemaStaff jane = new CinemaStaff("Jane","Jane");
            database.addCinemaStaff(john);
            database.addCinemaStaff(jane);
            /**
             * Initialise movie goers
             */
            //
            MovieGoer tommy = new MovieGoer("Tom","Tommy",91234321,"tommylee@gmail.com","tommy");
            MovieGoer dick = new MovieGoer("Dick","Dickson",98767890,"dicksonkoh@gmail.com","dickson");
            MovieGoer harry = new MovieGoer("Harry","Harry", 95551234,"harrywaltz@gmail.com","harry");
            database.addMovieGoer(tommy);
            database.addMovieGoer(dick);
            database.addMovieGoer(harry);
        } else
            database = (Database) obj;
    }

    /**
     *This method writes the database to the file to store the updated data. Call upon finish.
     */
    //
    public static void update() {
        Serialization.writeSerializedObject(FILENAME, database);
    }
}
