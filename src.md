classDiagram
direction BT
class AgeGroup {
<<enumeration>>
  - AgeGroup(String) 
  - String label
  + values() AgeGroup[]
  + valueOf(String) AgeGroup
   String label
}
class Booking {
  # Booking(String, MovieGoer, boolean[][], double) 
  - String TID
  - MovieGoer movieGoer
  - ArrayList~Ticket~ tickets
  - double price
   ArrayList~Ticket~ tickets
   String TID
   double price
   MovieGoer movieGoer
}
class BookingController {
  + BookingController() 
  + displaySeats(ShowTime) void
  + printBookingDetails(EnumMap~AgeGroup, Integer~, double) void
  + getAgeGroupCount(int) EnumMap~AgeGroup, Integer~
  + getSeats(int, ShowTime) boolean[][]
}
class BookingHistoryMenu {
  + BookingHistoryMenu(MovieGoer) 
  + start() void
   List~String~ bookingHistory
}
class BookingMenu {
  + BookingMenu(MovieGoer) 
  - selectShowTime() ShowTime
  + start() void
  + calculatePrice(EnumMap~AgeGroup, Integer~) double
}
class Cinema {
  + Cinema(String, boolean[][], CinemaClass) 
  - String cinemaCode
  - CinemaClass cinemaClass
  - ArrayList~ShowTime~ showTimes
  - boolean[][] layout
  + createShowTime(LocalDateTime, Movie) void
   CinemaClass cinemaClass
   String cinemaCode
   boolean[][] layout
   ArrayList~ShowTime~ showTimes
   String label
}
class CinemaClass {
<<enumeration>>
  - CinemaClass(String) 
  - String label
  + valueOf(String) CinemaClass
  + values() CinemaClass[]
   String label
}
class CinemaStaff {
  + CinemaStaff(String, String) 
  - String username
  - String password
  + login(String) boolean
   String password
   String username
}
class CinemaStaffMenu {
  + CinemaStaffMenu() 
  - displayMenu() void
  + loginCinemaStaff() CinemaStaff?
  + start() void
}
class Cineplex {
  + Cineplex(String) 
  - ArrayList~Cinema~ cinemas
  - String name
  + addCinema(Cinema) void
  + createCinema(String, boolean[][], CinemaClass) void
   String name
   ArrayList~ShowTime~ showTimes
   ArrayList~Cinema~ cinemas
   String label
}
class ContentRating {
<<enumeration>>
  - ContentRating(String) 
  - String label
  + valueOf(String) ContentRating
  + values() ContentRating[]
   String label
}
class DataManager {
  - DataManager() 
  - Database database
  + load() void
  + update() void
  + initialise() void
   Database database
}
class Database {
  + Database() 
  - ArrayList~Movie~ movieList
  - ArrayList~Cineplex~ cineplexList
  - PriceOutline pricingScheme
  + checkCinemaStaffUsername(String) boolean
  + addCinemaStaff(CinemaStaff) boolean
  + getMovieGoer(String, String) MovieGoer
  + checkMovieGoerUsername(String) boolean
  + addMovieGoer(MovieGoer) boolean
  + addCineplex(Cineplex) void
  + getCinemaStaff(String, String) CinemaStaff
   ArrayList~Cineplex~ cineplexList
   PriceOutline pricingScheme
   ArrayList~Movie~ movieList
}
class DateType {
<<enumeration>>
  - DateType(String) 
  - String label
  + valueOf(String) DateType
  + values() DateType[]
   String label
}
class Driver {
  + Driver() 
  + goBack(int) void
  + addMenu(Menu) void
  + goBack() void
}
class IO {
  + IO() 
  + displayTitle(String) void
  + readDouble(String) double
  + readBoolean(String, String, String) boolean
  + readDateTime(String) LocalDateTime
  + readDuration(String) Duration
  + readDate(String) LocalDate
  + displayMessageCentred(String, int) void
  + readInt(String) int
  + EnterToContinue() void
  + readLine(String) String
}
class LabelledItem {
<<Interface>>
   String label
}
class ListController {
  + ListController() 
  + displayLabelledItemList(String, List~T~, String) void
  + displayList(String, List~String~, String) void
}
class Main {
  + Main() 
  + main(String[]) void
}
class Menu {
<<Interface>>
  + start() void
}
class MenuController {
  + MenuController() 
  + getMenuOption(String, String[]) int
  + getLabelledItem(String, T[]) T
  + getLabelledItem(String, List~T~) T
}
class Movie {
  + Movie(String, String, String, String[], ShowingStatus, ContentRating, MovieFormat, Duration) 
  - String[] cast
  - ArrayList~ReviewStatus~ reviewRatings
  - MovieFormat movieFormat
  - String synopsis
  - ContentRating contentRating
  - ShowingStatus showingStatus
  - Duration duration
  - String title
  - String director
  - ArrayList~ShowTime~ showTimes
  # addShowTime(ShowTime) void
   String synopsis
   ArrayList~ReviewStatus~ reviewRatings
   Double overallRating
   Duration duration
   MovieFormat movieFormat
   ArrayList~ShowTime~ showTimes
   ShowingStatus showingStatus
   String title
   String label
   ContentRating contentRating
   double totalSales
   String[] cast
   String director
}
class MovieController {
  + MovieController() 
  + printMovieDetails(Movie) void
  + addMovieReview(Movie, MovieGoer) void
}
class MovieEditController {
  + MovieEditController() 
  - readTitle() String
  + removeMovie() void
  + updateMovie() void
  + addMovie() void
  - readCast() String[]
  - readDuration() Duration
  - readSynopsis() String
  - readReleaseRating() ContentRating
  - readMovieFormat() MovieFormat
  - readDirector() String
  - readShowingStatus() ShowingStatus
}
class MovieEditMenu {
  + MovieEditMenu() 
  + start() void
}
class MovieFormat {
<<enumeration>>
  - MovieFormat(String) 
  - String label
  + valueOf(String) MovieFormat
  + values() MovieFormat[]
   String label
}
class MovieGoer {
  + MovieGoer(String, String, Integer, String, String) 
  - String emailAddress
  - Integer mobileNumber
  - String username
  - String name
  - String password
  + login(String) boolean
   Integer mobileNumber
   String name
   String password
   String emailAddress
   String username
}
class MovieGoerMenu {
  + MovieGoerMenu() 
  + signupMovieGoer() MovieGoer?
  + start() void
  - displayMenu() void
  + loginMovieGoer() MovieGoer?
}
class MovieMenu {
  + MovieMenu(MovieGoer) 
  + start() void
  - selectMovie() Movie
}
class PriceOutline {
  + PriceOutline() 
  - double basePrice
  - ArrayList~LocalDate~ holidayDates
  - getDateType(LocalDate): DateType
  + getPrice(LocalDate, CinemaClass, AgeGroup, MovieFormat): double
  + setAgeMultiplier(AgeGroup, Double): void
  + setDateMultiplier(DateType, Double) void
  + getDateMultiplier(DateType) Double
  + getAgeMultiplier(AgeGroup): Double
  + getDateMultiplier(LocalDate) Double
  + setMovieMultiplier(MovieFormat, Double): void
  - isHoliday(LocalDate): boolean
  + setCinemaMultiplier(CinemaClass, Double): void
  + getCinemaMultiplier(CinemaClass) Double
  + getMovieMultiplier(MovieFormat): Double
   ArrayList~LocalDate~ holidayDates
   double basePrice
}
class PriceOutlineEditController {
  + PriceOutlineEditController() 
  + updateHolidays(PriceOutline) void
  + updateMultipliers(PriceOutline) void
  - updateCinemaClassMultiplier(PriceOutline) void
  - updateMovieTypeMultiplier(PriceOutline) void
  - addHoliday(PriceOutline) void
  - updateAgeGroupMultiplier(PriceOutline) void
  - updateDateTypeMultiplier(PriceOutline) void
  + updateBasePrice(PriceOutline) void
  - removeHoliday(PriceOutline) void
}
class PricingSchemeEditMenu {
  + PricingSchemeEditMenu() 
  + start() void
}
class ReviewStatus {
  - ReviewStatus() 
  - Integer rating
  - MovieGoer movieGoer
  - String review
  + createReviewRating(MovieGoer, String, int) ReviewStatus?
   int rating
   String review
   MovieGoer movieGoer
   String label
}
class SeatStatus {
<<enumeration>>
  + SeatStatus() 
  + values() SeatStatus[]
  + valueOf(String) SeatStatus
}
class Serialization {
  + Serialization() 
  + readSerializedObject(String) Object?
  + writeSerializedObject(String, Object) void
}
class ShowTime {
  # ShowTime(Cinema, LocalDateTime, Movie) 
  - Movie movie
  - LocalDateTime startDateTime
  - ArrayList~Booking~ bookings
  - Cinema cinema
  + createBooking(MovieGoer, boolean[][], double) Booking
  + checkAvail(boolean[][]): boolean
  + remove() void
  + createTID() String
  + checkFull() boolean
   boolean[][] layout
   Cinema cinema
   Movie movie
   String label
   ArrayList~Booking~ bookings
   LocalDate date
   LocalDateTime startDateTime
   double totalSales
   SeatStatus[][] seatAvailabilities
}
class ShowTimeController {
  + ShowTimeController() 
  + displayAllShowTimes() void
}
class ShowTimeEditController {
  + ShowTimeEditController() 
  + removeShowTime() void
  + addShowTime() void
  + updateShowTime() void
  - readMovie() Movie
  + checkClash(LocalDateTime, Duration, Cinema, ShowTime) boolean
  - readStartDateTime() LocalDateTime
  - readCinema() Cinema
}
class ShowTimeEditMenu {
  + ShowTimeEditMenu() 
  + start() void
}
class ShowTimeMenu {
  + ShowTimeMenu() 
  + start() void
}
class ShowingStatus {
<<enumeration>>
  - ShowingStatus(String) 
  ~ String label
  + valueOf(String) ShowingStatus
  + values() ShowingStatus[]
   String label
}
class Ticket {
  # Ticket(int, int) 
  - int row
  - int col
   int col
   int row
}
class TopMoviesMenu {
  + TopMoviesMenu() 
  + start() void
   List~String~ topMoviesByTicketSales
   List~String~ topMoviesByOverallRating
}
class UserMenu {
  + UserMenu() 
  + start() void
}

AgeGroup  ..>  LabelledItem 
BookingHistoryMenu  ..>  Menu 
BookingMenu  ..>  Menu 
Cinema  ..>  LabelledItem 
CinemaClass  ..>  LabelledItem 
CinemaStaffMenu  ..>  Menu 
Cineplex  ..>  LabelledItem 
ContentRating  ..>  LabelledItem 
DateType  ..>  LabelledItem 
Movie  ..>  LabelledItem 
MovieEditMenu  ..>  Menu 
MovieFormat  ..>  LabelledItem 
MovieGoerMenu  ..>  Menu 
MovieMenu  ..>  Menu 
PricingSchemeEditMenu  ..>  Menu 
ReviewStatus  ..>  LabelledItem 
ShowTime  ..>  LabelledItem 
ShowTimeEditMenu  ..>  Menu 
ShowTimeMenu  ..>  Menu 
ShowingStatus  ..>  LabelledItem 
TopMoviesMenu  ..>  Menu 
UserMenu  ..>  Menu 
