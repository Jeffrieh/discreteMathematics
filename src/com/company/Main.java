package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    private static final Person trump = new Person();

    public static void main(String[] args) {
        List<Sentient> allDomain = prepareForAllDomain();
        List<Sentient> existDomain = prepareThereExistDomain();
        Predicate<Sentient> predicate = preparePredicate();
        boolean resultForAll = forAll(allDomain, predicate);
        boolean resultsForAllShouldBeFalse = forAll(existDomain, predicate);
        boolean resultsThereExists = thereExists(existDomain, predicate);
        System.out.println("T : " + resultForAll );
        System.out.println("F : " + resultsForAllShouldBeFalse);
        System.out.println("T : " + resultsThereExists);
    }

    private static boolean forAll(List<Sentient> domain, Predicate<Sentient> p ){
        return domain.stream().allMatch(p);
    }

    private static boolean thereExists(List<Sentient> domain, Predicate<Sentient> p ){
        return domain.stream().anyMatch(p);
    }

    public static Predicate<Sentient> preparePredicate(){
        return p -> p.likes(trump);
    }

    public static List<Sentient> prepareForAllDomain(){
        List<Sentient> people = new ArrayList<>();

        for (int x = 0; x < 10; x++) {
            Person p = new Person();
            p.setLikes(trump);
            people.add(p);
        }

        return people;
    }

    public static List<Sentient> prepareThereExistDomain(){
        List<Sentient> people = new ArrayList<>();

        for (int x = 0; x < 10; x++) {
            Person p = new Person();

            //only add one
            if(x == 5){
                p.setLikes(trump);
            }

            people.add(p);
        }

        return people;
    }

}
