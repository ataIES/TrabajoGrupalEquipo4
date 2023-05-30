CREATE DATABASE  IF NOT EXISTS `prestamos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `prestamos`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: prestamos
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `casados`
--

DROP TABLE IF EXISTS `casados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `casados` (
  `id` varchar(36) NOT NULL,
  `conyuge_id` varchar(36) NOT NULL,
  `regimen_matrimonial` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`,`conyuge_id`),
  KEY `fk_clientes_conyuges_casados` (`conyuge_id`),
  CONSTRAINT `fk_clientes_conyuges_casados` FOREIGN KEY (`conyuge_id`) REFERENCES `clientes` (`cliente_id`),
  CONSTRAINT `fk_clientes_id_casados` FOREIGN KEY (`id`) REFERENCES `clientes` (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casados`
--

LOCK TABLES `casados` WRITE;
/*!40000 ALTER TABLE `casados` DISABLE KEYS */;
INSERT INTO `casados` VALUES ('1d26d5a7-54fd-486d-b734-18942de73f44','e91c0a86-449f-42d6-b72b-97b5f8d73f2e',0),('3297d693-8e23-43e1-8e0d-51f9f9514f6e','c6528bdc-2b47-4894-ae63-47eb11e59d82',0),('432d8d8c-2e66-4149-848c-49894e4a1379','c0387914-d7a2-4d9e-a29a-8e8b110ea3be',1),('50482a89-5f3a-4317-af99-73c8f6dc4a9f','9e043fb0-2b5b-40c4-85af-75e29a1e968e',1),('5a5c2c91-896a-405c-a3e4-ef4f84435d49','c634f053-8d6f-40dd-8d89-d4c5d0df9682',0),('7b7e5d8b-169e-4b5e-82fb-1a568623b19c','9b5f1265-b86c-4a63-af3d-8c64072ff881',0),('86514d0d-0f45-4abf-9e0f-c04c64914a70','bff4c0d6-f2b6-41c1-8d62-35ea25ee3ed2',0),('9b5f1265-b86c-4a63-af3d-8c64072ff881','7b7e5d8b-169e-4b5e-82fb-1a568623b19c',0),('9e043fb0-2b5b-40c4-85af-75e29a1e968e','50482a89-5f3a-4317-af99-73c8f6dc4a9f',1),('bff4c0d6-f2b6-41c1-8d62-35ea25ee3ed2','86514d0d-0f45-4abf-9e0f-c04c64914a70',0),('c0387914-d7a2-4d9e-a29a-8e8b110ea3be','432d8d8c-2e66-4149-848c-49894e4a1379',1),('c634f053-8d6f-40dd-8d89-d4c5d0df9682','5a5c2c91-896a-405c-a3e4-ef4f84435d49',0),('c6528bdc-2b47-4894-ae63-47eb11e59d82','3297d693-8e23-43e1-8e0d-51f9f9514f6e',0),('e91c0a86-449f-42d6-b72b-97b5f8d73f2e','1d26d5a7-54fd-486d-b734-18942de73f44',0);
/*!40000 ALTER TABLE `casados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `cliente_id` varchar(36) NOT NULL,
  `DNI` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `localidad` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  PRIMARY KEY (`cliente_id`),
  UNIQUE KEY `DNI_UNIQUE` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('13a24cfd-5d3f-4f67-b61c-370824b5d4d7','21098765U','Marcos','Rivera','987654321','Callejon de los Deseos 802','Cadiz','1981-07-22'),('1d26d5a7-54fd-486d-b734-18942de73f44','87654321P','Victoria','Munoz','987654321','Avenida Imaginativa 791','Hospitalet de Llobregat','1999-08-11'),('21b78259-8217-4b5a-9971-1dbf9f06ef2e','54321098G','Javier','Castro','987654321','Paseo de los Deseos 468','Leganes','1982-04-09'),('2c2a9f02-2d13-4d81-9671-46e54f2c673f','21098765O','Nicolas','Moreno','987654321','Calle Ficticia 680','Gijon','1988-02-28'),('2f4e34a7-1c2a-4a3a-ba7e-6b0b0a22f83e','21098765E','Rafael','Mendoza','987654321','Avenida de la Invencion 246','Fuenlabrada','1990-01-12'),('3297d693-8e23-43e1-8e0d-51f9f9514f6e','90123456E','Mateo','Gonzalez','987654321','Callejon de los Suenos 543','Zaragoza','1990-05-18'),('3bfe0812-bf78-4a5b-a1eb-7341f0e18a43','54321098Y','Gabriel','Morales','987654321','Calle Irrealidad 680','Jerez de la Frontera','1997-03-14'),('410f3d39-693f-4e67-bb7b-7c4cb9a20217','01234567J','Camila','Torres','987654321','Calle Irrealidad 135','Bilbao','2001-04-09'),('432d8d8c-2e66-4149-848c-49894e4a1379','65432109V','Mariana','Ortega','987654321','Callejon de los Anhelos 357','Badalona','1998-09-15'),('4b25dd91-6624-4e74-948c-48254d9f9af7','21098765M','Carlos','Navarro','987654321','Plaza de la Invencion 024','Getafe','1996-08-11'),('50482a89-5f3a-4317-af99-73c8f6dc4a9f','87654321V','Elena','Cortes','987654321','Paseo Irreal 913','Jaen','1949-03-14'),('54b2405c-d497-4759-b2e4-51a47ab4e3e3','32109876T','Lucia','Silva','987654321','Calle de la Invencion 135','Elche','1943-01-19'),('5a5c2c91-896a-405c-a3e4-ef4f84435d49','32109876J','Daniela','Aguilar','987654321','Avenida de los Anhelos 791','Castellon de la Plana','1994-09-21'),('5b9b14de-d2d7-4a01-b4b4-d3c6f6280455','23456789G','Daniel','Perez','987654321','Calle de la Ilusion 876','Murcia','1997-08-30'),('61e0b930-5e8f-49d2-b8e7-4b1277c85e68','98765432S','Eduardo','Guzman','987654321','Calle Falsa 680','Tarragona','1991-09-15'),('682f54a3-9b12-4d61-93da-26b0e2730f69','54321098L','Valeria','Flores','987654321','Callejon de la Ilusion 357','Cordoba','1996-12-16'),('692a4e38-0347-4c33-8bb7-6a5b8f8d4575','76543210Q','Sergio','Figueroa','987654321','Paseo de los Suenos 468','Marbella','1999-01-19'),('6a7848be-599f-4a2a-940d-8409d9f7f22f','10987654R','Martina','Jimenez','987654321','Paseo Irreal 913','Vitoria-Gasteiz','1995-11-13'),('6b5c1e4e-8c87-4e11-bf49-13be7d3f45c3','12345678B','Sofia','Rodriguez','987654321','Avenida Imaginaria 456','Barcelona','1995-03-14'),('7b7e5d8b-169e-4b5e-82fb-1a568623b19c','76543210A','Adrian','Montes','987654321','Callejon de los Suenos 802','Santa Cruz de Tenerife','1994-09-29'),('7cbf430a-2b9e-4290-8c42-48c7f3d2d1e6','65432109N','Emma','Diaz','987654321','Plaza de la Imaginacion 579','Vigo','1994-07-05'),('7cd6e66a-9ed3-4e64-9447-1b3e7c62f02e','54321098W','Ricardo','Araya','987654321','Plaza de la Fantasia 024','Badajoz','1995-12-03'),('7e015e39-4b3b-4b99-9404-5e16587211f5','76543210I','Samuel','Leon','987654321','Calle de los Suenos 680','Santander','1989-12-16'),('832e2b6d-10de-4f22-86ea-267207797ab0','65432109D','Natalia','Rios','987654321','Calle Falsa 135','Pamplona','1983-08-30'),('854f8956-934d-46f1-bb94-21d9ae7e3f8a','56789012C','Lucas','Martinez','987654321','Paseo Inventado 789','Valencia','1982-12-03'),('86514d0d-0f45-4abf-9e0f-c04c64914a70','32109876R','Isadora','Vega','987654321','Plaza de la Imaginacion 579','Lleida','1950-10-01'),('8deedf13-d60b-43f7-92fe-614100a84736','10987654H','Paula','Vasquez','987654321','Plaza Irreal 579','San Sebastian','1997-10-02'),('8f1a125d-d6ab-4a6c-b2b3-f36c08040544','98765432U','Tomas','Herrera','987654321','Avenida Ficticia 246','Oviedo','1983-10-01'),('9204c1fb-97c7-4f0c-a77f-cf2df86ebbe2','54321098O','Gonzalo','Cardenas','987654321','Avenida de la Fantasia 246','Logrono','1992-11-13'),('9b5f1265-b86c-4a63-af3d-8c64072ff881','10987654Z','Gabriela','Castro','987654321','Avenida de la Imaginacion 791','Sabadell','1991-12-03'),('9e043fb0-2b5b-40c4-85af-75e29a1e968e','98765432M','Sebastian','Gomez','987654321','Paseo de los Suenos 468','Valladolid','1939-09-21'),('a3b4c383-58c9-4a3f-85c2-7ebf7c5a3831','78901234F','Isabella','Hernandez','987654321','Avenida Fantastica 210','Malaga','1992-11-07'),('a5a16f14-fb82-4e64-9e80-4316094b174a','32109876B','Juliana','Medina','987654321','Paseo Fantastico 913','Mostoles','1988-05-18'),('aab1374a-4974-4a8c-bf89-d7d6d7e1e21d','87654321N','Laura','Paredes','987654321','Calle Irrealidad 135','Salamanca','1981-03-24'),('b2d1e4c6-519e-4f45-94f5-4b8d3ac83d6c','87654321F','Fernanda','Cordero','987654321','Callejon de la Fantasia 357','Almeria','1932-06-25'),('b601a80c-7e2e-4017-96a1-2728e4383e2a','10987654X','Patricia','Soto','987654321','Calle de la Invencion 135','Toledo','1998-09-29'),('bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e','76543210S','Juan','Ruiz','987654321','Plaza de la Fantasia 024','Granada','1986-06-06'),('bff4c0d6-f2b6-41c1-8d62-35ea25ee3ed2','10987654P','Andrea','Ochoa','987654321','Callejon de la Ilusion 357','Huelva','1985-06-06'),('c0387914-d7a2-4d9e-a29a-8e8b110ea3be','21098765W','Andres','Vargas','987654321','Paseo de los Suenos 468','Terrassa','1989-04-08'),('c634f053-8d6f-40dd-8d89-d4c5d0df9682','98765432K','Emilio','Valdez','987654321','Callejon Imaginario 802','Burgos','1987-07-05'),('c6528bdc-2b47-4894-ae63-47eb11e59d82','34567890D','Valentina','Lopez','987654321','Plaza Irreal 987','Sevilla','1998-09-29'),('d82fd3a4-eb7b-4db0-8ee9-0e127f9b6b38','45678901I','Santiago','Romero','987654321','Plaza de los Suenos 321','Las Palmas de Gran Canaria','1987-06-25'),('ddf1bb2a-4d6d-4c66-9f24-45f7f867ef67','87654321X','Antonella','Nunez','987654321','Plaza de la Fantasia 579','Cartagena','1992-07-22'),('e86ce66b-3a49-4a32-9d6d-df492dbb1bda','65432109T','Antonia','Avila','987654321','Avenida de la Ilusion 791','Leon','1996-04-08'),('e91c0a86-449f-42d6-b72b-97b5f8d73f2e','54321098Q','Diego','Castro','987654321','Callejon de los Deseos 802','A Coruna','1984-03-24'),('e9f7b319-60a9-40e5-a6e4-7c3a593e1313','89012345H','Mia','Sanchez','987654321','Paseo de la Imaginacion 654','Palma de Mallorca','1946-01-12'),('f07c26af-739e-4b7d-8e37-0f132cbff6f2','98765432A','Alejandro','Garcia','987654321','Calle Falsa 123','Madrid','1999-07-22'),('f3e8a40b-6af3-4967-88b3-3e034bb20606','98765432C','Lucas','Espinoza','987654321','Plaza de la Ilusion 024','Alcala de Henares','2000-11-07'),('f6edc70c-7a0b-401f-8f4d-2210c801a9e3','65432109L','Carla','Cervantes','987654321','Paseo Ficticio 913','Albacete','1947-02-28'),('f9861fb8-8531-4a64-930b-493a8884a27f','87654321K','Matias','Ramirez','987654321','Avenida de la Fantasia 245','Alicante','1985-10-02');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `generar_uuid` BEFORE INSERT ON `clientes` FOR EACH ROW BEGIN
    SET NEW.cliente_id = UUID();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `iban` varchar(34) NOT NULL,
  `cliente_id` varchar(36) NOT NULL,
  `tipo_cuenta` varchar(20) DEFAULT NULL,
  `saldo` decimal(10,2) DEFAULT NULL,
  `cantidad_ultima_nomina` decimal(10,2) DEFAULT NULL,
  `cantidad_media_ultimos_12_meses` decimal(10,2) DEFAULT NULL,
  `meses_cotizados` int DEFAULT NULL,
  PRIMARY KEY (`iban`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `cuentas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES ('ES0919975408740791480907','5b9b14de-d2d7-4a01-b4b4-d3c6f6280455','CUENTA_CORRIENTE',6485.00,2200.00,2556.00,12),('ES1263843508952136517223','9204c1fb-97c7-4f0c-a77f-cf2df86ebbe2','CUENTA_CORRIENTE',9450.00,0.00,0.00,NULL),('ES1276933706951969933681','4b25dd91-6624-4e74-948c-48254d9f9af7','CUENTA_PERSONAL',8792.00,0.00,0.00,NULL),('ES1305415167625082467770','7cd6e66a-9ed3-4e64-9447-1b3e7c62f02e','CUENTA_PERSONAL',562.00,0.00,0.00,NULL),('ES1337129940717291584071','854f8956-934d-46f1-bb94-21d9ae7e3f8a','CUENTA_PERSONAL',7906.00,0.00,0.00,NULL),('ES1685266126335590499262','21b78259-8217-4b5a-9971-1dbf9f06ef2e','CUENTA_PERSONAL',9823.00,980.00,980.00,12),('ES1697253371667829519927','86514d0d-0f45-4abf-9e0f-c04c64914a70','CUENTA_CORRIENTE',9104.00,1127.00,1127.00,NULL),('ES1758905669409885569972','e91c0a86-449f-42d6-b72b-97b5f8d73f2e','CUENTA_CORRIENTE',153.00,0.00,0.00,NULL),('ES2199114055485690637360','2f4e34a7-1c2a-4a3a-ba7e-6b0b0a22f83e','CUENTA_CORRIENTE',5106.00,2678.00,3124.00,NULL),('ES2227890504058437806952','9b5f1265-b86c-4a63-af3d-8c64072ff881','CUENTA_CORRIENTE',1367.00,1327.00,1327.00,NULL),('ES2231581607908808759449','54b2405c-d497-4759-b2e4-51a47ab4e3e3','CUENTA_CORRIENTE',3074.00,2213.00,2213.00,NULL),('ES2591958528166528710726','432d8d8c-2e66-4149-848c-49894e4a1379','CUENTA_CORRIENTE',412.00,0.00,0.00,NULL),('ES2636826696182331111702','aab1374a-4974-4a8c-bf89-d7d6d7e1e21d','CUENTA_EMPRESA',5161.00,1647.00,1440.00,NULL),('ES2662383139844680857451','f9861fb8-8531-4a64-930b-493a8884a27f','CUENTA_CORRIENTE',4176.00,0.00,0.00,NULL),('ES2701693343033018621365','6b5c1e4e-8c87-4e11-bf49-13be7d3f45c3','CUENTA_EMPRESA',1275.00,1394.00,1500.00,NULL),('ES2845965916518814119421','3297d693-8e23-43e1-8e0d-51f9f9514f6e','CUENTA_CORRIENTE',9617.00,0.00,0.00,NULL),('ES2975714050821722630367','13a24cfd-5d3f-4f67-b61c-370824b5d4d7','CUENTA_PERSONAL',3245.00,1375.00,1604.00,NULL),('ES3012448913719880720605','5a5c2c91-896a-405c-a3e4-ef4f84435d49','CUENTA_PERSONAL',8836.00,0.00,0.00,NULL),('ES3272999926217431893465','b2d1e4c6-519e-4f45-94f5-4b8d3ac83d6c','CUENTA_CORRIENTE',790.00,1925.00,1925.00,NULL),('ES3612833662762460648084','a5a16f14-fb82-4e64-9e80-4316094b174a','CUENTA_PERSONAL',6279.00,0.00,0.00,NULL),('ES3662211731788779464526','8deedf13-d60b-43f7-92fe-614100a84736','CUENTA_CORRIENTE',6509.00,0.00,0.00,NULL),('ES3811987829150978658926','d82fd3a4-eb7b-4db0-8ee9-0e127f9b6b38','CUENTA_EMPRESA',2674.00,2621.00,2530.00,NULL),('ES3963925107716920297015','ddf1bb2a-4d6d-4c66-9f24-45f7f867ef67','CUENTA_CORRIENTE',2853.00,0.00,0.00,NULL),('ES4063079774065989109351','2c2a9f02-2d13-4d81-9671-46e54f2c673f','CUENTA_EMPRESA',4369.00,3147.00,3000.00,NULL),('ES4102672061996973096616','692a4e38-0347-4c33-8bb7-6a5b8f8d4575','CUENTA_CORRIENTE',3790.00,3696.00,4300.00,NULL),('ES4326635718406161601881','bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e','CUENTA_PERSONAL',9251.00,3100.00,3620.00,12),('ES4601282398987173811089','f07c26af-739e-4b7d-8e37-0f132cbff6f2','CUENTA_CORRIENTE',3849.00,1972.00,2300.00,13),('ES5082497751287902153367','3bfe0812-bf78-4a5b-a1eb-7341f0e18a43','CUENTA_PERSONAL',9936.00,4642.00,5415.00,NULL),('ES5200446471544570658321','c6528bdc-2b47-4894-ae63-47eb11e59d82','CUENTA_CORRIENTE',542.00,2065.00,2409.00,NULL),('ES5254012972339373207555','50482a89-5f3a-4317-af99-73c8f6dc4a9f','CUENTA_PERSONAL',6519.00,2050.00,2050.00,1),('ES5973030366043146607396','f6edc70c-7a0b-401f-8f4d-2210c801a9e3','CUENTA_PERSONAL',1975.00,1736.00,1736.00,NULL),('ES6243211818664878441479','bff4c0d6-f2b6-41c1-8d62-35ea25ee3ed2','CUENTA_PERSONAL',7033.00,0.00,0.00,NULL),('ES6544060214620362783384','61e0b930-5e8f-49d2-b8e7-4b1277c85e68','CUENTA_PERSONAL',2487.00,4018.00,4687.00,NULL),('ES6576281118573787259326','8f1a125d-d6ab-4a6c-b2b3-f36c08040544','CUENTA_EMPRESA',5908.00,5812.00,5200.00,NULL),('ES6624186071335802764577','832e2b6d-10de-4f22-86ea-267207797ab0','CUENTA_PERSONAL',993.00,0.00,0.00,NULL),('ES6728092567241695472653','682f54a3-9b12-4d61-93da-26b0e2730f69','CUENTA_PERSONAL',5791.00,0.00,0.00,NULL),('ES6778471109049021970105','7cbf430a-2b9e-4290-8c42-48c7f3d2d1e6','CUENTA_PERSONAL',6982.00,5138.00,5994.00,NULL),('ES7128022998740051457461','e9f7b319-60a9-40e5-a6e4-7c3a593e1313','CUENTA_PERSONAL',813.00,2458.00,2458.00,NULL),('ES7304468749008831749487','f3e8a40b-6af3-4967-88b3-3e034bb20606','CUENTA_PERSONAL',3481.00,0.00,0.00,NULL),('ES7378712863636435723897','b601a80c-7e2e-4017-96a1-2728e4383e2a','CUENTA_CORRIENTE',9861.00,1200.00,1400.00,NULL),('ES7781973007339188473464','6a7848be-599f-4a2a-940d-8409d9f7f22f','CUENTA_CORRIENTE',6745.00,0.00,0.00,NULL),('ES7951731901229198214608','c0387914-d7a2-4d9e-a29a-8e8b110ea3be','CUENTA_PERSONAL',8647.00,0.00,0.00,NULL),('ES8007151353620826883504','410f3d39-693f-4e67-bb7b-7c4cb9a20217','CUENTA_CORRIENTE',9027.00,0.00,0.00,NULL),('ES8743004184944569246736','7b7e5d8b-169e-4b5e-82fb-1a568623b19c','CUENTA_EMPRESA',7564.00,3401.00,3616.00,NULL),('ES8781064520855308505013','1d26d5a7-54fd-486d-b734-18942de73f44','CUENTA_PERSONAL',8240.00,0.00,0.00,NULL),('ES8907240172567995095933','c634f053-8d6f-40dd-8d89-d4c5d0df9682','CUENTA_CORRIENTE',4610.00,1178.00,1374.00,NULL),('ES8931453136508178578743','e86ce66b-3a49-4a32-9d6d-df492dbb1bda','CUENTA_PERSONAL',7942.00,0.00,0.00,NULL),('ES8978977364021892092496','a3b4c383-58c9-4a3f-85c2-7ebf7c5a3831','CUENTA_PERSONAL',3098.00,0.00,0.00,NULL),('ES9276361651787464427753','7e015e39-4b3b-4b99-9404-5e16587211f5','CUENTA_PERSONAL',2291.00,0.00,0.00,NULL),('ES9584549493074216500139','9e043fb0-2b5b-40c4-85af-75e29a1e968e','CUENTA_CORRIENTE',14425.00,1056.00,1056.00,12);
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `numero_operacion` int NOT NULL AUTO_INCREMENT,
  `cliente_id` varchar(36) NOT NULL,
  `cantidad` decimal(10,2) DEFAULT NULL,
  `concepto` varchar(50) DEFAULT NULL,
  `emisor` varchar(50) DEFAULT NULL,
  `destinatario` varchar(50) DEFAULT NULL,
  `tipo_movimiento` varchar(50) DEFAULT NULL,
  `fecha` date DEFAULT (curdate()),
  PRIMARY KEY (`numero_operacion`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',1972.00,'','','ES4601282398987173811089','NOMINA','2023-05-24'),(2,'692a4e38-0347-4c33-8bb7-6a5b8f8d4575',-272.00,'','','ES4102672061996973096616','PAGO_TARJETA','2022-06-24'),(3,'c634f053-8d6f-40dd-8d89-d4c5d0df9682',-986.00,'','','ES8907240172567995095933','RETIRADA_CAJERO','2022-07-24'),(4,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',1972.00,'','','ES4601282398987173811089','NOMINA','2023-04-24'),(5,'c634f053-8d6f-40dd-8d89-d4c5d0df9682',-697.00,'','','ES8907240172567995095933','RETIRADA_CAJERO','2022-09-24'),(6,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',2300.00,'','','ES4601282398987173811089','NOMINA','2023-03-24'),(7,'692a4e38-0347-4c33-8bb7-6a5b8f8d4575',-805.00,'','','ES4102672061996973096616','PAGO_TARJETA','2022-11-24'),(8,'432d8d8c-2e66-4149-848c-49894e4a1379',-142.00,'','','ES2591958528166528710726','BIZUM','2022-12-24'),(9,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',1972.00,'','','ES4601282398987173811089','NOMINA','2023-02-24'),(10,'7cd6e66a-9ed3-4e64-9447-1b3e7c62f02e',-379.00,'','','ES1305415167625082467770','RECIBO','2023-02-24'),(11,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',1972.00,'','','ES4601282398987173811089','NOMINA','2023-01-24'),(12,'7e015e39-4b3b-4b99-9404-5e16587211f5',-236.00,'','','ES9276361651787464427753','RECIBO','2023-04-24'),(13,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',2300.00,'','','ES4601282398987173811089','NOMINA','2022-12-24'),(14,'ddf1bb2a-4d6d-4c66-9f24-45f7f867ef67',-168.00,'','','ES3963925107716920297015','PAGO_TARJETA','2023-05-24'),(15,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',1972.00,'','','ES4601282398987173811089','NOMINA','2022-11-24'),(16,'7e015e39-4b3b-4b99-9404-5e16587211f5',-482.00,'','','ES9276361651787464427753','RETIRADA_CAJERO','2023-05-24'),(17,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',1972.00,'','','ES4601282398987173811089','NOMINA','2022-10-24'),(18,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',1972.00,'','','ES4601282398987173811089','NOMINA','2022-09-25'),(19,'ddf1bb2a-4d6d-4c66-9f24-45f7f867ef67',-758.00,'','','ES3963925107716920297015','RECIBO','2023-05-24'),(20,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',1972.00,'','','ES4601282398987173811089','NOMINA','2022-08-24'),(21,'682f54a3-9b12-4d61-93da-26b0e2730f69',-946.00,'','','ES6728092567241695472653','RETIRADA_CAJERO','2023-05-24'),(22,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',1972.00,'','','ES4601282398987173811089','NOMINA','2022-07-24'),(23,'692a4e38-0347-4c33-8bb7-6a5b8f8d4575',-669.00,'','','ES4102672061996973096616','BIZUM','2023-05-24'),(24,'692a4e38-0347-4c33-8bb7-6a5b8f8d4575',-570.00,'','','ES4102672061996973096616','RECIBO','2023-05-24'),(25,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',1972.00,'','','ES4601282398987173811089','NOMINA','2022-06-24'),(26,'7cd6e66a-9ed3-4e64-9447-1b3e7c62f02e',112.00,'','','ES1305415167625082467770','BIZUM','2023-05-24'),(27,'682f54a3-9b12-4d61-93da-26b0e2730f69',-913.00,'','','ES6728092567241695472653','PAGO_TARJETA','2023-05-24'),(28,'c634f053-8d6f-40dd-8d89-d4c5d0df9682',726.00,'','','ES8907240172567995095933','BIZUM','2023-05-24'),(29,'682f54a3-9b12-4d61-93da-26b0e2730f69',-308.00,'','','ES6728092567241695472653','RETIRADA_CAJERO','2023-05-24'),(30,'bff4c0d6-f2b6-41c1-8d62-35ea25ee3ed2',-582.00,'','','ES6243211818664878441479','BIZUM','2023-05-24'),(31,'692a4e38-0347-4c33-8bb7-6a5b8f8d4575',-971.00,'','','ES4102672061996973096616','RETIRADA_CAJERO','2023-05-24'),(32,'7cd6e66a-9ed3-4e64-9447-1b3e7c62f02e',143.00,'','','ES1305415167625082467770','DEPOSITO','2023-05-24'),(33,'e9f7b319-60a9-40e5-a6e4-7c3a593e1313',-523.00,'','','ES7128022998740051457461','RECIBO','2023-05-24'),(34,'c634f053-8d6f-40dd-8d89-d4c5d0df9682',437.00,'','','ES8907240172567995095933','DEPOSITO','2023-05-24'),(35,'50482a89-5f3a-4317-af99-73c8f6dc4a9f',2050.00,'','','ES5254012972339373207555','NOMINA','2023-05-24'),(36,'b2d1e4c6-519e-4f45-94f5-4b8d3ac83d6c',-174.00,'','','ES3272999926217431893465','BIZUM','2023-05-24'),(37,'692a4e38-0347-4c33-8bb7-6a5b8f8d4575',691.00,'','','ES4102672061996973096616','DEPOSITO','2023-05-24'),(38,'50482a89-5f3a-4317-af99-73c8f6dc4a9f',-330.00,'','','ES5254012972339373207555','RECIBO','2023-05-24'),(39,'50482a89-5f3a-4317-af99-73c8f6dc4a9f',-625.00,'','','ES5254012972339373207555','RETIRADA_CAJERO','2023-05-24'),(40,'50482a89-5f3a-4317-af99-73c8f6dc4a9f',-797.00,'','','ES5254012972339373207555','RETIRADA_CAJERO','2023-05-24'),(41,'c634f053-8d6f-40dd-8d89-d4c5d0df9682',115.00,'','','ES8907240172567995095933','BIZUM','2023-05-24'),(42,'86514d0d-0f45-4abf-9e0f-c04c64914a70',-949.00,'','','ES1697253371667829519927','RECIBO','2023-05-24'),(43,'86514d0d-0f45-4abf-9e0f-c04c64914a70',-676.00,'','','ES1697253371667829519927','RETIRADA_CAJERO','2023-05-24'),(44,'86514d0d-0f45-4abf-9e0f-c04c64914a70',-580.00,'','','ES1697253371667829519927','RETIRADA_CAJERO','2023-05-24'),(45,'86514d0d-0f45-4abf-9e0f-c04c64914a70',-429.00,'','','ES1697253371667829519927','BIZUM','2023-05-24'),(46,'692a4e38-0347-4c33-8bb7-6a5b8f8d4575',854.00,'','','ES4102672061996973096616','DEPOSITO','2023-05-24'),(47,'bff4c0d6-f2b6-41c1-8d62-35ea25ee3ed2',-607.00,'','','ES6243211818664878441479','RECIBO','2023-05-24'),(48,'50482a89-5f3a-4317-af99-73c8f6dc4a9f',-762.00,'','','ES5254012972339373207555','RETIRADA_CAJERO','2023-05-24'),(49,'f07c26af-739e-4b7d-8e37-0f132cbff6f2',1972.00,'','','ES4601282398987173811089','NOMINA','2022-05-24'),(50,'c634f053-8d6f-40dd-8d89-d4c5d0df9682',-995.00,'','','ES8907240172567995095933','RETIRADA_CAJERO','2023-05-24'),(51,'5b9b14de-d2d7-4a01-b4b4-d3c6f6280455',2200.00,'','','ES0919975408740791480907','NOMINA','2023-04-25'),(52,'5b9b14de-d2d7-4a01-b4b4-d3c6f6280455',4400.00,'','','ES0919975408740791480907','NOMINA','2023-03-25'),(53,'5b9b14de-d2d7-4a01-b4b4-d3c6f6280455',2200.00,'','','ES0919975408740791480907','NOMINA','2023-02-25'),(54,'5b9b14de-d2d7-4a01-b4b4-d3c6f6280455',2200.00,'','','ES0919975408740791480907','NOMINA','2023-01-25'),(55,'5b9b14de-d2d7-4a01-b4b4-d3c6f6280455',2200.00,'','','ES0919975408740791480907','NOMINA','2022-12-25'),(56,'5b9b14de-d2d7-4a01-b4b4-d3c6f6280455',2200.00,'','','ES0919975408740791480907','NOMINA','2022-11-25'),(57,'5b9b14de-d2d7-4a01-b4b4-d3c6f6280455',2200.00,'','','ES0919975408740791480907','NOMINA','2022-10-25'),(58,'5b9b14de-d2d7-4a01-b4b4-d3c6f6280455',2200.00,'','','ES0919975408740791480907','NOMINA','2022-09-25'),(59,'5b9b14de-d2d7-4a01-b4b4-d3c6f6280455',4400.00,'','','ES0919975408740791480907','NOMINA','2022-08-25'),(60,'5b9b14de-d2d7-4a01-b4b4-d3c6f6280455',2200.00,'','','ES0919975408740791480907','NOMINA','2022-07-25'),(61,'5b9b14de-d2d7-4a01-b4b4-d3c6f6280455',2200.00,'','','ES0919975408740791480907','NOMINA','2022-06-25'),(62,'5b9b14de-d2d7-4a01-b4b4-d3c6f6280455',2200.00,'','','ES0919975408740791480907','NOMINA','2022-05-25'),(64,'bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e',3100.00,'','','ES4326635718406161601881','NOMINA','2023-04-25'),(65,'bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e',6200.00,'','','ES4326635718406161601882','NOMINA','2023-03-25'),(66,'bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e',3100.00,'','','ES4326635718406161601883','NOMINA','2023-02-25'),(67,'bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e',3100.00,'','','ES4326635718406161601884','NOMINA','2023-01-25'),(68,'bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e',3100.00,'','','ES4326635718406161601885','NOMINA','2022-12-25'),(69,'bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e',3100.00,'','','ES4326635718406161601886','NOMINA','2022-11-25'),(70,'bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e',3100.00,'','','ES4326635718406161601887','NOMINA','2022-10-25'),(71,'bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e',3100.00,'','','ES4326635718406161601888','NOMINA','2022-09-25'),(72,'bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e',6200.00,'','','ES4326635718406161601889','NOMINA','2022-08-25'),(73,'bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e',3100.00,'','','ES4326635718406161601890','NOMINA','2022-07-25'),(74,'bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e',3100.00,'','','ES4326635718406161601891','NOMINA','2022-06-25'),(75,'bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e',3100.00,'','','ES4326635718406161601892','NOMINA','2022-05-25'),(76,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499262','NOMINA','2023-04-25'),(77,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499263','NOMINA','2023-03-25'),(78,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499264','NOMINA','2023-02-25'),(79,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499265','NOMINA','2023-01-25'),(80,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499266','NOMINA','2022-12-25'),(81,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499267','NOMINA','2022-11-25'),(82,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499268','NOMINA','2022-10-25'),(83,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499269','NOMINA','2022-09-25'),(84,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499270','NOMINA','2022-08-25'),(85,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499271','NOMINA','2022-07-25'),(86,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499272','NOMINA','2022-06-25'),(87,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499273','NOMINA','2022-05-25'),(88,'21b78259-8217-4b5a-9971-1dbf9f06ef2e',980.00,'','','ES1685266126335590499274','NOMINA','2022-04-25'),(89,'9e043fb0-2b5b-40c4-85af-75e29a1e968e',1056.00,'','','ES9584549493074216500139','NOMINA','2023-04-25'),(90,'9e043fb0-2b5b-40c4-85af-75e29a1e968e',1056.00,'','','ES9584549493074216500140','NOMINA','2023-03-25'),(91,'9e043fb0-2b5b-40c4-85af-75e29a1e968e',1056.00,'','','ES9584549493074216500141','NOMINA','2023-02-25'),(92,'9e043fb0-2b5b-40c4-85af-75e29a1e968e',1056.00,'','','ES9584549493074216500142','NOMINA','2023-01-25'),(93,'9e043fb0-2b5b-40c4-85af-75e29a1e968e',1056.00,'','','ES9584549493074216500143','NOMINA','2022-12-25'),(94,'9e043fb0-2b5b-40c4-85af-75e29a1e968e',1056.00,'','','ES9584549493074216500144','NOMINA','2022-11-25'),(95,'9e043fb0-2b5b-40c4-85af-75e29a1e968e',1056.00,'','','ES9584549493074216500145','NOMINA','2022-10-25'),(96,'9e043fb0-2b5b-40c4-85af-75e29a1e968e',1056.00,'','','ES9584549493074216500146','NOMINA','2022-09-25'),(97,'9e043fb0-2b5b-40c4-85af-75e29a1e968e',1056.00,'','','ES9584549493074216500147','NOMINA','2022-08-25'),(98,'9e043fb0-2b5b-40c4-85af-75e29a1e968e',1056.00,'','','ES9584549493074216500148','NOMINA','2022-07-25'),(99,'9e043fb0-2b5b-40c4-85af-75e29a1e968e',1056.00,'','','ES9584549493074216500149','NOMINA','2022-06-25'),(100,'9e043fb0-2b5b-40c4-85af-75e29a1e968e',1056.00,'','','ES9584549493074216500150','NOMINA','2022-05-25');
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `actualiza_saldo` AFTER INSERT ON `movimientos` FOR EACH ROW BEGIN
  DECLARE saldo_actual DECIMAL(10,2);
  
  SELECT saldo INTO saldo_actual
  FROM Cuentas
  WHERE cliente_id = NEW.cliente_id;
  
  IF NEW.cantidad > 0 THEN
    SET saldo_actual = saldo_actual + NEW.cantidad;
  ELSE
    SET saldo_actual = saldo_actual - ABS(NEW.cantidad);
  END IF;
  
  UPDATE Cuentas
  SET saldo = saldo_actual
  WHERE cliente_id = NEW.cliente_id;
  
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `actualiza_nomina` AFTER INSERT ON `movimientos` FOR EACH ROW BEGIN
  IF NEW.tipo_movimiento = 'NOMINA' THEN
    UPDATE Cuentas
    SET cantidad_ultima_nomina = NEW.cantidad
    WHERE cliente_id = NEW.cliente_id;
  END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `calcula_media_nomina` AFTER INSERT ON `movimientos` FOR EACH ROW BEGIN
  DECLARE fecha_actual DATE;
  DECLARE fecha_inicio DATE;
  DECLARE fecha_fin DATE;
  DECLARE total DECIMAL(10,2);
  DECLARE contador INT;
  
  SET fecha_actual = CURDATE();
  SET fecha_inicio = DATE_SUB(fecha_actual, INTERVAL 12 MONTH);
  SET fecha_fin = DATE_SUB(fecha_actual, INTERVAL 1 DAY);
  
  SELECT COUNT(*) INTO contador
  FROM Movimientos
  WHERE cliente_id = NEW.cliente_id
  AND tipo_movimiento = 'NOMINA'
  AND fecha BETWEEN fecha_inicio AND fecha_fin;
  
  IF contador = 12 THEN
    SELECT AVG(cantidad) INTO total
    FROM Movimientos
    WHERE cliente_id = NEW.cliente_id
    AND tipo_movimiento = 'NOMINA'
    AND fecha BETWEEN fecha_inicio AND fecha_fin;
  ELSE
    SET total = 0;
  END IF;
  
  UPDATE Cuentas
  SET cantidad_media_ultimos_12_meses = total
  WHERE cliente_id = NEW.cliente_id;
  
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `mesesNomina` AFTER INSERT ON `movimientos` FOR EACH ROW BEGIN
    UPDATE cuentas
    SET meses_cotizados = (
        SELECT COUNT(tipo_movimiento)
        FROM movimientos
        WHERE tipo_movimiento = 'NOMINA' 
        AND fecha BETWEEN DATE_SUB(CURDATE(), INTERVAL 13 MONTH) AND CURDATE() 
        AND cliente_id = NEW.cliente_id
        GROUP BY cliente_id
    )
    WHERE cliente_id = NEW.cliente_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagos` (
  `numero_pago` int NOT NULL AUTO_INCREMENT,
  `numero_prestamo` int DEFAULT NULL,
  `fecha_pago` date DEFAULT NULL,
  `cantidad_pagada` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`numero_pago`),
  KEY `numero_prestamo` (`numero_prestamo`),
  CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`numero_prestamo`) REFERENCES `prestamosconcedidos` (`numero_prestamo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfiles` (
  `cliente_id` varchar(36) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `situacion_civil` varchar(20) DEFAULT NULL,
  `situacion_laboral` varchar(20) DEFAULT NULL,
  `moroso` tinyint(1) DEFAULT NULL,
  `proceso_judicial` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`),
  CONSTRAINT `perfiles_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles`
--

LOCK TABLES `perfiles` WRITE;
/*!40000 ALTER TABLE `perfiles` DISABLE KEYS */;
INSERT INTO `perfiles` VALUES ('13a24cfd-5d3f-4f67-b61c-370824b5d4d7','marcos48','21232f297a57a5a743894a0e4a801fc3','CASADO','CUENTA_AJENA',0,0),('1d26d5a7-54fd-486d-b734-18942de73f44','victoria17','5f4dcc3b5aa765d61d8327deb882cf99','CASADO','DESEMPLEADO',0,0),('21b78259-8217-4b5a-9971-1dbf9f06ef2e','javier34','21232f297a57a5a743894a0e4a801fc3','SOLTERO','CUENTA_PROPIA',0,0),('2c2a9f02-2d13-4d81-9671-46e54f2c673f','nicolas88','098f6bcd4621d373cade4e832627b4f6','SOLTERO','CUENTA_PROPIA',1,0),('2f4e34a7-1c2a-4a3a-ba7e-6b0b0a22f83e','rafael32','e10adc3949ba59abbe56e057f20f883e','SOLTERO','CUENTA_AJENA',1,1),('3297d693-8e23-43e1-8e0d-51f9f9514f6e','mateo90','21232f297a57a5a743894a0e4a801fc3','CASADO','AMO_DE_CASA',1,1),('3bfe0812-bf78-4a5b-a1eb-7341f0e18a43','gabriel87','25d55ad283aa400af464c76d713c07ad','SOLTERO','CUENTA_AJENA',1,1),('410f3d39-693f-4e67-bb7b-7c4cb9a20217','camila01','e10adc3949ba59abbe56e057f20f883e','CASADO','AMO_DE_CASA',0,1),('432d8d8c-2e66-4149-848c-49894e4a1379','mariana98','098f6bcd4621d373cade4e832627b4f6','CASADO','DESEMPLEADO',0,0),('4b25dd91-6624-4e74-948c-48254d9f9af7','carlos40','25d55ad283aa400af464c76d713c07ad','SOLTERO','AMO_DE_CASA',1,1),('50482a89-5f3a-4317-af99-73c8f6dc4a9f','elena49','827ccb0eea8a706c4c34a16891f84e7b','CASADO','PENSIONISTA',0,1),('54b2405c-d497-4759-b2e4-51a47ab4e3e3','lucia00','827ccb0eea8a706c4c34a16891f84e7b','SOLTERO','PENSIONISTA',0,1),('5a5c2c91-896a-405c-a3e4-ef4f84435d49','daniela37','098f6bcd4621d373cade4e832627b4f6','CASADO','DESEMPLEADO',0,1),('5b9b14de-d2d7-4a01-b4b4-d3c6f6280455','daniel97','d8578edf8458ce06fbc5bb76a58c5ca4','CASADO','CUENTA_AJENA',0,0),('61e0b930-5e8f-49d2-b8e7-4b1277c85e68','eduardo46','e10adc3949ba59abbe56e057f20f883e','SOLTERO','CUENTA_PROPIA',1,1),('682f54a3-9b12-4d61-93da-26b0e2730f69','valeria96','21232f297a57a5a743894a0e4a801fc3','CASADO','ESTUDIANTE',1,1),('692a4e38-0347-4c33-8bb7-6a5b8f8d4575','sergio44','098f6bcd4621d373cade4e832627b4f6','SOLTERO','CUENTA_AJENA',0,1),('6a7848be-599f-4a2a-940d-8409d9f7f22f','martina19','25d55ad283aa400af464c76d713c07ad','SOLTERO','AMO_DE_CASA',1,0),('6b5c1e4e-8c87-4e11-bf49-13be7d3f45c3','sofia95','5f4dcc3b5aa765d61d8327deb882cf99','SOLTERO','CUENTA_PROPIA',1,0),('7b7e5d8b-169e-4b5e-82fb-1a568623b19c','adrian28','827ccb0eea8a706c4c34a16891f84e7b','CASADO','CUENTA_PROPIA',0,0),('7cbf430a-2b9e-4290-8c42-48c7f3d2d1e6','emma94','d8578edf8458ce06fbc5bb76a58c5ca4','SOLTERO','CUENTA_AJENA',1,1),('7cd6e66a-9ed3-4e64-9447-1b3e7c62f02e','ricardo50','d8578edf8458ce06fbc5bb76a58c5ca4','SOLTERO','ESTUDIANTE',0,0),('7e015e39-4b3b-4b99-9404-5e16587211f5','samuel36','d8578edf8458ce06fbc5bb76a58c5ca4','SOLTERO','ESTUDIANTE',1,0),('832e2b6d-10de-4f22-86ea-267207797ab0','natalia31','5f4dcc3b5aa765d61d8327deb882cf99','CASADO','DESEMPLEADO',0,0),('854f8956-934d-46f1-bb94-21d9ae7e3f8a','lucas82','e10adc3949ba59abbe56e057f20f883e','SOLTERO','DESEMPLEADO',0,0),('86514d0d-0f45-4abf-9e0f-c04c64914a70','isadora45','5f4dcc3b5aa765d61d8327deb882cf99','CASADO','PENSIONISTA',0,0),('8deedf13-d60b-43f7-92fe-614100a84736','paula35','827ccb0eea8a706c4c34a16891f84e7b','SOLTERO','AMO_DE_CASA',0,1),('8f1a125d-d6ab-4a6c-b2b3-f36c08040544','tomas83','d8578edf8458ce06fbc5bb76a58c5ca4','SOLTERO','CUENTA_PROPIA',1,0),('9204c1fb-97c7-4f0c-a77f-cf2df86ebbe2','gonzalo42','827ccb0eea8a706c4c34a16891f84e7b','CASADO','ESTUDIANTE',1,0),('9b5f1265-b86c-4a63-af3d-8c64072ff881','gabriela27','21232f297a57a5a743894a0e4a801fc3','CASADO','PENSIONISTA',0,1),('9e043fb0-2b5b-40c4-85af-75e29a1e968e','sebastian91','827ccb0eea8a706c4c34a16891f84e7b','CASADO','PENSIONISTA',0,0),('a3b4c383-58c9-4a3f-85c2-7ebf7c5a3831','isabella92','827ccb0eea8a706c4c34a16891f84e7b','SOLTERO','ESTUDIANTE',1,0),('a5a16f14-fb82-4e64-9e80-4316094b174a','juliana29','d8578edf8458ce06fbc5bb76a58c5ca4','SOLTERO','AMO_DE_CASA',1,1),('aab1374a-4974-4a8c-bf89-d7d6d7e1e21d','laura41','21232f297a57a5a743894a0e4a801fc3','CASADO','CUENTA_PROPIA',0,0),('b2d1e4c6-519e-4f45-94f5-4b8d3ac83d6c','fernanda33','25d55ad283aa400af464c76d713c07ad','CASADO','PENSIONISTA',0,0),('b601a80c-7e2e-4017-96a1-2728e4383e2a','patricia69','098f6bcd4621d373cade4e832627b4f6','SOLTERO','CUENTA_PROPIA',1,1),('bf6a90e2-6e6c-49b0-b9e6-2ae579eb867e','juan86','21232f297a57a5a743894a0e4a801fc3','CASADO','CUENTA_AJENA',0,0),('bff4c0d6-f2b6-41c1-8d62-35ea25ee3ed2','andrea43','d8578edf8458ce06fbc5bb76a58c5ca4','CASADO','DESEMPLEADO',1,1),('c0387914-d7a2-4d9e-a29a-8e8b110ea3be','andres89','5f4dcc3b5aa765d61d8327deb882cf99','CASADO','ESTUDIANTE',1,1),('c634f053-8d6f-40dd-8d89-d4c5d0df9682','emilio38','5f4dcc3b5aa765d61d8327deb882cf99','CASADO','CUENTA_AJENA',0,1),('c6528bdc-2b47-4894-ae63-47eb11e59d82','valentina98','25d55ad283aa400af464c76d713c07ad','CASADO','CUENTA_AJENA',0,1),('d82fd3a4-eb7b-4db0-8ee9-0e127f9b6b38','santiago87','5f4dcc3b5aa765d61d8327deb882cf99','SOLTERO','CUENTA_PROPIA',1,1),('ddf1bb2a-4d6d-4c66-9f24-45f7f867ef67','antonella92','e10adc3949ba59abbe56e057f20f883e','CASADO','AMO_DE_CASA',1,0),('e86ce66b-3a49-4a32-9d6d-df492dbb1bda','antonia47','25d55ad283aa400af464c76d713c07ad','SOLTERO','AMO_DE_CASA',1,1),('e91c0a86-449f-42d6-b72b-97b5f8d73f2e','diego84','e10adc3949ba59abbe56e057f20f883e','CASADO','ESTUDIANTE',1,1),('e9f7b319-60a9-40e5-a6e4-7c3a593e1313','mia93','098f6bcd4621d373cade4e832627b4f6','SOLTERO','PENSIONISTA',1,1),('f07c26af-739e-4b7d-8e37-0f132cbff6f2','alejandro89','098f6bcd4621d373cade4e832627b4f6','CASADO','CUENTA_AJENA',0,0),('f3e8a40b-6af3-4967-88b3-3e034bb20606','lucas30','098f6bcd4621d373cade4e832627b4f6','SOLTERO','ESTUDIANTE',1,1),('f6edc70c-7a0b-401f-8f4d-2210c801a9e3','carla39','e10adc3949ba59abbe56e057f20f883e','SOLTERO','PENSIONISTA',1,0),('f9861fb8-8531-4a64-930b-493a8884a27f','matias85','25d55ad283aa400af464c76d713c07ad','SOLTERO','DESEMPLEADO',0,0);
/*!40000 ALTER TABLE `perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamosconcedidos`
--

DROP TABLE IF EXISTS `prestamosconcedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamosconcedidos` (
  `numero_prestamo` int NOT NULL AUTO_INCREMENT,
  `cliente_id` varchar(36) NOT NULL,
  `fecha_firma` date DEFAULT NULL,
  `numero_prestamo_preconcedido` int DEFAULT NULL,
  `cantidad_mensual` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`numero_prestamo`),
  KEY `cliente_id` (`cliente_id`),
  KEY `numero_prestamo_preconcedido` (`numero_prestamo_preconcedido`),
  CONSTRAINT `prestamosconcedidos_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`cliente_id`),
  CONSTRAINT `prestamosconcedidos_ibfk_2` FOREIGN KEY (`numero_prestamo_preconcedido`) REFERENCES `prestamospreconcedidos` (`numero_prestamo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamosconcedidos`
--

LOCK TABLES `prestamosconcedidos` WRITE;
/*!40000 ALTER TABLE `prestamosconcedidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamosconcedidos` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `actualizar_firma` AFTER INSERT ON `prestamosconcedidos` FOR EACH ROW BEGIN
    UPDATE prestamospreconcedidos
    SET firmado = 1
    WHERE numero_prestamo = NEW.numero_prestamo_preconcedido;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `prestamospreconcedidos`
--

DROP TABLE IF EXISTS `prestamospreconcedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamospreconcedidos` (
  `numero_prestamo` int NOT NULL AUTO_INCREMENT,
  `cliente_id` varchar(36) NOT NULL,
  `fecha_oferta` date DEFAULT NULL,
  `cantidad` decimal(10,2) DEFAULT NULL,
  `periodo_meses` int DEFAULT NULL,
  `tipo_interes` decimal(5,2) DEFAULT NULL,
  `plazo_aceptacion_dias` int DEFAULT NULL,
  `firmado` tinyint DEFAULT '0',
  PRIMARY KEY (`numero_prestamo`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `prestamospreconcedidos_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamospreconcedidos`
--

LOCK TABLES `prestamospreconcedidos` WRITE;
/*!40000 ALTER TABLE `prestamospreconcedidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamospreconcedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'prestamos'
--

--
-- Dumping routines for database 'prestamos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-29 10:00:51
