-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 05-03-2019 a las 08:35:11
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `agenciavuelos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id`, `nombre`) VALUES
(1, 'null'),
(2, 'null'),
(11, 'null'),
(3, 'null');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tickets`
--

CREATE TABLE IF NOT EXISTS `tickets` (
  `id` int(11) NOT NULL,
  `id_caso` int(11) NOT NULL,
  `id_Admin` int(11) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `asunto` varchar(50) NOT NULL,
  `prioridad` varchar(50) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `Respuesta` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tickets`
--

INSERT INTO `tickets` (`id`, `id_caso`, `id_Admin`, `fecha`, `asunto`, `prioridad`, `descripcion`, `estado`, `Respuesta`) VALUES
(1, 1, 1, '20-02-2019', 'Incidencia 1', 'Alta', 'asdafd', 'Abierto', ''),
(2, 1, 1, '20/02/2019', 'asd', 'Alta', 'ad', 'Abierto', ''),
(3, 2, 2, '20/02/2019', 'asde', 'a', 'asdasd', 'Abierto', ''),
(4, 4, 1, '25/11/2019', 'dasd', 'Alta', 'as', 'Cerrado', ''),
(5, 5, 2, '25/11/2019', 'adsf', 'Alta', 'asdf', 'Abierto', ''),
(6, 6, 1, '25/11/2019', 'as', 'Media', 'as', 'Abierto', ''),
(7, 7, 2, '25/11/2019', 'sgfh', 'Alta', 'sfdghsdsfghsg', 'Abierto', ''),
(8, 8, 1, '25/11/2019', 'adfa', 'Alta', 'dfasdf', 'Abierto', ''),
(1, 9, 1, '25/11/2019', '1', 'Alta', '1', 'Abierto', ''),
(2, 10, 1, '25/11/2019', 'asdf', 'Alta', 'asdfasdf', 'Abierto', ''),
(1, 11, 11, '25/11/2019', 'dasd', 'Media', 'fgaga', 'Abierto', ''),
(1, 12, 1, '25/11/2019', '11', 'Alta', 'fdsg', 'Cerrado', ''),
(1, 13, 1, '25/11/2019', 'sa', 'Alta', 'dfsa', 'Abierto', ''),
(1, 14, 1, '25/11/2019', '1', 'Media', '1', 'Pendiente', ''),
(1, 15, 2, '26/11/2019', 'as', 'Alta', 'asd', 'Pendiente', ''),
(1, 16, 2, '27/11/2019', 'a', 'Alta', 'a', 'Pendiente', ''),
(2, 17, 1, '27/11/2019', 'a', 'Alta', 'a', 'Pendiente', ''),
(12, 18, 2, '27/11/2019', 'a', 'Alta', 'a', 'Pendiente', ''),
(1, 19, 2, '27/11/2019', 'a', 'Alta', 'a', 'Pendiente', ''),
(12, 20, 2, '27/11/2019', 'a', 'Alta', 'a', 'Pendiente', ''),
(1, 21, 2, '27/11/2019', 'a', 'Alta', 'a', 'Cerrado', ''),
(12, 22, 2, '27/11/2019', 'a', 'Alta', 'a', 'Cerrado', ''),
(1, 23, 2, '27/11/2019', 'a', 'Alta', 'a', 'Pendiente', ''),
(1, 24, 2, '27/11/2019', 'aa', 'Alta', 'a', 'Pendiente', ''),
(1, 25, 3, '27/11/2019', 'a', 'Alta', 'aa', 'Cerrado', ''),
(1, 26, 1, '27/11/2019', 'Prueba', 'Alta', 'asdasf', 'Pendiente', ''),
(88, 27, 3, '4/21/2019', 'a', 'Alta', 'a', 'Pendiente', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
