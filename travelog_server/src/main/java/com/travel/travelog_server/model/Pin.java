package com.travel.travelog_server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travelog_server.dto.Index;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="pins")
@Getter
@Setter
public class Pin implements Index {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private Double lat;

    @Column (nullable = false)
    private Double lng;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false)
    private String description;

    @Column (nullable = true)
    private String picture;

    @Column (nullable = false)
    @JsonProperty("pinIndex")
    private Integer index;

    @Column (nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name="dayId")
    @JsonBackReference
    private Day day;

    @ManyToOne
    @JoinColumn(name="pinTypeId")
    private PinType pinType;

    @ManyToOne
    @JoinColumn(name="priceTypeId")
    private PriceType priceType;

    @OneToMany(mappedBy="pin", cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
    @JsonManagedReference
    private List<PinUrl> pinUrl;

    @PrePersist
    public void perPersist() {
        if(this.priceType == null) {
            this.priceType = new PriceType();
            this.priceType.setId(1L);
        }

        if(this.price == null) {
            this.price = 0;
        }

        if(this.title == null) {
            this.title = "";
        }

        if(this.description == null) {
            this.description = "";
        }
    }
}