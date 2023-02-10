package controller;

import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import model.Cineplex;
import model.DataManager;
import model.Movie;
import model.ShowTime;
import model.ShowingStatus;

/**
 * Class just has method to display all ShowTimes
 */
public class ShowTimeController {
	/**
	 * Method to display all ShowTimes
	 */
	public static void displayAllShowTimes() {
		System.out.println("========================================");
		System.out.println("|      Displaying Movie ShowTimes      |");
		System.out.println("========================================");
		List<Cineplex> cineplexList = DataManager.getDatabase().getCineplexList();
		
		for (Cineplex cineplex: cineplexList) {
			IO.displayTitle(cineplex.getName());
			List<ShowTime> showTimeList = cineplex.getShowTimes();
			
			// Group show times by their movies
			Map<Movie, List<ShowTime>> showTimesByMovie = showTimeList.stream().collect(Collectors.groupingBy(ShowTime::getMovie));    
			
			// Use a For-Each loop to iterate each entry in map
			for (Map.Entry<Movie, List<ShowTime>> movieShowTimes: showTimesByMovie.entrySet()) {
				Movie movie = movieShowTimes.getKey();
				
				ShowingStatus showingStatus = movie.getShowingStatus();
				
				// Only print out ShowTimes for PREVIEW and NOW_SHOWING movies because logically, they are the only statuses to have show times
				if (showingStatus == ShowingStatus.PREVIEW || showingStatus == ShowingStatus.NOW_SHOWING) {
					List<ShowTime> movieShowTimeList = movieShowTimes.getValue();
					
					System.out.println(movie.getTitle());
					
					Comparator<ShowTime> startdateComparator = Comparator.comparing(ShowTime::getStartDateTime);
					movieShowTimeList.sort(startdateComparator);
					
					for (ShowTime showTime: movieShowTimeList)
						System.out.println(showTime.getTag());
					
					System.out.println("");
				}
			}
		}
		IO.EnterToContinue();
	}
}
