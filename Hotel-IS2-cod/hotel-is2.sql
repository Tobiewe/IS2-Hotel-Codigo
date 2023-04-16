-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-04-2023 a las 18:00:53
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel-is2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Id` int(11) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `Correo` varchar(100) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT 0,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`Id`, `telefono`, `Correo`, `activo`, `nombre`) VALUES
(3, '123456789', 'alvaro@gmail.com', 0, NULL),
(4, '65478978', 'pepe@gmail.com', 1, NULL),
(5, '66666666', 'hola@fgaihd', 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_empresa`
--

CREATE TABLE `cliente_empresa` (
  `CIF` varchar(20) DEFAULT NULL,
  `cliente_Id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente_empresa`
--

INSERT INTO `cliente_empresa` (`CIF`, `cliente_Id`) VALUES
('12345678J', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_particular`
--

CREATE TABLE `cliente_particular` (
  `apellidos` varchar(100) DEFAULT NULL,
  `NIF` varchar(20) DEFAULT NULL,
  `cliente_Id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente_particular`
--

INSERT INTO `cliente_particular` (`apellidos`, `NIF`, `cliente_Id`) VALUES
('martinez', '12345671235Y', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `Id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`Id`, `nombre`, `activo`) VALUES
(2, 'reparar', 0),
(23, 'limpieza', 0),
(24, 'JuanAlberto', 0),
(25, 'Contabilidad', 0),
(26, 'Aventura', 0),
(27, 'wer', 0),
(28, 't', 0),
(29, 'Nombre del departamento', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `Id` int(11) NOT NULL,
  `sueldo` decimal(10,2) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `iddepartamento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`Id`, `sueldo`, `nombre`, `apellidos`, `activo`, `correo`, `telefono`, `iddepartamento`) VALUES
(23, '400.00', 'juan', 'luis', 1, 'pepe@gmail.com', '66666666', NULL),
(58, '1250.00', 'alberto', 'sanchez', 0, 'sanchez@jag.com', '33333333', NULL),
(59, '1200.00', 'alberto', 'galdos', 1, 'abertto@jag.com', '123456789', NULL),
(60, '3000.00', 'wer', 'djah', 0, 'adfg', '111111111', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `numero` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `tamanyo` varchar(20) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `ocupada` tinyint(1) DEFAULT 0,
  `id_empleado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`numero`, `piso`, `tamanyo`, `precio`, `ocupada`, `id_empleado`) VALUES
(6, 1, '30.5', '1030.54', 0, 23),
(15, 2, '3.0', '400.00', 0, 23),
(17, 1, '1.0', '5600.00', 0, 23),
(18, 2, '1.0', '1000.00', 0, 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linea_pedidos`
--

CREATE TABLE `linea_pedidos` (
  `id_Reserva` int(11) NOT NULL,
  `id_Cliente` int(11) NOT NULL,
  `id_Habitacion` int(11) NOT NULL,
  `activo` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `linea_pedidos`
--

INSERT INTO `linea_pedidos` (`id_Reserva`, `id_Cliente`, `id_Habitacion`, `activo`) VALUES
(34, 3, 6, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `Id` int(11) NOT NULL,
  `Total` decimal(10,2) DEFAULT NULL,
  `Fecha_entrada` date DEFAULT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `cliente_Id` int(11) DEFAULT NULL,
  `noches` int(11) NOT NULL,
  `activo` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`Id`, `Total`, `Fecha_entrada`, `Nombre`, `cliente_Id`, `noches`, `activo`) VALUES
(1, '1030.00', '1970-01-01', 'fiesta', 3, 5, 0),
(34, '1000.00', '0000-00-00', 'Dondado', 3, 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas`
--

CREATE TABLE `tareas` (
  `Id` int(11) NOT NULL,
  `Descripcion` varchar(500) DEFAULT NULL,
  `Lugar` varchar(100) DEFAULT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `activa` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tareas`
--

INSERT INTO `tareas` (`Id`, `Descripcion`, `Lugar`, `Nombre`, `activa`) VALUES
(67, 'Arreglo aire', 'habitacion 23', 'aire acondicionado', 0),
(69, 'Limpieza planta 5', 'pasillo verde', 'manolos', 0),
(70, 'wqer', 'qwe', 'qwe', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas_empleado`
--

CREATE TABLE `tareas_empleado` (
  `id_tareas` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tareas_empleado`
--

INSERT INTO `tareas_empleado` (`id_tareas`, `id_empleado`) VALUES
(67, 23);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `cliente_empresa`
--
ALTER TABLE `cliente_empresa`
  ADD KEY `cliente_Id` (`cliente_Id`);

--
-- Indices de la tabla `cliente_particular`
--
ALTER TABLE `cliente_particular`
  ADD KEY `cliente_Id` (`cliente_Id`);

--
-- Indices de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `iddepartamento` (`iddepartamento`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `habitacion_ibfk_1` (`id_empleado`);

--
-- Indices de la tabla `linea_pedidos`
--
ALTER TABLE `linea_pedidos`
  ADD PRIMARY KEY (`id_Reserva`,`id_Cliente`,`id_Habitacion`),
  ADD KEY `id_Cliente` (`id_Cliente`),
  ADD KEY `id_Habitacion` (`id_Habitacion`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `reserva_ibfk_1` (`cliente_Id`);

--
-- Indices de la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `tareas_empleado`
--
ALTER TABLE `tareas_empleado`
  ADD PRIMARY KEY (`id_tareas`,`id_empleado`),
  ADD KEY `id_empleado` (`id_empleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `tareas`
--
ALTER TABLE `tareas`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente_empresa`
--
ALTER TABLE `cliente_empresa`
  ADD CONSTRAINT `cliente_empresa_ibfk_1` FOREIGN KEY (`cliente_Id`) REFERENCES `cliente` (`Id`);

--
-- Filtros para la tabla `cliente_particular`
--
ALTER TABLE `cliente_particular`
  ADD CONSTRAINT `cliente_particular_ibfk_1` FOREIGN KEY (`cliente_Id`) REFERENCES `cliente` (`Id`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`iddepartamento`) REFERENCES `departamentos` (`Id`);

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`Id`);

--
-- Filtros para la tabla `linea_pedidos`
--
ALTER TABLE `linea_pedidos`
  ADD CONSTRAINT `linea_pedidos_ibfk_1` FOREIGN KEY (`id_Reserva`) REFERENCES `reserva` (`Id`),
  ADD CONSTRAINT `linea_pedidos_ibfk_2` FOREIGN KEY (`id_Cliente`) REFERENCES `cliente` (`Id`),
  ADD CONSTRAINT `linea_pedidos_ibfk_3` FOREIGN KEY (`id_Habitacion`) REFERENCES `habitacion` (`numero`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`cliente_Id`) REFERENCES `cliente` (`Id`);


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
