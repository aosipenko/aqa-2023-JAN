package org.prog.homework;

import java.util.List;

public class HomeworkMain {

    public static void main(String... args) {
        Airport airport = new Airport();
        airport.planes.add(new Plane("GE001", "Germany"));
        airport.planes.add(new Plane("GE002", "Germany"));
        airport.planes.add(new Plane("US003", "USA"));
        airport.planes.add(new Plane("GB004", "UK"));
        airport.planes.add(new Plane("CH005", "China"));

        Plane plane = airport.getPlaneByFlightIdAndDestination("US003", "AAAAA");
        System.out.println(plane.flightNumber);
        List<Plane> planes = airport.planeByDestination("Germany");
    }
}
