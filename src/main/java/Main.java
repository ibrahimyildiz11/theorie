import be.vdab.exceptions.PlantNietGevondenException;
import be.vdab.exceptions.PrijsTeLaagException;
import be.vdab.exceptions.SoortBestaatAlException;
import be.vdab.repositories.LeverancierRepository;
import be.vdab.repositories.PlantRepository;
import be.vdab.repositories.SoortRepository;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost/tuincentrum";
    private static final String USER = "root";
    private static final String PASSWORD = "1Qaz2wsx.";

    public static void main(String[] args) {
        try (var connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            System.out.println("Connectie geopend");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        };

        /*var repository = new PlantRepository();
        try {
            System.out.print(repository.verhoogPrijzenMet10Procent());
            System.out.println(" planten aangepast.");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }*/

        /*System.out.println("Woonplaats: ");
        var scanner = new Scanner(System.in);
        var woonplaats = scanner.nextLine();
        var repository = new LeverancierRepository();*/

       /* System.out.println("Naam: ");
        var scanner = new Scanner(System.in);
        var naam = scanner.nextLine();
        var repository = new PlantRepository();
        try {
            //repository.findAllNamen().forEach(System.out::println);
            //System.out.print("Aantal leveranciers:");
            //System.out.println(repository.findAantal());
            //repository.findAll().forEach(System.out::println);
            //repository.findByWoonplaats(woonplaats).forEach(System.out::println);
            System.out.print(repository.verhoogPrijzenMet10ProcentByNaam(naam));
            System.out.println(" plant(en) aangepast.");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }*/

        /*System.out.print("id:");
        var scanner = new Scanner(System.in);
        var id = scanner.nextLong();
        var repository = new LeverancierRepository();
        try {
            repository.findById(id)
                    .ifPresentOrElse(System.out::println,
                            () -> System.out.println("Niet gevonden"));
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }*/


        /*System.out.print("Woord:");
        var scanner = new Scanner(System.in);
        var woord = scanner.nextLine();*/
        /*var repository = new PlantRepository();
        try {
            //repository.findNamenByWoord(woord).forEach(System.out::println);
            repository.verhoogPrijzenBovenEnOnder100€();
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }*/

        /*System.out.print("Naam:");
        var scanner = new Scanner(System.in);
        var naam = scanner.nextLine();
        var repository = new SoortRepository();
        try {
            var nieuweId = repository.create(naam);
            System.out.println("Soort toegevoegd. Het nummer is " + nieuweId);
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        } catch (SoortBestaatAlException ex) {
            System.out.println("Soort bestaat al.");
        }*/

        /*System.out.println("Datum vanaf (dag/maand/jaar):");
        var formatter = DateTimeFormatter.ofPattern("d/M/y");
        var scanner = new Scanner(System.in);
        var datum = LocalDate.parse(scanner.nextLine(), formatter);*/
        /*var repository = new LeverancierRepository();
        try {
            repository.findLeverancierGewordenInHetJaar2000().forEach(System.out::println);
        }catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }*/

        var scanner = new Scanner(System.in);
        System.out.print("Nummer plant:");
        var id = scanner.nextLong();
        System.out.print("Nieuwe prijs:");
        var nieuwePrijs = scanner.nextBigDecimal();
        var repository = new PlantRepository();
        try {
            repository.verlaagPrijs(id, nieuwePrijs);
            System.out.println("Prijs aangepast");
        } catch (PlantNietGevondenException ex) {
            System.out.println("Plant niet gevonden.");
        }
        catch (PrijsTeLaagException ex) {
            System.out.println("Prijs te laag.");
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }

        /*var ids = new HashSet<Long>();
        var scanner = new Scanner(System.in);
        System.out.print("Nummer plant (0 om te stoppen):");
        for (long id; (id = scanner.nextInt()) != 0; ) {
            ids.add(id);
        }
        var repository = new PlantRepository();
        try {
            repository.findNamenByIds(ids).forEach(System.out::println);
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }*/

        /*var repository = new PlantRepository();
        try {
            repository.findRodePlantenEnHunLeveranciers().forEach(System.out::println);
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }*/

        /*var namen = new ArrayList<String>();
        var scanner = new Scanner(System.in);
        System.out.print("Naam (stop met STOP):");
        for (String naam; ! "STOP".equals(naam = scanner.nextLine()) ;) {
            namen.add(naam);
        }
        var repository = new SoortRepository();
        try {
            var gegenereerdeIds = repository.create(namen);
            gegenereerdeIds.forEach(System.out::println);
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }*/
    }
}
