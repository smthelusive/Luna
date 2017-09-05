package luna.domain;

import javax.persistence.*;

@Entity
@Table(name = "runways")
public class Runway {
    public Runway() {}
    @Id
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "airport_ref", referencedColumnName="id"),
            @JoinColumn(name="airport_ident", referencedColumnName="ident")
    })
    private Airport airport;
    @Column(name = "length_ft")
    private Integer lengthFt;
    @Column(name = "width_ft")
    private Integer widthFt;
    @Column(name = "surface")
    private String surface;
    @Column(name = "lighted")
    private Integer lighted;
    @Column(name = "closed")
    private Integer closed;
    @Column(name = "le_ident")
    private String leIdent;
    @Column(name = "le_latitude_deg")
    private Double leLatitudeDeg;
    @Column(name = "le_longitude_deg")
    private Double leLongitudeDeg;
    @Column(name = "le_elevation_ft")
    private Integer leElevationFt;
    @Column(name = "le_heading_degT")
    private Double leHeadingDegT;
    @Column(name = "le_displaced_threshold_ft")
    private Integer leDisplacedThresholdFt;
    @Column(name = "he_ident")
    private String heIdent;
    @Column(name = "he_latitude_deg")
    private Double heLatitudeDeg;
    @Column(name = "he_longitude_deg")
    private Double heLongitudeDeg;
    @Column(name = "he_elevation_ft")
    private Integer heElevationFt;
    @Column(name = "he_heading_degT")
    private Double heHeadingDegT;
    @Column(name = "he_displaced_threshold_ft")
    private Integer heDisplacedThresholdFt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Integer getLengthFt() {
        return lengthFt;
    }

    public void setLengthFt(Integer lengthFt) {
        this.lengthFt = lengthFt;
    }

    public Integer getWidthFt() {
        return widthFt;
    }

    public void setWidthFt(Integer widthFt) {
        this.widthFt = widthFt;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public Integer getLighted() {
        return lighted;
    }

    public void setLighted(Integer lighted) {
        this.lighted = lighted;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public String getLeIdent() {
        return leIdent;
    }

    public void setLeIdent(String leIdent) {
        this.leIdent = leIdent;
    }

    public Double getLeLatitudeDeg() {
        return leLatitudeDeg;
    }

    public void setLeLatitudeDeg(Double leLatitudeDeg) {
        this.leLatitudeDeg = leLatitudeDeg;
    }

    public Double getLeLongitudeDeg() {
        return leLongitudeDeg;
    }

    public void setLeLongitudeDeg(Double leLongitudeDeg) {
        this.leLongitudeDeg = leLongitudeDeg;
    }

    public Integer getLeElevationFt() {
        return leElevationFt;
    }

    public void setLeElevationFt(Integer leElevationFt) {
        this.leElevationFt = leElevationFt;
    }

    public Double getLeHeadingDegT() {
        return leHeadingDegT;
    }

    public void setLeHeadingDegT(Double leHeadingDegT) {
        this.leHeadingDegT = leHeadingDegT;
    }

    public Integer getLeDisplacedThresholdFt() {
        return leDisplacedThresholdFt;
    }

    public void setLeDisplacedThresholdFt(Integer leDisplacedThresholdFt) {
        this.leDisplacedThresholdFt = leDisplacedThresholdFt;
    }

    public String getHeIdent() {
        return heIdent;
    }

    public void setHeIdent(String heIdent) {
        this.heIdent = heIdent;
    }

    public Double getHeLatitudeDeg() {
        return heLatitudeDeg;
    }

    public void setHeLatitudeDeg(Double heLatitudeDeg) {
        this.heLatitudeDeg = heLatitudeDeg;
    }

    public Double getHeLongitudeDeg() {
        return heLongitudeDeg;
    }

    public void setHeLongitudeDeg(Double heLongitudeDeg) {
        this.heLongitudeDeg = heLongitudeDeg;
    }

    public Integer getHeElevationFt() {
        return heElevationFt;
    }

    public void setHeElevationFt(Integer heElevationFt) {
        this.heElevationFt = heElevationFt;
    }

    public Double getHeHeadingDegT() {
        return heHeadingDegT;
    }

    public void setHeHeadingDegT(Double heHeadingDegT) {
        this.heHeadingDegT = heHeadingDegT;
    }

    public Integer getHeDisplacedThresholdFt() {
        return heDisplacedThresholdFt;
    }

    public void setHeDisplacedThresholdFt(Integer heDisplacedThresholdFt) {
        this.heDisplacedThresholdFt = heDisplacedThresholdFt;
    }
}
