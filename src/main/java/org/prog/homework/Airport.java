package org.prog.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Airport {
    public final List<Plane> planes = new ArrayList<>();

    public Plane getPlaneByFlightIdAndDestination(String flightId, String dest) {
        Optional<Plane> result = planeByDestination(dest).stream()
                .filter(plane -> plane.flightNumber.equals(flightId))
                .findAny();
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("No plane was found!");
        }
    }

    public List<Plane> planeByDestination(String dest) {
        List<Plane> result = planes.stream()
                .filter(plane -> plane.destination.equals(dest))
                .collect(Collectors.toList());

        if (!result.isEmpty()) {
            return result;
        } else {
            throw new RuntimeException("No plane was found!");
        }
    }
}
