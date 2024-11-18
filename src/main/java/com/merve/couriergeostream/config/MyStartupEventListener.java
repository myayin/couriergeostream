package com.merve.couriergeostream.config;

import com.merve.couriergeostream.dto.CoordinateDTO;
import com.merve.couriergeostream.entity.Courier;
import com.merve.couriergeostream.entity.Store;
import com.merve.couriergeostream.service.CourierService;
import com.merve.couriergeostream.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.merve.couriergeostream.util.PointUtil.createPoint;

@Component
@RequiredArgsConstructor
public class MyStartupEventListener {
    private final StoreService storeService;
    private final CourierService courierService;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {

        List<Store> stores = new ArrayList<>();

        Store atasehirStore = new Store();
        atasehirStore.setName("Ataşehir MMM Migros");
        atasehirStore.setCity("İstanbul");
        atasehirStore.setDistrict("Ataşehir");
        atasehirStore.setLocation(createPoint(new CoordinateDTO().setLatitude(40.9923307).setLongitude(29.1244229)));
        stores.add(atasehirStore);


        Store novadaStore = new Store();
        novadaStore.setName("Novada MMM Migros");
        novadaStore.setCity("Aydın");
        novadaStore.setDistrict("Novada");
        novadaStore.setLocation(createPoint(new CoordinateDTO().setLatitude(40.986106).setLongitude(29.1161293)));
        stores.add(novadaStore);

        Store beylikduzuStore = new Store();
        beylikduzuStore.setName("Beylikdüzü 5M Migros");
        beylikduzuStore.setCity("İstanbul");
        beylikduzuStore.setDistrict("Beylikdüzü");
        beylikduzuStore.setLocation(createPoint(new CoordinateDTO().setLatitude(41.0066851).setLongitude(28.6552262)));
        stores.add(beylikduzuStore);

        Store ortakoyStore = new Store();
        ortakoyStore.setName("Ortaköy MMM Migros");
        ortakoyStore.setCity("İstanbul");
        ortakoyStore.setDistrict("Ortaköy");
        ortakoyStore.setLocation(createPoint(new CoordinateDTO().setLatitude(41.055783).setLongitude(29.0210292)));
        stores.add(ortakoyStore);

        Store caddeStore = new Store();
        caddeStore.setName("Caddebostan MMM Migros");
        caddeStore.setCity("İstanbul");
        caddeStore.setDistrict("Caddebostan");
        caddeStore.setLocation(createPoint(new CoordinateDTO().setLatitude(40.9632463).setLongitude(29.0630908)));
        stores.add(caddeStore);
        storeService.saveAll(stores);

        Courier courier = new Courier();
        courier.setCity("İstanbul");
        courier.setDistrict("Caddebostan");

        courierService.save(courier);

    }

}