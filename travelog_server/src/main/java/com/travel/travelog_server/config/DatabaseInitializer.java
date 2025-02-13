package com.travel.travelog_server.config;

import com.travel.travelog_server.model.PinType;
import com.travel.travelog_server.model.PriceType;
import com.travel.travelog_server.repository.PinTypeRepository;
import com.travel.travelog_server.repository.PriceTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DatabaseInitializer {
    private final PinTypeRepository pinTypeRepository;
    private final PriceTypeRepository priceTypeRepository;

    @Bean
    public ApplicationRunner initDatabase() {
        return args -> {
            if(pinTypeRepository.count() == 0) {
                List<PinType> defaultPinTypes = List.of(
                        new PinType("식사", "www.naver.com"),
                        new PinType("숙박", "www.naver.com"),
                        new PinType("카페", "www.naver.com"),
                        new PinType("관광지", "www.naver.com"),
                        new PinType("쇼핑", "www.naver.com"),
                        new PinType("버스", "www.naver.com"),
                        new PinType("지하철", "www.naver.com"),
                        new PinType("비행기", "www.naver.com"),
                        new PinType("택시", "www.naver.com"),
                        new PinType("도보", "www.naver.com")
                );

                pinTypeRepository.saveAll(defaultPinTypes);
            }

            if(priceTypeRepository.count() == 0) {
                List<PriceType> defaultPriceTypes = List.of(
                        new PriceType("원"),
                        new PriceType("달러"),
                        new PriceType("유로"),
                        new PriceType("엔"),
                        new PriceType("위안")
                );

                priceTypeRepository.saveAll(defaultPriceTypes);
            }
        };
    }
}
