-- -----------------------------------------------------
-- Table "PRODUCTOS"
-- -----------------------------------------------------
CREATE TABLE  PRODUCTOS (
  "id_producto" SERIAL NOT NULL,
  "nombre" VARCHAR(45) NULL,
  "descripcion" VARCHAR(45) NULL,
  "precio" DECIMAL(16,2) NULL,
  "imagen" VARCHAR(150) NULL,
  PRIMARY KEY ("id_producto")
);


-- -----------------------------------------------------
-- Table "TIENDAS"
-- -----------------------------------------------------
CREATE TABLE  TIENDAS (
  "id_tienda" SERIAL NOT NULL,
  "nombre" VARCHAR(20) NOT NULL,
  PRIMARY KEY ("id_tienda") 
);


-- -----------------------------------------------------
-- Table "TIENDAS_PRODUCTOS"
-- -----------------------------------------------------
CREATE TABLE  TIENDAS_PRODUCTOS (
  "id_tienda" INT NOT NULL,
  "id_producto" INT NOT NULL,
  "cantidad" INT NULL,
  PRIMARY KEY ("id_tienda", "id_producto"),
  CONSTRAINT "fk_TIENDAS_PRODUCTOS_PRODUCTOS1"
    FOREIGN KEY ("id_producto")
    REFERENCES PRODUCTOS ("id_producto")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_TIENDAS_PRODUCTOS_TIENDAS1"
    FOREIGN KEY ("id_tienda")
    REFERENCES TIENDAS ("id_tienda")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);