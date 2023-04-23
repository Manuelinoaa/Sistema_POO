-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 21-04-2023 a las 16:29:15
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

CREATE TABLE `articulos` (
  `cod_art` int(222) NOT NULL,
  `des_art` varchar(30) NOT NULL,
  `cant_art` float NOT NULL,
  `pre_com` float NOT NULL,
  `pre_vent` float NOT NULL,
  `punto_reorden` float NOT NULL,
  `id_ti_art` int(5) NOT NULL,
  `itbis` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`cod_art`, `des_art`, `cant_art`, `pre_com`, `pre_vent`, `punto_reorden`, `id_ti_art`, `itbis`) VALUES
(10, 'JAMON DE PAVO', 0, 50, 100, 5, 1, 0),
(11, 'JAMON', 24, 50, 100, 5, 1, 0),
(12, 'SALAMI', 20, 100, 200, 25, 1, 0),
(40, 'ZANAHORIA', 43, 30, 50, 5, 4, 0),
(51, 'CAFE EXPRESSO', 42, 100, 150, 5, 5, 18),
(21, 'GEO RICA', 91, 100, 110, 50, 2, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(5) NOT NULL,
  `nom_cliente` varchar(15) NOT NULL,
  `credito_tipo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nom_cliente`, `credito_tipo`) VALUES
(1, 'Manuel Inoa', 300),
(2, 'Moises Perez', 3000),
(3, 'Jose Vidal', 5000),
(4, 'Angel Sosa', 5000),
(5, 'Luis Perez', 3000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contador`
--

CREATE TABLE `contador` (
  `id_factura` int(10) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `contador`
--

INSERT INTO `contador` (`id_factura`) VALUES
(9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuadre`
--

CREATE TABLE `cuadre` (
  `cod_cuadre` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `fecha_cuadre` date NOT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cuadre`
--

INSERT INTO `cuadre` (`cod_cuadre`, `fecha`, `fecha_cuadre`, `total`) VALUES
(1, '2023-04-16', '2023-04-20', 110),
(2, '2023-04-18', '2023-04-20', 330),
(3, '2023-04-20', '2023-04-20', 860);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `nom_fact` varchar(4) NOT NULL,
  `tipo_fact` varchar(15) NOT NULL,
  `fecha` date NOT NULL,
  `subtotal` float NOT NULL,
  `itbis` float NOT NULL,
  `total` float NOT NULL,
  `id_cliente` int(5) NOT NULL,
  `nom_cliente` varchar(50) NOT NULL,
  `reg` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`nom_fact`, `tipo_fact`, `fecha`, `subtotal`, `itbis`, `total`, `id_cliente`, `nom_cliente`, `reg`) VALUES
('1', 'Al contado', '2023-04-16', 110, 0, 110, 2, 'Moises Perez', 1),
('2', 'A credito', '2023-04-16', 110, 0, 110, 2, 'Moises Perez', 2),
('3', 'A credito', '2023-04-16', 110, 0, 110, 2, 'Moises Perez', 3),
('4', 'A credito', '2023-04-16', 150, 27, 177, 2, 'Moises Perez', 4),
('5', 'A credito', '2023-04-16', 110, 0, 110, 2, 'Moises Perez', 5),
('6', 'A credito', '2023-04-16', 450, 54, 504, 4, 'Angel Sosa', 6),
('7', 'Al contado', '2023-04-18', 330, 0, 330, 2, 'Moises Perez', 7),
('8', 'Al contado', '2023-04-20', 110, 0, 110, 1, 'Manuel Inoa', 8),
('9', 'Al contado', '2023-04-20', 750, 135, 885, 3, 'Jose Vidal', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fac_detail`
--

CREATE TABLE `fac_detail` (
  `id_fact` varchar(5) NOT NULL,
  `id_articulo` varchar(5) NOT NULL,
  `des_art` varchar(30) NOT NULL,
  `cantidad` float NOT NULL,
  `precio` float NOT NULL,
  `importe` float NOT NULL,
  `reg` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `fac_detail`
--

INSERT INTO `fac_detail` (`id_fact`, `id_articulo`, `des_art`, `cantidad`, `precio`, `importe`, `reg`) VALUES
('1', '21', 'GEO RICA', 1, 110, 1, 1),
('2', '21', 'GEO RICA', 1, 110, 1, 2),
('3', '21', 'GEO RICA', 1, 110, 1, 3),
('4', '51', 'CAFE EXPRESSO', 1, 150, 1, 4),
('5', '21', 'GEO RICA', 1, 110, 1, 5),
('6', '40', 'ZANAHORIA', 1, 50, 1, 6),
('6', '11', 'JAMON', 1, 100, 1, 7),
('6', '51', 'CAFE EXPRESSO', 2, 150, 2, 8),
('7', '21', 'GEO RICA', 3, 110, 3, 9),
('8', '21', 'GEO RICA', 1, 110, 1, 10),
('9', '51', 'CAFE EXPRESSO', 5, 150, 5, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_art`
--

CREATE TABLE `tipo_art` (
  `id_ti_art` int(5) NOT NULL,
  `tipo_art` varchar(30) NOT NULL,
  `dist_art` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_art`
--

INSERT INTO `tipo_art` (`id_ti_art`, `tipo_art`, `dist_art`) VALUES
(1, 'CARNE', 'Libras'),
(2, 'QUESOS', 'Libras'),
(3, 'PAN', 'Unidad'),
(4, 'VEGETALES', 'Unidad'),
(5, 'CAFE', 'Libras'),
(6, 'MUEBLES', 'Unidad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id_user` int(10) NOT NULL,
  `nom_user` varchar(20) NOT NULL,
  `pass_user` varchar(32) NOT NULL,
  `tipo_user` int(3) NOT NULL,
  `nomb_em` varchar(30) NOT NULL,
  `apelli_em` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `nom_user`, `pass_user`, `tipo_user`, `nomb_em`, `apelli_em`) VALUES
(1, 'admin', '202cb962ac59075b964b07152d234b70', 1, 'Manuel', 'Inoa'),
(2, 'user', '202cb962ac59075b964b07152d234b70', 2, 'Jose', 'Bautista');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuadre`
--
ALTER TABLE `cuadre`
  ADD PRIMARY KEY (`cod_cuadre`),
  ADD UNIQUE KEY `fecha` (`fecha`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`reg`);

--
-- Indices de la tabla `fac_detail`
--
ALTER TABLE `fac_detail`
  ADD PRIMARY KEY (`reg`);

--
-- Indices de la tabla `tipo_art`
--
ALTER TABLE `tipo_art`
  ADD PRIMARY KEY (`id_ti_art`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cuadre`
--
ALTER TABLE `cuadre`
  MODIFY `cod_cuadre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `reg` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `fac_detail`
--
ALTER TABLE `fac_detail`
  MODIFY `reg` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
