CREATE DATABASE IF NOT EXISTS `hummel_wt_02`;
USE `hummel_wt_02`;
CREATE TABLE IF NOT EXISTS `authors` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `imagePath` VARCHAR(50) NOT NULL,
    INDEX `name_indx` (`name`)
);

CREATE TABLE IF NOT EXISTS `users` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `lastName` VARCHAR(50) NOT NULL,
    `email` VARCHAR(90) NOT NULL UNIQUE,
    `birthDate` DATE NOT NULL,
    `registrationDate` DATE NOT NULL,
    `balance` DECIMAL(26, 2) NOT NULL,
    `password` VARCHAR(64) NOT NULL,
    `address` VARCHAR(90),
    `phoneNumber` VARCHAR(20),
    `banned` INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS `orders` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`userId` INT NOT NULL,
	`date` TIMESTAMP NOT NULL,
    `price` DECIMAL(24, 2) NOT NULL,
    CONSTRAINT `fk_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`),
    INDEX `userId_indx` (`userId`)
);

CREATE TABLE IF NOT EXISTS `books` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(350) NOT NULL,
    `imagePath` VARCHAR(50) NOT NULL,
    `author` VARCHAR(50) NOT NULL,
    `price` DECIMAL(24, 2) NOT NULL,
    CONSTRAINT `fk_author` FOREIGN KEY (`author`) REFERENCES `authors` (`name`),
    INDEX `author_indx` (`author`)
);

CREATE TABLE IF NOT EXISTS `orders_books` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `orderId` INT NOT NULL,
    `bookId` INT NOT NULL,
    CONSTRAINT `fk_orderId` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`),
    CONSTRAINT `fk_bookId` FOREIGN KEY (`bookId`) REFERENCES `books` (`id`),
    INDEX `orderId_indx` (`orderId`),
    INDEX `bookId_indx` (`bookId`)
);

CREATE TABLE IF NOT EXISTS `roles`
(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS `users_roles`
(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `userId` INT NOT NULL,
    `roleId` INT NOT NULL,
    CONSTRAINT `fk_uId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`),
    CONSTRAINT `fk_roleId` FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`)
);

/*===TEST DATA===*/

/*AUTHORS INSERT*/
INSERT INTO `authors` (`name`, `imagePath`) VALUES ('Максім Багдановіч', 'assets/authors/bahdanowicz.jpg');
INSERT INTO `authors` (`name`, `imagePath`) VALUES ('Уладзімір Караткевіч', 'assets/authors/karatkiewicz.jpg');
INSERT INTO `authors` (`name`, `imagePath`) VALUES ('Адам Міцкевіч', 'assets/authors/mickiewicz.jpg');
INSERT INTO `authors` (`name`, `imagePath`) VALUES ('Янка Купала', 'assets/authors/kupala.jpg');
INSERT INTO `authors` (`name`, `imagePath`) VALUES ('Якуб Колас', 'assets/authors/jakub.jpg');

/*BOOKS INSERT*/
INSERT INTO `books` (`name`, `description`, `imagePath`, `author`, `price`) VALUES
   ('Пан Тадэвуш',
	'Твор вялікага паэта Адама Міцкевіча, які адзначаецца глыбокім і лірычным падыходам да развіцця паэтычнага мастацтва. У гэтай кнізе вы адкрываеце для сябе крыніцу непаўторнага беларускага культурнага асяроддзя.',
	'assets/books/am_tadewusz.jpg',
    'Адам Міцкевіч',
    1.19
   );
INSERT INTO `books` (`name`, `description`, `imagePath`, `author`, `price`) VALUES
    ('Паўлінка',
     'Твор вялікага беларускага паэта Янкі Купалы, у якім адлюстроўваецца яго глыбокае пачуццё нацыянальнай ідэнтычнасці і любові да прыроды. Кніга перадае той непаўторны дух, які ляжыць у аснове беларускай літаратуры.',
     'assets/books/jk_paulinka.jpg',
     'Янка Купала',
     1.29
    );
INSERT INTO `books` (`name`, `description`, `imagePath`, `author`, `price`) VALUES
    ('Новая зямля',
     'Зборнік твораў выдаючага беларускага паэта Якуба Коласа. У гэтым зборніку адлюстроўваецца шматгадовая творчасць паэта.',
     'assets/books/jk_ziamlia.jpg',
     'Якуб Колас',
     1.39
    );
INSERT INTO `books` (`name`, `description`, `imagePath`, `author`, `price`) VALUES
    ('Пярсцёнак',
     'Твор Максіма Багдановіча, прадстаўніка выдаючайся групы "Маладосць". У гэтай кнізе вы знойдзеце глыбокія пачуцці любові да роднай зямлі, грамадства і прыроды.',
     'assets/books/mb_piarscionak.jpg',
     'Максім Багдановіч',
     1.49
    );
INSERT INTO `books` (`name`, `description`, `imagePath`, `author`, `price`) VALUES
    ('У школе',
     'Твор Максіма Багдановіча, у якім адлюстроўваецца аўтабіяграфічныя моманты з жыцця паэта, які развіваў сваю творчасць у школьныя гады. Кніга звартае ўвагу на важнасць асвятлення тэмы адукацыі і выхавання ў мастацтве.',
     'assets/books/mb_szkola.jpg',
     'Максім Багдановіч',
     1.59
    );
INSERT INTO `books` (`name`, `description`, `imagePath`, `author`, `price`) VALUES
    ('Шыпшына',
     'Твор Максіма Багдановіча, у якім адлюстроўваецца яго ўзровень да праблемы чалавечага стасунку да прыроды. Кніга - асалода для тых, каму падабаецца экалагічная тэма ў літаратуры.',
     'assets/books/mb_szypszyna.jpg',
     'Максім Багдановіч',
     1.69
    );
INSERT INTO `books` (`name`, `description`, `imagePath`, `author`, `price`) VALUES
    ('Вянок',
     'Зборнік твораў Максіма Багдановіча, у якім яго лірычнасць і філасофская глыбіня пераплітаюцца ў вянку паэтычных абразаў. Кніга адкрые для вас светлы і глыбокі свет літаратурнага мастацтва.',
     'assets/books/mb_wianok.jpg',
     'Максім Багдановіч',
     1.79
    );
INSERT INTO `books` (`name`, `description`, `imagePath`, `author`, `price`) VALUES
    ('Зорка Венера',
     'Твор Максіма Багдановіча, у якім адлюстроўваецца яго бачанне прыроды як галоўнага элемента чалавечага існавання. Кніга - нумар адзін для тых, каму падабаецца лірыка і эстэтыка прыроды.',
     'assets/books/mb_wieniera.jpg',
     'Максім Багдановіч',
     1.89
    );
INSERT INTO `books` (`name`, `description`, `imagePath`, `author`, `price`) VALUES
    ('Каласы пад сярпом тваім',
     'Твор Уладзіміра Караткевіча, выдатнага паэта і культуртворца. У гэтай кнізе вы адчуеце эмоцыі і пачуцці беларускай нацыі, якія былі актуальнымі для часоў, у якіх жыў паэт.',
     'assets/books/uk_kalasy.jpg',
     'Уладзімір Караткевіч',
     1.99
    );

INSERT INTO `roles` (`id`, `name`) VALUES ('1', 'ROLE_ADMIN');

INSERT INTO `users` (`id`, `name`, `lastName`, `email`, `birthDate`, `registrationDate`, `balance`, `password`, `address`, `phoneNumber`, `banned`) VALUES ('1', 'Jahor', 'Burbowski', 'hummel.turbamentum@gmail.com', '2002-07-10', '2023-11-11', '1000.00', '00dd303d42a48b12b4f948e1eb821e9848cba34a5397715debe6266c6c1db2fc', NULL, NULL, '0');

INSERT INTO `users_roles` (`id`, `userId`, `roleId`) VALUES ('1', '1', '1');