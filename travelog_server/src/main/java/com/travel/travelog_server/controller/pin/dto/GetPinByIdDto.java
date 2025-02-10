package com.travel.travelog_server.controller.pin.dto;

import com.travel.travelog_server.model.Pin;
import com.travel.travelog_server.model.PinUrl;
import lombok.*;

import java.util.List;

@Setter
@Getter
public class GetPinByIdDto {
    private Long id;
    private Double lat;
    private Double lng;
    private String title;
    private String description;
    private String picture;
    private Integer price;
    private Integer index;
    private String pinIcon;
    private String priceType;
    private List<PinUrl> pinUrl;

    public GetPinByIdDto(Pin pin) {
        this.id = pin.getId();
        this.lat = pin.getLat();
        this.lng = pin.getLng();
        this.title = pin.getTitle();
        this.description = pin.getDescription();
        this.picture = pin.getPicture();
        this.price = pin.getPrice();
        this.index = pin.getIndex();
        this.pinIcon = pin.getPinType().getIcon();
        this.priceType = pin.getPriceType().getName();
        this.pinUrl = pin.getPinUrl();
    }
}
