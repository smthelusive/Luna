package luna.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "airports")
public class Airport implements Serializable {
    public Airport() {}
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "ident")
    private String ident;
    @Column(name = "type")
    private String type;
    @Column(name = "name")
    private String name;
    @Column(name = "latitude_deg")
    private Double latitudeDeg;
    @Column(name = "longitude_deg")
    private Double longitudeDeg;
    @Column(name = "elevation_ft")
    private Integer elevationFt;
    @Column(name = "continent")
    private String continent;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "iso_country", referencedColumnName="code")
    private Country country;
    @Column(name = "iso_region")
    private String isoRegion;
    @Column(name = "municipality")
    private String municipality;
    @Column(name = "scheduled_service")
    private String scheduledService;
    @Column(name = "gps_code")
    private String gpsCode;
    @Column(name = "iata_code")
    private String iataCode;
    @Column(name = "local_code")
    private String localCode;
    @Column(name = "home_link")
    private String homeLink;
    @Column(name = "wikipedia_link")
    private String wikipediaLink;
    @Column(name = "keywords")
    private String keywords;
    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Runway> runways;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitudeDeg() {
        return latitudeDeg;
    }

    public void setLatitudeDeg(Double latitudeDeg) {
        this.latitudeDeg = latitudeDeg;
    }

    public Double getLongitudeDeg() {
        return longitudeDeg;
    }

    public void setLongitudeDeg(Double longitudeDeg) {
        this.longitudeDeg = longitudeDeg;
    }

    public Integer getElevationFt() {
        return elevationFt;
    }

    public void setElevationFt(Integer elevationFt) {
        this.elevationFt = elevationFt;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Country getIsoCountry() {
        return country;
    }

    public void setIsoCountry(Country country) {
        this.country = country;
    }

    public String getIsoRegion() {
        return isoRegion;
    }

    public void setIsoRegion(String isoRegion) {
        this.isoRegion = isoRegion;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getScheduledService() {
        return scheduledService;
    }

    public void setScheduledService(String scheduledService) {
        this.scheduledService = scheduledService;
    }

    public String getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(String gpsCode) {
        this.gpsCode = gpsCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public String getHomeLink() {
        return homeLink;
    }

    public void setHomeLink(String homeLink) {
        this.homeLink = homeLink;
    }

    public String getWikipediaLink() {
        return wikipediaLink;
    }

    public void setWikipediaLink(String wikipediaLink) {
        this.wikipediaLink = wikipediaLink;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public void setRunways(List<Runway> runways) {
        this.runways = runways;
    }
}
