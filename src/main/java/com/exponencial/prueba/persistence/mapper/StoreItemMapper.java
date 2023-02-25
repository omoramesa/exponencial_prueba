package com.exponencial.prueba.persistence.mapper;

import com.exponencial.prueba.domain.StoreItem;
import com.exponencial.prueba.persistence.entity.TiendasProducto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface StoreItemMapper {
    @Mappings({
        @Mapping(source = "id.idProducto", target = "productId"),
        @Mapping(source = "cantidad", target = "quantity")
    })
    StoreItem toStoreProduct(TiendasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "tienda", ignore = true ),
            @Mapping(target = "producto", ignore = true ),
            @Mapping(target = "id.idTienda", ignore = true )
    })
    TiendasProducto toComprasProducto(StoreItem item);
}
