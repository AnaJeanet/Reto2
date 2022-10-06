-- reto3.categorias definition

CREATE TABLE `categorias` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- reto3.clientes definition

CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `edad` int NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- reto3.estado_motocicletas definition

CREATE TABLE `estado_motocicletas` (
  `id_estado_motocicletas` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_estado_motocicletas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- reto3.estado_reserva definition

CREATE TABLE `estado_reserva` (
  `id_estado_reserva` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_estado_reserva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- reto3.roles definition

CREATE TABLE `roles` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- reto3.motocicletas definition

CREATE TABLE `motocicletas` (
  `id_motocicleta` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `anio` int NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `id_categoria` int NOT NULL DEFAULT '0',
  `id_estado_motocicletas` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_motocicleta`),
  KEY `motocicletas_FK` (`id_categoria`),
  KEY `motocicletas_FK_1` (`id_estado_motocicletas`),
  CONSTRAINT `motocicletas_FK` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`),
  CONSTRAINT `motocicletas_FK_1` FOREIGN KEY (`id_estado_motocicletas`) REFERENCES `estado_motocicletas` (`id_estado_motocicletas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- reto3.reservas definition

CREATE TABLE `reservas` (
  `id_reservas` int NOT NULL AUTO_INCREMENT,
  `id_motocicleta` int NOT NULL,
  `id_cliente` int NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_entrega` date NOT NULL,
  `id_estado_reserva` int NOT NULL,
  `score` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_reservas`),
  KEY `reservas_FK` (`id_motocicleta`),
  KEY `reservas_FK_1` (`id_cliente`),
  KEY `reservas_FK_2` (`id_estado_reserva`),
  CONSTRAINT `reservas_FK` FOREIGN KEY (`id_motocicleta`) REFERENCES `motocicletas` (`id_motocicleta`),
  CONSTRAINT `reservas_FK_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  CONSTRAINT `reservas_FK_2` FOREIGN KEY (`id_estado_reserva`) REFERENCES `estado_reserva` (`id_estado_reserva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- reto3.usuarios definition

CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `id_rol` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `usuarios_FK` (`id_rol`),
  CONSTRAINT `usuarios_FK` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- reto3.calificacion_reservas definition

CREATE TABLE `calificacion_reservas` (
  `id_calificacion_reservas` int NOT NULL AUTO_INCREMENT,
  `califación` int NOT NULL,
  `mensaje` varchar(250) NOT NULL,
  `id_reservas` int NOT NULL,
  PRIMARY KEY (`id_calificacion_reservas`),
  KEY `calificacion_reservas_FK` (`id_reservas`),
  CONSTRAINT `calificacion_reservas_FK` FOREIGN KEY (`id_reservas`) REFERENCES `reservas` (`id_reservas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- reto3.mensajes definition

CREATE TABLE `mensajes` (
  `id_mensaje` int NOT NULL AUTO_INCREMENT,
  `id_motocicleta` int NOT NULL,
  `id_cliente` int NOT NULL,
  `texto` varchar(250) NOT NULL,
  PRIMARY KEY (`id_mensaje`),
  KEY `mensajes_FK` (`id_motocicleta`),
  KEY `mensajes_FK_1` (`id_cliente`),
  CONSTRAINT `mensajes_FK` FOREIGN KEY (`id_motocicleta`) REFERENCES `motocicletas` (`id_motocicleta`),
  CONSTRAINT `mensajes_FK_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO estado_motocicletas
(id_estado_motocicletas, descripcion)
VALUES(1, 'created');


INSERT INTO estado_reserva
(id_estado_reserva, descripcion)
VALUES(1, 'created');
