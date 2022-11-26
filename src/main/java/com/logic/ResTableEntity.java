package com.logic;

import jakarta.persistence.*;
@Entity
@NamedQuery(name = "get_res_by_price_limit_long",
        query = "SELECT e " +
                "FROM ResTableEntity e " +
                "WHERE e.price < :price")
//updateStartsWith
//@NamedQuery(name = "update_resort_by_name_string",
//        query = "UPDATE SET name :name " +
//                "FROM ResTableEntity e " +
//                "WHERE e.name like :name")

@Table(name = "res_table", schema = "db_resorts")
public class ResTableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private Long price;
    @Basic
    @Column(name = "season")
    private String season;

    public ResTableEntity(String country, String name,  String season, Long price) {
        this.country = country;
        this.name = name;
        this.price = price;
        this.season = season;
    }

    public ResTableEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResTableEntity that = (ResTableEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (season != null ? !season.equals(that.season) : that.season != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (season != null ? season.hashCode() : 0);
        return result;
    }
}
