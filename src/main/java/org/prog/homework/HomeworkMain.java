package org.prog.homework;

public class HomeworkMain {

    public static void main(String... args) {
        //Kyiv chernihiv chop
        //one two three four five
        Plane planeOne = new Plane();
        planeOne.destination = "Kyiv";
        planeOne.flightNumber = "00AA999";

        Plane planeTwo = new Plane();
        planeTwo.destination = "Chernihiv";
        planeTwo.flightNumber ="11BB876" ;

        Plane planeThree = new Plane();
        planeThree.destination = "Chop";
        planeThree.flightNumber = "22FF433";

        Plane planeFour = new Plane();
        planeFour.destination = "Kyiv";
        planeFour.flightNumber = "11GG343";

        Airport airport = new Airport();
        airport.planes.add(planeOne);
        airport.planes.add(planeTwo);
        airport.planes.add(planeThree);
        airport.planes.add(planeFour);
        airport.getPlaneByFlightIdAndDestination("Kyiv","11GG343");
        airport.getPlaneByFlightIdAndDestination("Kyiv","1G343");
        airport.planeByDestination("Kyiv");
        airport.planeByDestination("Uruguay");
        airport.planeByDestination("Chop");



    }
}
