package com.exponencial.prueba.persistence.mapper;

import com.exponencial.prueba.domain.Store;
import com.exponencial.prueba.persistence.entity.Tienda;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StoreItemMapper.class})
public interface StoreMapper {
    @Mappings({
            @Mapping(source = "idTienda", target = "storeId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "productos", target = "items"),
    })
    Store toStore(Tienda tienda);
    List<Store> toStores(List<Tienda> tiendas);

    @InheritInverseConfiguration

    Tienda toTienda(Store store);
}
