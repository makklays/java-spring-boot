DROP TABLE IF EXISTS currencies;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS credit_cards;
DROP TABLE IF EXISTS channels;
DROP TABLE IF EXISTS companies;
DROP TABLE IF EXISTS sequenceGenerator;

create table sequenceGenerator(
  next_val INTEGER NOT null
);

CREATE TABLE `currencies` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `r030` int(25) NOT NULL,
 `txt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `rate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `cc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `exchangedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `ip` varchar(21) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`),
 KEY `r030` (`r030`),
 KEY `txt` (`txt`),
 KEY `rate` (`rate`),
 KEY `cc` (`cc`),
 KEY `exchangedate` (`exchangedate`),
 KEY `ip` (`ip`),
 KEY `created_at` (`created_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin

CREATE TABLE `users` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `login` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `firstname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `lastname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `is_auth` int(2) DEFAULT 0,
 `code` varchar(25) DEFAULT NULL,
 `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`),
 KEY `login` (`login`),
 KEY `firstname` (`firstname`),
 KEY `lastname` (`lastname`),
 KEY `password` (`password`),
 KEY `gender` (`gender`),
 KEY `is_auth` (`is_auth`),
 KEY `code` (`code`),
 KEY `phone` (`phone`),
 KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin

CREATE TABLE `channels` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `descr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`),
 KEY `title` (`title`),
 KEY `descr` (`descr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin

CREATE TABLE `credit_cards` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `account` int(25) NOT NULL,
 `bank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `firstname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `lastname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `amount` float(25) NOT NULL,
 `currency` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `fromaccount` int(25) NOT NULL,
 `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `credit_card` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`),
 KEY `account` (`account`),
 KEY `bank` (`bank`),
 KEY `firstname` (`firstname`),
 KEY `lastname` (`lastname`),
 KEY `currency` (`currency`),
 KEY `fromaccount` (`fromaccount`),
 KEY `credit_card` (`credit_card`),
 KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin

CREATE TABLE `companies` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `channel_id` int(10) NOT NULL,
 `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `count_views` int(11) NOT NULL,
 `speed_hour_from` int(11) NOT NULL,
 `speed_hour_to` int(11) NOT NULL,
 `count_last_posts` int(11) NOT NULL DEFAULT 17,
 `range_views_from` int(11) NOT NULL DEFAULT 0,
 `range_views_to` int(11) NOT NULL DEFAULT 10,
 `shift_start` int(11) NOT NULL DEFAULT 10,
 `count_days` int(11) NOT NULL DEFAULT 1,
 `start_from` timestamp NOT NULL,
 `only_subscribes` int(2) NOT NULL DEFAULT 1,
 `have_break` int(2) NOT NULL DEFAULT 0,
 `comments` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`),
 KEY `title` (`title`),
 KEY `channel_id` (`channel_id`),
 KEY `start_from` (`start_from`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin

CREATE INDEX index_cc ON currencies(cc);

CREATE INDEX index_channel_id ON companies(channel_id);
CREATE INDEX index_company_title ON companies(title);
CREATE INDEX index_company_start_from ON companies(start_from);

CREATE INDEX index_channel_title ON channels(title);

CREATE INDEX index_creditcard_amount ON credit_cards(amount);

CREATE INDEX index_user_login ON users(login);
CREATE INDEX index_user_firstname ON users(firstname);
CREATE INDEX index_user_lastname ON users(lastname);
CREATE INDEX index_user_phone ON users(phone);

