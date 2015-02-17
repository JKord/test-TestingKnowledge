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
  `text` text,
  `question_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__question` (`question_id`),
  CONSTRAINT `FK__question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы testing_knowledge.answer: ~60 rows (приблизительно)
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` (`id`, `text`, `question_id`) VALUES
	(1, NULL, 1),
	(2, NULL, 1),
	(3, NULL, 1),
	(4, NULL, 1),
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
	(16, NULL, 5),
	(17, NULL, 5),
	(18, NULL, 5),
	(19, NULL, 5),
	(20, '*.ppt', 6),
	(21, '*.*', 6),
	(22, '*.bmp', 6),
	(23, '*.xls', 6),
	(24, 'А1t+F5', 7),
	(25, 'А1t+Х', 7),
	(26, NULL, 7),
	(27, ' Alt+F9', 7),
	(28, NULL, 7),
	(29, NULL, 8),
	(30, NULL, 8),
	(31, NULL, 8),
	(32, NULL, 8),
	(33, NULL, 8),
	(34, 'Shift + Insert', 9),
	(35, 'А1t + Еnter', 9),
	(36, 'F3', 9),
	(37, NULL, 9),
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
  `correct_answer_ids` text,
  `topic_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__topic` (`topic_id`),
  CONSTRAINT `FK__topic` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы testing_knowledge.question: ~13 rows (приблизительно)
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` (`id`, `correct_answer_ids`, `topic_id`) VALUES
	(1, '1', 1),
	(2, '7', 1),
	(3, '10', 1),
	(4, '14', 1),
	(5, '16', 1),
	(6, '23', 1),
	(7, '25', 2),
	(8, '29', 2),
	(9, '37', 2),
	(10, '40', 2),
	(11, '47', 2),
	(12, '53', 2),
	(20, '55', 2);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;


-- Dumping structure for таблица testing_knowledge.topic
CREATE TABLE IF NOT EXISTS `topic` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `count_questions` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы testing_knowledge.topic: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` (`id`, `count_questions`) VALUES
	(1, 6),
	(2, 7);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;


-- Dumping structure for таблица testing_knowledge.trans_answer
CREATE TABLE IF NOT EXISTS `trans_answer` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `code_lang` varchar(2) NOT NULL,
  `obj_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__answer` (`obj_id`),
  CONSTRAINT `FK__answer` FOREIGN KEY (`obj_id`) REFERENCES `answer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы testing_knowledge.trans_answer: ~8 rows (приблизительно)
/*!40000 ALTER TABLE `trans_answer` DISABLE KEYS */;
INSERT INTO `trans_answer` (`id`, `text`, `code_lang`, `obj_id`) VALUES
	(1, 'Робочою книгою', 'uk', 1),
	(2, 'Документом', 'uk', 2),
	(3, 'Презентацією', 'uk', 3),
	(4, 'Аркушем', 'uk', 4),
	(5, 'Workbooks', 'en', 1),
	(6, 'Document', 'en', 2),
	(7, 'Presentation', 'en', 3),
	(8, 'Leaf', 'en', 4),
	(9, 'Електронна таблиця', 'uk', 16),
	(10, 'Закладка аркуша', 'uk', 17),
	(11, 'Табличний редактор', 'uk', 18),
	(12, 'Робоча книга', 'uk', 19),
	(13, 'Spreadsheet', 'en', 16),
	(14, 'Bookmark sheet', 'en', 17),
	(15, 'Tabular editor', 'en', 18),
	(16, 'A workbook', 'en', 19),
	(17, 'Пункт меню Fі1е/Sаvе аs...', 'uk', 26),
	(18, 'Fi1e menu / Save as ...', 'en', 26),
	(19, 'Витягнути вилку комп\'ютера', 'uk', 28),
	(20, 'Pull the plug computer', 'en', 28),
	(21, 'створення ехе-файла програми', 'uk', 29),
	(22, 'створення запускного файла програми', 'uk', 30),
	(23, 'активізація попереднього вікна', 'uk', 31),
	(24, 'меню для роботи з вікнами', 'uk', 32),
	(25, 'розгортання активного вікна на повний екран', 'uk', 33),
	(26, 'creating EXE-file program', 'en', 29),
	(27, 'zapusknoho file creation program', 'en', 30),
	(28, 'activation of the previous screen', 'en', 31),
	(29, 'menu to work with windows', 'en', 32),
	(30, 'minimize the active window to full screen', 'en', 33),
	(31, 'пункт меню Run / Run', 'uk', 37),
	(32, 'menu item Run / Run', 'en', 37);
/*!40000 ALTER TABLE `trans_answer` ENABLE KEYS */;


-- Dumping structure for таблица testing_knowledge.trans_question
CREATE TABLE IF NOT EXISTS `trans_question` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `code_lang` varchar(2) NOT NULL,
  `obj_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_question_trans_question` (`obj_id`),
  CONSTRAINT `FK_question_trans_question` FOREIGN KEY (`obj_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы testing_knowledge.trans_question: ~26 rows (приблизительно)
/*!40000 ALTER TABLE `trans_question` DISABLE KEYS */;
INSERT INTO `trans_question` (`id`, `text`, `code_lang`, `obj_id`) VALUES
	(1, 'Файл MSExcel називають?', 'uk', 1),
	(2, 'Вкажіть, яка кількість закладок аркушів за замовчуванням відображається?', 'uk', 2),
	(3, 'Вкажіть, яка максимальна кількість стовпців на аркуші ЕТ MS Excel?', 'uk', 3),
	(4, 'Вкажіть, яка максимальна кількість рядків на аркуші ЕТ MS Excel?', 'uk', 4),
	(5, 'Програма, що моделює на екрані монітора двовимірну таблиці, що складається з рядків та стовпці - це', 'uk', 5),
	(6, 'Виберіть розширення MS Excel?', 'uk', 6),
	(7, 'Як вийти з середовища Turbo Рascal?', 'uk', 7),
	(8, 'Що таке «компіляція програми» ?', 'uk', 8),
	(9, 'Як запустити програму на виконання?', 'uk', 9),
	(10, 'Яка функція знаходить квадратний корінь виразу?', 'uk', 10),
	(11, 'Як знайти тангенс змінної m?', 'uk', 11),
	(12, 'а:=1; b:=-5; с:=-6. Якого значення набуде змінна d, якщо d:=sqrt(sqr(b)-4*а*с) ?', 'uk', 12),
	(13, 'Якого значення набуде змінна у в результаті виконання дій: а: =5; іf а>8 then у:=-1 else у: =10;?', 'uk', 20),
	(14, 'MSExcel file called?', 'en', 1),
	(15, 'Specify how many bookmarks sheets displayed by default?', 'en', 2),
	(16, 'Specify that the maximum number of columns per sheet ET MS Excel?', 'en', 3),
	(17, 'Specify that the maximum number of lines on a piece of ET MS Excel?', 'en', 4),
	(18, 'The program, which simulates the on-screen two-dimensional table consisting of rows and columns - it', 'en', 5),
	(19, 'Select expansion MS Excel?', 'en', 6),
	(20, 'To exit the environment Turbo Pascal?', 'en', 7),
	(21, 'What is a "compilation program"?', 'en', 8),
	(22, 'How to run a program in execution?', 'en', 9),
	(23, 'What is the function of the square root of the expression?', 'en', 10),
	(24, 'How to find the tangent of the variable m?', 'en', 11),
	(25, 'a: = 1; b: = - 5; c = - 6. What value will come into variable d, if d: = sqrt (sqr (b) -4 * a * s)?', 'en', 12),
	(26, 'What value will take variable as a result of actions: a = 5; IF a> 8 then in = - 1 else in = 10;?', 'en', 20);
/*!40000 ALTER TABLE `trans_question` ENABLE KEYS */;


-- Dumping structure for таблица testing_knowledge.trans_topic
CREATE TABLE IF NOT EXISTS `trans_topic` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `code_lang` varchar(2) NOT NULL,
  `obj_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_topic_trans_topic` (`obj_id`),
  CONSTRAINT `FK_topic_trans_topic` FOREIGN KEY (`obj_id`) REFERENCES `topic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы testing_knowledge.trans_topic: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `trans_topic` DISABLE KEYS */;
INSERT INTO `trans_topic` (`id`, `name`, `code_lang`, `obj_id`) VALUES
	(1, 'Microsoft Excel en', 'en', 1),
	(2, 'Microsoft Excel uk', 'uk', 1),
	(3, 'Basics of algorithms and Programming', 'en', 2),
	(4, 'Основи алгоритмізації та прогамування', 'uk', 2);
/*!40000 ALTER TABLE `trans_topic` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
