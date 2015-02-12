-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.5.27 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win32
-- HeidiSQL Версия:              7.0.0.4321
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for таблица testing_knowledge.answer
CREATE TABLE IF NOT EXISTS `answer` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `question_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK__question` FOREIGN KEY (`id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы testing_knowledge.answer: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;


-- Dumping structure for таблица testing_knowledge.question
CREATE TABLE IF NOT EXISTS `question` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `correct_answer_ids` text,
  `topic_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__topic` (`topic_id`),
  CONSTRAINT `FK__topic` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы testing_knowledge.question: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` (`id`, `text`, `correct_answer_ids`, `topic_id`) VALUES
	(1, 'erer', '1,2', 1);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;


-- Dumping structure for таблица testing_knowledge.topic
CREATE TABLE IF NOT EXISTS `topic` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы testing_knowledge.topic: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` (`id`, `name`) VALUES
	(1, 'Планета'),
	(2, 'Тварини');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
