package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class City implements Serializable {
    private String name;
    private List<Region> regions;

    public City(String name) {
        this.name = name;
        this.regions = new ArrayList<>();
    }

    public boolean addRegion(Region region) {
        if(!regions.contains(region)) {
            return regions.add(region);
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", regions=" + regions +
                '}';
    }
}
