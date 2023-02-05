package org.prog.homework;




import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Airport {


    public final List<Plane> planes = new ArrayList<>() {


    };

    //if no plane found - throw exception
    public Plane getPlaneByFlightIdAndDestination(String destination, String flightNumber) {

        try {
            String planeByFlightIdAndDestination = planes.stream()
                    .filter(c -> c.destination.equals(destination))
                    .filter(c -> c.flightNumber.equals(flightNumber))
                    .map(c -> c.flightNumber + " " + destination)
                    .findAny().get();

            System.out.println(planeByFlightIdAndDestination);
        } catch (Exception e) {
            System.out.println("failed to find such aircraft");
        }


        return null;
    }
    //if no plane found - throw exception
    public void planeByDestination( String destination) {

        List<Plane> planeByDestination = planes.stream()
                .filter(s -> s.destination.contains(destination))
                .collect(Collectors.toList());
        if ( planeByDestination.isEmpty()) {
            System.out.println("failed to find such aircraft");
        }
        else{

            for (Plane i : planeByDestination) {
                System.out.println(i.destination + " " + i.flightNumber);
            }
        }
    }

}
