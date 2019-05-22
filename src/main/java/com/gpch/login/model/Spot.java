package com.gpch.login.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "spot")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "spot_id")
    private Long id;
    @NotNull(message = "Please give a name")
    @NotEmpty(message = "Please give a name")
    @Column(name = "name")
    private String name;
    @NotNull(message = "please give a longitude")
    @Column(name = "longitude")
    private Double longitudine;
    @NotNull(message = "Please give a latitude")
    @Column(name = "latitude")
    private Double latitudine;
    @NotNull(message = "Please give the windProbability")
    @Column(name = "wind_probability")
    private Double windProbability;
    @NotNull(message = "Please give a country")
    @NotEmpty
    @Column(name = "country")
    private String country;
    @NotEmpty
    @NotNull(message = "Please give a date")
    @Column(name = "when_to_go")
    private String whenToGo;

    public Spot() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(Double longitudine) {
        this.longitudine = longitudine;
    }

    public Double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(Double latitudine) {
        this.latitudine = latitudine;
    }

    public Double getWindProbability() {
        return windProbability;
    }

    public void setWindProbability(Double windProbability) {
        this.windProbability = windProbability;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWhenToGo() {
        return whenToGo;
    }

    public void setWhenToGo(String whenToGo) {
        this.whenToGo = whenToGo;
    }
}
