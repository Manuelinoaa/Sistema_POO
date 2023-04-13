-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 20-03-2023 a las 17:38:18
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
(11, 'JAMON', 25, 50, 100, 5, 1, 0),
(12, 'SALAMI', 20, 100, 200, 25, 1, 0),
(40, 'ZANAHORIA', 50, 30, 50, 5, 4, 18),
(51, 'CAFE EXPRESSO', 50, 100, 150, 5, 5, 18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(5) NOT NULL,
  `nom_cliente` varchar(15) NOT NULL,
  `credito_tipo` float NOT NULL,
  `credito_pend` float NOT NULL,
  `compras` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nom_cliente`, `credito_tipo`, `credito_pend`, `compras`) VALUES
(1, 'Pedro Hernandez', 2500, 0, 0);

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
(5, 'CAFE', 'Libras');

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
(2, 'empleado', 'caf1a3dfb505ffed0d024130f58c5cfa', 2, 'Jose', 'Bautista'),
(5, 'admin2', '202cb962ac59075b964b07152d234b70', 2, 'Jose', 'Rodriguez');

--
-- Índices para tablas volcadas
--

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
