package jp.ac.ait.k22047;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class AichiTouristSpot {
    public record TouristSpot(double lat, double lon, double distanceFromAIT, String name){}

    public static void main(String[] args) {
        String[] files = {"c200326.csv", "c200328.csv", "c200329.csv", "c200330.csv", "c200361.csv", "c200362.csv", "c200363.csv", "c200364.csv"};
        String outputFileName = "TouristSpot.csv";

        double AITlat = 35.1834122;
        double AITlon = 137.1130419;

        List<TouristSpot> touristSpots = new ArrayList<>();

        for(String file: files){
            try (Scanner sc = new Scanner(Files.newBufferedReader(Path.of(file), Charset.forName("ms932")))) {
                int count = 0;
                int nameCol = 0;

                while (sc.hasNextLine()) {
                    double lat, lon, distance;
                    String name;

                    String line = sc.nextLine();
                    String[] cols = line.split(",", -1);
                    if(count == 0){
                        for(int i = 0; i < cols.length; i++){
                            if(Objects.equals(cols[i], "名称") || Objects.equals(cols[i], "データ名")) {
                                nameCol = i;
                            }
                        }
                    }else {
                        name = cols[nameCol];

                        String rmdLonLat = cols[1].replace("POINT(", "").replace(")", "");
                        String[] lonLat = rmdLonLat.split(" ", -1);

                        lat = parseDouble(lonLat[1]);
                        lon = parseDouble(lonLat[0]);

                        distance = sqrt(pow(AITlat - lat, 2) + pow(AITlon - lon, 2));

                        touristSpots.add(new TouristSpot(lat, lon, distance, name));
                    }
                    count++;
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }

        }

        touristSpots.sort((o1, o2) -> {
            if(o1.distanceFromAIT() - o2.distanceFromAIT() > 0) return 1;
            else if(o1.distanceFromAIT() - o2.distanceFromAIT() == 0) return 0;
            else return -1;
        });

//        for(TouristSpot touristspot: touristSpots) System.out.println(touristspot);

        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(outputFileName))) {
            bw.write("緯度情報,経度情報,愛工大からの距離,データ名");
            bw.newLine();
            for (TouristSpot touristspot: touristSpots) {
                bw.write(touristspot.lat() + "," + touristspot.lon() + "," + touristspot.distanceFromAIT() + "," + touristspot.name());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
