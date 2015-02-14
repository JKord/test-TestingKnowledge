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
  KEY `FK__question` (`question_id`),
  CONSTRAINT `FK__question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы testing_knowledge.answer: ~23 rows (приблизительно)
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` (`id`, `text`, `question_id`) VALUES
	(1, 'Робочою книгою', 1),
	(2, 'Документом', 1),
	(3, 'Презентацією', 1),
	(4, 'Аркушом', 1),
	(5, '1', 2),
	(6, '2', 2),
	(7, '3', 2),
	(8, '64', 3),
	(9, '128', 3),
	(10, '256', 3),
	(11, '386', 3),
	(12, '1024', 3),
	(13, '3254', 4),
	(14, '65536', 4),
	(15, '86456', 4),
	(16, 'Електронна таблиця ', 5),
	(17, 'Закладка аркуша', 5),
	(18, 'Табличний редактор', 5),
	(19, 'Робоча книга', 5),
	(20, '*.ppt', 6),
	(21, 'Робоча книга', 6),
	(22, '*.bmp', 6),
	(23, '*.xls', 6),
	(24, 'А1t+F5', 7),
	(25, 'А1t+Х', 7),
	(26, 'пункт меню Fі1е/Sаvе аs...', 7),
	(27, ' Alt+F9', 7),
	(28, 'Витягнути вилку комп\'ютера', 7),
	(29, 'створення ехе-файла програми', 8),
	(30, 'створення запускного файла програми', 8),
	(31, 'активізація попереднього вікна', 8),
	(32, 'меню для роботи з вікнами', 8),
	(33, 'розгортання активного вікна на повний екран', 8),
	(34, 'Shift + Insert', 9),
	(35, 'А1t + Еnter', 9),
	(36, 'F3', 9),
	(37, 'пункт меню Run / Run', 9),
	(38, 'Ctrl+F9', 9),
	(39, 'sqr', 10),
	(40, 'sqrt', 10),
	(41, 'ехр', 10),
	(42, 'abs', 10),
	(43, 'ln', 10),
	(44, 'tan(m)', 11),
	(45, 'sin/cos m', 11),
	(46, 'sin(m)/сos(m)', 11),
	(47, 'tg (m)', 11),
	(48, 'tg m', 11),
	(49, '1', 12),
	(50, '49', 12),
	(51, '-7', 12),
	(52, '-1', 12),
	(53, '-1', 20),
	(54, '1', 20),
	(55, '10', 20),
	(56, '8', 20),
	(57, '5', 20),
	(58, '101', 20),
	(59, '88', 20),
	(60, '65', 20);
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы testing_knowledge.question: ~6 rows (приблизительно)
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` (`id`, `text`, `correct_answer_ids`, `topic_id`) VALUES
	(1, 'Файл MSExcel називають?', '1', 1),
	(2, 'Вкажіть, яка кількість закладок аркушів за замовчуванням відображається?', '7', 1),
	(3, 'Вкажіть, яка максимальна кількість стовпців на аркуші ЕТ MS Excel?', '10', 1),
	(4, 'Вкажіть, яка максимальна кількість рядків на аркуші ЕТ MS Excel?', '14', 1),
	(5, 'Програма, що моделює на екрані монітора двовимірну таблиці, що складається з рядків та стовпці - це', '16', 1),
	(6, 'Виберіть рощирення MSExcel?', '23', 1),
	(7, 'Як вийти з середовища Turbo Рascal?', '25', 2),
	(8, 'Що таке «компіляція програми» ?', '29', 2),
	(9, 'Як запустити програму на виконання?', '37', 2),
	(10, 'Яка функція знаходить квадратний корінь виразу?', '40', 2),
	(11, 'Як знайти тангенс змінної m?', '47', 2),
	(12, 'а:=1; b:=-5; с:=-6. Якого значення набуде змінна d, якщо d:=sqrt(sqr(b)-4*а*с) ?', '53', 2),
	(20, 'Якого значення набуде змінна у в результаті виконання дій: а: =5; іf а>8 then у:=-1 else у: =10;?', '55', 2);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;


-- Dumping structure for таблица testing_knowledge.topic
CREATE TABLE IF NOT EXISTS `topic` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы testing_knowledge.topic: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` (`id`, `name`) VALUES
	(1, 'Microsoft Excel'),
	(2, 'Основи алгоритмізації та прогамування');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
